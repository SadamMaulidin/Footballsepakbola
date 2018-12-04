package com.tapperware.footballsepakbola

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

//TODO class RecyclerAdapter mewariskan Recycle View
class RecyclerAdapter(val context: Context, val items: List<Item>, val listener: (Item) -> Unit): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //TODO meng implementasikan method dari RecycleView
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_club, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items[position], listener)
    }

    //TODO memuat class viewHolder (untuk berinteraksi dengan tampilan)
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val namaClub = view.txtNamaClub
        val gambarLogoClub = view.imgLogoClub

        fun bindItem (item: Item, listener: (Item) -> Unit){
            namaClub.text = item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambarLogoClub)
            itemView.onClick {
                listener(item)
            }
        }
    }

}
