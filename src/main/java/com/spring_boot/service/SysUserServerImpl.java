package com.spring_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring_boot.dao.SysUserRepository;
import com.spring_boot.entity.SysUser;

public class SysUserServerImpl implements SysUserServer {
	@Autowired
	private SysUserRepository sys_userRepository;

	@Override
	public SysUser saveSysUser(SysUser sys_user) {
		// TODO 自动生成的方法存根
		return sys_userRepository.save(sys_user);
	}

	@Override
	public List<SysUser> fetchSysUserList() {
		// TODO 自动生成的方法存根
		return (List<SysUser>) sys_userRepository.findAll();
	}

	@Override
	public SysUser updateSysUser(SysUser sys_user, int departmentId) {
		// TODO 自动生成的方法存根
		SysUser sys_userDB = sys_userRepository.findById(departmentId).get();

//		if (Objects.nonNull(sys_user.getDepartmentName()) && !"".equalsIgnoreCase(sys_user.getDepartmentName())) {
//			sys_userDB.setDepartmentName(department.getDepartmentName());
//		}
//
//		if (Objects.nonNull(sys_user.getDepartmentAddress())
//				&& !"".equalsIgnoreCase(sys_user.getDepartmentAddress())) {
//			sys_userDB.setDepartmentAddress(sys_user.getDepartmentAddress());
//		}
//
//		if (Objects.nonNull(sys_user.getDepartmentCode()) && !"".equalsIgnoreCase(sys_user.getDepartmentCode())) {
//			sys_userDB.setDepartmentCode(sys_user.getDepartmentCode());
//		}

		return sys_userRepository.save(sys_userDB);
	}

	@Override
	public void deleteSysUserById(int SysUserId) {
		// TODO 自动生成的方法存根

	}

}
