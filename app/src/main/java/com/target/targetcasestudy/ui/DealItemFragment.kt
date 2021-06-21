package com.target.targetcasestudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.databinding.FragmentDealItemBinding


class DealItemFragment : Fragment() {

  companion object {
    fun newInstance(deal: DealItem): DealItemFragment {
      return DealItemFragment().apply {
        val args = Bundle()
        args.putParcelable(DEAL, deal)
        arguments = args
      }
    }

    const val DEAL = "dealSelected"
  }

  private lateinit var viewBinding: FragmentDealItemBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewBinding = FragmentDealItemBinding.inflate(inflater)
    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val deal: DealItem? = arguments?.getParcelable(DEAL)
    setUpView(deal)
  }

  private fun setUpView(deal: DealItem?) {
    with(viewBinding){
      buttons.dealItemButtonAddToCart.setOnClickListener {
        Toast.makeText(context, "Added To Cart", Toast.LENGTH_LONG).show()
      }
      buttons.dealItemButtonAddToList.setOnClickListener {
        Toast.makeText(context, "Added To List", Toast.LENGTH_LONG).show()
      }
      Picasso.with(context).load(deal?.imageURL ?: "").into(info.dealItemImageView)
      if(deal != null && deal.salePrice == null){
        info.dealItemTextViewSalePrice.text = deal.price?.displayString ?: "$0.00"
        info.dealItemTextViewRegularPrice.visibility = View.GONE
      } else if (deal != null){
        info.dealItemTextViewSalePrice.text = deal?.salePrice?.displayString
        info.dealItemTextViewRegularPrice.visibility = View.VISIBLE
        info.dealItemTextViewRegularPrice.text = deal?.price?.displayString
      }
    }
  }
}
