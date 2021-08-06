package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ModelAndView;

public class LogoutService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().invalidate();
		
		return new ModelAndView(true, "login.jsp");
	}

}
