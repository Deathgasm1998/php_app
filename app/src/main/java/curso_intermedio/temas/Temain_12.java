package curso_intermedio.temas;

public class Temain_12{

    private  String titulo12i;
    private  String descripcion12i;
    private  String imagen12i;
    public Temain_12(){
    }

    public Temain_12(String titulo12i, String descripcion12i, String imagen12i){
        this.titulo12i = titulo12i;
        this.descripcion12i = descripcion12i;
        this.imagen12i = imagen12i;
    }

    public String getTitulo12i(){ return titulo12i;}

    public void setTitulo12i(String titulo12i){this.titulo12i = titulo12i;}

    public String getDescripcion12i(){ return descripcion12i;}

    public void setDescripcion12i(String descripcion12i){ this.descripcion12i = descripcion12i;}

    public String getImagen12i() { return imagen12i;}

    public void setImagen12i(String imagen12i){this.imagen12i = imagen12i;}

}