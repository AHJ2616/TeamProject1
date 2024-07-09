package hairshop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import hairshop.DTO.CutService;
import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Reservation;
import hairshop.DTO.Shop;

public class UserService {
   Scanner scanner = new Scanner(System.in);

   public void memberService(Member user, List<Shop> shops, List<Member> members, List<Designer> designers,
         List<CutService> cutServices, List<Reservation> reservations, Designer user2) {
      boolean run = true;
      System.out.println("손님 전용 메뉴 입니다.");
      while (run) {

         System.out.println("1.예약 | 2.예약확인 | 3.회원정보수정 | 4.회원탈퇴 | 5.금액충전 | 6.로그아웃");
         int select = scanner.next().charAt(0);
         switch (select) {

         case 49:
            System.out.println("예약 서비스로 이동 합니다.");
            Reservation(scanner, user, shops, designers, cutServices, reservations, user2);
            break;

         case 50:
            System.out.println("예약확인 서비스로 이동합니다.");
            CheckReservation(scanner, user, shops, designers, cutServices, reservations, user2);
            break;

         case 51:
            System.out.println("회원정보 수정 서비스로 이동합니다.");
            ModifyUser(scanner, user);
            break;

         case 52:
            System.out.println("회원탈퇴 서비스로 이동합니다.");
            DeleteUser(scanner, user, members);
            break;

         case 53:
            System.out.println("금액충전 서비스로 이동합니다.");
            Charge(scanner, user);
            break;

         case 54:
            System.out.println("로그아웃 합니다.");
            user = null;
            run = false;
            break;

         default:
            System.out.println("1~6 사이의 숫자만 입력해주세요.");
         }// switch end

      } // while end
   } // memberService method end

   public void Reservation(Scanner scanner, Member user, List<Shop> shops, List<Designer> designers,
         List<CutService> cutService, List<Reservation> reservations, Designer user2) {

      Reservation newReservation = new Reservation(); // 예약 정보 객체 생성

      System.out.println("현재 예약 가능한 매장 리스트 입니다.");

      if (shops.isEmpty()) {
         System.out.println("예약 가능한 매장이 없습니다.");
         return;
      } // 예약가능한 매장이 없으면, 예약 메뉴로 복귀.

      for (int i = 0; i < shops.size(); i++) { // 현재 예약 가능한 매장 리스트 출력
         System.out.println((i + 1) + "번 " + shops.get(i).getShopName() + " " + shops.get(i).getLocation() + "점");
         // i번 . xx xxx nn점
         // 매장 리스트 출력
      } // for end

      System.out.println("번호를 입력하시면 해당 매장의 정보확인이 가능 합니다."); // 입력한 번호에 따라 매장이름, 지역, 가격 출력
      int select = scanner.nextInt();
      System.out.println("매장이름 : " + shops.get(select - 1).getShopName());
      System.out.println("매장위치 : " + shops.get(select - 1).getLocation());
      System.out.println("최저가 : " + shops.get(select - 1).getPrice());
      System.out.println("디자이너 수 : " + designers.size());
      System.out.println("1.예약 | 2.다른매장 보기");
      int select2 = scanner.nextInt();

      switch (select2) {

      case 1:

         System.out.println("디자이너 선택");
         for (int i = 0; i < designers.size(); i++) {
            System.out.println((i + 1) + ". " + designers.get(i).getName() + designers.get(i).getReviewNum());
         } // for end
            // 디자이너 리스트 출력
         System.out.print(">>>>");
         if (designers.isEmpty()) {
            System.out.println("예약 가능한 디자이너가 없습니다.");
            return;
         } // 예약가능한 매장이 없으면, 예약 메뉴로 복귀.

         int select3 = scanner.nextInt(); // 디자이너 번호 선택

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
         }

         System.out.println();

         System.out.println("예약 하실 날짜를 입력해주세요.  ex) 0709 ");
         System.out.print(">>>");
         String selectedDay = scanner.next();
         System.out.println("예약 시간을 입력해주세요.(10:00 ~ 21:30)  ex) 10:30");
         System.out.print(">>>");
         String selectedTime = scanner.next();

         System.out.println(designers.get(select3 - 1).schedule.get(selectedDay).get(selectedTime));

         System.out.println("시술 선택");
         for (int i = 0; i < cutService.size(); i++) {
            System.out.println((i + 1) + ". " + cutService.get(i).getCut());
            System.out.println(cutService.get(i).getContents());
            System.out.println(cutService.get(i).getPrice());
            System.out.println("=============================");
         } // 시술 리스트 출력
         System.out.print(">>>");
         int select6 = scanner.nextInt(); // 시술 번호 선택

         if (user.getMoney() < cutService.get(select6 - 1).getPrice()) {
            System.out.println("잔액이 부족합니다..");
            return;
         } else {
            user.setMoney(user.getMoney() - cutService.get(select6 - 1).getPrice());
            System.out.println("남은 잔액 : " + user.getMoney());
         }

         // select3 : 키보드로 입력받은 디자이너의 번호( 실제 인덱스는 select3 -1 )

         // select6 : 키보드로 입력받은 시술 번호 ( 실제 인덱스는 select6 -1 )

         newReservation.setShop(shops.get(select - 1).getShopName());
         newReservation.setDesigner(designers.get(select3 - 1).getName());
         newReservation.setDate(designers.get(select3 - 1).schedule.get(selectedDay).get(selectedTime));
         newReservation.setCutSV(cutService.get(select6 - 1).getCut());
         newReservation.setId(user.getId());

         // 새로 만든 객체에 정보 저장.

         reservations.add(newReservation);
         // 객체를 배열에 추가.
         System.out.println("예약 완료\t");

      case 2:
         break;

      default:
         System.out.println("1,2번만 입력 하세요");
      }// switch 종료

   }// Reservation Method end

   public void CheckReservation(Scanner scanner, Member user, List<Shop> shops, List<Designer> designers,
         List<CutService> cutService, List<Reservation> reservations, Designer user2) {

      List<Reservation> userReservations = new ArrayList<>();
      for (Reservation reservation : reservations) {
         if (reservation.getId().equals(user.getId())) {
            userReservations.add(reservation);
         }
      }

      if (userReservations.isEmpty()) {
         System.out.println("예약이 없습니다.");
         return;
      }

      for (int i = 0; i < userReservations.size(); i++) {
         System.out.println((i + 1) + "번째 예약 " + userReservations.get(i).toString());
         System.out.println("==============================================");
      }

      System.out.print("수정할 예약 번호를 입력하세요 (메뉴 복귀: 0) : ");
      int select = scanner.nextInt();

      if (select == 0) {
         return;
      }
      System.out.println("선택할 메뉴의 번호를 입력 하세요");
      System.out.println("1.디자이너 | 2.날짜 | 3.시술 | 4.예약 취소");
      System.out.print(">>>>>");
      int select1 = scanner.nextInt();
      switch (select1) {

      case 1:
         System.out.println("현재 디자이너 : " + reservations.get(select - 1).getDesigner()); // 현재 예약된 디자이너 출력
         for (int i = 0; i < designers.size(); i++) {
            System.out.println("변경 할 디자이너 : ");
            System.out.println((i + 1) + "번 " + designers.get(i).getName());

         } // for end // 디자이너 리스트 출력
         System.out.print(">>>");
         int select2 = scanner.nextInt(); // 디자이너 선택

         reservations.get(select - 1).setDesigner(designers.get(select2 - 1).getName()); // 예약된 디자이너를 새로 선택한 디자이너로 교체
         System.out.println("변경 완료 : " + reservations.get(select - 1).getDesigner());
         break;

      case 2:

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
         }
         System.out.println("현재 날짜,시간 : " + reservations.get(select - 1).getDate());
         System.out.print("변경할 날짜 입력");
         System.out.print(">>>");
         String modDate = scanner.next();
         System.out.print("변경할 시간 입력");
         System.out.print(">>>");
         String modTime = scanner.next();

         userReservations.get(select - 1).setDate(designers.get(select - 1).schedule.get(modDate).get(modTime));

         System.out.println("변경 완료 : " + userReservations.get(select - 1).getDate());

         break;

      case 3:
         System.out.println("현재 시술 : " + reservations.get(select - 1).getCutSV());

         System.out.println("변경할 시술 : ");

         for (int i = 0; i < cutService.size(); i++) {
            System.out.println((i + 1) + "번 " + cutService.get(i).getCut());
         }
         System.out.print(">>>");
         int select5 = scanner.nextInt();
         reservations.get(select - 1).setCutSV(cutService.get(select5 - 1).getCut());
         System.out.println("변경 완료 : " + reservations.get(select - 1).getCutSV());
         break;

      case 4:
         System.out.println("선택하신 예약을 취소 합니다.");
         reservations.remove(select - 1);
         System.out.println("취소 완료");
         break;

      default:
         System.out.println("1~4번만 입력 해주세요");
      }

   }

   public Member ModifyUser(Scanner scanner, Member user) {
      System.out.print("ID 입력 : ");
      String id = scanner.next();
      System.out.print("PW 입력 : ");
      String pw = scanner.next();

      if (id.equals(user.getId()) && pw.equals(user.getPw())) {
         System.out.println("수정할 정보 선택");
         System.out.println("1.비밀번호 | 2.이메일 | 3.핸드폰번호 ");
         System.out.print(">>>>");
         int select = scanner.next().charAt(0);

         switch (select) {
         case 49:
            System.out.print("현재 비밀번호 입력 : ");
            String userPw = scanner.next();
            System.out.print("변경할 비밀번호 입력 : ");
            String modPw = scanner.next();

            if (userPw.equals(user.getPw())) {
               user.setPw(modPw);
               System.out.println("비밀번호 변경 완료");
            } else {
               System.out.println("현재 비밀번호 입력 오류");
            }
            return user;

         case 50:
            System.out.print("현재 이메일 입력 : ");
            String userEmail = scanner.next();
            System.out.print("변경할 이메일 입력 : ");
            String modEmail = scanner.next();

            if (userEmail.equals(user.getEmail())) {
               user.setEmail(modEmail);
               System.out.println("이메일 변경 완료");
            } else {
               System.out.println("현재 이메일 입력 오류");
            }
            return user;

         case 51:
            System.out.print("현재 핸드폰 번호 입력 : ");
            String userPhone = scanner.next();
            System.out.print("변경할 핸드폰 번호 입력 : ");
            String modPhone = scanner.next();

            if (userPhone.equals(user.getPhone())) {
               user.setPhone(modPhone);
               System.out.println("핸드폰 번호 변경 완료");
            } else {
               System.out.println("현재 핸드폰 번호 입력 오류");
            }
            return user;

         default:
            System.out.println("1~3사이의 숫자만 입력하세요.");
         }
      } else {
         System.out.println("ID , PW 입력 오류");
      }
      return user;

   }// ModifyMember Method end

   public void DeleteUser(Scanner scanner, Member user, List<Member> members) {

      System.out.println("회원 탈퇴를 위해 인증을 진행 합니다.");
      System.out.print("ID 입력 : ");
      String id = scanner.next();
      System.out.print("PW 입력 : ");
      String pw = scanner.next();
      System.out.print("핸드폰 번호 입력 : ");
      String phone = scanner.next();

      if (id.equals(user.getId()) && pw.equals(user.getPw()) && phone.equals(user.getPhone())) {
         System.out.println("정말 삭제하시겠습니까?");
         System.out.println("1.Yes | 2.No");
         System.out.print(">>>");
         int select = scanner.next().charAt(0);

         switch (select) {

         case 49:
            for (int i = 0; i < members.size(); i++) {
               if (members.get(i) != null) {
                  if (members.get(i).getId().equals(user.getId())) {
                     System.out.println(user.getName() + "님 안녕히 가세요 .");
                     members.remove(i);
                  } // if end
               } // if end
            } // for end

            break;

         case 50:
            System.out.println("메뉴로 돌아갑니다.");
            break;

         default:
            System.out.println("1~2번 숫자만 입력하세요");

         }// switch 종료

      } else {
         System.out.println("회원정보 입력 오류");
      } // if-else 종료
   }// DeleteUser Method end

   public void Charge(Scanner scanner, Member user) {
      System.out.println("현재 잔고 : " + user.getMoney());
      System.out.print("충전 할 금액 입력 : ");
      int chargeMoney = scanner.nextInt();
      user.setMoney(chargeMoney + user.getMoney());
      System.out.println("충전 완료!");
      System.out.println("현재 잔고 : " + user.getMoney());

   }

} // MemberService Class end