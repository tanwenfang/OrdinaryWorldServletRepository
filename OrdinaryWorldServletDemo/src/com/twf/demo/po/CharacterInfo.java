package com.twf.demo.po;

import java.io.Serializable;

/**
 * 人物信息
 * @author twf
 *
 */
public class CharacterInfo implements Serializable{

	private static final long serialVersionUID = -3468076463472476354L;

	private String name; // 姓名
	
	private String sex; // 性别
	
	private String job; // 工作
	
	private String address; // 地址
	
	public CharacterInfo(String name, String sex, String job, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.job = job;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CharacterInfo [name=" + name + ", sex=" + sex + ", job=" + job
				+ ", address=" + address + "]";
	}
}