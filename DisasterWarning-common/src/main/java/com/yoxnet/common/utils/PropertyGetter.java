package com.yoxnet.common.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;

/**
 * 根据全局properties文件中的键获取对应的值工具
 *
 */
public class PropertyGetter {

    private static Logger logger = Logger.getLogger(PropertyGetter.class);
    private static final String prefix = ".properties";
    private static CombinedConfiguration compositeConfig = new CombinedConfiguration();

    private static Configuration getConfiguration(String module) {
        return compositeConfig.getConfiguration(module);
    }

    private static Configuration getConfiguration() {
        return compositeConfig;
    }

    /**
     * 根据键值返回对应布尔值
     *
     * @param key properties文件中键值
     * @return
     */
    public static boolean getBoolean(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getBoolean(key);
    }

    /**
     * 根据键值返回对应布尔值
     *
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认参数
     * @return
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration().getBoolean(key, defaultValue);
    }

    /**
     * 根据键值返回对应Double值
     *
     * @param key properties文件中键值
     * @return
     */
    public static double getDouble(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getDouble(key);
    }

    /**
     * 根据键值返回对应Double值
     *
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认参数
     * @return
     */
    public static double getDouble(String key, double defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration().getDouble(key, defaultValue);
    }

    /**
     * 根据键值返回对应Int值
     *
     * @param key properties文件中键值
     * @return
     */
    public static int getInt(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getInt(key);
    }

    /**
     * 根据键值返回对应Int值
     *
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认参数
     * @return
     */
    public static int getInt(String key, int defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration().getInt(key, defaultValue);
    }

    /**
     * 根据键值返回对应Long值
     *
     * @param key properties文件中键值
     * @return
     */
    public static long getLong(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getLong(key);
    }

    /**
     * 根据键值返回对应Long值
     *
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认参数
     * @return
     */
    public static long getLong(String key, long defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration().getLong(key, defaultValue);
    }

    /**
     * 根据键值返回对应字符串值
     *
     * @param key properties文件中键值
     * @return
     */
    public static String getString(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getString(key);
    }

    /**
     * 根据键值返回对应字符串值
     *
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认参数
     * @return
     */
    public static String getString(String key, String defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration().getString(key, defaultValue);
    }

    /**
     * 根据键值返回对应数组值
     *
     * @param key properties文件中键值
     * @return
     */
    public static String[] getStringArray(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getStringArray(key);
    }

    /**
     * 根据键值返回对应集合
     *
     * @param key properties文件中键值
     * @return
     */
    public static List<Object> getList(String key) {
        AssertUtil.notNull(key);
        return getConfiguration().getList(key);
    }

    /**
     * 根据键值返回对应集合
     *
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认集合
     * @return
     */
    public static List<Object> getList(String key, List<Object> defaultValues) {
        AssertUtil.notNull(key);
        return getConfiguration().getList(key, defaultValues);
    }

    /**
     * 根据文件名和键值返回对应Double值
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static double getDoubleInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getDouble(key);
    }

    /**
     * 根据文件名和键值返回对应Double值
     *
     * @param module       log4j.properties中的log4j
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认Double值
     * @return
     */
    public static double getDoubleInModule(String module, String key, double defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getDouble(key, defaultValue);
    }

    /**
     * 根据文件名和键值返回对应Int值
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static int getIntInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getInt(key);
    }

    /**
     * 根据文件名和键值返回对应Int值
     *
     * @param module       log4j.properties中的log4j
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认Int值
     * @return
     */
    public static int getIntInModule(String module, String key, int defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getInt(key, defaultValue);
    }

    /**
     * 根据文件名和键值返回对应Long值
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static long getLongInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getLong(key);
    }

    /**
     * 根据文件名和键值返回对应Long值
     *
     * @param module       log4j.properties中的log4j
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认Long值
     * @return
     */
    public static long getLongInModule(String module, String key, long defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getLong(key, defaultValue);
    }

    /**
     * 根据文件名和键值返回对应布尔值
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static boolean getBooleanInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getBoolean(key);
    }

    /**
     * 根据文件名和键值返回对应布尔值
     *
     * @param module       log4j.properties中的log4j
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认布尔值
     * @return
     */
    public static boolean getBooleanInModule(String module, String key, boolean defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getBoolean(key, defaultValue);
    }

    /**
     * 根据文件名和键值返回对应Double值
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static String getStringInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getString(key);
    }

    /**
     * 根据文件名和键值返回对应字符串值
     *
     * @param module       log4j.properties中的log4j
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认字符串值
     * @return
     */
    public static String getStringInModule(String module, String key, String defaultValue) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getString(key, defaultValue);
    }

    /**
     * 根据文件名和键值返回对应数组值
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static String[] getStringArrayInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getStringArray(key);
    }

    /**
     * 根据文件名和键值返回对应集合
     *
     * @param module log4j.properties中的log4j
     * @param key    properties文件中键值
     * @return
     */
    public static List<Object> getListInModule(String module, String key) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getList(key);
    }

    /**
     * 根据文件名和键值返回对应集合
     *
     * @param module       log4j.properties中的log4j
     * @param key          properties文件中键值
     * @param defaultValue 无结果返回默认集合
     * @return
     */
    public static List<Object> getListInModule(String module, String key, List<Object> defaultValues) {
        AssertUtil.notNull(key);
        return getConfiguration(module).getList(key, defaultValues);
    }

    static {
        logger.debug("开始解析配置文件！start--- >");
        scanFiles("classpath:");
//        try {
//            File dir = ResourceUtils.getFile("classpath:");
//            if (dir.isDirectory()) {
//                File[] files = dir.listFiles();
//                for (File file : files) {
//                    if (file.isDirectory()) {
//
//                    }
//                    if (!(file.getName().endsWith(prefix))) continue;
//                    try {
//                        PropertiesConfiguration config = new PropertiesConfiguration(file);
//                        FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
//                        strategy.setRefreshDelay(5000L);
//                        config.setReloadingStrategy(strategy);
//                        logger.debug("config name is: " + file.getName().replace(prefix, ""));
//                        compositeConfig.addConfiguration(config, file.getName().replace(prefix, ""));
//                    } catch (ConfigurationException e) {
//                        logger.error("加载配置文件出错!!!，配置文件名称：" + file.getPath() + "/" + file.getName(), e);
//                        System.exit(0);
//                    }
//                }
//            } else {
//                logger.error("查找配置文件根目录出错，classpath:properties不是一个目录！");
//            }
//        } catch (FileNotFoundException e) {
//            logger.error("没有找到配置文件根目录(classpath:properties/)", e);
//        }
//        logger.debug("结束解析配置文件！");
    }

    /**
     * 扫描属性文件解析
     * @param filePath
     */
    public static void scanFiles(String filePath) {
        try {
            File dir = ResourceUtils.getFile(filePath);
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        scanFiles(file.getAbsolutePath());
                    } else {
                        if (!(file.getName().endsWith(prefix))) continue;
                        try {
                            PropertiesConfiguration config = new PropertiesConfiguration(file);
                            FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
                            strategy.setRefreshDelay(5000L);
                            config.setReloadingStrategy(strategy);
                            logger.debug("config name is: " + file.getName().replace(prefix, ""));
                            compositeConfig.addConfiguration(config, file.getName().replace(prefix, ""));
                        } catch (ConfigurationException e) {
                            logger.error("加载配置文件出错!!!，配置文件名称：" + file.getPath() + "/" + file.getName(), e);
                            System.exit(0);
                        }
                    }
                }
            } else {
                logger.error("查找配置文件根目录出错，classpath:properties不是一个目录！");
            }
        } catch (FileNotFoundException e) {
            logger.error("没有找到配置文件根目录(classpath:properties/)", e);
        }
        logger.debug("结束解析配置文件！");
    }
}