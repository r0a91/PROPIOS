
public class Launcher {

	public static void main(String[] args) {
		Writer w1 = new Writer(1);
		Writer w2 = new Writer(2);
		
		w1.start();
		w2.start();
		

	}

}
