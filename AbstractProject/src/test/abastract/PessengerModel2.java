package test.abastract;
/**
 * 추상클래스 vs 인터페이스
 * 
 * @author user04
 *
 */
abstract class PessengerModel2 {
	int member = 0;
	
	public void setMember(int member) {	// 설계 뿐 아니라 구현도 가능
		this.member = member;
	}
	
	public abstract int getMember();
	protected abstract void getOn();
	protected abstract void getOff();
}


// vs

//	public interface PassengerModel1 {
//		int member = 0;
//		public void setMemger(int member);
//		public int getMember();
//		public void getOn();
//		public void getOff();
//	}

