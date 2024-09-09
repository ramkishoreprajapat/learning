package com.rk.junittesting.utils

class Helper {
    fun isPalindrome(input: String): Boolean {
        var i = 0;
        var j = input.length - 1;
        var result = true;

        while (i < j) {
            if (input[i] != input[j]) {
                result = false;
                break;
            }
            i++
            j--
        }

        return result
    }

    fun isPasswordValid(password: String) = when {
        password.isBlank() -> {
            "Password is required field"
        }

        password.length < 6 -> {
            "Length of password should be greater than 6"
        }

        password.length > 15 -> {
            "Length of password should be less than 15"
        }

        else -> {
            "Password is valid"
        }
    }

    fun reverseString(str: String): String {
        var reverseStr = ""
        for (i in str.length - 1 downTo 0) {
            reverseStr += str[i]
        }
        return reverseStr
    }
}