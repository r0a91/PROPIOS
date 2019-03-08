
public class Client extends Thread {
	private int id;
	private Directory dsrc, ddest;
	public Client(int i, Directory d1, Directory d2) {
		id = i;
		dsrc = d1;
		ddest = d2;
	}
	@Override
	public void run() {
		System.out.println("Cliente :" + id);
		FileSysUtil_Rev f1 = new FileSysUtil_Rev();
		f1.moveContents(dsrc, ddest);
	}
}
