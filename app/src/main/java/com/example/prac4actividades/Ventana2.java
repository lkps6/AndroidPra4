package com.example.prac4actividades;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ventana2 extends AppCompatActivity {
    TextView mensarecibido;
    Button aceptar;
    Spinner menu;
    int op=0;
    ListView list;  //Variable para la lista de datos
    List<String> listado = new ArrayList<>();  //Arreglo para listas de datos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);
        mensarecibido = findViewById(R.id.lblMensaje);
        aceptar = findViewById(R.id.btnAceptar);
        list = findViewById(R.id.ListaElementos);
        //
        final String[] operaciones = new String[]{"Elige una opcio","Agregar a la lista","Regresar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operaciones);
        menu = findViewById(R.id.ListaDatos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapter);
        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String valores = operaciones[position];
                if (valores == "Agregar a la lista") {
                    op = 1;
                }
                if (valores == "Regresar") {
                    op = 2;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Bundle recibir = getIntent().getExtras();

        if (recibir !=null){
            String cad1 = recibir.getString("mensaje");
            int n = recibir.getInt("numero");
            Toast.makeText(this, "El valor es "+n, Toast.LENGTH_SHORT).show();
            mensarecibido.setText(cad1);
        }

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retorno();
            }
        });
    }
    void retorno(){
        if (op == 1){
            agregarLista();
        }
        if (op==2){
            Intent  i = new Intent(Ventana2.this, MainActivity.class);
            startActivity(i);
        }


    }
    void agregarLista() {

        listado.add(mensarecibido.getText().toString());
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                listado
        );

        list.setAdapter(adapter);
    }

    boolean ValidarNumeros(String a){
        int cv1=0;
        for (int x=0;x<a.length();x++){
            //Toast.makeText(this, a.charAt(x)+" "+a.codePointAt(x), Toast.LENGTH_SHORT).show();
            if (a.codePointAt(x)>=48 && a.codePointAt(x)<=57){
                cv1++;

            }
        }
        if (cv1 == a.length()){
            // Toast.makeText(this, "Todos son numeros", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            /*  Toast.makeText(this, "No todo son numeros", Toast.LENGTH_SHORT).show();*/
            return false;
        }
    }
}