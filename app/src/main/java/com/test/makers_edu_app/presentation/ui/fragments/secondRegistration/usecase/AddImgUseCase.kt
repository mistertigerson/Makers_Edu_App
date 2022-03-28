package com.example.makersproject.presentation.ui.fragments.secondRegistration.usecase

import com.test.makers_edu_app.presentation.ui.fragments.secondRegistration.model.ModelImg
import com.example.makersproject.presentation.ui.fragments.secondRegistration.repository.ImgRepository

class AddImgUseCase(private val repository: ImgRepository) {
    fun addImg(img: ModelImg) {
        repository.addImg(img)
    }
}