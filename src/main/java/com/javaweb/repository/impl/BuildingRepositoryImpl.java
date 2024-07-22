package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;


@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "123456789";

	@Override
	public List<BuildingEntity> findAll(String name) {
		String sql = "select * from estatebasic.building";
		List<BuildingEntity> result = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setWard(rs.getString("ward"));
				building.setStreet(rs.getString("street"));
				result.add(building);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
