package com.example.igbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)


    val words = ArrayList<Word>()
//
//        val w = Word("lutti", "one")
//        words.add(w)
        words.add(Word("otu", "one"))
        words.add(Word("abuo", "two"))
        words.add(Word("ato", "three"))
        words.add(Word("ano", "four"))
        words.add(Word("ise", "five"))
        words.add(Word("isi", "six"))
        words.add(Word("asa", "seven"))
        words.add(Word("asato", "eight"))
        words.add(Word("itoolu", "nine"))
        words.add(Word("Iri", "ten"))

//        words.add("one")
//        words.add("two")
//        words.add("three")
//        words.add("four")
//        words.add("five")
//        words.add("six")
//        words.add("seven")
//        words.add("eight")
//        words.add("nine")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")

//       val rootView: LinearLayout = findViewById<LinearLayout>(R.id.rootView)

//        for (i in 0 until words.size){
//            val wordView: TextView = TextView(this)
//        wordView.text = words[i]
//        rootView.addView(wordView)
//
//////        }
        val adapter :WordAdapter = WordAdapter(this, words)
        val listView:ListView = findViewById(R.id.list)
        listView.adapter=adapter

//val listView:GridView = findViewById(R.id.list)
//        listView.adapter=itemsAdapter


    }
}