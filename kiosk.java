import java.util.Scanner;

public class kiosk{

	static public void kio() {
		String userid = null;
		String userpw = null;
		BbsDAO bd = new BbsDAO();
		while(true) {
		System.out.println("=======================");
		System.out.println("�����������α׷��� �����մϴ�.");
		System.out.println("=======================");
		Scanner sc = new Scanner(System.in);
		System.out.println("1 : ȸ������\t2 : �α���");
		int num = sc.nextInt();
		if(num==1) {
			bd.sign();
		}else if(num==2) {
			System.out.println("1 : ����ڷα���\t2 : �����ڷα���");
			int num1 = sc.nextInt();
			if(num1==1) {
				bd.login(userid, userpw);//����ڷα���
			}else if(num1==2) {
				int i =bd.adminlogin(userid, userpw);//�����ڷα��� int i = �α��� ��Ȳ Ȯ��
				if(i==1) {
					bd.bookin();//�������
				}else System.out.println("���α׷��� �����մϴ�.");
				
				
			}
		}
		
		}
	}
	
}
