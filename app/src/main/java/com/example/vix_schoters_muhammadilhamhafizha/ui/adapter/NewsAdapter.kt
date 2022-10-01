package com.example.vix_schoters_muhammadilhamhafizha.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vix_schoters_muhammadilhamhafizha.databinding.AdapterNewsBinding
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import com.example.vix_schoters_muhammadilhamhafizha.util.DateUtil

class NewsAdapter(
    var articles: ArrayList<ArticleModel>,
    var listener: OnAdapterListener,
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article: ArticleModel){
            binding.article = article
            binding.format = DateUtil()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        AdapterNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            listener.onClick( article )
        }
    }

    interface OnAdapterListener {
        fun onClick(article: ArticleModel)
    }

    fun add(data: List<ArticleModel>) {
        articles.addAll(data)
        notifyItemRangeInserted((articles.size - data.size), data.size)
    }

    fun clear() {
        articles.clear()
        notifyDataSetChanged()
    }
}
