package com.example.igbo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat


class WordAdapter:ArrayAdapter<Word> {

    private var mColorResourceId:Int= 0

    constructor(context:Activity, words:ArrayList<Word>,colorResourceId:Int ) :  super(context,0,words){

        mColorResourceId = colorResourceId
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView==convertView) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        }


        val currentWord : Word? = getItem(position)

        val miwokTextView = listItemView?.findViewById<TextView>(com.example.igbo.R.id.igbo_text_view)
        miwokTextView?.text = currentWord?.getMiwokTranslation()

        val defaultTextView = listItemView?.findViewById<TextView>(com.example.igbo.R.id.default_text_view)
        defaultTextView?.text = currentWord?.getDefaultTranslation()

        val imageResourceView: ImageView? = listItemView?.findViewById<ImageView>(com.example.igbo.R.id.images_view)
        if (currentWord!!.hasImage()){
            imageResourceView?.setImageResource(currentWord.getImageResourceId()!!)

            imageResourceView?.visibility = View.VISIBLE
        }
        else{
            imageResourceView?.visibility = View.GONE
        }

        val textContainer = listItemView?.findViewById<View>(com.example.igbo.R.id.text_container)
        val color:Int = ContextCompat.getColor(context, mColorResourceId)
        textContainer?.setBackgroundColor(color)

        return listItemView!!
    }



}