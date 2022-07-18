package com.example.calificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calificacion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText txt_usuario = findViewById(R.id.txt_usuario);
        EditText txt_contra = findViewById(R.id.txt_contra);
        EditText txt_v_contra = findViewById(R.id.txt_V_contra);
        TextView registro = findViewById(R.id.registro);


        registro.setVisibility(View.INVISIBLE);


        binding.btnRegistrar.setOnClickListener(view -> {
            String usuario = binding.txtUsuario.getText().toString();
            String contra  = binding.txtContra.getText().toString();
            String vcontra = binding.txtVContra.getText().toString();

            if(contra.equals(vcontra)){
                if(contra.length()>4){

                    registro.setVisibility(View.VISIBLE);

                    txt_usuario.setText("");
                    txt_contra.setText("");
                    txt_v_contra.setText("");
                    float val = 1;
                    abrirRegistro(usuario, contra, val);


                }else{
                    Context context = MainActivity.this;
                    CharSequence text = "MINIMO 5 CARACTERS";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }else{
                Context context = MainActivity.this;
                CharSequence text = "LAS CONTRASEÑAS NO COINCIDEN";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });



    }

    private void abrirRegistro(String usu, String contra, float val){
        Intent intent= new Intent(this, Ingreso.class);

        Registro registro = new Registro(usu, contra, val);
        intent.putExtra(Ingreso.REGISTR0_KEY, registro);

        startActivity(intent);
    }




}