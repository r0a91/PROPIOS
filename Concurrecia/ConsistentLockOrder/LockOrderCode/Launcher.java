
public class Launcher {

	public static void main(String[] args) {
		Directory d1 = new Directory("Imagenes");
		Directory d2 = new Directory("Musica");
		Directory d3 = new Directory("Papelera");
		
		Client c1 = new Client(1, d1, d2);
		Client c2 = new Client(2, d2, d1);
		
		c1.start();
		c2.start();
		
	}

}
