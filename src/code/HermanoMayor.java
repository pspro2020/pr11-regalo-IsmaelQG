package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class HermanoMayor implements Runnable{
	
	private final int dineroRequerido;
	private final CountDownLatch countDownLatch;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public HermanoMayor(int dineroRequerido) {
		this.dineroRequerido = dineroRequerido;
		countDownLatch = new CountDownLatch(dineroRequerido);
	}

	@Override
	public void run() {
		System.out.printf("%s -> Esperando los %d€...\n", LocalTime.now().format(dateTimeFormatter), dineroRequerido);
		try {
			countDownLatch.await();
			System.out.printf("%s -> Yendo a comprar el regalo...\n", LocalTime.now().format(dateTimeFormatter));
		}
		catch(InterruptedException e) {
			System.out.println("Compra interrumpida, esperando a obtener el dinero necesario");
		}
	}
	
	public void recaudar(int dinero, String alumno){
		System.out.printf("%s -> %d€ obtenido de %s\n", LocalTime.now().format(dateTimeFormatter), dinero, alumno);
		for (int i = 0; i < dinero; i++) {
            countDownLatch.countDown();
        }
	}

}
