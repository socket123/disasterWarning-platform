package com.yoxnet.pathProfile.bean;

import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.disaster.service.impl.DisasterServiceImpl;
import com.yoxnet.disaster.vo.DisasterVO;
import com.yoxnet.pathProfile.service.impl.PathProfilrServiceImpl;
import com.yoxnet.profile.vo.ProfileVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/***
 * 路况线状表
 */

public class PathProfile implements Serializable {
	
	private final static Logger logger = LoggerFactory.getLogger(PathProfilrServiceImpl.class);
	
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
     *  预留字段
     */
    private String disasterType;

    /**
     * 预留字段
     */
    private String disasterLevel;

    /**
     * 说明 文字说明
     */
    private String details;

    private static final long serialVersionUID = 1L;
    
    /**将本身对象转换成vo对象返回*/
	public ProfileVO toCommandVO(){
        ProfileVO commandVo = new ProfileVO();
		try {
			PropertyUtils.copyProperties(commandVo, this);
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			logger.error("实体转换vo错误："+ErrCodeE.NONE);
		}
		return commandVo;
	}
	
	public PathProfile fromCommandVo(DisasterVO commandVo){
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

    public String getStartPileId() {
        return startPileId;
    }

    public void setStartPileId(String startPileId) {
        this.startPileId = startPileId == null ? null : startPileId.trim();
    }

    public String getEndPileId() {
        return endPileId;
    }

    public void setEndPileId(String endPileId) {
        this.endPileId = endPileId == null ? null : endPileId.trim();
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
        sb.append(", startPileId=").append(startPileId);
        sb.append(", endPileId=").append(endPileId);
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