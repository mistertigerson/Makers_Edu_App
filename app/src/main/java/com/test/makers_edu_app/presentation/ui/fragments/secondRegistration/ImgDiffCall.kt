package com.example.makersproject.presentation.ui.fragments.secondRegistration

import androidx.recyclerview.widget.DiffUtil
import com.test.makers_edu_app.presentation.ui.fragments.secondRegistration.model.ModelImg

class ImgDiffCall: DiffUtil.ItemCallback<ModelImg>(){
    override fun areItemsTheSame(oldItem: ModelImg, newItem: ModelImg): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ModelImg, newItem: ModelImg): Boolean {
        return oldItem == newItem
    }

}