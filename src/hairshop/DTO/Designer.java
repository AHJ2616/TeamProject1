package hairshop.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Designer extends Member{ //DesignerDTO의 추상화 class
	//필드
	protected String name; //디자이너 이름(member class의 name 을 불러오기)
	protected String id; //디자이너 이름(member class의 name 을 불러오기)
	protected String shopName; //디자이너의 매장이름	
	protected int reviewNum; // 디자이너가 받은 리뷰 갯수
	public Map<String,Map<String,String>> schedule = new HashMap<>() {
		
		
		
	};
	//게시판에서 리뷰 오름/내림 차순으로 정렬하고 싶으면 사용하기.
	
	
	
	
	public Designer(){}//디자이너 기본 생성자
	
	public Designer(String name,String id) {//사용자 임의 생성자1
	this.name = name;
	this.id = id;
	}
	
	public Designer(String name,String id,String shopName) {//사용자 임의 생성자2
		this.name = name;
		this.id = id;
		this.shopName = shopName;
		}
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
