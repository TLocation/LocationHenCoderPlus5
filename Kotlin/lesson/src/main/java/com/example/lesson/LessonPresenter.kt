package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList

//internal modle 内部类

/**
 * internal 声明的类不可以用作泛型
 */
/*internal*/ class LessonPresenter(private val activity: LessonActivity) {
    private  val LESSON_PATH = "lessons"
    private var lessons:List<Lesson> = ArrayList()
    private val type = object : TypeToken<List<Lesson>>() {}.type
    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity.runOnUiThread { activity.showResult(entity) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { toast(message) }
            }


        })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter { it.state == Lesson.State.PLAYBACK })
    }



}