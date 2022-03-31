package com.test.makers_edu_app.presentation.ui.fragments.account

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.test.makers_edu_app.R
import com.test.makers_edu_app.data.extensions.showToast2
import com.test.makers_edu_app.databinding.FragmentEditAccountBinding

class EditAccountFragment : Fragment(R.layout.fragment_edit_account) {

    private val binding: FragmentEditAccountBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveData.setOnClickListener {
            dataAndError()
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.tvChangePhoto.setOnClickListener {

        }
    }

    // Проверка edittext-ов на заполненость и отправка данных в Firestore
    private fun dataAndError() {

        val name = binding.etAddName
        val speciality = binding.etAddSpeciality
        val city = binding.etAddCity
        val contact = binding.etAddContact
        val education = binding.etAddEducation
        val experience = binding.etAddExperience

        if (name.text.isEmpty() && speciality.text.isEmpty()
            && city.text.isEmpty() && contact.text.isEmpty() && education.text.isEmpty()
            && experience.text.isEmpty()
        ) {
            binding.etAddName.error = getString(R.string.et_error_rus)
            binding.etAddSpeciality.error = getString(R.string.et_error_rus)
            binding.etAddCity.error = getString(R.string.et_error_rus)
            binding.etAddContact.error = getString(R.string.et_error_rus)
            binding.etAddEducation.error = getString(R.string.et_error_rus)
            binding.etAddExperience.error = getString(R.string.et_error_rus)
        } else {

            if (name.text.isNotEmpty() && speciality.text.isNotEmpty()
                && city.text.isNotEmpty() && contact.text.isNotEmpty()
                && education.text.isNotEmpty()
                && experience.text.isNotEmpty()
            ) {
                addDataToFirestore()
            }
        }
    }

    // Отправка данных в Firestore
    private fun addDataToFirestore(): Editable? {

        val db = Firebase.firestore

        val user = hashMapOf(
            "Name" to binding.etAddName.text.toString(),
            "Speciality" to binding.etAddSpeciality.text.toString(),
            "City" to binding.etAddCity.text.toString(),
            "Contact" to binding.etAddContact.text.toString(),
            "Education" to binding.etAddEducation.text.toString(),
            "Experience" to binding.etAddExperience.text.toString()
        )

        db.collection("Users")
            .add(user)
            .addOnSuccessListener {
                showToast2(context, getString(R.string.success_data))
            }.addOnFailureListener {
                showToast2(context, getString(R.string.error_data))
            }
        return null
    }
}
