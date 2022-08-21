package com.spring_boot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot.entity.SysUser;

@Repository
public interface SysUserRepository extends CrudRepository<SysUser, Integer> {
	List findByLoginnameAndPassword(String Loginname, String password);
}
