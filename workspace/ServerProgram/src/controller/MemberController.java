package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ModelAndView;
import service.LoginService;
import service.LogoutService;
import service.MemberListService;
import service.MemberService;
import service.MemberUpdateService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String[] arr = requestURI.split("/");
		String cmd = arr[arr.length - 1];
		
		MemberService memberService = null;
		ModelAndView modelAndView = null;
		
		switch (cmd) {
		case "list.do":
			memberService = new MemberListService();
			modelAndView = memberService.execute(request, response);
			break;
		case "loginPage.do":
			modelAndView = new ModelAndView(false, "login.jsp");
			break;
		case "login.do":
			memberService = new LoginService();
			modelAndView = memberService.execute(request, response);
			break;
		case "logout.do":
			memberService = new LogoutService();
			modelAndView = memberService.execute(request, response);
			break;
		case "update.do":
			memberService = new MemberUpdateService();
			modelAndView = memberService.execute(request, response);
			break;
		}
		
		if(modelAndView != null) {
			if(modelAndView.isRedirect()) {
				response.sendRedirect(modelAndView.getView());
			} else {
				request.getRequestDispatcher(modelAndView.getView()).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
