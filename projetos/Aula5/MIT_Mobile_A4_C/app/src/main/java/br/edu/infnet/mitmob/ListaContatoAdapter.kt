package br.edu.infnet.mitmob

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaContatoAdapter () : RecyclerView.Adapter<ListaContatoAdapter.ViewHolder>() {

    var listaContatos = listOf<Contato>()
    set(value) {

        field = value
        notifyDataSetChanged()
    }

    lateinit var itemListener : RecycleViewItemListener

    fun setRecycleViewItemListener(listener : RecycleViewItemListener) {

        itemListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaContatoAdapter.ViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.contato_listrow, parent, false)
        return ListaContatoAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(listaContatos[position], itemListener, position)
    }

    override fun getItemCount(): Int {

        return listaContatos.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(contato : Contato, itemListener : RecycleViewItemListener, position : Int) {

            val rowNome = itemView.findViewById<TextView>(R.id.rowNome)
            rowNome.setText(contato.nome)
            val rowEmail = itemView.findViewById<TextView>(R.id.rowEmail)
            rowEmail.setText(contato.email)
            val rowFone = itemView.findViewById<TextView>(R.id.rowFone)
            rowFone.setText(contato.fone)

            itemView.setOnClickListener {

                itemListener.recyclerViewItemClicked(it, contato.id)
            }
        }
    }
}