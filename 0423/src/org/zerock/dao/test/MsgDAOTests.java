package org.zerock.dao.test;

import java.util.List;

import org.junit.Test;
import org.zerock.dao.MsgDAO;
import org.zerock.vo.MsgVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MsgDAOTests {

	private MsgDAO dao = new MsgDAO();
	
	@Test
	public void testList() {
		String mid = "u1";
		
		List<MsgVO> receiveList = dao.getRecieve(mid);
		
		log.info(receiveList);
		
		dao.getSend(mid);
		
	}
	
}
