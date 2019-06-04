package com.cafe24.jblog2.vo;

import org.springframework.web.multipart.MultipartFile;

public class BlogVo {
	private String blogtitle;
	private String bloglogo;
	private String blogid;
	private MultipartFile blogimage;

	public String getBlogtitle() {
		return blogtitle;
	}

	public String getBloglogo() {
		return bloglogo;
	}

	public String getBlogid() {
		return blogid;
	}

	public MultipartFile getBlogimage() {
		return blogimage;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public void setBloglogo(String bloglogo) {
		this.bloglogo = bloglogo;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public void setBlogimage(MultipartFile blogimage) {
		this.blogimage = blogimage;
	}

	@Override
	public String toString() {
		return "BlogVo [blogtitle=" + blogtitle + ", bloglogo=" + bloglogo + ", blogid=" + blogid + ", blogimage="
				+ blogimage + "]";
	}

}
