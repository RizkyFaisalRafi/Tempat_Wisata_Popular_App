package com.rifara.submission_dicoding.lokasi

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rifara.submission_dicoding.DetailActivity
import com.rifara.submission_dicoding.R
import com.bumptech.glide.Glide

class LokasiAdapter(private val listLokasiWisata: ArrayList<LokasiTempat>):
    RecyclerView.Adapter<LokasiAdapter.LokasiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LokasiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_view_holder_layout, parent, false)
        return LokasiViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LokasiViewHolder, position: Int) {
        holder.tvName.text = listLokasiWisata[position].name
        holder.tvDetail.text = "${listLokasiWisata[position].detail.substring(0, 30)}..."
        holder.tvsource.text = listLokasiWisata[position].source
        Glide.with(holder.itemView.context)
            .load(listLokasiWisata[position].img)
            .into(holder.imgLokasi)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NAME, listLokasiWisata[position].name)
            intent.putExtra(DetailActivity.EXTRA_SOURCE, listLokasiWisata[position].source)
            intent.putExtra(DetailActivity.EXTRA_DETAIL, listLokasiWisata[position].detail)
            intent.putExtra(DetailActivity.EXTRA_IMG, listLokasiWisata[position].img)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listLokasiWisata.size

    inner class LokasiViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val tvName = itemView.findViewById(R.id.tv_nama) as TextView
        val tvDetail = itemView.findViewById(R.id.tv_detail) as TextView
        val imgLokasi = itemview.findViewById(R.id.img_lokasi) as ImageView
        val tvsource = itemView.findViewById(R.id.tv_source) as TextView
    }
}