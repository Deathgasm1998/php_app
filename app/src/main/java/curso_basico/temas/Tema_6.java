package curso_basico.temas;

public class Tema_6 {

    private  String titulo6;
    private  String descripcion6;
    private  String imagen6;
    public Tema_6() {
    }

    public Tema_6(String titulo6, String descripcion6, String imagen6) {
        this.titulo6 = titulo6;
        this.descripcion6 = descripcion6;
        this.imagen6 = imagen6;
    }

    public String getImagen6() {
        return imagen6;
    }

    public void setImagen6(String imagen6) {
        this.imagen6 = imagen6;
    }

    public String getTitulo6() {
        return titulo6;
    }

    public void setTitulo6(String titulo6) {
        this.titulo6 = titulo6;
    }

    public String getDescripcion6() {
        return descripcion6;
    }

    public void setDescripcion6(String descripcion6) { this.descripcion6 = descripcion6; }
}
