package com.example.admin.tripmex;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.IglesiasViewHolder>{

    private List<Iglesias> iglesias;
    Context con;

    public Adaptador(List<Iglesias> iglesias, Context contexto){
        con = contexto;
        this.iglesias = iglesias;
    }

    @Override
    public IglesiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IglesiasViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(IglesiasViewHolder holder, int position) {
        Iglesias iglesia = iglesias.get(position);
        holder.nombre.setText(iglesia.getNombre());
        holder.telefono.setText("Telefono: "+ iglesia.getTelefono());
        holder.puntuacion.setText("Puntuacion:" +iglesia.getPuntuacion());
        Picasso.with(con).load(iglesia.getUrlImagen()).resize(300, 300).into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return iglesias.size();
    }


    public class IglesiasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nombre;
        TextView telefono;
        TextView puntuacion;
        ImageView imagen;

        public IglesiasViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nombre = (TextView) itemView.findViewById(R.id.Nombre);
            telefono = (TextView) itemView.findViewById(R.id.Telefono);
            puntuacion = (TextView) itemView.findViewById(R.id.Puntuacion);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(con,TemplateLugar.class);
            Iglesias ig = iglesias.get(getPosition());
            i.putExtra("nombre",ig.getNombre());
            i.putExtra("descripcion",ig.getDescripcion());
            i.putExtra("url",ig.getUrlImagen());
            i.putExtra("longitud",String.valueOf(ig.getLongitudY()));
            i.putExtra("latitud",String.valueOf(ig.getLatitudX()));
            i.putExtra("ubicacion",ig.getUbicacion());
            i.putExtra("puntuacion",String.valueOf(ig.getPuntuacion()));
            i.putExtra("paginaWeb",ig.getPaginaWeb());
            i.putExtra("telefono",String.valueOf(ig.getTelefono()));
            con.startActivity(i);
        }
    }
}
