package com.roshankhatri.neccps.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CpsSimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
			handle(request,response,authentication);
			clearAuthenticationAttributes(request);
	}
		protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
			String targetUrl=determineTargetUrl(authentication);
			if(response.isCommitted()){
				System.out.println("unable to redirect"+targetUrl);
				return;
			}
			redirectStrategy.sendRedirect(request, response,targetUrl);
		}
		protected String determineTargetUrl(Authentication authentication) {
			boolean isAdmin=false;
			boolean isCo=false;
			boolean isSecret=false;
			boolean isPay=false;
			boolean isExam=false;
			boolean isIr=false;
			boolean isThesis=false;
			Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")){
					isAdmin=true;
					break;
				}else if (grantedAuthority.getAuthority().equals("ROLE_SECRET")) {
					isSecret=true;
					break;
				}
				else if (grantedAuthority.getAuthority().equals("ROLE_PAY")){
					isPay=true;
					break;
				}
				else if (grantedAuthority.getAuthority().equals("ROLE_EXAM")) {
					isExam=true;
					break;
				}else if (grantedAuthority.getAuthority().equals("ROLE_IR")) {
					isIr=true;
					break;
				}
				else if (grantedAuthority.getAuthority().equals("ROLE_THESIS")) {
					isThesis=true;
					break;
				}
				else if (grantedAuthority.getAuthority().equals("ROLE_COORD")) {
					isCo=true;
					break;
				}	
			}
			if(isAdmin){
				return "/home";
			}else if (isCo) {
				return "/Program/";
			}else if (isSecret) {
				return "/Student/";
			}else if (isPay) {
				return "/Payment/";
			}else if (isExam) {
				return "/ExamResult/";
			}else if(isIr){
				return "/IssueReturn/";
			}else if (isThesis) {
				return "/Thesis/";
			}
			else {
				throw new IllegalStateException();
			}
		}
		protected void clearAuthenticationAttributes(HttpServletRequest request) {
			HttpSession session=request.getSession(false);
			if(session==null){
				return;
			}
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
			this.redirectStrategy = redirectStrategy;
		}
		public RedirectStrategy getRedirectStrategy() {
			return redirectStrategy;
		}
}
