package com.yoxnet.waterSystem.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.yoxnet.waterSystemLocation.bean.WaterSystemLocation;
//水系VO类
public class WaterSysVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
     * 任务名称
     */
    private String taskName;
	
	/**
     * 水系编号：第一个字母K表示水库，H表示河流，后面五位数字
     */
    private String waterSysId;

    /**
     * 时间
     */
    private String time;

    /**
     * 水位
     */
    private BigDecimal waterLevel;

    /**
     * 流量
     */
    private BigDecimal flow;

    /**
     * 含沙量
     */
    private BigDecimal siltConcentration;


    /**
     * 水系名称
     */
    private String waterSysName;

    /**
     * 防洪水位
     */
    private BigDecimal floodLevel;

    private List<WaterSystemLocation> locationList;

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the waterSysId
	 */
	public String getWaterSysId() {
		return waterSysId;
	}

	/**
	 * @param waterSysId the waterSysId to set
	 */
	public void setWaterSysId(String waterSysId) {
		this.waterSysId = waterSysId;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the waterLevel
	 */
	public BigDecimal getWaterLevel() {
		return waterLevel;
	}

	/**
	 * @param waterLevel the waterLevel to set
	 */
	public void setWaterLevel(BigDecimal waterLevel) {
		this.waterLevel = waterLevel;
	}

	/**
	 * @return the flow
	 */
	public BigDecimal getFlow() {
		return flow;
	}

	/**
	 * @param flow the flow to set
	 */
	public void setFlow(BigDecimal flow) {
		this.flow = flow;
	}

	/**
	 * @return the siltConcentration
	 */
	public BigDecimal getSiltConcentration() {
		return siltConcentration;
	}

	/**
	 * @param siltConcentration the siltConcentration to set
	 */
	public void setSiltConcentration(BigDecimal siltConcentration) {
		this.siltConcentration = siltConcentration;
	}

	/**
	 * @return the waterSysName
	 */
	public String getWaterSysName() {
		return waterSysName;
	}

	/**
	 * @param waterSysName the waterSysName to set
	 */
	public void setWaterSysName(String waterSysName) {
		this.waterSysName = waterSysName;
	}

	/**
	 * @return the floodLevel
	 */
	public BigDecimal getFloodLevel() {
		return floodLevel;
	}

	/**
	 * @param floodLevel the floodLevel to set
	 */
	public void setFloodLevel(BigDecimal floodLevel) {
		this.floodLevel = floodLevel;
	}

	/**
	 * @return the locationList
	 */
	public List<WaterSystemLocation> getLocationList() {
		return locationList;
	}

	/**
	 * @param locationList the locationList to set
	 */
	public void setLocationList(List<WaterSystemLocation> locationList) {
		this.locationList = locationList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public WaterSysVO(String taskName, String waterSysId, String time, BigDecimal waterLevel, BigDecimal flow,
			BigDecimal siltConcentration, String waterSysName, BigDecimal floodLevel,
			List<WaterSystemLocation> locationList) {
		super();
		this.taskName = taskName;
		this.waterSysId = waterSysId;
		this.time = time;
		this.waterLevel = waterLevel;
		this.flow = flow;
		this.siltConcentration = siltConcentration;
		this.waterSysName = waterSysName;
		this.floodLevel = floodLevel;
		this.locationList = locationList;
	}

	public WaterSysVO() {
		super();
	}

	
    
    
    
}