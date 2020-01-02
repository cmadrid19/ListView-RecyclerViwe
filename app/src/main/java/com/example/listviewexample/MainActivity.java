package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        loadListView();

        loadRecyclerView();


    }


    private void loadListView(){
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, // contexto
                android.R.layout.simple_list_item_1, //modelo item
                getResources().getStringArray(R.array.list_items)); //datos

        listView.setAdapter(adapter);
    }

    private void loadRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview);
        //recyclerView.setHasFixedSize(true);//opcional, si sé que el tamaño no va a cambiar

        //1. Create the Custom Row Layout

        //2. Create ViewHolder

        //3. Create Adapter
        String[] datos = getResources().getStringArray(R.array.list_items);


        ArrayList<Number> aListDatos = new ArrayList<>();
        for (int x = 0; x < datos.length ; x++){
            aListDatos.add(new Number(datos[x]));
            Log.d("TAG", datos[x]);
        }

        AdapterNumber adapterNumber = new AdapterNumber(aListDatos);

        recyclerView.setAdapter(adapterNumber);

        //A diferencia de un ListView, un RecyclerView necesita un Layout Manager para manejar el posicionamiento de sus elementos.
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //recView.setLayoutManager(new GridLayoutManager(this,3));
        //StaggeredGridLayoutManager para celdas de tamaño variable
        //recView.setLayoutManager(new StaggeredGridLayoutManager());


        //ITEM DECORATOR --> OPCIONAL

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

}
