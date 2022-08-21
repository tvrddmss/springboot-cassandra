//package com.spring_boot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.spring_boot.dao.SysUserRepository;
//
//@RestController
//public class SysUserController {
//	@Autowired
//	SysUserRepository sysuserRepository;
//
//	@RequestMapping("/findAllUser")
//	public Object findAllUser() {
//		return sysuserRepository.findAll();
//	}
//
//	@RequestMapping("/findAllUser")
//	public Object findUserByLoginnameAndPassword(String Loginname, String Password) {
//		return sysuserRepository.findByLoginnameAndPassword(Loginname, Password);
//	}
//}
