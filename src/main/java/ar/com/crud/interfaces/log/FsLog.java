package ar.com.crud.interfaces.log;

public class FsLog implements ILog {

	public void log() {
		System.out.println("Loguendo en FileSystem c://invento");
	}

}
