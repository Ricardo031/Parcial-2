package Clases;

public class Usuarios {
    private String imagen;
    private String nombre;
    private String vivos;
    private String especie;


    public Usuarios(String imagen, String nombre, String especie, String vivos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.vivos = vivos;
        this.especie = especie;

    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getVivos() {
        return vivos;
    }

    public void setVivos(String vivos) {
        this.vivos = vivos;
    }
}

