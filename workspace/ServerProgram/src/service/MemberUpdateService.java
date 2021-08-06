package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberDTO;
import domain.ModelAndView;
import repository.MemberRepository;

public class MemberUpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		String grade = null;
		if(point >= 5000) {grade = "vip";}
		else if(point >= 4000) {grade = "gold";}
		else if(point >= 3000) {grade = "silver";}
		else {grade = "bronze";}
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setPoint(point);
		dto.setNo(no);
		dto.setGrade(grade);

		int count = MemberRepository.getInstance().update(dto);
		if(count > 0) {
			HttpSession session = request.getSession();
			MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
			loginDTO.setName(name);
			loginDTO.setPoint(point);
			loginDTO.setGrade(grade);
		}
		
		return new ModelAndView(true, "myPage.jsp");
	}

}
