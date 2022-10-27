package com.gemrartairplane.airplanechaos.raitlist
import androidx.recyclerview.widget.DiffUtil

class UsersDiffUtill: DiffUtil.ItemCallback<SingleUser>() {
    override fun areItemsTheSame(oldItem: SingleUser, newItem: SingleUser): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SingleUser, newItem: SingleUser): Boolean {
        return oldItem == newItem
    }
}