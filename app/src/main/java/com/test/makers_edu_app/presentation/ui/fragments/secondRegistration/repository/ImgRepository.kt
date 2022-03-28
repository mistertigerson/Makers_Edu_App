package com.example.makersproject.presentation.ui.fragments.secondRegistration.repository

import androidx.lifecycle.LiveData
import com.test.makers_edu_app.presentation.ui.fragments.secondRegistration.model.ModelImg

interface ImgRepository {
    fun addImg(img: ModelImg)
    fun getImg(): LiveData<List<ModelImg>>
    fun deleteImg(img: ModelImg)
}