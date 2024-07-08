package hairshop.DTO;



public class Shop {// ShopDTO의 추상화 class
	//필드
	protected String shopName; //매장 이름
	protected String location; //매장 위치 (동네이름 xx점)
	
	protected int price; 	//시술들 중에서 가장 비용이 적은 값 
	//ex) 매장전체의 시술중에서 가장 싼게 앞머리 커트 5,000원 이면 price = 5000
	
	
	

	

	//기본생성자
	public Shop() {}
	
	//사용자 지정 생성자 : 미용실 초기값 입력용
	public Shop(String shopName, String location, int price) {
		super();
		this.shopName = shopName;
		this.location = location;
		this.price = price;
	}//생성자 end
	
	
	
	// getter & setter method
	
	public String getShopName() {
		return shopName;
	}

	public String getLocation() {
		return location;
	}

	public int getPrice() {
		return price;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}//class end
