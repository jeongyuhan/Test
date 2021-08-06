package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import domain.ModelAndView;
import repository.MemberRepository;

public class LoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDTO loginDTO = MemberRepository.getInstance().login(id, name);
		ModelAndView modelAndView = null;
		
		if(loginDTO != null) {
			request.getSession().setAttribute("loginDTO", loginDTO);
			modelAndView = new ModelAndView(true, "myPage.jsp");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = null; 
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 이름을 확인하세요.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return modelAndView;
	}

}
