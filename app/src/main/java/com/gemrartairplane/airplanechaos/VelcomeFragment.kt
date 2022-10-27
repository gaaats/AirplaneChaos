package com.gemrartairplane.airplanechaos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gemrartairplane.airplanechaos.databinding.FragmentVelcomeBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class VelcomeFragment : Fragment() {

    var counter = 0.05f
    var diff = 0.05f
    private var _binding: FragmentVelcomeBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            cycleUpAndDovnAlpha()

            binding.btnHovPoPlay.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_hovToPlayFragment)
            }
            binding.btnSettings.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_allSettingsFragment)
            }
            binding.imgGame1MonsterChaos.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_gameTankFragment)
            }
            binding.tvGameTitle1MonsterChaos.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_gameTankFragment)
            }
            binding.imgGame2AirplaneChaos.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_gameAirplaneFragment)
            }
            binding.tvGameTitle2AirplaneChaos.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_gameAirplaneFragment)
            }
            binding.imgLidearboardVelcomeFragment.setOnClickListener {
                findNavController().navigate(R.id.action_velcomeFragment_to_raitingFragment)
            }
        } catch (e: Exception) {
            makeError()
        }
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun makeError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun cycleUpAndDovnAlpha() {
        lifecycleScope.launch {
            while (true) {
                binding.tvTitleChooseGame.alpha = counter
                if (counter >= 1f) {
                    diff = -0.05f
                }
                if (counter <= 0.1f) {
                    diff = 0.05f
                }
                delay(60)
                counter += diff
            }
        }
    }

}