package hairshop.DTO;


import java.util.ArrayList;
import java.util.List;

public class Review {
	
	//필드
	protected String review; //디자이너에 대한 리뷰
	protected String name; //리뷰작성자 (회원이름 불러오기)
	protected String designer; //디자이너 이름
	//김** 등으로 표기할 것인지 or 그냥 이름 전체 표기를 할 것인지
	
	protected int date; //작성일 : String으로 할 것인지 int로 할것인지 정하여 수정해주세요
	//String로 할 경우 : 날짜를 DateFormat으로 표기
	//int로 할 경우 : 계산을 통해서 X일전 , X개월전 등으로 표기가능
	
	

	//기본 생성장
	public Review(){}
	
	
	public String getDesigner() {
		return designer;
	}


	public void setDesigner(String designer) {
		this.designer = designer;
	}


	//사용자 임의 생성자 : 리뷰 샘플 생성용
	public Review(String designer,String review, String name) {
		this.designer = designer;
		this.review = review;
		this.name = name;
	
	}

	
	
	
	// getter & setter method
	

	public String getReview() {
		return review;
	}


	public String getName() {
		return name;
	}


	public int getDate() {
		return date;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDate(int date) {
		this.date = date;
	}
	
	@Override
	   public String toString() {
	      return  "리뷰 :" + review + ", 작성자:" + name ;
	   }
	   
	
	
	
}//class end
