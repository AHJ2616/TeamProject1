package hairshop.DTO;


public class Designer { // DesignerDTO의 추상화 class
	// 필드
	

	protected String name; // 디자이너 이름(member class의 name 을 불러오기)
	protected String date; // 날짜 DateFormat 활용하여서 월,일,요일 표기
	protected String time; // 예약시간 : 디자이너 스케줄, 고객 예약시간 설정 (30분단위로)

	public String[] dates = new String[31]; // 1달에 최대 31일
	// 값이 한정되있으므로 collection(list,map 등) 보다는 []배열이 좋다.
	// static으로 만들면 1개월밖에 정할 수 없으니까 non-static으로.
	
	protected String[] times = new String[24]; // 시간표
	// 매장의 설정은 오전 10시 - 오후 10시 (총 12시간) 오픈
	// 오전 10시부터 30분 단위로 예약가능 시간을 만들기 위해 12 * 2(00분 , 30분) = 24

	protected int reviewNum; // 디자이너가 받은 리뷰 갯수
	// 게시판에서 리뷰 오름/내림 차순으로 정렬하고 싶으면 사용하기.

	// getter & setter method

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public String[] getDates() {
		return dates;
	}

	public String[] getTimes() {
		return times;
	}

	public void setDates(String[] dates) {
		this.dates = dates;
	}

	public void setTimes(String[] times) {

		this.times = times;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

}// class end
