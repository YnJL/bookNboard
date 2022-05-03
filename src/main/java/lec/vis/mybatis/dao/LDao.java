package lec.vis.mybatis.dao;

import java.util.List;

import lec.vis.mybatis.dto.LedgerDTO;

public interface LDao {
	public int linsert(LedgerDTO dto);
	public int ldelete(int lID);
	public int lupdate(LedgerDTO dto);
	public LedgerDTO lselect(int lID);
	public List<LedgerDTO> lselectAll();
	public List<LedgerDTO> lselByMID(String mID);
	public List<LedgerDTO> lselByMon(String mID, String yr, String mn);
	
}
