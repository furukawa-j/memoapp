package bean;

public class Users {

	/*
	 * usersテーブルから取得した登録情報を格納するBean（Usersクラス）を作成する。
	 */

	private int num;
	private String id;
	private String password;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
