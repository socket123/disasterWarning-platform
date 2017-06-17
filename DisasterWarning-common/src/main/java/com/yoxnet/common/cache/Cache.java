package com.yoxnet.common.cache;


/**   
* @Title: Cache.java 
* @Description: TODO
* @author : Aaron
* @date: 2017年3月15日 上午11:42:58 
* @version:V1.0 
* Copyright 悦享互联 2016 All right reserved.
* Modification  History:
* Version       Date          Author          Description
* ----------------------------------------------------------------------------
*  1.0         2017年3月15日        Aaron              TODO
*/ 


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cache {

	private static final Logger LOG = Logger.getLogger(Cache.class.getName());

    private static final ConcurrentMap<String,Object> DATA_CACHE = new ConcurrentHashMap<String,Object>();

    private static DelayQueue<DelayItem<Pair>> QUEUE = new DelayQueue<DelayItem<Pair>>();

    private static Thread daemonThread;

    static {

        Runnable daemonTask = new Runnable() {
            public void run() {
                daemonCheck();
            }
        };

        daemonThread = new Thread(daemonTask);
        daemonThread.setDaemon(true);
        daemonThread.setName("Cache Daemon");
        daemonThread.start();
    }

    private static void daemonCheck() {

        if (LOG.isLoggable(Level.INFO))
            LOG.info("cache service started.");

        for (;;) {
            try {
                DelayItem<Pair> delayItem = QUEUE.take();
                if (delayItem != null) {
                    // 超时对象处理
                    Pair pair = delayItem.getItem();
                    DATA_CACHE.remove(pair.first, pair.second); 
                }
            } catch (InterruptedException e) {
                if (LOG.isLoggable(Level.SEVERE))
                    LOG.log(Level.SEVERE, e.getMessage(), e);
                break;
            }
        }

        if (LOG.isLoggable(Level.INFO))
            LOG.info("cache service stopped.");
    }

    // 添加缓存对象
    public static void put(String key, Object value, long time, TimeUnit unit) {
        Object oldValue = DATA_CACHE.put(key, value);
        if (oldValue != null)
        	QUEUE.remove(key);

        long nanoTime = TimeUnit.NANOSECONDS.convert(time, unit);
        QUEUE.put(new DelayItem<Pair>(new Pair(key, value), nanoTime));
    }

    public static Object get(String key) {
        return DATA_CACHE.get(key);
    }
    
	
	public static void remove(String key) {
		DATA_CACHE.remove(key);
	}
    

    public static void main(String[] args) throws Exception {
        Cache.put("1", "aaaa", 1, TimeUnit.MINUTES);
        Cache.put("2", "bbbb", 1, TimeUnit.MINUTES);

        Thread.sleep(1000 * 2);
        {
            String str = Cache.get("1").toString();
            System.out.println(str);
            System.out.println(Cache.get("2"));
        }

        Thread.sleep(1000 * 60);
        {
        	if(Cache.get("1") != null){
        		String str = Cache.get("1").toString();
                System.out.println(str);
        	}else{
        		System.out.println("null");
        	}
            System.out.println(Cache.get("2"));
        }
        
        Thread.sleep(1000 * 3);
        {
        	if(Cache.get("1") != null){
        		String str = Cache.get("1").toString();
                System.out.println(str);
        	}else{
        		System.out.println("null");
        	}
            System.out.println(Cache.get("2"));
        }
    }
}

