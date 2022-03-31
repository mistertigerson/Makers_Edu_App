package com.example.makersproject.presentation.ui.fragments.secondRegistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.makers_edu_app.data.extensions.loadImage
import com.test.makers_edu_app.R
import com.test.makers_edu_app.presentation.ui.fragments.secondRegistration.model.ModelImg

class SecondAdapter : ListAdapter<ModelImg, SecondAdapter.SecondViewHolder>(ImgDiffCall()) {

    var imgOnLongListener: ((ModelImg) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.certificate_image_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val imgItem = getItem(position)
        holder.ivImg.loadImage(imgItem.photo)
        holder.itemView.setOnLongClickListener {
            imgOnLongListener?.invoke(imgItem)
            true
        }
    }

    class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImg: ImageView = itemView.findViewById(R.id.imgCertificate)
    }
}