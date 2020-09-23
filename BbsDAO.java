import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BbsDAO {

	Scanner sc= new Scanner(System.in);
	private Connection conn;
	private ResultSet rs;
	PreparedStatement pstm;
	Bbs bs = new Bbs();
	//생성자 DB연결
	public BbsDAO() {
		try {
			String url = "jdbc:mysql://localhost:3306/Bbs?serverTimezone=UTC&characterEncoding=UTF-8";
			 String user = "root";
			 String pass = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
//			String sql = "insert into user values(?,?)";
//			PreparedStatement pstm =conn.prepareStatement(sql);
//			pstm.executeUpdate();
//			pstm.close();
//			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sign(){//유저가입
		System.out.println("회원가입을 시작합니다.");
		System.out.println("================");
		System.out.println("아이디를 입력하세요.");
		bs.setUserid(sc.next());//아이디입력
		System.out.println("비밀번호를 입력하세요.");
		bs.setUserpw(sc.next());//비밀번호입력
		String sql = "insert into user values(?,?)";//sql문
		try {
			pstm =conn.prepareStatement(sql);
			pstm.setString(1, bs.getUserid());//값넣기
			pstm.setString(2, bs.getUserpw());//값넣기
			pstm.executeUpdate();//실행
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//유저 로그인
	public int login(String userid,String userpw) {
		String sql1 = "select upw from user where uid=?";
		try {
			System.out.println("사용자 아이디를 입력하세요.");
			userid =sc.next();//아이디 입력값
			System.out.println("사용자 비밀번호를 입력해주세요");
			userpw =sc.next();//비번 입력값
			pstm = conn.prepareStatement(sql1);//쿼리문 실행
			pstm.setString(1, userid);//물음표에 userid 값 넣기
			rs = pstm.executeQuery();//rs는 userid 입력값에 맞는 비번 결과값
			if(rs.next()) {
				if(rs.getString(1).equals(userpw)) {
					System.out.println("로그인 성공");
					return 1;//로그인성공
				}else System.out.println("비밀번호 불일치");
				return 0;//비밀번호 불일치
			}else System.out.println("아이디 없음");
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터베이스 오류");
		return -2;//데이터베이스 오류
	}
	//관리자 로그인
	public int adminlogin(String userid,String userpw) {
		String sql2 = "select adpw from admin where adid=?";
		try {
			System.out.println("관리자 아이디를 입력하세요.");
			userid =sc.next();//아이디 입력값
			System.out.println("관리자 비밀번호를 입력해주세요");
			userpw =sc.next();//비번 입력값
			pstm = conn.prepareStatement(sql2);//쿼리문 실행
			pstm.setString(1, userid);//물음표에 userid 값 넣기
			rs = pstm.executeQuery();//rs는 userid 입력값에 맞는 비번 결과값
			if(rs.next()) {
				if(rs.getString(1).equals(userpw)) {
					System.out.println("로그인 성공");
					return 1;//로그인성공
				}else System.out.println("비밀번호 불일치");
				return 0;//비밀번호 불일치
			}else System.out.println("아이디 없음");
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터베이스 오류");
		return -2;//데이터베이스 오류
	}
	
	public void bookin() {//책넣기
		
		System.out.println("-도서등록-");
		System.out.println("등록하실 책의 넘버를 입력해주세요.");
		int bno = sc.nextInt();
		System.out.println("등록하실 책의 이름을 입력해주세요.");
		String bname = sc.next();
		
		String sql = "insert into books values(?,?)";
		try {
			pstm = conn.prepareStatement(sql);//쿼리문 실행
			pstm.setInt(1, bno);//값넣기
			pstm.setString(2, bname);//값넣기
			pstm.executeUpdate();//쿼리문 업데이트
			pstm.close();
			conn.close();//닫아주기
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
 