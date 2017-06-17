package com.yoxnet.hedgeMeasures.bean;

import java.io.Serializable;

public class DataHedgeMeasures implements Serializable {
    private String id;

    /**
     * 灾害类型：选：提示、滑坡泥石流、河流超标洪水、水库溃决、雪灾、道路结冰
     */
    private String disasterType;

    /**
     * 灾害级别：选：蓝、黄、橙、红
     */
    private String disasterLevel;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", disasterType=").append(disasterType);
        sb.append(", disasterLevel=").append(disasterLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}