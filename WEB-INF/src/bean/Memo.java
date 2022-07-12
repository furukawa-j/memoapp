package bean;

import java.util.Date;

public class Memo {

	/*
	 * memoテーブルから取得したメモ内容を格納するBean（Memoクラス）を作成する。
	 */

	private String id;
	private String title;
	private String text;
	private Date datetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
