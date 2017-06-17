package com.yoxnet.hiddenPoints.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import com.yoxnet.points.vo.PointesVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.disaster.service.impl.DisasterServiceImpl;
import com.yoxnet.disaster.vo.DisasterVO;

/**
 * 隐患点  点状
 */

public class HiddenPoints implements Serializable {
	
	private final static Logger logger = LoggerFactory.getLogger(DisasterServiceImpl.class);
	
    private String id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 公里桩编号
     */
    private String kilometerPileId;

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
     * 说明
     */
    private String details;

    private static final long serialVersionUID = 1L;
    
    /**将本身对象转换成vo对象返回*/
  	public PointesVO toCommandVO(){
        PointesVO commandVo = new PointesVO();
  		try {
  			PropertyUtils.copyProperties(commandVo, this);
  		} catch (IllegalAccessException | InvocationTargetException
  				| NoSuchMethodException e) {
  			e.printStackTrace();
  			logger.error("实体转换vo错误："+ErrCodeE.NONE);
  		}
  		return commandVo;
  	}
  	
  	public HiddenPoints fromCommandVo(DisasterVO commandVo){
  		try {
  			PropertyUtils.copyProperties(this, commandVo);
  		} catch (IllegalAccessException | InvocationTargetException
  				| NoSuchMethodException e) {
  			e.printStackTrace();
  			logger.error("vo转换实体错误："+ErrCodeE.NONE);
  		}
  		return this;
  	}	

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getKilometerPileId() {
        return kilometerPileId;
    }

    public void setKilometerPileId(String kilometerPileId) {
        this.kilometerPileId = kilometerPileId == null ? null : kilometerPileId.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType == null ? null : disasterType.trim();
    }

    public String getDisasterLevel() {
        return disasterLevel;
    }

    public void setDisasterLevel(String disasterLevel) {
        this.disasterLevel = disasterLevel == null ? null : disasterLevel.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskName=").append(taskName);
        sb.append(", kilometerPileId=").append(kilometerPileId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", disasterType=").append(disasterType);
        sb.append(", disasterLevel=").append(disasterLevel);
        sb.append(", details=").append(details);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}