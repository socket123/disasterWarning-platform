package com.yoxnet.kilometerPileInfo.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class KilometerPileInfo implements Serializable {
    private Integer id;

    /**
     * 公里桩编号：道路名称_桩公里
     */
    private String kilometerPileId;

    /**
     * 道路名称
     */
    private String roadName;

    /**
     * 桩公里
     */
    private Integer pileLength;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKilometerPileId() {
        return kilometerPileId;
    }

    public void setKilometerPileId(String kilometerPileId) {
        this.kilometerPileId = kilometerPileId == null ? null : kilometerPileId.trim();
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName == null ? null : roadName.trim();
    }

    public Integer getPileLength() {
        return pileLength;
    }

    public void setPileLength(Integer pileLength) {
        this.pileLength = pileLength;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", kilometerPileId=").append(kilometerPileId);
        sb.append(", roadName=").append(roadName);
        sb.append(", pileLength=").append(pileLength);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}