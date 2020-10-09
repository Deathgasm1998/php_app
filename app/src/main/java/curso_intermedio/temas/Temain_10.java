package curso_intermedio.temas;

public class Temain_10{

    private  String titulo10i;
    private  String descripcion10i;
    private  String imagen10i;
    public Temain_10(){
    }

    public Temain_10(String titulo10i, String descripcion10i, String imagen10i){
        this.titulo10i = titulo10i;
        this.descripcion10i = descripcion10i;
        this.imagen10i = imagen10i;
    }

    public String getTitulo10i(){ return titulo10i;}

    public void setTitulo10i(String titulo10i){this.titulo10i = titulo10i;}

    public String getDescripcion10i(){ return descripcion10i;}

    public void setDescripcion10i(String descripcion10i){ this.descripcion10i = descripcion10i;}

    public String getImagen10i() { return imagen10i;}

    public void setImagen10i(String imagen10i){this.imagen10i = imagen10i;}

}