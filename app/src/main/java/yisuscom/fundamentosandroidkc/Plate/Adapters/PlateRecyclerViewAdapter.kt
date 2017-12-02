package yisuscom.fundamentosandroidkc.Plate.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.R

/**
 * Created by jesus on 02/12/2017.
 */
class PlateRecyclerViewAdapter (val plates: ArrayList<Plate>): RecyclerView.Adapter<PlateRecyclerViewAdapter.PlateRecyclerViewHolder>() {

    var plateRecyclerViewHolderClick: PlateRecyclerViewHolderClick? = null

    override fun getItemCount(): Int {
        return plates.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlateRecyclerViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_recyclerview_plate, parent, false)
        val viewHolder = PlateRecyclerViewHolder(view)
        viewHolder.plateRecyclerViewHolderClick = plateRecyclerViewHolderClick

        return viewHolder
    }

    override fun onBindViewHolder(holder: PlateRecyclerViewHolder?, position: Int) {
        holder?.bindPlate(plates[position])
    }

    inner class PlateRecyclerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val plateName = itemView.findViewById<TextView>(R.id.plateNameText)
        val plateAllergens = itemView.findViewById<TextView>(R.id.allergensText)
        val platePrice = itemView.findViewById<TextView>(R.id.priceText)
        var plateRecyclerViewHolderClick: PlateRecyclerViewHolderClick? = null

        fun bindPlate (plate: Plate) {
            plateName.text = plate.name
            plateAllergens.text = plate.allergens.joinToString("\n")
            platePrice.text = plate.price.toString()
            itemView.setOnClickListener {
                plateRecyclerViewHolderClick?.clicked(plate)
            }
        }

    }

    interface PlateRecyclerViewHolderClick  {
        fun clicked(plate: Plate)
    }
}