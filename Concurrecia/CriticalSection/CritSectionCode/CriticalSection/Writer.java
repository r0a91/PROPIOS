
public class Writer extends Thread {
	private int id;
	public Writer(int i) {
		this.id=i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Logger foo = FileLogger.getFileLogger();
		String msg = "Escritor id: " + id + "\n";
		foo.log(msg);
	}

}
