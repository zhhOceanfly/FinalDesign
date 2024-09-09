package com.dw.model;

import java.util.Date;
import java.util.HashSet;

/**
 * 日志
 * @author DY1101shaoyuxian
 *
 */
public class Blog {
	public static int blogId = 1;
	Long nodeId;
	String title;
	Date pubDate; //发表时间
	int goodCounts; //点赞人数
	
	Iterable<Publish> publish = new HashSet<Publish>();
	
	Iterable<Comment> comment = new HashSet<Comment>();
	
	public Blog(){
		super();
	}
	public Blog(String title){
		this.title = title;
		this.goodCounts = 0;
		this.pubDate = new java.util.Date();
	}
	
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setDate(Date date) {
		this.pubDate = date;
	}
	public int getGoodCounts(){
		return goodCounts;
	}
	public void addGoodCounts(){
		this.goodCounts += 1;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Iterable<Publish> getPublish() {
		return publish;
	}
	public void setPublish(Iterable<Publish> publish) {
		this.publish = publish;
	}
	public Iterable<Comment> getComment() {
		return comment;
	}
	public void setComment(Iterable<Comment> comment) {
		this.comment = comment;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blog blog = (Blog) o;

        if (nodeId != null ? !nodeId.equals(blog.nodeId) : blog.nodeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : 0;
    }
}
