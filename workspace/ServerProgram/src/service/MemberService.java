package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ModelAndView;

public interface MemberService {
	
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response);
	
}
