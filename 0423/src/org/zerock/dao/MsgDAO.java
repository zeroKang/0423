package org.zerock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.zerock.vo.MsgVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MsgDAO {
	
	private static final String REC ="select * from tbl_msg where whom =? and mno > 0";

	public List<MsgVO> getRecieve(String whom){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MsgVO> result = null;
		
		try {
			con = AIADataSource.getConnection();
			pstmt = con.prepareStatement(REC);
			pstmt.setString(1, whom);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<>();
			
			while(rs.next()) {
				
				MsgVO vo = MsgVO.builder()
					.mno(rs.getInt("mno"))
					.whom(rs.getString("whom"))
					.who(rs.getString("who"))
					.content(rs.getString("content"))
					.regdate(rs.getTimestamp("regdate").toLocalDateTime())
					.build();
				result.add(vo);
			}
			
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			if(rs != null) { try { rs.close(); }catch(Exception e) {}}
			if(pstmt != null) { try { pstmt.close(); }catch(Exception e) {}}
			if(con != null) { try { con.close(); }catch(Exception e) {}}
		}
		
		return result;
	}
	
	public List<MsgVO> getSend(String who){
		
		return null;
	}
	
}
