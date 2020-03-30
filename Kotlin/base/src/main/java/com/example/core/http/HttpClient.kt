package com.example.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:19
 * description：
 */
object HttpClient : OkHttpClient() {
    private val gson = Gson()

    fun <T> convert(json: String, type: Type) {
        return gson.fromJson(json, type)
    }


    fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>): Unit {
        val request = Request.Builder()
                .url("https://api.hencoder.com/$path")
                .build()
        val call: Call = newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200..299 -> {
                        val body = response.body()
                        var json: String = body!!.string()
                        entityCallback.onSuccess(convert<Any>(json, type) as T)
                    }
                    in 400..499 -> {
                        entityCallback.onFailure("客户端错误")
                    }
                    in 501..599 -> {
                        entityCallback.onFailure("服务器错误")
                    }
                    else -> {
                        entityCallback.onFailure("未知错误")
                    }
                }
            }
        })
    }
}