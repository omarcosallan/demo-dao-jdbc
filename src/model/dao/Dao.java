package model.dao;

import java.util.List;

public interface Dao<T, ID> {
	
	void insert(T obj);
	void update(T obj); 
	void deleteById(ID id);
	T findById(ID id);
	List<T> findAll();
}
