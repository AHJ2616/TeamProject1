package hairshop.service;

import hairshop.DTO.Member;
import java.util.*;

public class MemberSerivice extends Member {// 로그인 회원가입

	static Scanner sc = new Scanner(System.in);
	
	public Member login(List<Member> members,Member user) {//로그인
		boolean run = true;
		while (run) {
			System.out.println("로그인 아이디를 입력해 주세요.");
			String id1 = sc.next();
			System.out.println("로그인 비밀번호를 입력해 주세요");
			String pw1 = sc.next();
			
			for(int i=0;i<members.size();i++) {// length 대신 size 쓰기
				if(members.get(i).getId().equals(id1)&&members.get(i).getPw().equals(pw1)) { 
					//index i번째 getId = id1이고 getPw = pw1 일때
					user = members.get(i); // index i번째 맴버 객체 = user 객체와 같다.
					System.out.println(user.getName()+ "회원님 로그인에 성공하였습니다.");
					return user;
					
				}//if end
				
				
				
			}//for end
			System.out.println("로그인 정보가 일치하지 않습니다. 확인후 다시 시도해 주세요.");
			menu1(members);

		} // while end
		return user;
	}// 로그인 method end
	
	public void menu1(List<Member> members) {//로그인 재시도 or 회원가입 
		System.out.println("1.로그인 재시도|2.회원가입");
		String select=sc.next();
		switch(select) {
		case "1" :
			break;
		case "2" : register(members);
			break;
		}//switch end
		
	}//로그인 재시도 method end

	public List<Member> register(List<Member> members) {//회원가입
		System.out.println("============== 회원가입 ==============");
		String id1 = registerId(members);
		String pw1 = registerPw();
		String name1 = registerName();
		String email1 = registerEmail(members);
		String phone1 = registerPhone();
		designer = false;
		Member member1 = new Member(id1,pw1,name1,email1,phone1,false);
		members.add(member1);
		System.out.println(member1.getName()+"님의 회원가입이 완료되었습니다!");

		return members;
		
	}//회원가입 method end
	
	public String registerId(List<Member> members) {//아이디 등록
		boolean run = true;
		String id1 = "id1";
		while(run) {
		System.out.println("\n사용하실 아이디를 입력해주세요");
		System.out.print("입력 : ");
		id1 = sc.next();
		
		for(int i=0;i<members.size();i++) {
			 
			if(id1.equals(members.get(i).getId()))
					{System.out.println("중복되는 아이디 입니다. 다시 입력해주세요");
					run=true;
					}
			
		}//for end
		 {System.out.println("사용가능한 아이디 입니다.");
		 run=false;
		 }
		
		
		}//while end
		return id1;
	}//아이디 등록 method end

	public String registerPw() {//비밀번호 등록
		String pw1 = "pw1";
		String pw2 = "pw2";
		boolean run = true;
		while(run) {
		System.out.println("사용하실 비밀번호를 입력해주세요(8-20자리)");
		System.out.print("입력 : ");
		pw1 = sc.next();
		if(pw1.length()>=8&&pw1.length()<=20)
		{
		boolean run2 = true;
		while(run2) {
			System.out.println("비밀번호 확인 : 비밀번호를 다시 입력해주세요");
			System.out.print("입력 : ");
			pw2 = sc.next();
			if(pw1.equals(pw2)) {
				System.out.println("비밀번호가 일치합니다.");
				run2=false; run=false; break;
			}//if end
			else {System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");}
		}//while(run2) end
			
		} else {System.out.println("비밀번호를 8-20자리 사이에서 설정해주세요");}
		}//while end
		return pw1;
	}//비밀번호 등록 method end

	public String registerName() {//이름등록
		String name1 = "name";
		boolean run =true;
		while(run){
		System.out.println("한글이름을 입력해 주세요");
		System.out.print("입력 : ");
		name1 = sc.next();
		for(int i=0; i<name1.length();i++) {
			char x = name1.charAt(i);
			if(x>=0xAC00&&x<=0xD7A3) {
				run=false;
			}
			else {System.out.println("올바른 형식이 아닙니다");
			}
			
		}//for end
		}//while end
		return name1;
	}

public String registerEmail(List<Member> members) {
	String email1 = "e@";
	boolean run = true;
	while(run) {
	System.out.println("이메일 주소를 입력해 주세요");
	email1 = sc.next();
	if(email1.matches("^\\w+@\\w+\\.\\w{2,3}$")) {
		for(int i =0;i<members.size();i++) {
			if(members.get(i).getEmail().equals(email1)) {
				System.out.println("중복된 이메일은 사용이 불가능 합니다.");
			}
			else {System.out.println("사용가능한 이메일 주소 입니다.");
			run=false;}
		}
	}//if end
	else {System.out.println("올바른 형식이 아닙니다.");}
	}//while end
	return email1;
}

public String registerPhone() {
	String phone1="phone";
	boolean run = true;
	while(run) {
		System.out.println("전화번호를 입력해주세요(-제외)");
		System.out.print("010-");
		phone1 = sc.next();
		if(phone1.matches("^[0-9]{7,8}$")){
			run=false;
			
		}//if end
		else {System.out.println("올바른 전화번호를 입력해주세요");}
	}//while end
	
	return phone1;
}

public List<Member> setMembers(List<Member> members){//멤버 샘플
	Member member1 = new Member("미용사","qwer1234","김가위","kkk@kkk.com","12341234",true);
	Member member2 = new Member("손님","1234qwer","이샘플","kkk2@kkk.com","11111111",false);
	Member member3 = new Member("manager1","managerpw1","나사장","kkk@kkk.com","12341234",false);
	Member member4 = new Member("상엽디자이너","12341234","상엽 디자이너","sy@kkk.net","88884444",true);
	members.add(member1);
	members.add(member2);
	members.add(member3);
	members.add(member4);
	return members;
}//멤버 샘플 method end
}// class end
