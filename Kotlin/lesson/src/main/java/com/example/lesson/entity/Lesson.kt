package com.example.lesson.entity

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:11
 * description：
 */
data class Lesson(var date: String?, var content: String?,var state:State?) {

    enum class State {
        PLAYBACK {
            override fun stateName() = "有回放"
        },
        LIVE {
            override fun stateName() = "正在直播"
        },
        WAIT {
            override fun stateName() = "等待中"
        };

        abstract fun stateName(): String

    }
}