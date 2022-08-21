package com.spring_boot.service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.spring_boot.entity.SysUser;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl {

	// 自定义sql语句
	public SysUser findByTenantIdAndSequenceId(String loginname, String password) {
//		
//		String cql = String.format("select * from sys_user where loginname = '%s' and password='%s'", loginname,
//				password);
//		SysUser sys_user = cassandraTemplate.selectOne(cql, SysUser.class);
//		return sys_user;

		Cluster cluster = Cluster.builder().addContactPoint("192.168.50.8").withCredentials("cassandra", "cassandra")
				.build();
		Session session = cluster.connect("mycasdb");
		// ResultSet resultset = session.execute("select * from sys_user");

		ResultSet resultset = session.execute("select * from sys_user where loginname='" + loginname
				+ "' and password='" + password + "' ALLOW FILTERING");

//			List<Row> resultset = new ArrayList<Row>();
		String message = "";
		for (int i = 0; i < resultset.getColumnDefinitions().asList().size(); i++) {
			message += resultset.getColumnDefinitions().asList().get(i).getName() + "\t";
		}
		List<Row> rows = resultset.all();
		for (int i = 0; i < rows.toArray().length; i++) {
			for (int j = 0; j < resultset.getColumnDefinitions().asList().size(); j++) {
				switch (resultset.getColumnDefinitions().asList().get(j).getType().toString()) {
				case "int":
					message += rows.get(i).getInt(resultset.getColumnDefinitions().asList().get(j).getName()) + "\t";
					break;
				case "varint":
					message += rows.get(i).getVarint(resultset.getColumnDefinitions().asList().get(j).getName()) + "\t";
					break;
				default:
					message += rows.get(i).getString(resultset.getColumnDefinitions().asList().get(j).getName()) + "\t";
					break;
				}
			}
			message += "\r\n";
		}
		System.out.print(message);
		
		Row model=rows.get(0);
		SysUser sys_user = new SysUser();
		sys_user.id = model.getInt("id");
		sys_user.loginname = model.getString("loginname");
		//sys_user.password = model.getString("password");
		sys_user.name = model.getString("name");
		sys_user.role = model.getString("role");
		sys_user.roleid = model.getInt("roleid");
		return sys_user;
	}

}
