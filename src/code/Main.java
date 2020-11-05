package code;

public class Main {

	public static void main(String[] args) {
		HermanoMayor hermanoMayor = new HermanoMayor(10);
		new Thread(hermanoMayor).start();
		for(int i = 0; i<5; i++) {
			new Thread(new Alumno(hermanoMayor, "Alumno " + i)).start();
		}
	}

}
