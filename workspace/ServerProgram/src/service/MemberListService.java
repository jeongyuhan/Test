package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ModelAndView;
import repository.MemberRepository;

public class MemberListService implements MemberService {
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberRepository repository = MemberRepository.getInstance();
		request.setAttribute("list", repository.selectMemberList());
		
		return new ModelAndView(false, "list.jsp");
	}
	
}
