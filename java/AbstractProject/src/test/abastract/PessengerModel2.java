package test.abastract;
/**
 * �߻�Ŭ���� vs �������̽�
 * 
 * @author user04
 *
 */
abstract class PessengerModel2 {
	int member = 0;
	
	public void setMember(int member) {	// ���� �� �ƴ϶� ������ ����
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

