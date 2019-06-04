package com.cafe24.jblog2.vo;

public class CategoryVo {
	private int c_no;
	private String c_name;
	private String c_desc;
	private String c_regdate;
	private int p_count;
	private String userid;

	public int getC_no() {
		return c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public String getC_desc() {
		return c_desc;
	}

	public String getC_regdate() {
		return c_regdate;
	}

	public int getP_count() {
		return p_count;
	}

	public String getUserid() {
		return userid;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}

	public void setC_regdate(String c_regdate) {
		this.c_regdate = c_regdate;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "CategoryVo [c_no=" + c_no + ", c_name=" + c_name + ", c_desc=" + c_desc + ", c_regdate=" + c_regdate
				+ ", p_count=" + p_count + ", userid=" + userid + "]";
	}

}
