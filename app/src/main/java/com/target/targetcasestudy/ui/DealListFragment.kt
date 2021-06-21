package com.target.targetcasestudy.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.target.targetcasestudy.data.DealItem
import com.target.targetcasestudy.data.Products
import com.target.targetcasestudy.databinding.FragmentDealListBinding


class DealListFragment : Fragment(), DealItemClickListener{

  companion object {
    fun newInstance(products: Products): DealListFragment {
      return DealListFragment().apply {
        val args = Bundle()
        args.putParcelable(PRODUCT_LIST, products)
        arguments = args
      }
    }
    const val PRODUCT_LIST = "productList"
  }

  private lateinit var viewBinding: FragmentDealListBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewBinding = FragmentDealListBinding.inflate(inflater)
    setUpView()
    return viewBinding.root
  }

  private fun setUpView(){
    val productObject: Products? = arguments?.getParcelable(PRODUCT_LIST)
    val clickListener = this
    viewBinding.recyclerView.apply {
      layoutManager = LinearLayoutManager(requireContext())
      adapter = DealItemAdapter(productObject?.products, clickListener)
      addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }
  }

  override fun onClick(deal: DealItem) {
    Toast.makeText(context, deal.title, Toast.LENGTH_LONG).show()
    activity?.supportFragmentManager?.beginTransaction()?.add(DealItemFragment.newInstance(deal), "dealItem")
  }


}
