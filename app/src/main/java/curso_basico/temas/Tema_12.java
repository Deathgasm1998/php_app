package curso_basico.temas;

public class Tema_12 {
    private  String titulo12;
    private  String descripcion12;
    private  String imagen12;

    public Tema_12() {
    }

    public Tema_12(String titulo12, String descripcion12, String imagen12) {
        this.titulo12 = titulo12;
        this.descripcion12 = descripcion12;
        this.imagen12 = imagen12;
    }

    public String getTitulo12() {
        return titulo12;
    }

    public void setTitulo12(String titulo12) {
        this.titulo12 = titulo12;
    }

    public String getDescripcion12() {
        return descripcion12;
    }

    public void setDescripcion12(String descripcion12) {
        this.descripcion12 = descripcion12;
    }

    public String getImagen12() {
        return imagen12;
    }

    public void setImagen12(String imagen12) {
        this.imagen12 = imagen12;
    }
}