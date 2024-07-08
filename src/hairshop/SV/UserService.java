package hairshop.SV;

import java.util.List;
import java.util.Scanner;
import hairshop.DTO.CutService;
import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Reservation;
import hairshop.DTO.Shop;

public class UserService {
	Scanner scanner = new Scanner(System.in);

	public void memberService(Member user, List<Shop> shops, List<Member> members, List<Designer> designers,
			List<CutService> cutService, List<Reservation> reservations) {
		boolean run = true;
		System.out.println("손님 전용 메뉴 입니다.");
		while (run) {

			System.out.println("1.예약 | 2.예약확인 | 3.회원정보수정 | 4.회원탈퇴 | 5.금액충전 | 6.로그아웃");
			int select = scanner.next().charAt(0);
			switch (select) {

			case 49:
				System.out.println("예약 서비스로 이동 합니다.");
				Reservaition(scanner, user, shops, designers, cutService, reservations);
				break;

			case 50:
				System.out.println("예약확인 서비스로 이동합니다.");
				CheckReservation(scanner, user, shops, designers, cutService, reservations);

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

	public void Reservaition(Scanner scanner, Member user, List<Shop> shops, List<Designer> designers,
			List<CutService> cutService, List<Reservation> reservations) {

		Reservation newReservation = new Reservation();
		Designer selected = new Designer();

		System.out.println("현재 예약 가능한 매장 리스트 입니다.");

		for (int i = 0; i < shops.size(); i++) {
			System.out.println((i + 1) + "." + shops.get(i).getShopName());
		} // for end

		System.out.println("번호를 입력하시면 해당 매장의 정보확인이 가능 합니다.");
		int select = scanner.nextInt();
		System.out.println(shops.get(select - 1).getShopName());
		System.out.println(shops.get(select - 1).getLocation());
		System.out.println(shops.get(select - 1).getPrice());
		System.out.println("1.예약 | 2.다른매장 보기");
		int select2 = scanner.nextInt();

		switch (select2) {

		case 1:

			System.out.println("디자이너 선택");
			for (int i = 0; i < designers.size(); i++) {
				System.out.println((i + 1) + ". " + designers.get(i).getName() + designers.get(i).getReviewNum());
			}
			System.out.println(">>>>");
			int select3 = scanner.nextInt();

			System.out.println("날짜 선택");
			int x = 6;
			for (int i = 0; i < selected.getDates().length; i++) {
				if (selected.getDates()[i] != null) {
					System.out.println((i + 1) + ". " + (designers.get(select3 - 1).getDates()[i]) + "일 ");
					if ((i + 1) % x == 0) {
						System.out.println();
					}
				}
			}
			int select4 = scanner.nextInt();

			System.out.println("시간 선택");
			for (int i = 0; i < selected.getTimes().length; i++) {
				if (selected.getTimes()[i] != null) {
					System.out.println((i + 1) + ". " + (designers.get(select3 - 1).getTimes()[i]) + " | ");
					if ((i + 1) % x == 0) {
						System.out.println();

					}
				}

			}
			int select5 = scanner.nextInt();

			designers.get(select3 - 1).setTimes(null);

			System.out.println("시술 선택");
			for (int i = 0; i < cutService.size(); i++) {
				System.out.println((i + 1) + ". " + cutService.get(i).getCut());
				System.out.println(cutService.get(i).getContents());
				System.out.println(cutService.get(i).getPrice());
				System.out.println("=============================");
			}
			int select6 = scanner.nextInt();

			newReservation.setShop(shops.get(select - 1).getShopName());
			newReservation.setDesigner(designers.get(select3 - 1).getName());
			newReservation.setDate(selected.getDates()[select4 - 1]);
			newReservation.setTime(selected.getTimes()[select5 - 1]);
			newReservation.setCutSV(cutService.get(select6 - 1).getCut());
			newReservation.setId(user.getId());

			reservations.add(newReservation);

			System.out.println("예약 완료\t");

		case 2:
			break;

		default:
			System.out.println("1,2번만 입력 하세요");
		}

	}// Reservation Method end

	public void CheckReservation(Scanner scanner, Member user, List<Shop> shops, List<Designer> designers,
			List<CutService> cutService, List<Reservation> reservations) {

		Designer selected = new Designer();
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).getId().equals(user.getId())) {
				System.out.println((i + 1) + "번째 예약 " + reservations.get(i).toString());
				System.out.println("==============================================");
			}

		}
		System.out.print("수정할 예약번호 : " + "\n메뉴 복귀 : 0번입력");
		int select = scanner.nextInt();
		if (select == 0) {
			return;
		}
		System.out.println("선택할 메뉴의 번호를 입력 하세요");
		System.out.println("1.디자이너 | 2.날짜 | 3.시간 | 4.시술 | 5.예약 취소");
		System.out.print(">>>>>");
		int select1 = scanner.nextInt();
		switch (select1) {

		case 1:
			System.out.println("현재 디자이너 : " + reservations.get(select - 1).getDesigner());

			for (int i = 0; i < designers.size(); i++) {
				System.out.println("변경 할 디자이너 : ");
				System.out.println((i + 1) + "번 " + designers.get(i).getName());
			}

			int select2 = scanner.nextInt();
			reservations.get(select - 1).setDesigner(designers.get(select2).getName());
			System.out.println("변경 완료 : " + reservations.get(select).getDesigner());
			break;

		case 2:
			System.out.println("현재 날짜 : " + reservations.get(select - 1).getDate());
			System.out.print("변경할 날짜 선택");

			int x = 6;
			for (int i = 0; i < selected.getDates().length; i++) {
				if (selected.getDates()[i] != null) {
					System.out.println((i + 1) + ". " + (designers.get(i - 1).getDates()[i]) + "일 ");
					if ((i + 1) % x == 0) {
						System.out.println();
					}
				}
			}
			int select3 = scanner.nextInt();
			reservations.get(select - 1).setDate(designers.get(select).getDates()[select3 - 1]);
			System.out.println("변경 완료 : " + reservations.get(select).getDate());

			break;

		case 3:
			System.out.println("현재 시간 : " + reservations.get(select - 1).getTime());
			System.out.print("변경할 시간 선택");
			x = 6;
			for (int i = 0; i < selected.getTimes().length; i++) {
				if (selected.getTimes()[i] != null) {
					System.out.println((i + 1) + ". " + (designers.get(i - 1).getTimes()[i]) + " | ");
					if ((i + 1) % x == 0) {
						System.out.println();
					}
				}
			}
			int select4 = scanner.nextInt();
			reservations.get(select - 1).setTime(designers.get(select).getTimes()[select4 - 1]);
			System.out.println("변경 완료 : " + reservations.get(select).getTime());

			break;

		case 4:
			System.out.println("현재 시술 : " + reservations.get(select - 1).getCutSV());

			System.out.println("변경할 시술 : ");
			for (int i = 0; i < cutService.size(); i++) {
				System.out.println((i + 1) + "번 " + cutService.get(i).getCut());
			}
			int select5 = scanner.nextInt();
			reservations.get(select).setCutSV(cutService.get(select5).getCut());
			System.out.println("변경 완료 : " + reservations.get(select).getCutSV());
			break;

		case 5:
			System.out.println("선택하신 예약을 취소 합니다.");
			reservations.remove(select - 1);
			System.out.println("취소 완료");
			break;

		default:
			System.out.println("1~5번만 입력 해주세요");
		}

	}

	public Member ModifyUser(Scanner scanner, Member user) {
		System.out.println("ID 입력 : ");
		String id = scanner.next();
		System.out.println("PW 입력 : ");
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
				System.out.println("현재 이메일 입력 : ");
				String userEmail = scanner.next();
				System.out.println("변경할 이메일 입력 : ");
				String modEmail = scanner.next();

				if (userEmail.equals(user.getEmail())) {
					user.setEmail(modEmail);
					System.out.println("이메일 변경 완료");
				} else {
					System.out.println("현재 이메일 입력 오류");
				}
				return user;

			case 51:
				System.out.println("현재 핸드폰 번호 입력 : ");
				String userPhone = scanner.next();
				System.out.println("변경할 핸드폰 번호 입력 : ");
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
		}
		return user;

	}// ModifyMember Method end

	public void DeleteUser(Scanner scanner, Member user, List<Member> members) {

		System.out.println("회원 탈퇴를 위해 인증을 진행 합니다.");
		System.out.println("ID 입력 : ");
		String id = scanner.next();
		System.out.println("PW 입력 : ");
		String pw = scanner.next();
		System.out.println("핸드폰 번호 입력 : ");
		String phone = scanner.next();

		if (id.equals(user.getId()) && pw.equals(user.getPw()) && phone.equals(user.getPhone())) {
			System.out.println("정말 삭제하시겠습니까?");
			System.out.println("1.Yes | 2.No");
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
		user.setMoney(chargeMoney);
		System.out.println("충전 완료!");
		System.out.println("현재 잔고 : " + user.getMoney());

	}

} // MemberService Class end
