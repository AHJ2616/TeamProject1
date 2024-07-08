package hairshop.DTO;

public class Reservation {

	protected String shop;
	protected String designer;
	protected String date;
	protected String time;
	protected String cutSV;
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShop() {
		return shop;
	}

	public String getDesigner() {
		return designer;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getCutSV() {
		return cutSV;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setCutSV(String cutSV) {
		this.cutSV = cutSV;
	}

	@Override
	public String toString() {
		return "미용실 : " + shop + "\n디자이너 : " + designer + "\n날짜 : " + date + "\n시간 : " + time + "\n시술내용 : " + cutSV;

	}

}
