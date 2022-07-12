package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Memo;

/*
 * メモ一覧を表示する為の"displayメソッド"を定義する。
 * 戻り値にMemo型のリストを返す。
 * （Memoオブジェクトには、メモのタイトルや本文などが格納されている。）
 */

public class DisplayDAO extends DAO {

	public List<Memo> display() throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from memo order by datetime desc;"); //降順にすることで最新投稿から表示される。
		ResultSet rs = st.executeQuery();

		List<Memo> memoList = new ArrayList<>();

		while (rs.next()) {

			Memo m = new Memo();
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
