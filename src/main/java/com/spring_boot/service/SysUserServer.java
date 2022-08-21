package com.spring_boot.service;

import java.util.List;

import com.spring_boot.entity.SysUser;

public interface SysUserServer {
	// save operation
    SysUser saveSysUser(SysUser sys_user);
  
    // read operation
    List<SysUser> fetchSysUserList();
  
    // update operation
    SysUser updateSysUser(SysUser sys_user, int departmentId);
  
    // delete operation
    void deleteSysUserById(int SysUserId);
}
