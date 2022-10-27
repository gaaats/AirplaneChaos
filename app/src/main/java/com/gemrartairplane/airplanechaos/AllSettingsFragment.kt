package com.gemrartairplane.airplanechaos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.gemrartairplane.airplanechaos.databinding.FragmentAllSettingsBinding
import com.gemrartairplane.airplanechaos.databinding.FragmentFaaaaailedBinding
import com.google.android.material.snackbar.Snackbar

class AllSettingsFragment : Fragment() {
    private var _binding: FragmentAllSettingsBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            binding.btnImgExitAllSettings.setOnClickListener {
                initAlertDialog()
            }
            binding.btnOtherSettings.setOnClickListener {
                findNavController().navigate(R.id.action_allSettingsFragment_to_vibroVolumeSettingsFragment)
            }
            binding.btnPhotos.setOnClickListener {
                findNavController().navigate(R.id.action_allSettingsFragment_to_photoFragment)
            }
            binding.btnAboutApp.setOnClickListener {
                findNavController().navigate(R.id.action_allSettingsFragment_to_aboutAppFragment)
            }
            binding.btnAboutAuthor.setOnClickListener {
                findNavController().navigate(R.id.action_allSettingsFragment_to_aboutAuthorFragment)
            }
            binding.btnGoToRules.setOnClickListener {
                findNavController().navigate(R.id.action_allSettingsFragment_to_hovToPlayFragment)
            }


        } catch (e: Exception){
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