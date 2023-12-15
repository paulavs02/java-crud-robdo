package ar.com.crud.interfaces.log;

public class SmsLog implements ILog {

	public void log() {
		System.out.println("Enviando sms a +54911...");
	}
}
