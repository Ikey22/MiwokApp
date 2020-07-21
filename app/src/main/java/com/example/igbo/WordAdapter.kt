package com.example.igbo

import android.R
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class WordAdapter:ArrayAdapter<Word> {

    constructor(context:Activity, words:ArrayList<Word> ) :  super(context,0,words){

    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView==convertView) {
            listItemView = LayoutInflater.from(context).inflate(com.example.igbo.R.layout.list_item,parent,false)
        }


        val currentWord : Word? = getItem(position)

        val igboTextView = listItemView?.findViewById<TextView>(com.example.igbo.R.id.igbo_text_view)
        igboTextView?.text = currentWord?.getIgboTranslation()

        val defaultTextView = listItemView?.findViewById<TextView>(com.example.igbo.R.id.default_text_view)
        defaultTextView?.text = currentWord?.getDefaultTranslation()


        return listItemView!!
    }

    //   override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
//        // Check if the existing view is being reused, otherwise inflate the view
//        var listItemView = convertView
//        if (listItemView == null) {
//            listItemView = LayoutInflater.from(context).inflate(
//                R.layout.list_item, parent, false
//            )
//        }
//
//        // Get the {@link AndroidFlavor} object located at this position in the list
//        val currentWord: Word? = getItem(position)
//
//        // Find the TextView in the list_item.xml layout with the ID version_name
//        val igboTextView:TextView = listItemView.findViewById(R.id.)
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        nameTextView.setText(currentAndroidFlavor.getVersionName())
//
//        // Find the TextView in the list_item.xml layout with the ID version_number
//        val numberTextView = listItemView.findViewById<View>(R.id.version_number) as TextView
//        // Get the version number from the current AndroidFlavor object and
//        // set this text on the number TextView
//        numberTextView.setText(currentAndroidFlavor.getVersionNumber())
//
//        // Find the ImageVie
//
//        // Return the whole list item layout (containing 2 TextViews and an ImageView)
//        // so that it can be shown in the ListView
//        return listItemView
//    }


}