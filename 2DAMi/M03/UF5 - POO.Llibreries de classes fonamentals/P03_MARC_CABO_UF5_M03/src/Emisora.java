public class Emisora {
    private String nomEmisora, especialitat;
    private double frecuencia;

    public Emisora(String nomEmisora, String especialitat, double frecuencia) {
        this.nomEmisora = nomEmisora;
        this.especialitat = especialitat;
        this.frecuencia = frecuencia;
    }

    public String getNomEmisora() {
        return nomEmisora;
    }

    public void setNomEmisora(String nomEmisora) {
        this.nomEmisora = nomEmisora;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Emisora{" +
                "nomEmisora='" + nomEmisora + '\'' +
                ", especialitat='" + especialitat + '\'' +
                ", frecuencia=" + frecuencia +
                '}';
    }
}
