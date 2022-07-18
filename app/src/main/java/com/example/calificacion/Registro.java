package com.example.calificacion;

import android.os.Parcel;
import android.os.Parcelable;

public class Registro  implements Parcelable {
private String usuario;
private String clave;
private float valor;

    public Registro(String usuario, String clave, float valor) {
        this.usuario = usuario;
        this.clave = clave;
        this.valor = valor;
    }

    protected Registro(Parcel in){
        usuario = in.readString();
        clave = in.readString();
        valor = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(usuario);
        dest.writeString(clave);
        dest.writeFloat(valor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Registro> CREATOR = new Creator<Registro>() {
        @Override
        public Registro createFromParcel(Parcel in) {
            return new Registro(in);
        }

        @Override
        public Registro[] newArray(int size) {
            return new Registro[size];
        }
    };


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
