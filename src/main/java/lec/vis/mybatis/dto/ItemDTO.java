package lec.vis.mybatis.dto;

public class ItemDTO {
	private String iID;
	private String item;
	private String iSec;
	
	public String getiID() {
		return iID;
	}
	public void setiID(String iID) {
		this.iID = iID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getiSec() {
		return iSec;
	}
	public void setiSec(String iSec) {
		this.iSec = iSec;
	}
	public ItemDTO(String iID, String item, String iSec) {
		super();
		this.iID = iID;
		this.item = item;
		this.iSec = iSec;
	}
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IOItemDTO [iID=" + iID + ", item=" + item + ", iSec=" + iSec + "]";
	}
	
}
