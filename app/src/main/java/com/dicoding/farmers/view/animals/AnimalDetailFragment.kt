package com.dicoding.farmers.view.animals

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.farmers.R
import com.dicoding.farmers.databinding.FragmentAnimalDetailBinding


class AnimalDetailFragment : Fragment() {
    private var _binding: FragmentAnimalDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAnimalDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("animal_position") ?: 0
        val animalNames = resources.getStringArray(R.array.animal_names)
        val animalsDescription = resources.getStringArray(R.array.animal_descriptions)
        val animalsFood = resources.getStringArray(R.array.animal_foods)
        val animalsLifespan = resources.getStringArray(R.array.animal_lifespans)
        val animalsBenefit = resources.getStringArray(R.array.animal_benefits)
        val animalsTips = resources.getStringArray(R.array.animal_care_tips)
        val animalImage = arrayOf(
            R.drawable.animals, R.drawable.animal_goat, R.drawable.animal_chicken
        )

        binding.detailAnimalImage.setImageResource(animalImage[position])
        binding.detailAnimalName.text = Html.fromHtml(animalNames[position], Html.FROM_HTML_MODE_LEGACY)
        binding.detailAnimalDesc.text = animalsDescription[position]
        binding.detailFood.text = animalsFood[position]
        binding.detailLifespan.text = animalsLifespan[position]
        binding.detailBenefit.text = animalsBenefit[position]
        binding.detailCareTips.text = animalsTips[position]
    }
}