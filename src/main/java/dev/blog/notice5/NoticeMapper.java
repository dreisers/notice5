package dev.blog.notice5;

import java.util.ArrayList;
import java.util.HashMap;

public interface NoticeMapper {
	/*
	 ����(notice.xml)�� ��ϵǾ� �ִ� id�� �������̽� �޼ҵ忡 �ٽ� �ѹ� ��������ν�
	 MyBatis3���� ȣ���ϱ� ���ϵ��� ������.
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
