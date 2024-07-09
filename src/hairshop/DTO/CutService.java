package hairshop.DTO;

import java.util.ArrayList;
import java.util.List;

public class CutService implements Comparable<CutService>{
	//필드
	protected String shopName; //매장 이름
	protected String cut; //시술이름 (커트,염색,펌 등)
	protected String contents; //시술설명 (시술에 대한 간략한 설명)
	protected int price; //시술 가격
	
	//기본생성자
	public CutService(){}
	
	
	//사용자 지정 생성자 : 가격표 초기값 입력용
	public CutService(String shopName, String cut, String contents, int price) {
		super();
		this.shopName = shopName;
		this.cut = cut;
		this.contents = contents;
		this.price = price;

	}
	
	
	// getter & setter method
	public String getShopName() {
		return shopName;
	}

	public String getCut() {
		return cut;
	}

	public String getContents() {
		return contents;
	}

	public int getPrice() {
		return price;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setCut(String cut) {
		this.cut = cut;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public int compareTo(CutService cutService) {
		if(cutService.price < price) {
			return 1;
		}else if (cutService.price > price) {
			return -1;
		}
		return 0;
	}

	
	
	

}//class end