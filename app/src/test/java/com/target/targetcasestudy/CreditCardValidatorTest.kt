package com.target.targetcasestudy

import com.target.targetcasestudy.data.validateCreditCard
import org.junit.Assert
import org.junit.Test

/**
 * Feel free to make modifications to these unit tests! Remember, you have full technical control
 * over the project, so you can use any libraries and testing strategies that see fit.
 * Drop the last digit from the number. The last digit is what we want to check against
Reverse the numbers
Multiply the digits in odd positions (1, 3, 5, etc.) by 2 and subtract 9 to all any result higher than 9
Add all the numbers together
The check digit (the last number of the card) is the amount that you would need to add to get a multiple of 10 (Modulo 10)
 *
 */
class CreditCardValidatorTest {
  @Test
  fun `is credit card number valid`() {
    Assert.assertTrue(
      "valid credit card number should yield true",
      validateCreditCard("4539976741512043")
    )
  }

  /*TODO   Validate more card numers and invalid card numbers*/
  /*TODO  Parameterize Tests*/
  /*TODO ValidCrediCardLength*/
  /*TODO validCreidtCardValues*/
  /*TODO sumDigits*/
  /*TODO multiplier (10 tests)*/
}
