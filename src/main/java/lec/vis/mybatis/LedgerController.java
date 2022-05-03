package lec.vis.mybatis;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lec.vis.mybatis.dao.ItemDao;
import lec.vis.mybatis.dao.LDao;
import lec.vis.mybatis.dto.LedgerDTO;

/**
 * Servlet implementation class LedgerController
 */
@Controller
public class LedgerController{
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LedgerController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@RequestMapping("/lAdmin")
	public String listadmin(Model model) {
		LDao dao = sqlSession.getMapper(LDao.class);
		model.addAttribute("list",dao.lselectAll());
		return "lAdmin";
	}
	
	@RequestMapping("/ledger")//
	public String ledger(Model model, HttpServletRequest request){
		LDao dao = sqlSession.getMapper(LDao.class);
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mid");
		List<LedgerDTO> list = dao.lselByMID(mID);
		int sum_inc=0, sum_exp=0, sum_bal=0;
		for(LedgerDTO x : list) {
			sum_inc+= x.getIncome();
			sum_exp+= x.getExpnse();
		}
		sum_bal=sum_inc-sum_exp;
		model.addAttribute("list",list);
		model.addAttribute("sum_inc", sum_inc);
		model.addAttribute("sum_exp", sum_exp);
		model.addAttribute("sum_bal", sum_bal);
		return "ledger";
	}
	
	@RequestMapping("/sByMn")//
	public String lByMon(Model model, HttpServletRequest request){
		LDao dao = sqlSession.getMapper(LDao.class);
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mid");
		String sYrMn = request.getParameter("sMonth");
		String mon[] = sYrMn.split("-");
		List<LedgerDTO> list = dao.lselByMon(mID, mon[0], mon[1]);
		int sum_inc=0, sum_exp=0, sum_bal=0;
		for(LedgerDTO x : list) {
			sum_inc+= x.getIncome();
			sum_exp+= x.getExpnse();
		}
		sum_bal=sum_inc-sum_exp;
		model.addAttribute("list",list);
		model.addAttribute("sum_inc", sum_inc);
		model.addAttribute("sum_exp", sum_exp);
		model.addAttribute("sum_bal", sum_bal);
		model.addAttribute("year", mon[0]);
		model.addAttribute("month", mon[1]);
		return "lByMon";
	}
	
	@RequestMapping("/ldelete")
	public String ldelete(HttpServletRequest request) {
		LDao dao = sqlSession.getMapper(LDao.class);
		dao.ldelete(Integer.parseInt(request.getParameter("lID")));
		return "redirect:ledger";			// 나중에 ledger로 redirect할것
	}
	
	@RequestMapping("/linsert")
	public String linsert(HttpServletRequest request) {
		LDao dao = sqlSession.getMapper(LDao.class);
		LedgerDTO dto = new LedgerDTO();
		dto.setmID(request.getParameter("mID"));
		
		String strDate = request.getParameter("lDate"); 
		//날짜입력 : 년월일시분초 분해 -> 재조립
		String token[] = strDate.split("-");
		int yr = Integer.parseInt(token[0]);
		int mo = Integer.parseInt(token[1]);
		int da = Integer.parseInt(token[2]);
		@SuppressWarnings("deprecation")
		Date date = new Date(yr-1900, mo-1, da);
		
		dto.setlDate(date);
		dto.setiID(request.getParameter("iID"));
		dto.setDetail(request.getParameter("detail"));
		if(request.getParameter("income")=="") {
			dto.setIncome(0);
		} else {
			dto.setIncome(Integer.parseInt(request.getParameter("income")));
		}
		if(request.getParameter("expnse")=="") {
			dto.setExpnse(0);
		} else {
			dto.setExpnse(Integer.parseInt(request.getParameter("expnse")));
		}
		dto.setNote(request.getParameter("note"));
		dao.linsert(dto);
		return "redirect:ledger";
	}
	@RequestMapping("/ladd")
	public String ladd(Model model) {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		model.addAttribute("items",dao.selectAll());
		return "ladd";
	}
	
	@RequestMapping("/lupdate")
	public String lupdate(HttpServletRequest request) {
		LDao dao = sqlSession.getMapper(LDao.class);
		LedgerDTO dto = new LedgerDTO();
		dto.setlID(Integer.parseInt(request.getParameter("lID")));
		
		String strDate = request.getParameter("lDate"); 
//		String token[] = strDate.split("-");
//		int yr = Integer.parseInt(token[0]);
//		int mo = Integer.parseInt(token[1]);
//		int da = Integer.parseInt(token[2]);
		Date date = Date.valueOf(strDate);
		
		dto.setlDate(date);
		dto.setiID(request.getParameter("iID"));
		dto.setDetail(request.getParameter("detail"));
		if(request.getParameter("income")=="") {
			dto.setIncome(0);
		} else {
			dto.setIncome(Integer.parseInt(request.getParameter("income")));
		}
		if(request.getParameter("expnse")=="") {
			dto.setExpnse(0);
		} else {
			dto.setExpnse(Integer.parseInt(request.getParameter("expnse")));
		}
		dto.setNote(request.getParameter("note"));
		dao.lupdate(dto);
		return "redirect:ledger";
	}
	@RequestMapping("/lmodify")
	public String lmod(Model model, HttpServletRequest request) {
		ItemDao idao = sqlSession.getMapper(ItemDao.class);
		model.addAttribute("items",idao.selectAll());
		LDao ldao = sqlSession.getMapper(LDao.class);
		String lid = request.getParameter("lID");
		model.addAttribute("ldto",ldao.lselect(Integer.parseInt(lid)));
		return "lmod";
	}
	@RequestMapping("/items")
	public String items(Model model) {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		model.addAttribute("items",dao.selectAll());
		return "items";
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
