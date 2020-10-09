package curso_intermedio.temas;

public class Temain_20{

    private  String titulo20i;
    private  String descripcion20i;
    private  String imagen20i;
    public Temain_20(){
    }

    public Temain_20(String titulo20i, String descripcion20i, String imagen20i){
        this.titulo20i = titulo20i;
        this.descripcion20i = descripcion20i;
        this.imagen20i = imagen20i;
    }

    public String getTitulo20i(){ return titulo20i;}

    public void setTitulo20i(String titulo20i){this.titulo20i = titulo20i;}

    public String getDescripcion20i(){ return descripcion20i;}

    public void setDescripcion20i(String descripcion20i){ this.descripcion20i = descripcion20i;}

    public String getImagen20i() { return imagen20i;}

    public void setImagen20i(String imagen20i){this.imagen20i = imagen20i;}

}