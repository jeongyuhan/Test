package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBConnector;
import domain.MemberDTO;

public class MemberRepository {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private static MemberRepository repository;
	
	private MemberRepository() {}
	
	public static MemberRepository getInstance() {
		if(repository == null) {
			repository = new MemberRepository();
		}
		return repository;
	}
	
	public List<MemberDTO> selectMemberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			con = DBConnector.getInstance().getConnection();
			sql = "SELECT * FROM MEMBER_TABLE";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGrade(rs.getString(4));
				dto.setPoint(rs.getInt(5));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(con, ps, rs);	
		}
		return list;
	}
	
	public MemberDTO login(String id, String name) {
		MemberDTO dto = null;
		try {
			con = DBConnector.getInstance().getConnection();
			sql = "SELECT * FROM MEMBER_TABLE WHERE ID = ? AND NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setNo(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGrade(rs.getString(4));
				dto.setPoint(rs.getInt(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(con, ps, rs);	
		}
		return dto;
	}
	
	public int update(MemberDTO dto) {
		int count = 0;
		try {
			con = DBConnector.getInstance().getConnection();
			sql = "UPDATE MEMBER_TABLE SET NAME = ?, POINT = ?, GRADE = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPoint());
			ps.setString(3, dto.getGrade());
			ps.setInt(4, dto.getNo());
			count = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(con, ps, null);	
		}
		return count;
	}
	
	
	
	
	
}
