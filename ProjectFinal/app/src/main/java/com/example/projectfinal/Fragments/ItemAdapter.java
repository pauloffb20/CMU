package com.example.projectfinal.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectfinal.Models.Treino;
import com.example.projectfinal.R;

import java.util.ArrayList;
import java.util.List;

public  class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Treino> treinosList;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public ItemAdapter(Context context){
        this.treinosList = new ArrayList<>();
        mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return  new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
       holder.treino = treinosList.get(position);
       holder.textView.setText(treinosList.get(position).getType());
       holder.textDistancia.setText(treinosList.get(position).getDistance());
       holder.tempo.setText(treinosList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
    return  treinosList.size();
    }

    public void setTreinoList(List<Treino> treinoList) {
        this.treinosList = treinoList;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView textView, textDistancia, tempo;

        private Treino treino;
        public ItemViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
            textView = view.findViewById(R.id.conteudo);
            textDistancia = view.findViewById(R.id.textDistance);
            tempo = view.findViewById(R.id.textTempo);
        }
    }
}