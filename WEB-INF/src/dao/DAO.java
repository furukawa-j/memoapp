package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * 共通のデータベース処理（データソースの取得、データベースへの接続）を”DAOクラス”に記述し、
 * 各処理ごとにサブクラスを作成する。
 */

public class DAO {
	static DataSource ds;	//※1

	public Connection getConnection() throws Exception {

		if (ds==null) {	//※2
			InitialContext ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/memo");
		}
		return ds.getConnection();
	}
}

/* ※1
 * 取得したデータソース（ds）をststicフィールドに格納し、
 * 各処理のあいだで同一のデータソースを共有できるようにしておく。
 *※2
 * 初回接続であるかを判定する。（初回の場合、dsの中身はnullである。）
 */