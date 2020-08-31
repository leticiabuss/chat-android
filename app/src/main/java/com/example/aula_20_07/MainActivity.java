package com.example.aula_20_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Runnable {

    public ArrayList<Contato> listaContatos = new ArrayList<>(1);

    class MyAdapter extends BaseAdapter {

        // override other abstract methods here

        @Override
        public int getCount() {
            //return Model.getInstance().getListaUsuarios().size();
            return listaContatos.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
//            return Model.getInstance().getListaUsuarios().get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.linhausuario, container, false);
            }

            final Contato contato = listaContatos.get(position);
            ((TextView) convertView.findViewById(R.id.txtHorario)).setText(contato.servidor);
            ((TextView) convertView.findViewById(R.id.txtUserName)).setText(contato.nome);

            if(contato.validaServidor(contato.getServidor()) == true){
                 return convertView;}
            else
                return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);

        Button botaoEnviar = findViewById(R.id.botaoEnviar);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.listausuarios);
            }
        });

        listaContatos.add(new Contato("Valmor", "10:12"));
        listaContatos.add(new Contato("Leticia", "08:12"));
        listaContatos.add(new Contato("Matheus", "09:12"));
        listaContatos.add(new Contato("Davi", "09:12"));

        ListView listaContato = findViewById(R.id.listausuarios);

        listaContato.setAdapter(new MyAdapter());


    }

    @Override
    public void run() {
        setContentView(R.layout.cadastrousuario);
    }



}