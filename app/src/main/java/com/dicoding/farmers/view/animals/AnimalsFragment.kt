package com.dicoding.farmers.view.animals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dicoding.farmers.R
import com.dicoding.farmers.databinding.FragmentAnimalsBinding



class AnimalsFragment : Fragment() {
    private var _binding:FragmentAnimalsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardCattle.setOnClickListener {
            navigateToDetail(0)
        }
        binding.cardGoat.setOnClickListener {
            navigateToDetail(1)
        }
        binding.cardChicken.setOnClickListener {
            navigateToDetail(2)
        }
    }

    private fun navigateToDetail(position: Int) {
        val bundle = Bundle().apply {
            putInt("animal_position", position)
        }
        findNavController().navigate(R.id.action_animalsFragment_to_animalDetailFragment, bundle)
    }
}