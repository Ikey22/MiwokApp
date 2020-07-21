package com.example.igbo

class Word {
    var mIgboTranslation:String? = null
    var mDefaultTranslation:String? = null

    constructor(igboTranslation:String, defaultTranslation:String ){
        this.mIgboTranslation=igboTranslation
        this.mDefaultTranslation = defaultTranslation
    }

    fun getDefaultTranslation(): String? {

        return mDefaultTranslation


    }

    fun getIgboTranslation():String?{
        return mIgboTranslation
    }
}