package lec.vis.mybatis.dao;

import java.util.List;

import lec.vis.mybatis.dto.CBoardDTO;

public interface BDao {
	public CBoardDTO view_content(int bID);
	public int binsert(String mID, String bTitl, String bCont);
	public List<CBoardDTO> blist();
	public int bmodify(int bID, String bTitl, String bCont, String mID);
	public int bdelete(int bID);
	public int reply(String mID, String bTitl, String bCont, int bGroup, int bSteps, int bIndnt);
	public CBoardDTO view_reply(int bID);
	public void upHit(int bID);
	
}
