package com.example.listviewexample;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder {
    private TextView text_view_titulo;


    public NumberViewHolder(View itemView) {
        super(itemView);
        text_view_titulo = (TextView) itemView.findViewById(R.id.number);
    }


    public void cargarLibroEnHolder(Number l) {

        text_view_titulo.setText(l.getName());
    }
}