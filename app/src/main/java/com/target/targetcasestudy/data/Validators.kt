package com.target.targetcasestudy.data

/**
 * For an explanation of how to validate credit card numbers read:
 *
 * https://www.freeformatter.com/credit-card-number-generator-validator.html#fakeNumbers
 *
 * This contains a breakdown of how this algorithm should work as
 * well as a way to generate fake credit card numbers for testing
 *
 * The structure and signature of this is open to modification, however
 * it *must* include a method, field, etc that returns a [Boolean]
 * indicating if the input is valid or not
 *
 * Additional notes:
 *  * This method does not need to validate the credit card issuer
 *  * This method must validate card number length (13 - 19 digits), but does not
 *    need to validate the length based on the issuer.
 *
 *    Drop the last digit from the number. The last digit is what we want to check against
Reverse the numbers
Multiply the digits in odd positions (1, 3, 5, etc.) by 2 and subtract 9 to all any result higher than 9
Add all the numbers together
The check digit (the last number of the card) is the amount that you would need to add to get a multiple of 10 (Modulo 10)
 *
 * @param creditCardNumber - credit card number of (13, 19) digits
 * @return true if a credit card number is believed to be valid,
 * otherwise false
 */
fun validateCreditCard(creditCardNumber: String?): Boolean {
    return if(creditCardNumber.isNullOrEmpty()) {
        false
    } else {
        validCreditCardValues(creditCardNumber) && validCreditCardLength(creditCardNumber)
    }
}

fun validCreditCardLength(creditCardNumber: String): Boolean {
    val length = creditCardNumber.length
    return (length >= 13) && (length <= 19)
}

fun validCreditCardValues(creditCardNumber: String): Boolean {
    //save last digit
    val lastDigit = creditCardNumber.last().toString().toInt()
    val withoutLastDigit = creditCardNumber.dropLast(1)
    val reversed = withoutLastDigit.reversed()
    val sumDigits = sumDigits(reversed)
    val key = sumDigits % 10
    //compare to last digit
    return (lastDigit + key) % 10 == 0
}

fun sumDigits(values: String): Int {
    var sum = 0
    for (i in values.indices) {
        sum += if (i % 2 == 0) {
            multiplier(values[i])
        } else {
            values[i].toString().toInt()
        }
    }
    return sum
}

fun multiplier(value: Char): Int {
    val digit = value.toString().toInt()
    return if (digit < 5) {
        digit * 2
    } else {
        (digit * 2) - 9
    }
}


/*TODO Validate if all values are digits*/

