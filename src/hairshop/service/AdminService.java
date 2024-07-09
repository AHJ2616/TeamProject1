package hairshop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hairshop.DTO.CutService;
import hairshop.DTO.Designer;
import hairshop.DTO.Member;
import hairshop.DTO.Schedule;
import hairshop.DTO.Shop;

public class AdminService extends Shop {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scannerInt = new Scanner(System.in);


	public void adminMenu(List<Designer> designers,List<Shop> shops,List<Member> members,List<CutService> cutServices,Member user,Designer user2) {
		
		boolean run = true;
		while (run) {
		System.out.println("1.헤어컷 관리|2.디자이너 관리|3.뒤로가기|");
		int select = scanner.nextInt();
			switch (select) {
			case 1: // 헤어 시술 가격표(CutService) 관련 메서드
				editCut(designers,shops,members,cutServices);
				break;
			case 2:
				editDesigner(designers,shops,members,cutServices,user,user2);
				break;
			case 3: // 메뉴 종료 버튼
				run = false;
				break;
			}// end switch
		} // end while

	}// end adminMenu
	

	public void editCut(List<Designer> designers,List<Shop> shops,List<Member> members,List<CutService> cutServices) { // 1. 헤어컷 설정
		boolean run = true;
		while (run) {
			System.out.println("------- 헤어컷 추가/제거/수정 -------");
			System.out.println("|1.추가|2.수정|3.제거|4.뒤로가기|");
			System.out.println("----------- 헤어컷 목록 -----------");
			for (int i = 0; i < cutServices.size(); i++) { // 헤어컷 목록을 보여주는 println
				System.out.println((i + 1) + "." + "샵:" + cutServices.get(i).getShopName() + "|컷트:"
						+ cutServices.get(i).getCut() + "|컷트설명:" + cutServices.get(i).getContents() + "|가격:"
						+ cutServices.get(i).getPrice());
			} // end for
			System.out.print(">>>");
			int select1 = scanner.nextInt();
			switch (select1) {
			case 1: // 헤어컷 추가
				CutService cutAdd = new CutService();
				System.out.println("--------- 헤어컷 추가 ---------");
				System.out.println("샵의 이름을 입력하세요.:");
				System.out.print(">>>");
				cutAdd.setShopName(scanner.next()); // 샵의 이름을 입력받음
				System.out.println("시술의 이름을 입력하세요.:");
				System.out.print(">>>");
				cutAdd.setCut(scanner.next()); // 시술의 이름을 입력받음
				System.out.println("시술의 내용(설명)을 입력하세요.:");
				System.out.print(">>>");
				cutAdd.setContents(scanner.next()); // 시술 내용을 입력받음
				System.out.println("시술의 가격을 입력하세요.:");
				System.out.print(">>>");
				cutAdd.setPrice(scannerInt.nextInt()); // 시술 가격을 입력받음
				cutServices.add(cutAdd); // 입력받은 값 배열에 대입
				System.out.println("추가 완료");
				Collections.sort(cutServices); // 헤어컷 가격 오름차순 정렬 '낮은게 가장 위로감'
				price = cutServices.get(0).getPrice();
				shops.get(0).setPrice(price);
				break;
			case 2:
				System.out.println("--------- 헤어컷 수정 ---------");
				System.out.println("수정하실 시술의 번호를 입력해 주세요.");
				System.out.print(">>>");
				int cutEdit = scanner.nextInt();
				System.out.println("------- 수정하실 내용확인 -------");
				System.out.println(
						"지점:"+ cutServices.get(cutEdit-1).getShopName()+
						"|시술명:"+cutServices.get(cutEdit-1).getCut()+
						"|시술내용:"+cutServices.get(cutEdit-1).getContents()+
						"|가격:"+cutServices.get(cutEdit-1).getPrice()	
				);
				System.out.println("수정하실 부분을 선택해 주세요.");
				System.out.println("1.지점 / 2. 시술명 / 3.시술내용 /4. 가격 / 5.취소");
				System.out.print(">>>");
				int select2 = scanner.nextInt();
				switch(select2) {
				case 1:
					System.out.println("수정하실 지점의 이름을 입력해 주세요.");
					System.out.print(">>>");
					String editShop = scanner.next();
					cutServices.get(cutEdit-1).setShopName(editShop);
					System.out.println("지점수정이 완료되었습니다.");
					break;
				case 2:
					System.out.println("수정하실 시술의 이름을 입력해 주세요.");
					System.out.print(">>>");
					String editCut = scanner.next();
					cutServices.get(cutEdit-1).setCut(editCut);
					System.out.println("헤어컷 수정이 완료되었습니다.");
					break;
				case 3:
					System.out.println("수정하실 시술내용을 입력해 주세요.");
					System.out.print(">>>");
					String editContent = scanner.next();
					cutServices.get(cutEdit-1).setContents(editContent);
					System.out.println("시술내용 수정이 완료되었습니다.");
					break;
				case 4:
					System.out.println("수정하실 가격을 입력해 주세요.");
					System.out.print(">>>");
					int editPrice = scanner.nextInt();
					cutServices.get(cutEdit-1).setPrice(editPrice);
					System.out.println("가격 수정이 완료되었습니다.");
					break;
				case 5:
					break;
				default:
					System.out.println("명령어만 입력해주세요.");
				}
				break;
			case 3: // 헤어컷 삭제
				System.out.println("--------- 헤어컷 삭제 ---------");
				System.out.println("삭제할 시술의 번호를 입력해 주세요.");
				System.out.print(">>>");
				int cutDel = scanner.nextInt();
				System.out.println("------- 삭제하실 내용확인 -------");
				System.out.println(
						"시술명:" + cutServices.get(cutDel-1).getCut() + "|지점: "
				+ cutServices.get(cutDel-1).getShopName());
				System.out.println("삭제 하시겠습니까? (1.예 / 2.아니오)");
				System.out.print(">>>");
				int select3 = scanner.nextInt();
				switch (select3) {
				case 1:
					cutServices.remove(cutDel-1);
					break;
				case 2:
					break;
				default:
					System.out.println("명령어만 입력해주세요.");
				}// end switch
				break;
			case 4:
				run = false;
				break;
				
			default:
				System.out.println("명령어만 입력해주세요.");

			}// end switch
			
		} // end while
			
	}// end cutEdit

	public void editDesigner(List<Designer> designers,List<Shop> shops,List<Member> members,List<CutService> cutServices,Member user,Designer user2) { // 2. 디자이너 설정
		Schedule sch = new Schedule();
		System.out.println("------- 디자이너 설정 -------");
		System.out.println("|1.권한부여|2.권한삭제|3.뒤로가기|");
		int select = scanner.nextInt();
			switch (select) {
			case 1: // 디자이너 권한 부여
				System.out.println("권한을 부여할 아이디를 입력하세요.");
				System.out.print(">>>");
				String magIn = scanner.next();
				try {
					for (int i = 0; i < members.size(); i++) {
						if (members.get(i).getId().equals(magIn)) {
							members.get(i).setDesigner(true);
							Designer designer1 = new Designer();
							designer1.setName(members.get(i).getName()); //이름 옮겨주기
							designer1.setId(members.get(i).getId()); //아이디 옮겨주기
							designer1.setShopName(user2.getShopName()); //매장이름 옮겨주기
							designer1.schedule= sch.setSchedule(designer1.schedule);
							designer1.schedule= sch.setSchedule2(designer1.schedule);
							break;
						} // end if
					} // end for
				} catch (Exception e) {
					// Try-Catch로 예외 발생 처리
					//e.printStackTrace();
				}
				System.out.println("아이디를 다시 확인해주세요.");
				break;
			case 2: // 디자이너 권한 삭제
				System.out.println("권한을 삭제할 아이디를 입력하세요.");
				System.out.print(">>>");
				String magOut = scanner.next();
				try {
					for (int i = 0; i < members.size(); i++) {
						if (members.get(i).getId().equals(magOut)) {
							members.get(i).setDesigner(false);
							break;
						} // end if
					} // end for
				} catch (Exception e) {
					// Try-Catch로 예외 발생 처리
					//e.printStackTrace();
				}
				System.out.println("아이디를 다시 확인해주세요.");
				break;
			case 3: // 뒤로가기
				break;
			default:
				System.out.println("명령어만 입력해주세요.");
			}// end switch

	} // end editDesigner

	public List<Designer> setDesigners(List<Designer> designers,List<Member> members){//user값 디자이너배열에 넣기
		Schedule sch = new Schedule();
		for(int i=0;i<members.size();i++) {
			if(members.get(i).isDesigner()==true) {
				Designer x = new Designer(members.get(i).getName(),members.get(i).getId());
				x.schedule= sch.setSchedule(x.schedule);
				x.schedule= sch.setSchedule2(x.schedule);
				designers.add(x);
			}
			
		}//for end
		
		return designers;
	}//method end
	

	public Designer setAdmin(Designer user2) {//매장주인 매장명입력
		System.out.println("매장명을 입력해주세요");
		String x = scanner.next();
		user2.setShopName(x);
		return user2;
	}//method end
}// end class
