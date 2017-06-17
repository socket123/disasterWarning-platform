package com.yoxnet.log.bean;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private String id;

    /**
     * 推送时间
     */
    private Date logTime;

    /**
     * 推送标题
     */
    private String logTitle;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 推送内容
     */
    private String logContent;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle == null ? null : logTitle.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logTime=").append(logTime);
        sb.append(", logTitle=").append(logTitle);
        sb.append(", taskName=").append(taskName);
        sb.append(", logContent=").append(logContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}