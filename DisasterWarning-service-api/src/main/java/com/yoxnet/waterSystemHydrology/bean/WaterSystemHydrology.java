package com.yoxnet.waterSystemHydrology.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoxnet.common.code.ErrCodeE;
import com.yoxnet.waterSystem.vo.WaterSysVO;

public class WaterSystemHydrology implements Serializable {
	
	private final static Logger logger = LoggerFactory.getLogger(WaterSystemHydrology.class);
	
    private String id;

    /**
     * 水系编号
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

    public String getWaterSysId() {
        return waterSysId;
    }

    public void setWaterSysId(String waterSysId) {
        this.waterSysId = waterSysId == null ? null : waterSysId.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(BigDecimal waterLevel) {
        this.waterLevel = waterLevel;
    }

    public BigDecimal getFlow() {
        return flow;
    }

    public void setFlow(BigDecimal flow) {
        this.flow = flow;
    }

    public BigDecimal getSiltConcentration() {
        return siltConcentration;
    }

    public void setSiltConcentration(BigDecimal siltConcentration) {
        this.siltConcentration = siltConcentration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", waterSysId=").append(waterSysId);
        sb.append(", time=").append(time);
        sb.append(", waterLevel=").append(waterLevel);
        sb.append(", flow=").append(flow);
        sb.append(", siltConcentration=").append(siltConcentration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}