package com.spring_boot.entity;

import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

//@Data
//@NoArgsConstructor//无参构造
//public class SysUser {
//
//	// @PrimaryKeyColumn(value = "id", type = PrimaryKeyType.CLUSTERED)
//	public Integer id;
//	public String loginname;
//	public String password;
//	public String name;
//	public String phone;
//	public String role;
//	public int roleid;
//}
@Table(value = "sys_user")
public class SysUser {

	@PrimaryKey
	public int id;
	@Column
	public String loginname;
	@Column
	public String password;
	@Column
	public String name;
	@Column
	public String role;
	@Column
	public int roleid;
}