package com.gemrartairplane.airplanechaos.help

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gemrartairplane.airplanechaos.R
import com.gemrartairplane.airplanechaos.databinding.ForPagerSingleBinding

class CustomPagerAdapter (val list: List<Int>): RecyclerView.Adapter<CustomPagerAdapter.VievPagerHolder>() {

    inner class VievPagerHolder (view: View): RecyclerView.ViewHolder(view){

        val binding = ForPagerSingleBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VievPagerHolder {
        val viev = LayoutInflater.from(parent.context).inflate(R.layout.for_pager_single, parent, false)
        return VievPagerHolder(viev)
    }

    override fun onBindViewHolder(holder: VievPagerHolder, position: Int) {
        holder.binding.imageViev.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}