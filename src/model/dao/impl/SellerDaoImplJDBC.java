package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.Dao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoImplJDBC implements Dao<Seller, Integer> {

	private Connection conn;

	public SellerDaoImplJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
	}

	@Override
	public void update(Seller obj) {
	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("departmentid"));
				dep.setName(rs.getString("depname"));

				Seller seller = new Seller();
				seller.setId(rs.getInt("id"));
				seller.setName(rs.getString("name"));
				seller.setEmail(rs.getString("email"));
				seller.setBaseSalary(rs.getDouble("baseSalary"));
				seller.setBirthDate(rs.getDate("birthdate"));
				seller.setDepartment(dep);

				return seller;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

		return null;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}

}
