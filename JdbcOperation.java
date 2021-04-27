package com.te.crudOperation;

import java.util.ArrayList;

public interface JdbcOperation 
{
	public void insert(int userid,String username);

	public ArrayList<Object> select();

	public void update(int userid,String username);

	public void delete(int userid);



	

}
