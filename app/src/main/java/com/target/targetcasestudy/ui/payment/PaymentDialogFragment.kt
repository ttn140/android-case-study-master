package com.target.targetcasestudy.ui.payment

import android.os.Bundle
import android.service.autofill.Validators
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.validateCreditCard
import com.target.targetcasestudy.databinding.DialogPaymentBinding

/**
 * Dialog that displays a minimal credit card entry form.
 *
 * Your task here is to enable the "submit" button when the credit card number is valid and
 * disable the button when the credit card number is not valid.
 *
 * You do not need to input any of your actual credit card information. See `Validators.kt` for
 * info to help you get fake credit card numbers.
 *
 * You do not need to make any changes to the layout of this screen (though you are welcome to do
 * so if you wish).
 */
class PaymentDialogFragment : DialogFragment() {

  private lateinit var viewBinding: DialogPaymentBinding
  private lateinit var submitButton: Button
  private lateinit var creditCardInput: EditText
  private lateinit var cancelButton: Button

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewBinding = DialogPaymentBinding.inflate(inflater)
    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupView()
  }

  private fun setupView() {
    with(viewBinding) {
      submitButton = submit
      creditCardInput = cardNumber
      cancelButton = cancel
    }

    cancelButton.setOnClickListener { dismiss() }
    submitButton.setOnClickListener { dismiss() }/*TODO snackbar validation*/
    creditCardInput.addTextChangedListener(creditCardTextWatcher)
  }

  private val creditCardTextWatcher = object: TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(creditCardInput: Editable?) {
      val isValid = validateCreditCard(creditCardInput?.toString())
      submitButton.isEnabled = isValid

    }

  }
}
