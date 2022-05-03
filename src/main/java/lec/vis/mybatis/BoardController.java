package lec.vis.mybatis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lec.vis.service.Constant;
import lec.vis.service.IBoardService;

import lec.vis.mybatis.dao.BDao;
import lec.vis.mybatis.dto.CBoardDTO;

/**
 * Servlet implementation class LedgerController
 */
@Controller
public class BoardController{
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	IBoardService service;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@RequestMapping("/boardpage")
	public String boardlist(Model model, HttpServletRequest request,HttpServletResponse response) {
//		BDao dao = sqlSession.getMapper(BDao.class);
//		model.addAttribute("boardlist",dao.blist());
		return "boardpage";
	}
	
    
	@RequestMapping("/cboard")
	public String boardlist(Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		model.addAttribute("boardlist",dao.blist());
		return "cboard";
	}
	
	@RequestMapping("/bdelete")
	public String bdelete(HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.bdelete(Integer.parseInt(request.getParameter("bID")));
		return "redirect:cboard";
	}
	
	@RequestMapping("/binsert")
	public String binsert(HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		String mID = request.getParameter("mID");
		String bTitl = request.getParameter("bTitl");
		String bCont = request.getParameter("bCont");

		dao.binsert(mID, bTitl, bCont);
		
		return "redirect:cboard";
	}
	@RequestMapping("/content_write")
	public String bwrite() {
		return "content_write";
	}
	@RequestMapping("/content_view")
	public String cview(HttpServletRequest request) {
		int bID = Integer.parseInt(request.getParameter("bID"));
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.upHit(bID);
		CBoardDTO dto = dao.view_content(bID);
		request.setAttribute("content_view", dto);
		return "content_view";
	}
	@RequestMapping("/c_mod")
	public String cmod(Model model, HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		String bid = request.getParameter("bID");
		model.addAttribute("dto",dao.view_content(Integer.parseInt(bid)));
		return "content_modify";
	}
	@RequestMapping("/content_mod")
	public String conmod(HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		int bID = Integer.parseInt(request.getParameter("bID"));
		String bTitl = request.getParameter("bTitl");
		String bCont = request.getParameter("bCont");
		String mID = request.getParameter("mID");
		dao.bmodify(bID, bTitl, bCont, mID);
		return "redirect:cboard";
	}
	
	@RequestMapping("/reply")
	public String rinsert(HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		String mID = request.getParameter("mID");
		String bTitl = request.getParameter("bTitl");
		String bCont = request.getParameter("bCont");
		int bGroup = Integer.parseInt(request.getParameter("bGroup"));
		int bSteps = Integer.parseInt(request.getParameter("bSteps"));
		int bIndnt = Integer.parseInt(request.getParameter("bIndnt"));

		dao.reply(mID, bTitl, bCont, bGroup, bSteps, bIndnt);
		
		return "redirect:cboard";
	}
	@RequestMapping("/reply_write")
	public String rwrite(Model model, HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		String bid = request.getParameter("bID");
		model.addAttribute("dto",dao.view_content(Integer.parseInt(bid)));
		return "reply_write";
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
