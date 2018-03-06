package com.example.admin.tripmex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by IMT on 26/10/2017.
 */

public class AdaptadorMain extends RecyclerView.Adapter<AdaptadorMain.EstadosViewHolder> {
    private List<Estados> estados;
    Context con;

    public AdaptadorMain(List<Estados> estados, Context con){
        this.estados = estados;
        this.con = con;
    }

    @Override
    public AdaptadorMain.EstadosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EstadosViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estado, parent, false));
    }

    @Override
    public void onBindViewHolder(AdaptadorMain.EstadosViewHolder holder, int position) {
        Estados estado = estados.get(position);
        holder.nombreEstado.setText(estado.getNombre());
        Picasso.with(con).load(estado.getImagenEstado()).resize(250,250).into(holder.escudoEstado);


    }

    @Override
    public int getItemCount() {
        return estados.size();
    }

    public class EstadosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nombreEstado;
        ImageView escudoEstado;

        public EstadosViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nombreEstado = (TextView) itemView.findViewById(R.id.nombreEstado);
            escudoEstado = (ImageView) itemView.findViewById(R.id.imgEstado);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(con,lugares.class);
            Estados ig = estados.get(getPosition());
            Toast.makeText(con,ig.getNombre(),Toast.LENGTH_SHORT).show();
            i.putExtra("nombreEstado",ig.getNombre());
            con.startActivity(i);

        }
    }
}
