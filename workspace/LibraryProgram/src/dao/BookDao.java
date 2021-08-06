package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

public class BookDao {
	
	// singleton
	private static BookDao bookDao;
	
	private BookDao() {}
	
	public static BookDao getinstance() {
		if(bookDao == null) {
			bookDao = new BookDao();
		}
		return bookDao;
	}
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) con.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BookVO> selectBookList(){
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			con = DBConnection.getConnection();
			sql = "SELECT * FROM BOOK";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBook_no(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setAuthor(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setPublication_date(rs.getDate(5));
				vo.setIsbn(rs.getString(6));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	
	public BookVO selectBookOne(int book_no) {
		BookVO vo = null;
		try {
			con = DBConnection.getConnection();
			sql = "SELECT * FROM BOOK WHERE BOOK_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, book_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BookVO();
				vo.setBook_no(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setAuthor(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setPublication_date(rs.getDate(5));
				vo.setIsbn(rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return vo;
	}
	
	
	
	
}
