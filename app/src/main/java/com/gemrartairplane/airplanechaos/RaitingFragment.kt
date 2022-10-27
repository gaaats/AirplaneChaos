package com.gemrartairplane.airplanechaos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.gemrartairplane.airplanechaos.databinding.FragmentRaitingBinding
import com.gemrartairplane.airplanechaos.raitlist.SingleUser
import com.gemrartairplane.airplanechaos.raitlist.UserRaitingListAdapter
import com.google.android.material.snackbar.Snackbar


class RaitingFragment : Fragment() {
    private var _binding: FragmentRaitingBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    private val adapter by lazy {
        UserRaitingListAdapter()
    }

    val listNames = listOf(
        "William",
        "James",
        "Robert",
        "John",
        "David",
        "Elizabeth",
        "Richard",
        "Barbara",
        "Susan",
        "Joseph",
        "Jessica",
        "Thomas",
        "Sarah",
        "Karen",
        "Lisa",
        "Charles",
        "Christopher",
        "Daniel",
        "Nancy",
        "Betty",
        "Matthew"
    )

    val listPersons = mutableListOf<SingleUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRaitingBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        for (i in 1..50){
            val person = SingleUser(name = listNames.random())
            listPersons.add(person)
        }

        try {
            initOnItemClickListener()
            addVertAndHorDividers()
            adapter.submitList(listPersons)
            binding.recyclerViewRaitlist.adapter = adapter
            binding.btnImgExitRaitFragment.setOnClickListener {
                requireActivity().onBackPressed()
            }
            binding.btnGoUnderstand.setOnClickListener {
                requireActivity().onBackPressed()
            }

        } catch (e: Exception) {
            makeErrorNotOut()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun makeErrorNotOut() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private fun addVertAndHorDividers() {
        binding.recyclerViewRaitlist.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initOnItemClickListener() {
        adapter.setOnItemClickListener {
            Snackbar.make(
                binding.root,
                "My name is ${it.name}",
                Snackbar.LENGTH_LONG
            ).show()

        }
    }
}