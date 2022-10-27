package com.gemrartairplane.airplanechaos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gemrartairplane.airplanechaos.databinding.FragmentGameTankBinding
import com.gemrartairplane.airplanechaos.game.GameTask
import com.gemrartairplane.airplanechaos.game.GameViev
import com.google.android.material.snackbar.Snackbar

class GameTankFragment : Fragment(), GameTask {
    private var _binding: FragmentGameTankBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    val listLogoEnemyTanks = listOf(
        R.drawable.tank,
        R.drawable.tank_4,
        R.drawable.tank1,
        R.drawable.tank2,
        R.drawable.tank3,
    )

    private var mGameViev: GameViev? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameTankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            binding.btnStart.setOnClickListener {
                mGameViev =
                    GameViev(requireContext(), this, R.drawable.ttttt, listLogoEnemyTanks)
                mGameViev!!.setBackgroundResource(R.drawable.road_tanks)
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

        findNavController().navigate(R.id.action_gameTankFragment_to_faaaaailedFragment)
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

