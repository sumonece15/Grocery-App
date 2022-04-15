package com.sumon.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter (var list: List<GroceryItems>, val groceryItemClickInterface: GroceryItemClickInterface) :
    RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>(){

    inner class GroceryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nameTV = itemView.findViewById<TextView>(R.id.tvItemName)
        val quantityTV = itemView.findViewById<TextView>(R.id.tvQuantity)
        val rateTV = itemView.findViewById<TextView>(R.id.tvRate)
        val costTV = itemView.findViewById<TextView>(R.id.tvTotalCost)
        val amountTV = itemView.findViewById<TextView>(R.id.tvTotalAmount)
        val deleteIV = itemView.findViewById<ImageView>(R.id.ivDelete)
    }


    interface GroceryItemClickInterface{

        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item, parent, false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        holder.nameTV.text = list.get(position).itemName
        holder.quantityTV.text = list.get(position).itemQuantity.toString()
        holder.rateTV.text = "Tk."+list.get(position).itemPrice.toString()
        val itemTotal : Int = list.get(position).itemPrice * list.get(position).itemQuantity
        holder.amountTV.text = "Tk."+itemTotal.toString()
        holder.deleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list.get(position))
        }
    }

    override fun getItemCount(): Int {

    return list.size
    }
}