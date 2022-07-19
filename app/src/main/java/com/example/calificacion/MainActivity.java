package com.example.calificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calificacion.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText txt_usuario = findViewById(R.id.txt_usuario);
        EditText txt_contra = findViewById(R.id.txt_contra);
        EditText txt_v_contra = findViewById(R.id.txt_V_contra);
        EditText txt_mail = findViewById(R.id.txt_mail);
        EditText txt_rol = findViewById(R.id.txt_rol);
        TextView registro = findViewById(R.id.registro);


        registro.setVisibility(View.INVISIBLE);


        binding.btnRegistrar.setOnClickListener(view -> {
            String usuario = binding.txtUsuario.getText().toString();
            String contra  = binding.txtContra.getText().toString();
            String vcontra = binding.txtVContra.getText().toString();
            String mail = binding.txtMail.getText().toString();
            String rol = binding.txtRol.getText().toString();
            String vmail = binding.rTxtMail.getText().toString();

            if(contra.equals(vcontra)){
                if(contra.length()>4){

                    if (!validarEmail(mail)||!validarEmail(vmail)){
                        Context context = MainActivity.this;
                        CharSequence text = "CORREO NO VALIDO";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }else if(mail.equals(vmail)){
                        if(rol.equals("Administrador")||rol.equals("Invitado")){
                            registro.setVisibility(View.VISIBLE);

                            txt_usuario.setText("");
                            txt_contra.setText("");
                            txt_v_contra.setText("");
                            txt_mail.setText("");
                            txt_rol.setText("");
                            float val = 1;
                            abrirRegistro(usuario, contra, val, mail, rol);
                        }else{
                            Context context = MainActivity.this;
                            CharSequence text = "Solo validos los roles 'Administrador e 'Invitado'";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }else{
                        Context context = MainActivity.this;
                        CharSequence text = "LOS CORREOS NO COINCIDEN";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }


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

    private void abrirRegistro(String usu, String contra, float val, String mail, String rol){
        Intent intent= new Intent(this, Ingreso.class);

        Registro registro = new Registro(usu, contra, val, mail, rol);
        intent.putExtra(Ingreso.REGISTR0_KEY, registro);

        startActivity(intent);
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }



}