package model.dao;

import model.dao.impl.SellerDaoImplJDBC;

public class DaoFactory {

	public static SellerDaoImplJDBC createSellerDao() {
		return new SellerDaoImplJDBC();
	}
}
