package com.example.pc02_renzovargas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pc02_renzovargas.R
import com.example.pc02_renzovargas.model.EquiposModel
import com.squareup.picasso.Picasso

class EquipoAdapter(private var lstEquipo: List<EquiposModel>): RecyclerView.Adapter<EquipoAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tvEquipo: TextView = itemView.findViewById(R.id.tvEquipo)
        val tvAno: TextView = itemView.findViewById(R.id.tvAno)
        val tvTit: TextView = itemView.findViewById(R.id.tvGana)
        val ivLogo: ImageView = itemView.findViewById(R.id.ivEscudo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_equipo, parent, false))
    }

    override fun getItemCount(): Int {
        return lstEquipo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCourse = lstEquipo[position]
        holder.tvEquipo.text = itemCourse.nombreequipo
        holder.tvAno.text = itemCourse.anio
        holder.tvTit.text = itemCourse.titulos
        Picasso.get().load(itemCourse.url).into(holder.ivLogo)
    }
}