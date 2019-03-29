package dev.blog.notice5;

import java.util.ArrayList;
import java.util.HashMap;

public interface NoticeMapper {
	/*
	 매퍼(notice.xml)에 등록되어 있는 id를 인터페이스 메소드에 다시 한번 등록함으로써
	 MyBatis3에서 호출하기 편리하도록 지원함.
	 */
	
	//<insert id="create">
	public int create (NoticeDTO dto);
	
	//<select id="list">
	public ArrayList<NoticeDTO> list();
	
	public NoticeDTO read(NoticeDTO dto);
	
	public int delete(NoticeDTO dto);

	public int update(NoticeDTO dto);
	
	public ArrayList<NoticeDTO> search(HashMap searchMap);
	
}
