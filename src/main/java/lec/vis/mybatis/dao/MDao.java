package lec.vis.mybatis.dao;

import java.util.List;

import lec.vis.mybatis.dto.MemberDTO;

public interface MDao {
	public void minsert(MemberDTO dto);
	public List<MemberDTO> mlist();
	public void mdelete(String mID);
	public int batch(List<MemberDTO> list);
	public MemberDTO mselect(String mID);
	public boolean login(String id, String pw);
}
