package test.buy;
/**
 * 
 * <아이스크림 심부름>
출연진: 나, 로봇, 편의점(점원)
데이터: 1000원, "누가바"

1. (내가 로봇에게) 왼손 줘.
1-1. left;
2. 왼손 <- 1000원.
2-1. left = 1000;
3. (내가 로봇에게) 아이스크림 사와.
3-1. buyIcecream();
4. 로봇이 편의점(cu)를 발견하고 들어간다.
4-1. cu;
5. (로봇이 점원에게) 아이스크림 주세요.
5-1. getIcecream();
	6. 점원이 매대에서 아이스크림("누가바")를 가져온다.
	6-1. "누가바";	
	7. (5번에 대한 응답으로) (점원이 로봇에게) 아이스크림(누가바)를 준다.
	7-1. return [6-1];
	7-2. (로봇의) right = [7-1];
8. 로봇이 내가 있는 곳으로 돌아온다.
8-1. ;
9. 로봇이 나에게 손에 있는 아이스크림을 준다.
9-1. syso(right);

 * @author 김희수
 *
 */
public class BuyIcecream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. (내가 로봇에게) 왼손 줘.
		int left;
		//	2. 왼손 <- 1000원.
		left = 1000;
		//	3. (내가 로봇에게) 아이스크림 사와.
		buyIcecream(left);
		//	8. 로봇이 내가 있는 곳으로 돌아온다.
		Object right = buyIcecream(left);
		//	9. 로봇이 나에게 손에 있는 아이스크림을 준다.
		System.out.println(right);
	}
	
	private static Object buyIcecream(int left) {
			//	4. 로봇이 편의점(cu)를 발견하고 들어간다.
			CU cu = new CU();
			//	5. (로봇이 점원에게) 아이스크림 주세요.
			String right = cu.getIcecream(left);
			return right;	
	}
}
