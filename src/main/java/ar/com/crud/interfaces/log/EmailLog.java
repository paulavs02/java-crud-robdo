package ar.com.crud.interfaces.log;

public class EmailLog implements ILog {

	public void log() {
		System.out.println("Enviando por mail este mensaje");
	}

}
