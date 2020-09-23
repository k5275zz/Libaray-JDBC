import java.util.Scanner;

public class kiosk{

	static public void kio() {
		String userid = null;
		String userpw = null;
		BbsDAO bd = new BbsDAO();
		while(true) {
		System.out.println("=======================");
		System.out.println("도서관리프로그램을 실행합니다.");
		System.out.println("=======================");
		Scanner sc = new Scanner(System.in);
		System.out.println("1 : 회원가입\t2 : 로그인");
		int num = sc.nextInt();
		if(num==1) {
			bd.sign();
		}else if(num==2) {
			System.out.println("1 : 사용자로그인\t2 : 관리자로그인");
			int num1 = sc.nextInt();
			if(num1==1) {
				bd.login(userid, userpw);//사용자로그인
			}else if(num1==2) {
				int i =bd.adminlogin(userid, userpw);//관리자로그인 int i = 로그인 현황 확인
				if(i==1) {
					bd.bookin();//도서등록
				}else System.out.println("프로그램을 종료합니다.");
				
				
			}
		}
		
		}
	}
	
}
