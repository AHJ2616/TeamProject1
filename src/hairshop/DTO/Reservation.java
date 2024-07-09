package hairshop.DTO;

import java.util.Map;

public class Reservation {

   protected String shop;
   protected String designer;
   protected Map<String, String> date;
   protected Map<String, String> time;
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

   public Map<String, String> getDate() {
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

   public void setDate(Map<String, String> map) {
      this.date = map;
   }

   public void setTime(Map<String, String> map) {
      this.time = map;
   }

   public void setCutSV(String cutSV) {
      this.cutSV = cutSV;
   }

   @Override
   public String toString() {
      return "미용실 : " + shop + "\n디자이너 : " + designer + "\n날짜 : " + date + "\n시간 : " + time + "\n시술내용 : " + cutSV;

   }

}
