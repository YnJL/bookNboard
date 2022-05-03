package lec.vis.mybatis.dto;

import java.sql.Timestamp;

public class CBoardDTO {
	private int bID;
	private String mID;
	private String bTitl;
	private String bCont;
	private Timestamp bDate;
	private int bHits;
	private int bGroup;
	private int bSteps;
	private int bIndnt;
	
	public CBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CBoardDTO(int bID, String mID, String bTitl, String bCont) {
		super();
		this.bID = bID;
		this.mID = mID;
		this.bTitl = bTitl;
		this.bCont = bCont;
	}
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getbTitl() {
		return bTitl;
	}
	public void setbTitl(String bTitl) {
		this.bTitl = bTitl;
	}
	public String getbCont() {
		return bCont;
	}
	public void setbCont(String bCont) {
		this.bCont = bCont;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHits() {
		return bHits;
	}
	public void setbHits(int bHits) {
		this.bHits = bHits;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbSteps() {
		return bSteps;
	}
	public void setbSteps(int bSteps) {
		this.bSteps = bSteps;
	}
	public int getbIndnt() {
		return bIndnt;
	}
	public void setbIndnt(int bIndnt) {
		this.bIndnt = bIndnt;
	}
	@Override
	public String toString() {
		return "CBoardDTO [bID=" + bID + ", mID=" + mID + ", bTitl=" + bTitl + ", bCont=" + bCont + ", bDate=" + bDate
				+ ", bHits=" + bHits + ", bGroup=" + bGroup + ", bSteps=" + bSteps + ", bIndnt=" + bIndnt + "]";
	}	
}
