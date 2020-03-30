package com.example.core.http

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:17
 * description：
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String?)


}