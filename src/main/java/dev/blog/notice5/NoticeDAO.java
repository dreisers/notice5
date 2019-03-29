package dev.blog.notice5;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoticeDAO {

	// MyBatis��� ������������ DB����
	@Autowired
	SqlSession sqlSession;

	public NoticeDAO() {
		System.out.println("--- NoticeDAO ����");
	}

	public int create(NoticeDTO dto) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		int count = mapper.create(dto);
		return count;
	}// create end

	public ArrayList<NoticeDTO> list() {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		ArrayList<NoticeDTO> list = mapper.list();
		return list;
	}// list end

	public int update(NoticeDTO dto) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		int count = mapper.update(dto);
		return count;
	}// update end

	public NoticeDTO read(NoticeDTO dto) { // notice.xml�� �ִ� �������� �����ϱ� ���� �޼ҵ�
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		dto = mapper.read(dto);  
		return dto;
	}//read end
	
	public int delete(NoticeDTO dto) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		int count = mapper.delete(dto);
		return count;
	}//delete end	
	
	public ArrayList<NoticeDTO> search(String col, String word){
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		HashMap searchMap = new HashMap();
		searchMap.put("col", col);
		searchMap.put("word", word);
		ArrayList<NoticeDTO> list = mapper.search(searchMap);
		return list;
	}//search end
	
}// class end
