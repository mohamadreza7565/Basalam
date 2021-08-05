package com.example.basalam.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basalam.R
import com.example.basalam.model.Product
import com.example.basalam.utils.SetLocale
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_rv_items.view.*

class ProductsRvAdapter(val context: Context) :
    RecyclerView.Adapter<ProductsRvAdapter.ViewHolder>() {

    val list: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.product_rv_items, parent, false)
    )


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var product = list[position]
        Picasso.get().load(product.photo.url).into(holder.imv_product)

        holder.tv_des.text = product.vendor.name // Set text shopName
        holder.tv_price.text = SetLocale().set(product.price.toString(),",") +  " تومان" // Set text productPrice with locale
        holder.tv_productName.text = product.name // Set text productName
        holder.tv_wight.text = product.weight.toString() + " گرم" // Set text productWeight
        holder.tv_star.text ="(" + product.rating.count.toString() + ")" + product.rating.rating.toString()// Set text productRate


    }

    override fun getItemCount() = list.size


    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imv_product: ImageView = view.imv_product
        var tv_star: TextView = view.tv_star
        var tv_productName: TextView = view.tv_product_name
        var tv_des: TextView = view.tv_des
        var tv_price: TextView = view.tv_price
        var tv_wight: TextView = view.tv_wight

    }

    fun replace(list: List<Product>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addAll(list: List<Product>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(movie: Product) {
        list.add(movie)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

}