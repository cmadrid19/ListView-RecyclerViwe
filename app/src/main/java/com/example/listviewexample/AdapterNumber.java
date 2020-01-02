package com.example.listviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNumber extends RecyclerView.Adapter<NumberViewHolder> {


    private ArrayList<Number> datos;

    //Creo la vista, con el Holder dentro
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NumberViewHolder numberViewHolder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.custom_row_layout, parent, false);

         numberViewHolder = new NumberViewHolder(itemView);

        return numberViewHolder;
    }

    //Al holder, le meto la info de libro que toca
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {

        Number number = datos.get(position);
        holder.cargarLibroEnHolder(number);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public AdapterNumber(ArrayList<Number> numbers) {
        this.datos = numbers;
    }
}

