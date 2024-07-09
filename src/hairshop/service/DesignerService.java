package hairshop.service;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import hairshop.DTO.Designer;
import hairshop.DTO.Reservation;

public class DesignerService extends Designer {
   
   public void designerMenu (Scanner scanner,List<Reservation> reservations) { // 디자이너 본체 메뉴
      boolean designer = true;
      
      while(designer) {
      System.out.println("============ 디자이너 ===========");
      System.out.println("1.스케쥴관리 | 2.예약확인 | 3.리뷰확인 | 4.종료");
      System.out.print(">>>");
      int designSelect = scanner.nextInt();
      switch(designSelect) {
      case 1:
         System.out.println("스케쥴 관리를 시작합니다.");
         designerSC(scanner);
         break;
      case 2:
         System.out.println("예약을 확인합니다.");
         
         break;
      case 3:
         System.out.println("리뷰를 확인합니다.");
         
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
   
   
   public static void designerSC(Scanner scanner) {
      System.out.println("--------스케쥴 관리--------");
      System.out.println("1.일정관리 | 2. 종료");
      int sc = scanner.nextInt();
      switch(sc) { 
      case 1:
      System.out.print("스케쥴관리 (년): ");
           int year = scanner.nextInt();
           System.out.print("스케쥴관리 (1-12월): ");
           int month = scanner.nextInt();
           System.out.println("일정을 추가할 날짜를 선택하세요:");
         System.out.print(">>>");
         int dat = scanner.nextInt();
      printCalendar(year, month); // 캘린더 출력
      
      break;
      case 2:
         System.out.println("디자이너 메뉴로 돌아갑니다.");
         break;
         default:
            System.out.println(">>> 입력오류 <<<");
      }
   }
   
   

   public static void printCalendar(int year, int month) { // 달력 출력
        Calendar calendar = Calendar.getInstance(); // 현재 시간을 가져옴
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 현재 월의 날자

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("      " + year + "년 " + month + "월");
        for (String day : days) {
            System.out.print(day + " ");
        }
        System.out.println();

        int currentDay = 1;

        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }

        while (currentDay <= daysInMonth) {
            System.out.printf("%3d ", currentDay);
            if ((firstDayOfWeek + currentDay - 1) % 7 == 0) {
                System.out.println();
            }
            currentDay++;
        }

        if ((firstDayOfWeek + daysInMonth - 1) % 7 != 0) {
            System.out.println();
        }
        }
   
   public static void addCal(Scanner scanner) {
      
      System.out.println("1.휴무 | 2.휴무취소 | 3.종료 ");
      System.out.print(">>>");
      int add = scanner.nextInt();
      switch(add) {
      case 1:
         
         break;
      case 2:
         
         break;
      case 3:
         System.out.println("스케쥴관리를 종료합니다.");
         break;
         default:
            System.out.println(">>> 입력오류 <<<");
      }
   }
   
   
} // class 종료
