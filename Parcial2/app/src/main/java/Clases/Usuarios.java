package Clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuarios implements Parcelable {
    private String imagen;
    private String nombre;
    private String vivos;
    private String especie;

    public Usuarios(String imagen, String nombre, String especie, String vivos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.especie = especie;
        this.vivos = vivos;
    }

    protected Usuarios(Parcel in) {
        imagen = in.readString();
        nombre = in.readString();
        vivos = in.readString();
        especie = in.readString();
    }

    public static final Creator<Usuarios> CREATOR = new Creator<Usuarios>() {
        @Override
        public Usuarios createFromParcel(Parcel in) {
            return new Usuarios(in);
        }

        @Override
        public Usuarios[] newArray(int size) {
            return new Usuarios[size];
        }
    };

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVivos() {
        return vivos;
    }

    public String getEspecie() {
        return especie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagen);
        dest.writeString(nombre);
        dest.writeString(vivos);
        dest.writeString(especie);
    }
}
