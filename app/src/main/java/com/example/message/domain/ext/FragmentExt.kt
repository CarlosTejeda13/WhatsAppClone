package com.example.message.domain.ext

import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard(){
    view?.let { activity?.hideKeyboard(it) }
}