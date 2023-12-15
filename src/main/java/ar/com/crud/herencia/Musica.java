package ar.com.crud.herencia;

import java.util.Arrays;

public class Musica extends Articulo {
	
	private String[] temas;
	
	public Musica(
			String titulo,
			Float precio,
			String img) {
		
		super(titulo, precio, img);
	}
	public void setTemas(String[] temas) {
		this.temas = temas;
	};
	
	public String[] getTemas() {
		return this.temas;
	}

	@Override
	public String toString() {//f5
		return super.toString() +  ", Musica [temas=" + Arrays.toString(temas) + "]";
	}
	
}
