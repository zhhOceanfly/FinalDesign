package com.dw.model;

import java.util.Date;

/**
 * @author DY1101shaoyuxian
 * 
 */
public class MANAGER {
	Admin admin;
	
	String type;//student, blog

	Long relationshipId;
	
	public MANAGER(){
		super();
	}
	public MANAGER(Admin admin, String type){
		this.admin = admin;
		this.type = type;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
