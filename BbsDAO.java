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
	//������ DB����
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
	
	public void sign(){//��������
		System.out.println("ȸ�������� �����մϴ�.");
		System.out.println("================");
		System.out.println("���̵� �Է��ϼ���.");
		bs.setUserid(sc.next());//���̵��Է�
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		bs.setUserpw(sc.next());//��й�ȣ�Է�
		String sql = "insert into user values(?,?)";//sql��
		try {
			pstm =conn.prepareStatement(sql);
			pstm.setString(1, bs.getUserid());//���ֱ�
			pstm.setString(2, bs.getUserpw());//���ֱ�
			pstm.executeUpdate();//����
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//���� �α���
	public int login(String userid,String userpw) {
		String sql1 = "select upw from user where uid=?";
		try {
			System.out.println("����� ���̵� �Է��ϼ���.");
			userid =sc.next();//���̵� �Է°�
			System.out.println("����� ��й�ȣ�� �Է����ּ���");
			userpw =sc.next();//��� �Է°�
			pstm = conn.prepareStatement(sql1);//������ ����
			pstm.setString(1, userid);//����ǥ�� userid �� �ֱ�
			rs = pstm.executeQuery();//rs�� userid �Է°��� �´� ��� �����
			if(rs.next()) {
				if(rs.getString(1).equals(userpw)) {
					System.out.println("�α��� ����");
					return 1;//�α��μ���
				}else System.out.println("��й�ȣ ����ġ");
				return 0;//��й�ȣ ����ġ
			}else System.out.println("���̵� ����");
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����ͺ��̽� ����");
		return -2;//�����ͺ��̽� ����
	}
	//������ �α���
	public int adminlogin(String userid,String userpw) {
		String sql2 = "select adpw from admin where adid=?";
		try {
			System.out.println("������ ���̵� �Է��ϼ���.");
			userid =sc.next();//���̵� �Է°�
			System.out.println("������ ��й�ȣ�� �Է����ּ���");
			userpw =sc.next();//��� �Է°�
			pstm = conn.prepareStatement(sql2);//������ ����
			pstm.setString(1, userid);//����ǥ�� userid �� �ֱ�
			rs = pstm.executeQuery();//rs�� userid �Է°��� �´� ��� �����
			if(rs.next()) {
				if(rs.getString(1).equals(userpw)) {
					System.out.println("�α��� ����");
					return 1;//�α��μ���
				}else System.out.println("��й�ȣ ����ġ");
				return 0;//��й�ȣ ����ġ
			}else System.out.println("���̵� ����");
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����ͺ��̽� ����");
		return -2;//�����ͺ��̽� ����
	}
	
	public void bookin() {//å�ֱ�
		
		System.out.println("-�������-");
		System.out.println("����Ͻ� å�� �ѹ��� �Է����ּ���.");
		int bno = sc.nextInt();
		System.out.println("����Ͻ� å�� �̸��� �Է����ּ���.");
		String bname = sc.next();
		
		String sql = "insert into books values(?,?)";
		try {
			pstm = conn.prepareStatement(sql);//������ ����
			pstm.setInt(1, bno);//���ֱ�
			pstm.setString(2, bname);//���ֱ�
			pstm.executeUpdate();//������ ������Ʈ
			pstm.close();
			conn.close();//�ݾ��ֱ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
 