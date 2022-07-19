package com.example.calificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.calificacion.databinding.ActivityIngresoBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ingreso extends AppCompatActivity {
    public static final String REGISTR0_KEY = "Registro";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIngresoBinding binding =ActivityIngresoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        Registro registro = extras.getParcelable(REGISTR0_KEY);
        binding.setRegistro(registro);

        String contra = registro.getClave();
        float valor = registro.getValor();

        int st = 0;
        String seguridad = "";

        Pattern p = Pattern.compile("\\W");
        Matcher m = p.matcher(contra);
        while (m.find()) st++;

        if(contra.length()>=12&&st>=4){
            valor = 5;
            seguridad = "La clave de seguridad se considera Alta";
        }else if(contra.length()>=10&&st>=2){
            valor = 4;
            seguridad = "La clave de seguridad se considera Media-Alta";
        }else if(contra.length()>=8&&st>=1){
            valor = 3;
            seguridad = "La clave de seguridad se considera Media";
        }else if(contra.length()>=8){
            valor = 2;
            seguridad = "La clave de seguridad se considera Baja";
        }else{
            valor = 1;
            seguridad = "La clave de seguridad se considera Insegura";
        }

        binding.txtUsuario.setText(registro.getUsuario());
        binding.valoracion.setRating(valor);
        binding.txtSeguridad.setText(seguridad);
        binding.txtEmail.setText(registro.getMail());
        binding.txtRol.setText(registro.getRol());




    }
}