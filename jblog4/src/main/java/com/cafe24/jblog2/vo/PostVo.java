package com.cafe24.jblog2.vo;

public class PostVo {
	private int p_no;
	private String p_title;
	private String p_desc;
	private String p_regdate;
	private int c_no;

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getP_no() {
		return p_no;
	}

	public String getP_title() {
		return p_title;
	}

	public String getP_desc() {
		return p_desc;
	}

	public String getP_regdate() {
		return p_regdate;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}

	@Override
	public String toString() {
		return "PostVo [p_no=" + p_no + ", p_title=" + p_title + ", p_desc=" + p_desc + ", p_regdate=" + p_regdate
				+ ", c_no=" + c_no + "]";
	}

}
