package com.dicoding.farmers.view.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dicoding.farmers.R
import com.dicoding.farmers.databinding.FragmentAddBinding
import com.dicoding.farmers.utils.DatePickerFragment
import com.dicoding.farmers.view.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class AddFragment : Fragment(){
    private var _binding:FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var addFarmViewModel: AddFarmViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireContext())
        addFarmViewModel = ViewModelProvider(this, factory)[AddFarmViewModel::class.java]
        binding.icDateButton.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(parentFragmentManager, "datePicker")
        }
        binding.submitBtn.setOnClickListener{
            addFarm()
        }
        parentFragmentManager.setFragmentResultListener(
            "DATE_PICKER_RESULT",
            viewLifecycleOwner
        ) { _, bundle ->
            val selectedDate = bundle.getString("SELECTED_DATE")
            binding.tvDueDate.text = selectedDate
        }
    }



    private fun addFarm(){
        val name = binding.addEdName.text.toString().trim()
        val weight = binding.addEdWeight.text.toString().trim()
        val age = binding.addEdAge.text.toString().trim()
        val description = binding.addEdDescription.text.toString().trim()
        val weightValue = weight.toLongOrNull()
        val ageValue = age.toLongOrNull()

        if (weightValue == null || ageValue == null) {
            Snackbar.make(binding.root, "Weight and Age must be valid numbers", Snackbar.LENGTH_SHORT).show()
            return
        }

        addFarmViewModel.insertFarm(
            name = name,
            weight = weightValue,
            age = ageValue,
            description = description
        )

        Snackbar.make(binding.root,"Farm added successfully", Snackbar.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addFragment_to_homeFragment)
    }

}