package com.javaex.vo;

public class GalleryVO {
	
	//필드
	private int no;
	private String orgName;
	private String saveName;
	private String filePath;
	private long fileSize;
	private String userNo;
	
	
	//생성자
	public GalleryVO() {
		super();
	}


	public GalleryVO(int no, String orgName, String saveName, String filePath, long fileSize, 
		   String userNo) {
		super();
		this.no = no;
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.userNo = userNo;
	}


	
	//메소드gs
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	//메소드일반
	@Override
	public String toString() {
		return "GalleryVO [no=" + no + ", orgName=" + orgName + ", saveName=" + saveName + ", filePath=" + filePath
				+ ", fileSize=" + fileSize + ", userNo=" + userNo + "]";
	}

}
