package com.ussco.xref.to.maintenance;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseMaintenanceTO implements Serializable {

	private String code;
	private String userId;
	private Date modifiedTime;
	private boolean del;
	private boolean modified;
	private boolean add;

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public boolean isDel() {
		return this.del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public boolean isModified() {
		return this.modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public boolean isAdd() {
		return this.add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

}
