package org.zerock.service;

import java.util.List;

import org.zerock.dao.MsgDAO;
import org.zerock.vo.MsgVO;

public class MsgService {

	private MsgDAO dao;
	
	public MsgService() {
		this.dao = new MsgDAO();
	}

	public List<MsgVO> getWhom(String mid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MsgVO> getWho(String mid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
