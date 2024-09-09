package com.dw.model;

import java.util.Date;

/**
 * @author DY1101shaoyuxian
 * 
 */
public class Comment {
	Student stu;
	Blog blog;
	Date comDate; //∆¿¬€ ±º‰
	String comTitle;

	Long relationshipId;
	
	public Comment(){
		super();
	}
	public Comment(Student stu,Blog blog,String title){
		this.stu = stu;
		this.blog = blog;
		this.comDate = new java.util.Date();
		this.comTitle = title;
	}
	
	public String getComTitle() {
		return comTitle;
	}
	public void setComTitle(String comTitle) {
		this.comTitle = comTitle;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Date getDate() {
		return comDate;
	}
	public void setDate(Date date) {
		this.comDate = date;
	}
	public Long getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}
	
	@Override
    public int hashCode() {
        return relationshipId != null
                ? relationshipId.hashCode()
                : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Publish))
            return false;
        Publish that = (Publish)obj;

        return (relationshipId != null && that.relationshipId != null &&
                relationshipId.equals(that.relationshipId));
    }
}
