package com.yoxnet.common.utils;

/**
 * 统计信息
 * 
 * @author huanghp
 * 
 */
public class ZgStatistic {

	/**
	 * 是否是最下层组 【1：是 0：否】
	 */
	private Integer bottomGroup;

	/**
	 * 组id
	 */
	private Integer groupId;
	/**
	 * 组名
	 */
	private String groupName;
	/**
	 * 组长Id
	 */
	private Integer groupLeaderId;
	/**
	 *  组长名称
	 */
	private String leaderName;
	/**
	 * 总数
	 */
	private Integer total;
	/**
	 * 类型 1 订单统计 2 注册统计 3派件统计 4 提成信息
	 */
	private Integer type;

	public Integer getBottomGroup() {
		return bottomGroup;
	}

	public void setBottomGroup(Integer bottomGroup) {
		this.bottomGroup = bottomGroup;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupLeaderId() {
		return groupLeaderId;
	}

	public void setGroupLeaderId(Integer groupLeaderId) {
		this.groupLeaderId = groupLeaderId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

}
