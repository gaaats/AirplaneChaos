package com.gemrartairplane.airplanechaos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gemrartairplane.airplanechaos.databinding.FragmentGameAirplaneBinding
import com.gemrartairplane.airplanechaos.game.GameTask
import com.gemrartairplane.airplanechaos.game.GameViev
import com.google.android.material.snackbar.Snackbar


class GameAirplaneFragment : Fragment(), GameTask {
    private var _binding: FragmentGameAirplaneBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    val listLogoEnemy = listOf(
        R.drawable.en21,
        R.drawable.en22,
        R.drawable.en23,
        R.drawable.en24,
    )

    private var mGameViev: GameViev? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameAirplaneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            binding.btnStart.setOnClickListener {
                mGameViev =
                    GameViev(requireContext(), this, R.drawable.jet___, listLogoEnemy)
                mGameViev!!.setBackgroundResource(R.drawable.road_plane)
                mGameViev!!.background.alpha = 100
                binding.root.addView(mGameViev)
                binding.btnStart.visibility = View.GONE
                binding.tvScoreGame1.visibility = View.GONE
                binding.imgLogoGame1.visibility = View.GONE
            }
        } catch (e: Exception) {
            snackBarError()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun closeGame(score: Int) {
        val scoreText = "Score : $score"
        binding.root.removeView(mGameViev)
        binding.tvScoreGame1.text = scoreText
        binding.btnStart.visibility = View.VISIBLE
        binding.tvScoreGame1.visibility = View.VISIBLE
        binding.imgLogoGame1.visibility = View.VISIBLE
        mGameViev = null

        findNavController().navigate(R.id.action_gameAirplaneFragment_to_faaaaailedFragment)
    }

    private fun snackBarError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

}

