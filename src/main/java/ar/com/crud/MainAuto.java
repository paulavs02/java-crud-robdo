package ar.com.crud;

public class MainAuto {

	public static void main(String[] args) {
		// Crear un objeto Auto con color inicial "blanco"
        Auto miAuto = new Auto("blanco");

        // Imprimir el color inicial
        System.out.println("Color inicial: " + miAuto.getColor());

        // Cambiar el color
        miAuto.cambioDeColor();

        // Imprimir el color después del cambio
        System.out.println("Color después del cambio: " + miAuto.getColor());

        // Cambiar el color usando el setter
        miAuto.setColor("rojo");

        // Imprimir el color después del cambio usando el setter
        System.out.println("Color después de cambiar usando el setter: " + miAuto.getColor());
	}

}
