package com.gemrartairplane.airplanechaos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.gemrartairplane.airplanechaos.databinding.FragmentPhotoBinding
import com.gemrartairplane.airplanechaos.help.CustomPagerAdapter
import com.google.android.material.snackbar.Snackbar

class PhotoFragment : Fragment() {
    private var _binding: FragmentPhotoBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            binding.btnImgExit.setOnClickListener {
                initAlertDialogForExitPhotoPfagment()
            }

            val listOfImages = generateImgForPager()
            val pagerAdapter = CustomPagerAdapter(listOfImages)
            binding.pager.adapter = pagerAdapter
            binding.circleIndicatorPhotoGalery.setViewPager(binding.pager)


        } catch (e: Exception) {
            snackBarErrorPhotoFragment()
        }

        super.onViewCreated(view, savedInstanceState)
    }


    private fun snackBarErrorPhotoFragment() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private fun initAlertDialogForExitPhotoPfagment() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, are you really want to log out ?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    private fun generateImgForPager(): List<Int> {
        return listOf(
            R.drawable.tank2,
            R.drawable.tank1,
            R.drawable.tank_4,
            R.drawable.tank,
            R.drawable.tank3,
            R.drawable.en24,
            R.drawable.en22,
            R.drawable.en21,
        )
    }
}