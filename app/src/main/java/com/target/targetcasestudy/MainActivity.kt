package com.target.targetcasestudy

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.target.targetcasestudy.data.Products
import com.target.targetcasestudy.ui.DealListFragment
import com.target.targetcasestudy.ui.payment.PaymentDialogFragment
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    title = "Deals"
    getDeals()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.credit_card -> {
        PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
        true
      }
      else -> false
    }
  }

  private fun getDeals() {
    val queue = Volley.newRequestQueue(this)
    val url = getString(R.string.baseurl)

    val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
      { response ->
        handleProducts(response)
        Log.v("networkCall", response.toString())
      },
      {
        Toast.makeText(this, "no", Toast.LENGTH_LONG).show()
      }
    )

    queue.add(jsonObjectRequest)
  }

  private fun handleProducts(productsObject: JSONObject){
    val products = Gson().fromJson(productsObject.toString(), Products::class.java)
    supportFragmentManager.beginTransaction()
      .replace(R.id.container, DealListFragment.newInstance(products))
      .commit()
  }
}
