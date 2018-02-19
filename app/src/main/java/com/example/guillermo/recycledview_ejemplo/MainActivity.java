package com.example.guillermo.recycledview_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> ListDatos;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=(RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ListDatos=new ArrayList<String>();
        String linea;

        InputStream is=this.getResources().openRawResource(R.raw.data);
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));

        try{
            while((linea=reader.readLine())!=null){
                ListDatos.add(linea.split(";")[0]);
                ListDatos.add(linea.split(";")[1]);
                ListDatos.add(linea.split(";")[2]);

        }
        is.close();
        }catch(IOException e){
        }

        //for(int i=0;i<50;i++){
          //  ListDatos.add("Dato= "+i+" ");
        //}

        AdapterDatos adapter=new AdapterDatos(ListDatos);
        recycler.setAdapter(adapter);
    }
}
