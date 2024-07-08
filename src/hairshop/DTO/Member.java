package hairshop.DTO;

import java.util.ArrayList;
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
	
	
	//getter & setter method
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getMoney() {
		return money;
	}

	public boolean isDesigner() {
		return designer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setDesigner(boolean designer) {
		this.designer = designer;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", money=" + money + ", designer=" + designer + "]";
	}
	
	
	
}//class end
