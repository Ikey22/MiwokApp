package com.example.igbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        val words = ArrayList<Word>()

        words.add(Word("where are you going?", "ebee ka ị na-aga?"))
        words.add(Word("what is your name?", "kedu aha gị?"))
        words.add(Word("my name is...", "aha m bụ."))
        words.add(Word("how are you feeling?", "kedu ka ọ dị gị?"))
        words.add(Word("I'm feeling good", "ahụ dị m ma"))
        words.add(Word("are you coming?", "ị ga-abịa?"))
        words.add(Word("yes, I'm coming", "Ee, m na-abịa"))
        words.add(Word("I'm coming", "ana m abịa"))
        words.add(Word("let's go", "ka a pụọ"))
        words.add(Word("come here", "bịa ebe a"))




        val adapter :WordAdapter = WordAdapter(this, words)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter=adapter

    }
}