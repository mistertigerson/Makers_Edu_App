package com.test.makers_edu_app.presentation.ui.fragments.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makersproject.presentation.ui.fragments.main.MainModel
import com.test.makers_edu_app.databinding.MainItemBinding
import kotlin.properties.Delegates

class MainAdapter(private val clickOnPlaylist2: ClickOnPlaylist2) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val list: ArrayList<MainModel> = arrayListOf()
    private lateinit var binding: MainItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<MainModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class MainViewHolder(itemView: MainItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        fun onBind(mainModel: MainModel) {

            binding.ivIcon.setImageResource(mainModel.imageIcon)
            binding.tvComments.text = mainModel.comments
            binding.tvNameOfAuthor.text = mainModel.NameOfAuthor
            binding.tvTitle.text = mainModel.title

            binding.root.setOnClickListener {
                clickOnPlaylist2.onClick(mainModel, absoluteAdapterPosition)
            }
            binding.btnBuy.setOnClickListener {
                clickOnPlaylist2.clickBtn()
            }
        }

    }

    interface ClickOnPlaylist2 {
        fun onClick(model: MainModel, position: Int)
        fun clickBtn()
    }
}