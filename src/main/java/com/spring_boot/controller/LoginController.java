package com.spring_boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_boot.dao.SysUserRepository;
import com.spring_boot.entity.SysUser;

@Controller
public class LoginController {

	@Autowired
	SysUserRepository sysuserRepository;

	@RequestMapping("/login.do")
	public ModelAndView login_do(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/login.commit")
	public String one(String loginname, String password) {
//		System.out.println("loginname=" + loginname + "password=" + password);
//		com.spring_boot.service.ServiceImpl server = new com.spring_boot.service.ServiceImpl();
//		SysUser sys_user = server.findByTenantIdAndSequenceId(loginname, password);
//		System.out.println("loginname=" + loginname + "password=" + password);

		password = com.spring_boot.authentication.security.util.EncryptUtil.md5(password);
		List<SysUser> list = sysuserRepository.findByLoginnameAndPassword(loginname, password);
		if (list.size() > 0) {
			System.out.println("login=" + list.get(0));
		}

		return "main";
	}

}
