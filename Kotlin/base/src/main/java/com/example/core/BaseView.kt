package com.example.core

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:36
 * description：
 */
interface BaseView<T> {
    fun getPresenter():T
}