package lec.vis.mybatis.dto;

import java.sql.Date;

public class LedgerDTO {
	private int lID;
	private String mID;
	private Date lDate;
	private String iID;
	private String detail;
	private int income;
	private int expnse;
	private String note;
	
	public int getlID() {
		return lID;
	}
	public void setlID(int lID) {
		this.lID = lID;
	}
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}
	public String getiID() {
		return iID;
	}
	public void setiID(String iID) {
		this.iID = iID;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getExpnse() {
		return expnse;
	}
	public void setExpnse(int expnse) {
		this.expnse = expnse;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public LedgerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LedgerDTO(int lID, String mID, Date lDate, String iID, String detail, int income, int expnse,
			String note) {
		super();
		this.lID = lID;
		this.mID = mID;
		this.lDate = lDate;
		this.iID = iID;
		this.detail = detail;
		this.income = income;
		this.expnse = expnse;
		this.note = note;
	}
	@Override
	public String toString() {
		return "LedgerDTO [lID=" + lID + ", mID=" + mID + ", lDate=" + lDate + ", iID=" + iID + ", detail=" + detail
				+ ", income=" + income + ", expnse=" + expnse + ", note=" + note + "]";
	}
	
	
	
}
