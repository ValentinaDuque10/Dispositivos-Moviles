package com.example.votacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /*Se crean los objetos*/
    private EditText editTextParticipantes,editTextEdad;
    private TextView textVCandidato1,textVCandidato2,textVCandidato3,textVGanador;
    private Button butCandidato1,butCandidato2,butCandidato3;
    private int total=0;

    @Override
    /*Se enlaza con la interfaz*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEdad=(EditText)findViewById(R.id.editTextEdad);
        editTextParticipantes=(EditText) findViewById(R.id.editTextParticipantes);
        textVCandidato1=(TextView) findViewById(R.id.textVCandidato1);
        textVCandidato2=(TextView) findViewById(R.id.textVCandidato2);
        textVCandidato3=(TextView) findViewById(R.id.textVCandidato3);
        textVGanador=(TextView) findViewById(R.id.textVGanador);
        butCandidato1=(Button) findViewById(R.id.butCandidato1);
        butCandidato2=(Button) findViewById(R.id.butCandidato2);
        butCandidato3=(Button) findViewById(R.id.butCandidato3);

    }
    /*Variables que van a ir contando los votos de cada candidato*/
    private int cand1=0,cand2=0,cand3=0;

    /*Validacion de que la persona sea mayor de edad*/
    private boolean validarEdad(){
        boolean votoValido=false;
        int edadV=Integer.parseInt(editTextEdad.getText().toString());
        /*Validacion  exitosa*/
        if(edadV>=18){
            votoValido=true;
            return votoValido;
        }
        /*Validacion invalida*/
        else{
            AlertDialog.Builder mensajeInf=new AlertDialog.Builder(this);
            mensajeInf.setMessage("Su voto no fue valido, No tiene la suficiente edad para participar de estas elecciones");
            mensajeInf.setTitle("VOTO INVALIDO");
            mensajeInf.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog dialog=mensajeInf.create();
            dialog.show();
            votoValido=false;
            return votoValido;
        }
    }

    public void candidatos1(View view){
        int max=Integer.parseInt(editTextParticipantes.getText().toString());
        validarEdad();
        if(validarEdad()==true && cand1+cand2+cand3<max){
            cand1 +=1;

        }
        textVCandidato1.setText(String.valueOf(cand1));
    }

    public void candidatos2(View view){
        int max=Integer.parseInt(editTextParticipantes.getText().toString());
        validarEdad();
        if(validarEdad()==true && cand1+cand2+cand3<max){
            cand2 +=1;
            textVCandidato1.setText(String.valueOf(cand2));
        }
        textVCandidato1.setText(String.valueOf(cand2));
    }

    public void candidatos3(View view){
        int max=Integer.parseInt(editTextParticipantes.getText().toString());
        validarEdad();
        if(validarEdad()==true && cand1+cand2+cand3<max){
            cand3 +=1;
        }
        textVCandidato3.setText(String.valueOf(cand3));
    }

    public void contarVotos(View view){
        total=cand1+cand2+cand3;
        if (cand1==cand2 || cand1==cand3 || cand2==cand3){
            textVGanador.setText(("Es empate"));
        }
        if (cand1>cand2 && cand1>cand3){
            textVGanador.setText(("El ganador es: Cand1"));
        }
        if (cand2>cand1 && cand2>cand3){
            textVGanador.setText(("El ganador es: Cand2"));
        }
        if (cand3>cand1 && cand3>cand2){
            textVGanador.setText(("El ganador es: Cand3"));
        }
    }

    public void cerrar(View view){
        AlertDialog.Builder mensajeCerrar=new AlertDialog.Builder(this);
        mensajeCerrar.setMessage("seguro que desea salir del sistema de votacion?");
        mensajeCerrar.setTitle("INFORMATIVO");
        mensajeCerrar.setPositiveButton("si", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {


                dialogInterface.cancel();
            }
        });


    }

}