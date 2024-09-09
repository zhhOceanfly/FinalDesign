package com.dw.model;

import java.util.Date;

/**
 * @author DY1101shaoyuxian
 * 
 */
public class Publish {
	Student stu;
	Blog blog;
	Long relationshipId;
	
	public Publish(){
		super();
	}
	public Publish(Student stu,Blog blog){
		this.stu = stu;
		this.blog = blog;
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
