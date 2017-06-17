package com.yoxnet.points.vo;

import java.io.Serializable;
import java.util.List;

import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;

/**
 * 隐患点
 */
public class PointesVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private String id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 起始桩编号
     */
    private String startPileId;

    /**
     * 结束桩编号
     */
    private String endPileId;

    /**
     * 起始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 灾害类型：选：提示、滑坡泥石流、河流超标洪水、水库溃决、雪灾、道路结冰
     */
    private String disasterType;

    /**
     * 灾害级别：选：绿、蓝、黄、橙、红（绿色为灾害类型为提示）
     */
    private String disasterLevel;
    
    /**
     * 灾害状态：点状灾害或线状灾害
     */
    private String disasterState;

    /**
     * 说明
     */
    private String details;
    
    
	/**---------公里桩数据字段---------------*/
    
    /**
     * 公里桩编号
     */
    private String kilometerPileId;
    /**
     * 公里桩数据集合
     */
    private List<KilometerPileInfo> pileList;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	 * @return the startPileId
	 */
	public String getStartPileId() {
		return startPileId;
	}
	/**
	 * @param startPileId the startPileId to set
	 */
	public void setStartPileId(String startPileId) {
		this.startPileId = startPileId;
	}
	/**
	 * @return the endPileId
	 */
	public String getEndPileId() {
		return endPileId;
	}
	/**
	 * @param endPileId the endPileId to set
	 */
	public void setEndPileId(String endPileId) {
		this.endPileId = endPileId;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the disasterType
	 */
	public String getDisasterType() {
		return disasterType;
	}
	/**
	 * @param disasterType the disasterType to set
	 */
	public void setDisasterType(String disasterType) {
		this.disasterType = disasterType;
	}
	/**
	 * @return the disasterLevel
	 */
	public String getDisasterLevel() {
		return disasterLevel;
	}
	/**
	 * @param disasterLevel the disasterLevel to set
	 */
	public void setDisasterLevel(String disasterLevel) {
		this.disasterLevel = disasterLevel;
	}
	/**
	 * @return the disasterState
	 */
	public String getDisasterState() {
		return disasterState;
	}
	/**
	 * @param disasterState the disasterState to set
	 */
	public void setDisasterState(String disasterState) {
		this.disasterState = disasterState;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the kilometerPileId
	 */
	public String getKilometerPileId() {
		return kilometerPileId;
	}
	/**
	 * @param kilometerPileId the kilometerPileId to set
	 */
	public void setKilometerPileId(String kilometerPileId) {
		this.kilometerPileId = kilometerPileId;
	}
	/**
	 * @return the pileList
	 */
	public List<KilometerPileInfo> getPileList() {
		return pileList;
	}
	/**
	 * @param pileList the pileList to set
	 */
	public void setPileList(List<KilometerPileInfo> pileList) {
		this.pileList = pileList;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PointesVO(String id, String taskName, String startPileId, String endPileId, String startTime,
			String endTime, String disasterType, String disasterLevel, String disasterState, String details,
			String kilometerPileId, List<KilometerPileInfo> pileList) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.startPileId = startPileId;
		this.endPileId = endPileId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.disasterType = disasterType;
		this.disasterLevel = disasterLevel;
		this.disasterState = disasterState;
		this.details = details;
		this.kilometerPileId = kilometerPileId;
		this.pileList = pileList;
	}
	public PointesVO() {
		super();
	}


    
    

  
}