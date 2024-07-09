package hairshop;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import hairshop.DTO.CutService;
import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Reservation;
import hairshop.DTO.Review;
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
	public static List<Review> reviews = new ArrayList<>();
	
	static { // 초기값 설정

		// 매장 정보
		shops.add(new Shop("차홍아르더", "서울 강남구", 33_000)); // 미용실 1
		// 시술 정보 ↓샵 ↓시술명 ↓시술내용 ↓비용 ↓번호
		cutServices.add(new CutService("차홍아르더", "남성컷트", "남성 기본 헤어컷", 33_000));
		cutServices.add(new CutService("차홍아르더", "여성컷트", "여성 기본 헤어컷", 70_000));
		cutServices.add(new CutService("차홍아르더", "남자 파마", "남성 기본 펌", 120_000));
		cutServices.add(new CutService("차홍아르더", "여자 파마", "여성 기본 펌", 300_000));
		cutServices.add(new CutService("차홍아르더", "염색", "기본기장 염색", 60_000));
	
		reservations.add(new Reservation("차홍아르더","상엽 디자이너","7월1일 12:30","염색","손님1"));
		reservations.add(new Reservation("차홍아르더","김가위","7월1일 15:30","남성컷트","손님"));
		reservations.add(new Reservation("차홍아르더","김가위","7월2일 16:00","남성컷트","손님"));
		
		   reviews.add(new Review("상엽 디자이너", "쁘띠쁘띠","손님1"));
		   reviews.add(new Review("상엽 디자이너", "최고","손님2"));
		   reviews.add(new Review("김가위", "머리 잘하세요","손님3"));
	
	}
	
	
	public static Member user;//로그인 정보 저장용
	public static Designer user2; //디자이너 로그인 정보 저장용
	
	public static void main(String[] args) {	// 메인메서드
		
		
		
		UserService userService = new UserService(); //유저서비스 인스턴스 생성
		MemberSerivice memberService = new MemberSerivice(); //멤버서비스 인스턴스 생성
		AdminService adminService = new AdminService(); //admin 인스턴스 생성
		DesignerService designerService = new DesignerService();
		
		members=memberService.setMembers(members);//맴버 초기값
		designers=adminService.setDesigners(designers, members); //맴버 디자이너 boolean이 true일 경우 자동으로 디자이너객체 생성
		boolean run = true;
		while(run) {
			for(Member x :members) {//테스트용 코드
				System.out.println(x.toString());
			}
		System.out.println("1.로그인|2.회원가입|3.종료");
		String select = sc.next();
		switch(select) {
		case "1" : user = memberService.login(members,user);
		if(user.getId().matches("^manager\\d*")){
			adminService.adminMenu(designers, shops, members, cutServices,user,user2);}
		else {
		if(user.isDesigner()) {designerService.designerMenu(sc, reservations,reviews,user);
			
			
		} else {userService.memberService(user, shops, members, designers, cutServices, reservations,user2);}
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
