package com.gemrartairplane.airplanechaos.raitlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gemrartairplane.airplanechaos.R
import com.gemrartairplane.airplanechaos.databinding.SingleUserLeaderBinding
import kotlin.random.Random


class UserRaitingListAdapter() :
    ListAdapter<SingleUser, UserRaitingListAdapter.UserRaitListVievHolder>(UsersDiffUtill()) {

    private var onItemClickListener: ((person: SingleUser) -> Unit)? = null
    private var addToFavorite: ((recipe: SingleUser) -> Unit)? = null

    class UserRaitListVievHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = SingleUserLeaderBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRaitListVievHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.single_user_leader, parent, false).also {
                return UserRaitListVievHolder(it)
            }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserRaitListVievHolder, position: Int) {
        val currentItem = getItem(position)
        val listNames = listOf(
            "sasha",
            "masha",
            "roma",
            "denis",
            "eva",
            "nastya",
            "kolya",
            "john",
            "noname",
            "rembo",
            "frodo",
            "gimli"
        )

        val listImages = listOf(
            R.drawable.god,
            R.drawable.superhero6,
            R.drawable.superhero5,
            R.drawable.superhero4,
            R.drawable.superhero3,
            R.drawable.superhero2,
            R.drawable.superhero1,
            R.drawable.superhero,
            R.drawable.achilles,
            R.drawable.supermom,
            R.drawable.kitty,
        )
        holder.binding.apply {
            val currentImg = listImages.random()
            val currentScore = Random.nextInt(1, 5000)
            tvName.text = currentItem.name
            tvScore.text = currentScore.toString()
            imgPersonAvataer.setImageResource(currentImg)
            root.setOnClickListener {
                onItemClickListener?.invoke(currentItem)
            }

        }
    }

    fun setOnItemClickListener(listener: (person: SingleUser) -> Unit) {
        onItemClickListener = listener
    }
}