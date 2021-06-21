package com.target.targetcasestudy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.databinding.DealListItemBinding

class DealItemAdapter(private val deals: List<DealItem>?, private val clickListener: DealItemClickListener) : RecyclerView.Adapter<DealItemViewHolder>() {
    private lateinit var viewBinding: DealListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        viewBinding =
            DealListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DealItemViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        if(deals == null) {
            return 0
        }
        return deals.size
    }

    override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
        if(deals == null) {
            return
        }
        val item = deals[position]
        viewHolder.bind(item)
        viewHolder.itemView.setOnClickListener {
            clickListener.onClick(item)
        }
    }
}

class DealItemViewHolder(itemView: DealListItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val title = itemView.dealListItemTitle
    private val price = itemView.dealListItemPrice
    private val location = itemView.dealListLocation.locationBadgeText
    private val image = itemView.dealListItemImageView

    fun bind(deal: DealItem) {
        title.text = deal.title
        price.text = deal.price?.displayString ?: "$0.00"
        location.text = deal.aisle
        image.contentDescription = deal.title
        Picasso.with(itemView.context).load(deal.imageURL).into(image)
    }

}

interface DealItemClickListener {
    fun onClick(deal: DealItem)
}