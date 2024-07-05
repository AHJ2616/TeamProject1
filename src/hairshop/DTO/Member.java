package hairshop.DTO;

import java.util.LinkedList;
import java.util.List;

public class Member { //MemberDTO의 추상화 class
	//필드
	protected String id; //아이디
	protected String pw; //패스워드
	protected String name; //이름
	protected String email; //이메일주소
	protected String phone; //전화번호 : 정보 수정,정보 보기에만 사용할 것이어서 String으로 해도 상관없다
	
	protected int money; //결제용 머니 20억 이하숫자 이니까 int
	protected boolean designer; //디자이너 권한 true: 관리페이지 false : 일반회원
	
	public static List<Member> members = new LinkedList<>();
	
	public static Member user = new Member();
	//로그인한 member의 세션대신 사용할 static 객체
	
	
	//기본생성자
	public Member() {}

	//사용자 지정 생성자 : 회원 샘플 만들기용
	public Member(String id, String pw, String name, String email, String phone, boolean designer) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designer = designer;
	}//생성자 end
	
	
	
	
}//class end
