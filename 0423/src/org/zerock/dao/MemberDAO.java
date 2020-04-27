package org.zerock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zerock.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDAO {

	public MemberVO getMember(String mid)throws Exception{
		MemberVO member = null;
		
		String sql ="SELECT * FROM tbl_member WHERE mid = ?";
		
		try(Connection con = AIADataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setString(1, mid);
			
			try(ResultSet rs = pstmt.executeQuery()){
				log.info(rs);
			}
			
		}catch(Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return member;
	}
}
