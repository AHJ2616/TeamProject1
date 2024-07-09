package hairshop.DTO;


import java.util.Map;

public class Reservation {

   protected String shop;
   protected String designer;
   protected String date;
   protected Map<String, String> time;
   protected String cutSV;
   protected String id;

   public Reservation(){}//기본생성자
   
  
   public Reservation(String shop, String designer,String date , String cutSV, String id) {
	super();
	this.shop = shop;
	this.designer = designer;
	this.date = date;
	this.cutSV = cutSV;
	this.id = id;
}




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

   public Map<String, String> getTime() {
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

   public void setDate(String string) {
      this.date = string;
   }

   public void setTime(Map<String, String> map) {
      this.time = map;
   }

   public void setCutSV(String cutSV) {
      this.cutSV = cutSV;
   }

   @Override
   public String toString() {
      return "미용실 : " + shop + "\n디자이너 : " + designer + "\n날짜,시간 : " + date + "\n시술내용 : " + cutSV;

   }

}