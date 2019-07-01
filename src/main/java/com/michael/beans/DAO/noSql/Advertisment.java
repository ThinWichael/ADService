package com.michael.beans.DAO.noSql;

import org.springframework.data.annotation.Id;

public class Advertisment implements Cloneable{

	@Id
    public String _id;
	
	public String title;
	public String url;
	public Integer capWindowMin;
	public Integer capNum;
	
	public Advertisment(String _id, String title, String url, Integer capWindowMin, Integer capNum) {
		this._id = _id;
		this.title = title;
		this.url = url;
		this.capWindowMin = capWindowMin;
		this.capNum = capNum;
	}
	
	@Override
	 public Object clone() throws CloneNotSupportedException {
	  return super.clone();
	 }
	
	@Override
    public String toString() {
        return String.format(
                "Student[_id=%s, title='%s', url='%s', capWindowMin=%s , capNum=%s ]",
                _id, title, url, capWindowMin, capNum);
    }
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCapWindowMin() {
		return capWindowMin;
	}

	public void setCapWindowMin(Integer capWindowMin) {
		this.capWindowMin = capWindowMin;
	}

	public Integer getCapNum() {
		return capNum;
	}

	public void setCapNum(Integer capNum) {
		this.capNum = capNum;
	}

	public Advertisment() {
		// TODO Auto-generated constructor stub
	}

}
