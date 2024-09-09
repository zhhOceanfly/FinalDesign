package com.dw.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生实体类
 * 
 * @author DY1101shaoyuxian
 * 
 */
public class Student {

	private String stId;// 学号
	private Long nodeId; //neo4j内部编号
	private String stName;// 姓名
	private String stSex;// 性别
	private String stAge;// 年龄
	private String stTel;// 电话
	private String stDept;// 学院
	private String stAddress;// 家庭地址
	private String stIdCard;// 身份证号
	private String stPassword;// 密码
	private String stRegTime;//注册时间
	
	Set<Student> friends = new HashSet<Student>();

	Set<Publish> publish = new HashSet<Publish>();
	
	Set<Comment> comment = new HashSet<Comment>();
	
	public Set<Student> getFriends() {
		return friends;
	}
	public void addFriend(Student friend) {
		friends.add(friend);
	}

	public Set<Publish> getPublish() {
		return publish;
	}
	public void addPublish(Blog blog) {
		publish.add(new Publish(this,blog));
	}

	public Set<Comment> getComment() {
		return comment;
	}
	public void addComment(Blog blog,String title){
		comment.add(new Comment(this,blog,title));
	}
	
	public String getStId() {
		return stId;
	}
	public void setStId(String stId) {
		this.stId = stId;
	}
	
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStSex() {
		return stSex;
	}
	public void setStSex(String stSex) {
		this.stSex = stSex;
	}

	public String getStAge() {
		return stAge;
	}
	public void setStAge(String stAge) {
		this.stAge = stAge;
	}

	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}

	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}

	public String getStAddress() {
		return stAddress;
	}
	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}
	public String getStPassword() {
		return stPassword;
	}
	public void setStPassword(String password) {
		this.stPassword = password;
	}
	public String getStIdCard(){
		return stIdCard;
	}
	public void setStIdCard(String idCard){
		this.stIdCard = idCard;
	}
	public String getStRegTime(){
		return stRegTime;
	}
	public void setStRegTime(){
		this.stRegTime = (new java.util.Date()).toString();
	}
	
	public Student() {
		super();
	}
	public Student(String stuId, String password) {
		this.stId = stuId;
		this.stPassword = password;
	}
	public Student(String stuId, String stName, String password){
		this.stId = stuId;
		this.stName = stName;
		this.stPassword = password;
	}
	public Student(String stId, String stSex, String stAge,
			String stTel, String stDept, String stAddress, String stIdCard) {
		this.stId = stId;
		this.stName = stName;
		this.stSex = stSex;
		this.stAge = stAge;
		this.stTel = stTel;
		this.stDept = stDept;
		this.stAddress = stAddress;
		this.stIdCard = stIdCard;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student stu = (Student) o;

        if (nodeId != null ? !nodeId.equals(stu.nodeId) : stu.nodeId != null) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : 0;
    }
}
