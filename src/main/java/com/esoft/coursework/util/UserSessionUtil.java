package com.esoft.coursework.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.esoft.coursework.domain.OperationalCenter;

@Component
@Scope("session")
public class UserSessionUtil {
	private Long userId;
	private String userCode;
	private String userName;
	private String designation;
	private OperationalCenter operationalCenter;
	
	public static UserSessionUtil getUserSessionUtil(HttpServletRequest httpServletRequest) {
		if (httpServletRequest.getSession()	.getAttribute("userSession")!=null)
			return (UserSessionUtil) httpServletRequest.getSession().getAttribute("userSession");
		else
			return null;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public OperationalCenter getCollectionCenter() {
		return operationalCenter;
	}
	public void setCollectionCenter(OperationalCenter operationalCenter) {
		this.operationalCenter = operationalCenter;
	}
	
}
