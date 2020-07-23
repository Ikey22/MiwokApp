package com.example.igbo

class Word {
    var mMiwokTranslation:String? = null
    var mDefaultTranslation:String? = null
    private val NO_IMAGE_PROVIDED = -1
    private  var mImageResourceId:Int = NO_IMAGE_PROVIDED
    private var mAudioResource:Int? = null



    constructor(defaultTranslation:String, miwokTranslation:String, imageResourceId:Int , audioResourceId:Int){
        this.mMiwokTranslation=miwokTranslation
        this.mDefaultTranslation = defaultTranslation
        this.mImageResourceId=imageResourceId
        this.mAudioResource=audioResourceId


    }
    constructor(defaultTranslation:String, miwokTranslation:String,audioResourceId:Int ){
        this.mMiwokTranslation=miwokTranslation
        this.mDefaultTranslation = defaultTranslation
        this.mAudioResource=audioResourceId
    }



    fun getDefaultTranslation(): String? {

        return mDefaultTranslation


    }

    fun getMiwokTranslation():String?{
        return mMiwokTranslation
    }

    fun getImageResourceId():Int?{
        return mImageResourceId
    }

    fun hasImage():Boolean{
    return mImageResourceId != NO_IMAGE_PROVIDED
    }


    fun getAudioResource():Int?{
        return mAudioResource
    }
}