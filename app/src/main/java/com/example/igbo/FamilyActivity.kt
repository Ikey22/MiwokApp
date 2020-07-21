package com.example.igbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)


        val words = ArrayList<Word>()
//
//        val w = Word("lutti", "one")
//        words.add(w)
        words.add(Word("father", "father"))
        words.add(Word("blue", "amaloji"))
        words.add(Word("brown", "uri"))
        words.add(Word("green", "ndụ-ndu"))
        words.add(Word("grey", " ntụ-ntụ"))
        words.add(Word("orange", "uhie-edo"))
        words.add(Word("pink", "uhie ọcha"))
        words.add(Word("purple", "ododo"))
        words.add(Word("white", "ọcha"))
        words.add(Word("yellow", "edo"))



        val adapter :WordAdapter = WordAdapter(this, words)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter=adapter

    }
}