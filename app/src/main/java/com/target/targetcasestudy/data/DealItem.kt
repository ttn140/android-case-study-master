package com.target.targetcasestudy.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Products(
  var products: List<DealItem>
) : Parcelable

@Parcelize
data class DealItem(
  var id: Int,
  var title: String,
  var aisle: String,
  var description: String,
  var imageURL: String?,
  @SerializedName("regular_price")
  var price: Price?,
  @SerializedName("sale_price")
  var salePrice: Price?

) : Parcelable

@Parcelize
data class Price(
  @SerializedName("display_string")
  var displayString: String
) : Parcelable
