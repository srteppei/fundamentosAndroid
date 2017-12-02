package yisuscom.fundamentosandroidkc.Table.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import yisuscom.fundamentosandroidkc.Commons.Domains.Table
import yisuscom.fundamentosandroidkc.R

/**
 * Created by jesus on 30/11/2017.
 */
class TableRecyclerViewAdapter(val tables: ArrayList<Table>) : RecyclerView.Adapter<TableRecyclerViewAdapter.TableViewHolder>() {

    var tableViewHolderClick: TableViewHolderClick? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TableViewHolder {

        // Creamos la vista plantilla que más tarde se rellenará con el número en cuestión que se quiera mostrar
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_table, parent, false)
        // Le decimos a la vista de este ViewHolder a quién llamar cuando se le pulse
        val viewHolder = TableViewHolder(view)
        viewHolder.tableViewHolderClick = tableViewHolderClick

        return viewHolder
    }

    override fun getItemCount(): Int {
        return tables.count()
    }

    override fun onBindViewHolder(holder: TableViewHolder?, position: Int) {
        holder?.bindTable(tables[position])
    }

    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tableNumber = itemView.findViewById<TextView>(R.id.tableNumber);
        val tableDescription = itemView.findViewById<TextView>(R.id.tableDescription)
        var tableViewHolderClick: TableViewHolderClick? = null

        fun bindTable (table: Table) {
            tableNumber.setText(table.id.toString())
            tableDescription.setText(table.description)
            itemView.setOnClickListener { tableViewHolderClick?.clicked(table) }
        }
    }

    interface TableViewHolderClick {
        fun clicked (table: Table)
    }

}