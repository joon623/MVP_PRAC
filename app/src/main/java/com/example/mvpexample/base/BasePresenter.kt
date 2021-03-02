package com.example.mvpexample.base

interface BasePresenter<T> {
    fun takeView(view: T)
    fun dropView()
}
