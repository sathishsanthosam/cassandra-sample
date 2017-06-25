package com.vzt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

@Component
public class DemoService {
	
	@Autowired
	CassandraOperations cassandraOperations;
	
	public Long getAccountId(){
		Select select = QueryBuilder.select("account_id").from("user_asset_info");
		select.where(QueryBuilder.eq("organization", "AFM-HUM"));
		select.where(QueryBuilder.eq("username", "1-W2BNXX"));
		//String query = "select account_id from user_asset_info where organization='AFM-HUM' and username='1-W2BNXX'";
		List<Long> accountiD = cassandraOperations.select(select, Long.class);
		return accountiD.get(0);
	}

}
