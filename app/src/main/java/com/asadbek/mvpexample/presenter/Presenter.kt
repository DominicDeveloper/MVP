package com.asadbek.mvpexample.presenter

import android.util.Log
import com.asadbek.mvpexample.contact.Contract

private const val TAG = "MVP"
class Presenter(private var mainView:Contract.View?,
private val model: Contract.Model):Contract.Presenter,Contract.Model.OnFinishedListener {
    override fun onFinished(string: String) {
        Log.d(TAG, "onFinished: in presenter")
        if (mainView != null){
            mainView?.setString(string)
            mainView?.hideProgress()
        }
    }

    override fun onButtonClick() {
       if (mainView != null){
           mainView?.showProgress()
       }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

}