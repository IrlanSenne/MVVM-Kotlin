package com.senne.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

    private var db = DB()

    private var mTestTitle = MutableLiveData<String>()
    var textTitle = mTestTitle

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTestTitle.value = "MVVM"
    }

    fun login(name: String) {
        val ret = db.login(name)
        mLogin.value = ret

    }
}