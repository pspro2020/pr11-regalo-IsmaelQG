package code;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Alumno implements Runnable{
	
	private final HermanoMayor hermanoMayor;
	private final String nombre;
	
	public Alumno(HermanoMayor hermanoMayor, String nombre) {
		this.hermanoMayor = hermanoMayor;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		try {
			obtenerDinero();
		} catch (InterruptedException e) {
			System.out.println("Interrumpido mientras obtenia dinero");
		}
		hermanoMayor.recaudar(ThreadLocalRandom.current().nextInt(2,6), nombre);
		
	}
	
	private void obtenerDinero() throws InterruptedException {
		TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(3,11));
	}

}
