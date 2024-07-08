package hairshop;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import hairshop.DTO.CutService;
import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Reservation;
import hairshop.DTO.Shop;

import hairshop.DTO.Member;
import hairshop.service.MemberSerivice;
import hairshop.service.UserService;
public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static List<Designer> designers = new ArrayList<>();
	public static List<Shop> shops = new ArrayList<>();
	public static List<Member> members = new ArrayList<>();
	public static List<CutService> cutServices = new ArrayList<>();
	public static List<Reservation> reservations = new ArrayList<>();
	public static Member user;
	
	public static void main(String[] args) {	// 메인메서드
		UserService userService = new UserService();
		MemberSerivice memberService = new MemberSerivice(); //멤버서비스 인스턴스 생성
		members=memberService.setMembers(members);
		boolean run = true;
		while(run) {
		System.out.println("1.로그인|2.회원가입|3.종료");
		String select = sc.next();
		switch(select) {
		case "1" : user = memberService.login(members,user);
		if(user.getId().matches("^manager\\d*")){System.out.println("매니저 메뉴");}
		else {
		if(user.isDesigner()) {
			System.out.println("디자이너용 메뉴");
			
		} else {userService.memberService(user, shops, members, designers, cutServices, reservations);}
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
