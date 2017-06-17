package com.yoxnet.gps.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class GpsInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String TaskName;    //任务名称
	private String id;       	//车辆ID
	private String name;        //车辆号码
    private String recvtime;    //服务器时间（毫秒）
    private String gpstime;     //GPS时间（毫秒）
    private BigDecimal lat;     //纬度
    private BigDecimal lng;     //经度
    private BigDecimal lat_xz;  //纬度修正值
    private BigDecimal lng_xz;  //经度修正值
    private String state;       //车辆状态
    private String speed;       //速度
    private String direct;      //方向
    private String temp;       	//温度
    private String oil;       	//油量
    private String oilMN1;      //模拟量1
    private String oilMN2;      //模拟量2
    private String distance;    //模拟量1形式里程
    private String totalDis;    //总里程
    private String av;      	//有效性
    private String info;      	//文字位置信息
    private String vhcofflinemin;//不在线时长（分钟）
    private String stopDefDis;  //设防距离
    private String stopDefLat;  //设防纬度
    private String stopDefLng;  //设防经度
    private String temp1;      	//温度1
    private String temp2;     	//温度2
    private String temp3;     	//温度3
    private String temp4;     	//温度4
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return TaskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the recvtime
	 */
	public String getRecvtime() {
		return recvtime;
	}
	/**
	 * @param recvtime the recvtime to set
	 */
	public void setRecvtime(String recvtime) {
		this.recvtime = recvtime;
	}
	/**
	 * @return the gpstime
	 */
	public String getGpstime() {
		return gpstime;
	}
	/**
	 * @param gpstime the gpstime to set
	 */
	public void setGpstime(String gpstime) {
		this.gpstime = gpstime;
	}
	/**
	 * @return the lat
	 */
	public BigDecimal getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public BigDecimal getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	/**
	 * @return the lat_xz
	 */
	public BigDecimal getLat_xz() {
		return lat_xz;
	}
	/**
	 * @param lat_xz the lat_xz to set
	 */
	public void setLat_xz(BigDecimal lat_xz) {
		this.lat_xz = lat_xz;
	}
	/**
	 * @return the lng_xz
	 */
	public BigDecimal getLng_xz() {
		return lng_xz;
	}
	/**
	 * @param lng_xz the lng_xz to set
	 */
	public void setLng_xz(BigDecimal lng_xz) {
		this.lng_xz = lng_xz;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	/**
	 * @return the direct
	 */
	public String getDirect() {
		return direct;
	}
	/**
	 * @param direct the direct to set
	 */
	public void setDirect(String direct) {
		this.direct = direct;
	}
	/**
	 * @return the temp
	 */
	public String getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	/**
	 * @return the oil
	 */
	public String getOil() {
		return oil;
	}
	/**
	 * @param oil the oil to set
	 */
	public void setOil(String oil) {
		this.oil = oil;
	}
	/**
	 * @return the oilMN1
	 */
	public String getOilMN1() {
		return oilMN1;
	}
	/**
	 * @param oilMN1 the oilMN1 to set
	 */
	public void setOilMN1(String oilMN1) {
		this.oilMN1 = oilMN1;
	}
	/**
	 * @return the oilMN2
	 */
	public String getOilMN2() {
		return oilMN2;
	}
	/**
	 * @param oilMN2 the oilMN2 to set
	 */
	public void setOilMN2(String oilMN2) {
		this.oilMN2 = oilMN2;
	}
	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}
	/**
	 * @return the totalDis
	 */
	public String getTotalDis() {
		return totalDis;
	}
	/**
	 * @param totalDis the totalDis to set
	 */
	public void setTotalDis(String totalDis) {
		this.totalDis = totalDis;
	}
	/**
	 * @return the av
	 */
	public String getAv() {
		return av;
	}
	/**
	 * @param av the av to set
	 */
	public void setAv(String av) {
		this.av = av;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the vhcofflinemin
	 */
	public String getVhcofflinemin() {
		return vhcofflinemin;
	}
	/**
	 * @param vhcofflinemin the vhcofflinemin to set
	 */
	public void setVhcofflinemin(String vhcofflinemin) {
		this.vhcofflinemin = vhcofflinemin;
	}
	/**
	 * @return the stopDefDis
	 */
	public String getStopDefDis() {
		return stopDefDis;
	}
	/**
	 * @param stopDefDis the stopDefDis to set
	 */
	public void setStopDefDis(String stopDefDis) {
		this.stopDefDis = stopDefDis;
	}
	/**
	 * @return the stopDefLat
	 */
	public String getStopDefLat() {
		return stopDefLat;
	}
	/**
	 * @param stopDefLat the stopDefLat to set
	 */
	public void setStopDefLat(String stopDefLat) {
		this.stopDefLat = stopDefLat;
	}
	/**
	 * @return the stopDefLng
	 */
	public String getStopDefLng() {
		return stopDefLng;
	}
	/**
	 * @param stopDefLng the stopDefLng to set
	 */
	public void setStopDefLng(String stopDefLng) {
		this.stopDefLng = stopDefLng;
	}
	/**
	 * @return the temp1
	 */
	public String getTemp1() {
		return temp1;
	}
	/**
	 * @param temp1 the temp1 to set
	 */
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	/**
	 * @return the temp2
	 */
	public String getTemp2() {
		return temp2;
	}
	/**
	 * @param temp2 the temp2 to set
	 */
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	/**
	 * @return the temp3
	 */
	public String getTemp3() {
		return temp3;
	}
	/**
	 * @param temp3 the temp3 to set
	 */
	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}
	/**
	 * @return the temp4
	 */
	public String getTemp4() {
		return temp4;
	}
	/**
	 * @param temp4 the temp4 to set
	 */
	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public GpsInfo(String taskName, String id, String name, String recvtime, String gpstime, BigDecimal lat,
			BigDecimal lng, BigDecimal lat_xz, BigDecimal lng_xz, String state, String speed, String direct,
			String temp, String oil, String oilMN1, String oilMN2, String distance, String totalDis, String av,
			String info, String vhcofflinemin, String stopDefDis, String stopDefLat, String stopDefLng, String temp1,
			String temp2, String temp3, String temp4) {
		super();
		TaskName = taskName;
		this.id = id;
		this.name = name;
		this.recvtime = recvtime;
		this.gpstime = gpstime;
		this.lat = lat;
		this.lng = lng;
		this.lat_xz = lat_xz;
		this.lng_xz = lng_xz;
		this.state = state;
		this.speed = speed;
		this.direct = direct;
		this.temp = temp;
		this.oil = oil;
		this.oilMN1 = oilMN1;
		this.oilMN2 = oilMN2;
		this.distance = distance;
		this.totalDis = totalDis;
		this.av = av;
		this.info = info;
		this.vhcofflinemin = vhcofflinemin;
		this.stopDefDis = stopDefDis;
		this.stopDefLat = stopDefLat;
		this.stopDefLng = stopDefLng;
		this.temp1 = temp1;
		this.temp2 = temp2;
		this.temp3 = temp3;
		this.temp4 = temp4;
	}
	public GpsInfo() {
		super();
	}
}