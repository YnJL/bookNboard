package lec.vis.mybatis.dao;

import java.util.List;

import lec.vis.mybatis.dto.ItemDTO;

public interface ItemDao {
	public int insert(ItemDTO dto);
	public int delete(int iID);
	public int update(ItemDTO dto);
	public ItemDTO select(int iID);
	public List<ItemDTO> selectAll();
	
}
