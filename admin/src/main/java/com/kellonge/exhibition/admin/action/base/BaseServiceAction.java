package com.kellonge.exhibition.admin.action.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.kellonge.exhibition.model.vo.system.AjaxResult;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage(value = "json-default")
@Namespace("/")
public class BaseServiceAction extends ActionSupport {
	public static Logger logger = Logger.getLogger(BaseServiceAction.class);

	public HttpServletRequest request = ServletActionContext.getRequest(); 
	public HttpServletResponse response = ServletActionContext.getResponse(); 
	public HttpSession session = ServletActionContext.getRequest().getSession();
	public AjaxResult resultVo=new AjaxResult();
	
	
 
	protected void page(String object) {
		HttpContext.page(object);
	}
	
	protected String getParameter(String strParameter){
		return HttpContext.getParameter(strParameter);
	}
	
	protected void redirectToLogin(){
		
		//HttpContext.redirect(Utility.getLoginPath());
	}
	
	protected void service() {
		if (CurrentInfo.checkAccess() == false) {
			redirectToLogin();
		}
	}

}
