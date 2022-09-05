package webFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		String requestURI = req.getRequestURI();
		
		System.out.println("URI :" + requestURI);
		
		if (requestURI.endsWith("/login")) {
			chain.doFilter(request, response);
			return ;
		}
		
		if (req.getSession().getAttribute("userInfo") == null) {
			res.sendRedirect("/servletHw/login");
			return ;
		}
		
		chain.doFilter(request, response);
		
	}
	
	
	
}
