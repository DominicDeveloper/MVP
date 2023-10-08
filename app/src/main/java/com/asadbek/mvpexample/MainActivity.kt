package com.asadbek.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.asadbek.mvpexample.contact.Contract
import com.asadbek.mvpexample.databinding.ActivityMainBinding
import com.asadbek.mvpexample.model.Model
import com.asadbek.mvpexample.presenter.Presenter

private const val TAG = "MVP"
class MainActivity : AppCompatActivity(),Contract.View {
    lateinit var binding: ActivityMainBinding
    private var presenter:Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this,Model())
        binding.button.setOnClickListener {
            presenter?.onButtonClick()
        }


    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        Log.d(TAG, "hideProgress: in mainActivity")
        binding.progressBar.visibility = View.INVISIBLE
        binding.textView.visibility = View.VISIBLE

    }

    override fun setString(string: String) {
        Log.d(TAG, "setString: in mainActivity")
        binding.textView.text = string

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }
}