package ar.com.crud;

public class Auto {
    // Atributos
    private String color;

    // Constructor
    public Auto(String color) {
        this.color = color;
    }

    // Métodos
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void cambioDeColor() {
        // Cambia el color del auto de blanco a negro y viceversa
        if ("blanco".equals(this.color)) {
            this.color = "negro";
        } else {
            this.color = "blanco";
        }
    }
}
