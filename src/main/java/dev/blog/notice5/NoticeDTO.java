package dev.blog.notice5;

public class NoticeDTO {
	
	private int noticeno;
	private String title;
	private String rname;
	private String rdate;
	
	public NoticeDTO() {}

	public int getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeno=" + noticeno + ", title=" + title + ", rname=" + rname + ", rdate=" + rdate + "]";
	}
	
	
	
	
	
}
