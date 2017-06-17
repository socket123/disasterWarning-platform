package com.yoxnet.waterSystemLocation.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.waterSystem.vo.WaterSysVO;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrology;

public class WaterSystemLocation implements Serializable {
	
	private final static Logger logger = LoggerFactory.getLogger(WaterSystemHydrology.class);
	
    private String id;

    /**
     * 水系定位点编号：水系编号_X,   X表示一位数字
     */
    private String waterLocationId;

    /**
     * 水系编号
     */
    private String waterSysId;

    /**
     * 定位点经度
     */
    private BigDecimal locationLongitude;

    /**
     * 定位点纬度
     */
    private BigDecimal locationLatitude;
    
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWaterLocationId() {
        return waterLocationId;
    }

    public void setWaterLocationId(String waterLocationId) {
        this.waterLocationId = waterLocationId == null ? null : waterLocationId.trim();
    }

    public String getWaterSysId() {
        return waterSysId;
    }

    public void setWaterSysId(String waterSysId) {
        this.waterSysId = waterSysId == null ? null : waterSysId.trim();
    }

    public BigDecimal getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(BigDecimal locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public BigDecimal getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(BigDecimal locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", waterLocationId=").append(waterLocationId);
        sb.append(", waterSysId=").append(waterSysId);
        sb.append(", locationLongitude=").append(locationLongitude);
        sb.append(", locationLatitude=").append(locationLatitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}