package com.example.mvpexample.view.Search

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mvpexample.R
import com.example.mvpexample.base.BaseActivity
import com.example.mvpexample.model.dog.Dog
import com.example.mvpexample.presenter.SearchContract
import com.example.mvpexample.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_main.*

class SearchActivity : BaseActivity(), SearchContract.View {

    private lateinit var searchPresenter: SearchPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchPresenter.takeView(this)

        setButton()
    }

    private fun setButton() {
        getDogListButton.setOnClickListener {
            searchPresenter.getDogList()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showDogList(dogList : List<Dog>) {
        firstDogText.text = "Name : ${dogList[0].name}, Age : ${dogList[0].age}"
        secondDogText.text = "Name : ${dogList[1].name}, Age : ${dogList[1].age}"
        thirdDogText.text = "Name : ${dogList[2].name}, Age : ${dogList[2].age}"
    }

    override fun onDestroy() {
        super.onDestroy()
        searchPresenter.dropView()
    }


    override fun initPresenter() {
        searchPresenter = SearchPresenter()
    }

    override fun showError(error: String) {
        Toast.makeText(this@SearchActivity, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        searchRefresh.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        searchRefresh.visibility = View.GONE
    }

}