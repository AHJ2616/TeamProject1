package hairshop.DTO;

import java.util.ArrayList;
import java.util.List;

public class Designer { //DesignerDTO의 추상화 class
	//필드
	protected String name; //디자이너 이름(member class의 name 을 불러오기)
	protected String id; //디자이너 이름(member class의 name 을 불러오기)
	protected String shopName; //디자이너의 매장이름	
	protected int reviewNum; // 디자이너가 받은 리뷰 갯수
	//게시판에서 리뷰 오름/내림 차순으로 정렬하고 싶으면 사용하기.
	
	// getter & setter method
	
	public String getName() {
		return name;
	}

	

	public int getReviewNum() {
		return reviewNum;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
	
	
}//class end
