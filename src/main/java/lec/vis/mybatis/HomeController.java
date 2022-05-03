package lec.vis.mybatis;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lec.vis.mybatis.dao.MDao;
import lec.vis.mybatis.dto.MemberDTO;

import org.apache.ibatis.session.SqlSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/mlist")
	public String mlist(Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		model.addAttribute("mlist",dao.mlist());
		return "mlist";
	}
		
	@RequestMapping("/mdelete")
	public String mdelete(HttpServletRequest request) {
		MDao dao = sqlSession.getMapper(MDao.class);
		dao.mdelete(request.getParameter("mID"));
		return "redirect:home";
	}
	
	@RequestMapping("/register")
	public String minsert(HttpServletRequest request) {
		MDao dao = sqlSession.getMapper(MDao.class);
		MemberDTO dto = new MemberDTO(
				request.getParameter("mID"),
				request.getParameter("mPW"),
				request.getParameter("mName"),
				request.getParameter("mPhon"));
		dao.minsert(dto);
		return "redirect:home";			// home url로 매핑
	}
	@RequestMapping("/regform")
	public String regform() {
		return "regform";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		MDao dao = sqlSession.getMapper(MDao.class);
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		try {
			MemberDTO dto = dao.mselect(id);
			String mpw = dto.getmPW();
			if (pw.equals(mpw)) {
				session.setAttribute("mid", id);
				session.setAttribute("check", "success");
				return "redirect:home";
			} else {
				session.setAttribute("mid", id);
				session.setAttribute("check", "failure");
				return "redirect:loginform";
			}
		} catch (Exception e) {
				session.setAttribute("mid", id);
				session.setAttribute("check", "except");
				e.printStackTrace();
				return "redirect:loginform";
		}
	}
	@RequestMapping("/loginform")
	public String loginform() {
		return "loginform";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
}
