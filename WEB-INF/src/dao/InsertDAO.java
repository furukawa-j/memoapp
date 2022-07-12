package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDAO extends DAO {
	public void insert(String title,String text)throws Exception{

		Connection con = getConnection();

		PreparedStatement st=con.prepareStatement(
		"insert into memo values('sample123',?,?,now());");
		st.setString(1, title);
		st.setString(2,text);
		st.executeUpdate();

		st.close();
		con.close();
	}

}
