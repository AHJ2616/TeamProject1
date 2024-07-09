package hairshop.service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Reservation;
import hairshop.DTO.Review;

public class DesignerService extends Designer {
   
   public void designerMenu (Scanner scanner,List<Reservation> reservations
         ,List<Review> reviews , Member user) { // 디자이너 본체 메뉴
      boolean designer = true;
      
      while(designer) {
      System.out.println("============ 디자이너 ===========");
      System.out.println("1.스케쥴관리 | 2.예약확인 | 3.리뷰확인 | 4.종료");
      System.out.print(">>>");
      int designSelect = scanner.nextInt();
      switch(designSelect) {
      case 1:
         System.out.println("스케쥴 관리를 시작합니다.");
         designerSC(scanner,reservations,user);
         break;
      case 2:
         System.out.println("예약을 확인합니다.");
         ShowRe(reservations, user);
         break;
      case 3:
         System.out.println("리뷰를 확인합니다.");
         showReview(scanner, reviews,user);
         break;
      case 4:
         System.out.println("디자이너 메뉴를 종료합니다.");
         designer = false;
         break;
         default:
            System.out.println(">>> 1 ~ 4까지만 입력가능 <<<");
      } // switch문 종료
      } // while문 종료
   } // 디자이너 본체 메뉴 종료
   
   
   public static void designerSC(Scanner scanner, List<Reservation> reservations,  Member user) {
      System.out.println("--------스케쥴 관리--------");
      System.out.println("1.일정관리 | 2. 종료");
      int sc = scanner.nextInt();
      switch(sc) { 
      case 1:
         Calendar cal = Calendar.getInstance();
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E");
         System.out.println(df.format(cal.getTime()));
         System.out.println("SU MO TU WE TH FR SA");

         int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

         cal.set(Calendar.DATE, 1);
         int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

         for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("   ");
         }
         for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%02d ", i);
            if (dayOfWeek % 7 == 0) {
               System.out.println();
            }
            dayOfWeek++;
         }//달력
         ShowRe(reservations,user);
         System.out.println("\n예약을 막으실 날짜를 입력해주세요.  ex) 0709 ");
         System.out.print(">>>");
         String selectedDay = scanner.next();
         System.out.println("예약을 막으실 시간을 입력해주세요.(10:00 ~ 21:30)  ex) 10:30");
         System.out.print(">>>");
         String selectedTime = scanner.next();
         System.out.println("해당시간에 예약금지 조치되었습니다.");
      break;
      case 2:
         System.out.println("디자이너 메뉴로 돌아갑니다.");
         break;
         default:
            System.out.println(">>> 입력오류 <<<");
      }
   }
   
   
   public static void ShowRe(List<Reservation> reservations, Member user) {
      System.out.println("\n------예약 현황------");
      for(int i =0; i<reservations.size(); i++) {
         if(user.getName().equals(reservations.get(i).getDesigner())) {
            System.out.println("날짜 : "+reservations.get(i).getDate()+" 시술명 : "+reservations.get(i).getCutSV());
         }
      }
   }
   
   public static void showReview(Scanner scanner, List<Review> reviews, Member user ) { // 리뷰 불가
      System.out.println("-------리뷰 확인-------");
      for(int i =0; i < reviews.size(); i++ ) {
    	  if(user.getName().equals(reviews.get(i).getDesigner())) {
         System.out.println("작성자 : "+reviews.get(i).getName() + " 리뷰내용 : "+reviews.get(i).getReview());
    	  }
      }
   }
   
   
   
} // class 종료

