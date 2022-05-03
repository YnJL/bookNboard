package lec.vis.mybatis.dto;

import java.sql.Timestamp;

public class MemberDTO {
	private String mID;
	private String mPW;
	private String mName;
	private String mPhon;
	private Timestamp mRdte;
	
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getmPW() {
		return mPW;
	}
	public void setmPW(String mPW) {
		this.mPW = mPW;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPhon() {
		return mPhon;
	}
	public void setmPhon(String mPhon) {
		this.mPhon = mPhon;
	}
	public Timestamp getmRdte() {
		return mRdte;
	}
	public void setmRdte(Timestamp mRdte) {
		this.mRdte = mRdte;
	}
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String mID, String mPW, String mName, String mPhon) {
		super();
		this.mID = mID;
		this.mPW = mPW;
		this.mName = mName;
		this.mPhon = mPhon;
	}
	@Override
	public String toString() {
		return "MemberDTO [mID=" + mID + ", mPW=" + mPW + ", mName=" + mName + ", mPhon=" + mPhon + ", mRdte=" + mRdte
				+ "]";
	}
	
}
