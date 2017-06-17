package com.yoxnet.waterSystemInfo.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.waterSystem.vo.WaterSysVO;

public class WaterSystemInfo implements Serializable {
	
	private final static Logger logger = LoggerFactory.getLogger(WaterSystemInfo.class);
	
    private Integer id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 水系编号：第一个字母K表示水库，H表示河流，后面五位数字
     */
    private String waterSysId;

    /**
     * 水系名称
     */
    private String waterSysName;

    /**
     * 防洪水位
     */
    private BigDecimal floodLevel;
    
    /**将本身对象转换成vo对象返回*/
  	public WaterSysVO toCommandVO(){
  		WaterSysVO commandVo = new WaterSysVO();
  		try {
  			PropertyUtils.copyProperties(commandVo, this);
  		} catch (IllegalAccessException | InvocationTargetException
  				| NoSuchMethodException e) {
  			e.printStackTrace();
  			logger.error("实体转换vo错误："+ErrCodeE.NONE);
  		}
  		return commandVo;
  	}

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getWaterSysId() {
        return waterSysId;
    }

    public void setWaterSysId(String waterSysId) {
        this.waterSysId = waterSysId == null ? null : waterSysId.trim();
    }

    public String getWaterSysName() {
        return waterSysName;
    }

    public void setWaterSysName(String waterSysName) {
        this.waterSysName = waterSysName == null ? null : waterSysName.trim();
    }

    public BigDecimal getFloodLevel() {
        return floodLevel;
    }

    public void setFloodLevel(BigDecimal floodLevel) {
        this.floodLevel = floodLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskName=").append(taskName);
        sb.append(", waterSysId=").append(waterSysId);
        sb.append(", waterSysName=").append(waterSysName);
        sb.append(", floodLevel=").append(floodLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}