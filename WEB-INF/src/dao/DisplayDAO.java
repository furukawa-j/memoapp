package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Memo;

/*
 * 自身のメモ一覧を表示する為、データベースから
 *
 */

public class DisplayDAO extends DAO {

	public List<Memo> display()throws Exception{

		Connection con = getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from memo;");
		ResultSet rs=st.executeQuery();

		List<Memo>memoList=new ArrayList<>();

		while (rs.next()) {

			Memo m=new Memo();
				m.setId(rs.getString("id"));
				m.setTitle(rs.getString("title"));
				m.setText(rs.getString("text"));
				m.setDatetime(rs.getTimestamp("datetime"));
			memoList.add(m);
		}
		st.close();
		con.close();
		return memoList;
	}
}
