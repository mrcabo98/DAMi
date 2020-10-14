public class Camisa {
    private String model, talla, color;

    public Camisa(String model, String talla, String color) {
        this.model = model;
        this.talla = talla;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Camisa{" +
                "model='" + model + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
