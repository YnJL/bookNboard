package lec.vis.service;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import lec.vis.mybatis.dao.BDao;
import lec.vis.mybatis.dto.CBoardDTO;

import java.util.Collections;

// 페이징 처리 부분도 포함시키는 것이 바람직함 
public class BListService implements IBoardService{

	private SqlSession sqlSession = Constant.sqlSession;
	public static final int PostPerPage = 10;
	public BListService() {}
	@Override
	public void execute(Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		List<CBoardDTO> dtos = dao.blist();
		model.addAttribute("list",dtos);
	}
	
	// 추가 메소드 들 
	public List<CBoardDTO> selectList(int a,int z) throws SQLException{
		BDao dao = sqlSession.getMapper(BDao.class);
		List<CBoardDTO> dtos = dao.blist();//모든 자료 
		return dtos.subList(a-1,z);// 페이지에 나타낼 자료
	}
	
	// 페이징 처리를 위한 객체 얻기
	public BoardList getBoardView(int pageNum) throws SQLException{
		int cpageNum = pageNum;
		BDao dao = sqlSession.getMapper(BDao.class);
		int TotalPost = dao.blist().size(); 
		List<CBoardDTO> boardList = null;
		int pageFirstPost = 0;
		int pageLastPost = 0;
		if(TotalPost>0) {
			// 10페이지 : (10-1)*ppp+1  ===> 10페이지 첫행은 91번 자료 
			pageFirstPost = (pageNum-1) * PostPerPage +1;
			pageLastPost = pageFirstPost + PostPerPage -1; //100 
			// 마지막 페이지의 끝번호는 마지막 자료보다 큰 인덱스면 안된다.
			if(pageLastPost>TotalPost) {
				pageLastPost = TotalPost;
			}
			boardList = selectList(pageFirstPost,pageLastPost);
			
		}else {
			cpageNum = 0;
			boardList = Collections.emptyList();
			
		}
		return new BoardList(
				TotalPost,cpageNum,boardList,PostPerPage,pageFirstPost,pageLastPost
		);
	}

}
