package com.example.app.entity

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 21:29
 * description：
 */
 class User(username:String?,password:String?,code:String?) {
   constructor():this(null,null,null)
var username:String?
    var password:String?
    var code:String? = null
        /**
         * 递归
         */
//    set(value) {
//        field = value
//    }
//    get() {
//        return field
//    }
        set(value){
           field = value
        }
        get() = field

    init {
         this.username = username
         this.password = password
         this.code = code
    }
}