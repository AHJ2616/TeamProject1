package hairshop;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import hairshop.DTO.CutService;
import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Reservation;
import hairshop.DTO.Schedule;
import hairshop.DTO.Shop;

import hairshop.DTO.Member;
import hairshop.service.AdminService;
import hairshop.service.DesignerService;
import hairshop.service.MemberSerivice;
import hairshop.service.UserService;
public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static List<Designer> designers = new ArrayList<>();
	public static List<Shop> shops = new ArrayList<>();
	public static List<Member> members = new ArrayList<>();
	public static List<CutService> cutServices = new ArrayList<>();
	public static List<Reservation> reservations = new ArrayList<>();
	
	static { // 초기값 설정

		// 매장 정보
		shops.add(new Shop("차홍아르더", "서울 강남구", 30000)); // 미용실 1
		// 시술 정보 ↓샵 ↓시술명 ↓시술내용 ↓비용 ↓번호
		cutServices.add(new CutService("차홍아르마", "남성컷트", "남성 기본 헤어컷", 30000));
		cutServices.add(new CutService("차홍아르마", "여성컷트", "여성 기본 헤어컷", 50000));
	}
	
	
	public static Member user;//로그인 정보 저장용
	
	public static void main(String[] args) {	// 메인메서드
		Schedule sch = new Schedule();
		sch.setSchedule(Schedule.schedule); //초기 HashMap 값 저장
		sch.setSchedule2(Schedule.schedule); //초기 HashMap 값 저장
		UserService userService = new UserService();
		MemberSerivice memberService = new MemberSerivice(); //멤버서비스 인스턴스 생성
		members=memberService.setMembers(members);
		
		AdminService adminService = new AdminService(); //admin 인스턴스 생성
		DesignerService designerService = new DesignerService();
		
		boolean run = true;
		while(run) {
			for(Member x :members) {//테스트용 코드
				System.out.println(x.toString());
			}
		System.out.println("1.로그인|2.회원가입|3.종료");
		String select = sc.next();
		switch(select) {
		case "1" : user = memberService.login(members,user);
		if(user.getId().matches("^manager\\d*")){adminService.adminMenu(designers, shops, members, cutServices);}
		else {
		if(user.isDesigner()) {designerService.designerMenu(sc, reservations);
			
			
		} else {userService.memberService(user, shops, members, designers, cutServices, reservations,Schedule.schedule);}
		}
			break;
		case "2" : members=memberService.register(members);
			break;
		case "3" : 
			System.out.println("시스템을 종료합니다");
			run = false;
			break;
			default : System.out.println("오류 : 잘못입력하셨습니다.\n보기에서 선택하여 주세요");
		}//switch end

		}//while end
	}//main method end

}//class end
