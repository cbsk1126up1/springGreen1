package cat;

import java.sql.SQLException;
import java.util.Vector;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CatDAO extends DBConn {
	CatVO vo = null;

	// 유기묘 등록하기
	public int setCatInput(CatVO vo) {
		int res = 0;
		
		try {
			sql = "insert into jcat values (default,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getKind());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getfDate());
			pstmt.setString(5, vo.getFeatures());
			pstmt.setString(6, vo.getPhoto());
			pstmt.setString(7, vo.getMissing());
			pstmt.setString(8, vo.getSingoja());
			pstmt.setString(9, vo.getSingotel());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(setCanInput) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 전체목록 조회하기
	public Vector getCatList() {
		Vector vData = new Vector<>();
		try {
			sql = "select *,date_format(fDate, '%Y-%m-%d %H시') as ffDate from jcat order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int no = 0;
			while(rs.next()) {
				Vector vo = new Vector<>();
				no++;
				//vo.add(rs.getInt("idx"));
				vo.add(no);
				vo.add(rs.getString("kind"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ffDate"));
				//vo.add(rs.getString("features"));
				//vo.add(rs.getString("photo"));
				vo.add(rs.getString("singoja"));
				vo.add((rs.getString("missing")).equals("0") ? "실종묘" : "유기묘");
				vo.add(rs.getInt("idx"));
				
				vData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류(getCatList) : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}

	// 고유번호 개별자료 검색
	public CatVO getSearch(int idx) {
		CatVO vo = new CatVO();
		
		try {
			sql = "select * from jcat where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setKind(rs.getString("kind"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setfDate(rs.getString("fDate"));
				vo.setFeatures(rs.getString("features"));
				vo.setPhoto(rs.getString("photo"));
				vo.setSingoja(rs.getString("singoja"));
				vo.setMissing((rs.getString("missing")).equals("0") ? "분실묘" : "신고묘");
				vo.setSingotel(rs.getString("singotel"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류(getSearch) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 이름 개별자료 검색
	public CatVO getNameSearch(String name) {
		CatVO vo = new CatVO();
		
		try {
			sql = "select * from jcat where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setKind(rs.getString("kind"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setfDate(rs.getString("fDate"));
				vo.setFeatures(rs.getString("features"));
				vo.setPhoto(rs.getString("photo"));
				vo.setSingoja(rs.getString("singoja"));
				//vo.setMissing((rs.getString("missing")).equals("0") ? "분실묘" : "신고묘");
				vo.setMissing(rs.getString("missing"));
				vo.setSingotel(rs.getString("singotel"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류(getNameSearch) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 내용 수정하기
	public int setCatUpdate(CatVO vo) {
		int res = 0;
		try {
			sql = "update jcat set kind=?, gender=?, fDate=?, features=?, photo=?, missing=?, singoja=?, singotel=?, name=? where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getKind());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getfDate());
			pstmt.setString(4, vo.getFeatures());
			pstmt.setString(5, vo.getPhoto());
			pstmt.setString(6, vo.getMissing());
			pstmt.setString(7, vo.getSingoja());
			pstmt.setString(8, vo.getSingotel());
			pstmt.setString(9, vo.getName());
			pstmt.setInt(10, vo.getIdx());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류(setCatUpdate) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public Vector getCatListsort(String cbCondition, String sortOption) {
		Vector vData = new Vector<>();
		try {
			sql = "select *, (select count(*) from jcat) as cnt,date_format(fDate, '%Y-%m-%d %H시') as ffDate from jcat order by "+cbCondition+" " + sortOption;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int no = 0, i = 1;
			while(rs.next()) {
				if(sortOption.equals("desc")) {
					no = rs.getInt("cnt") - i;
					i++;
				}
				no++;
				
				Vector vo = new Vector<>();
				vo.add(no);
				vo.add(rs.getString("kind"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ffDate"));
				vo.add(rs.getString("singoja"));
				vo.add((rs.getString("missing")).equals("0") ? "분실묘" : "신고묘");
				vo.add(rs.getInt("idx"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류(getCatListsort) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// 삭제 처리하기
	public int setCatDelete(String name) {
		int res = 0;
			try {
				sql = "delete from jcat where name=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				res = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("SQL 오류(getCatListsort) : " + e.getMessage());
			} finally {
				pstmtClose();
			}
		return res;
	}
}
