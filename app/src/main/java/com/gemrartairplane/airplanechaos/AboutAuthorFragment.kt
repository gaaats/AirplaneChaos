package com.gemrartairplane.airplanechaos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.gemrartairplane.airplanechaos.databinding.FragmentAboutAuthorBinding
import com.gemrartairplane.airplanechaos.databinding.FragmentVibroVolumeSettingsBinding
import com.gemrartairplane.airplanechaos.help.SingleVievModel
import com.google.android.material.snackbar.Snackbar

class AboutAuthorFragment : Fragment() {
    private var _binding: FragmentAboutAuthorBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    private val singleVievModel by activityViewModels<SingleVievModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAuthorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("vtgt", singleVievModel.toString())
        try {
            binding.btnOkAboutAvuthor.setOnClickListener {
                requireActivity().onBackPressed()
            }
            binding.btnImgExitAboutApp.setOnClickListener {
                initAlertDialog()
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

    private fun snackBarError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private fun initAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }
}