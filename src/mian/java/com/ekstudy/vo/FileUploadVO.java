package com.ekstudy.vo;

public class FileUploadVO {
	private int uuid;
	private String myName;
	private byte[] myFile;
	
	
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public byte[] getMyFile() {
		return myFile;
	}
	public void setMyFile(byte[] myFile) {
		this.myFile = myFile;
	}
	
	
}
