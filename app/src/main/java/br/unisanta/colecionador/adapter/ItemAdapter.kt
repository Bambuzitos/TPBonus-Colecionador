package br.unisanta.colecionador.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.colecionador.R
import br.unisanta.colecionador.model.Item
import com.bumptech.glide.Glide

class ItemAdapter(
    private val lista: MutableList<Item>,
    private val onExcluir: (Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgItem: ImageView = view.findViewById(R.id.imgItem)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtValor: TextView = view.findViewById(R.id.txtValor)
        val btnEditar: Button = view.findViewById(R.id.btnEditar)
        val btnExcluir: Button = view.findViewById(R.id.btnExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = lista[position]

        Glide.with(holder.itemView.context).load(item.imagem).into(holder.imgItem)

        holder.txtNome.text = item.nome
        holder.txtValor.text = "R$ ${item.valor}"

        holder.btnEditar.setOnClickListener {}

        holder.btnExcluir.setOnClickListener {
            onExcluir(position)
            lista.removeAt(position)
            notifyItemRemoved(position)
        }

    }

    override fun getItemCount() = lista.size
}
