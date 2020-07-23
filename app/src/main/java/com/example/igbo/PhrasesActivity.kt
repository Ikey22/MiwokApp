package com.example.igbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)



        val words = ArrayList<Word>()

        words.add(Word("Where are you going?", "Ebee ka ị na-aga?",R.raw.phrase_where_are_you_going))
        words.add(Word("What is your name?", "Gini bu aha gị?",R.raw.phrase_where_are_you_going))
        words.add(Word("My name is...", "Aha m bụ...",R.raw.phrase_where_are_you_going))
        words.add(Word("How are you feeling?", "Ahụ dị m mma",R.raw.phrase_where_are_you_going))
        words.add(Word("I’m feeling good", " nwanne nwoke nke okenye",R.raw.phrase_where_are_you_going))
        words.add(Word("Are you coming?", "E na-abịa?",R.raw.phrase_where_are_you_going))
        words.add(Word("Yes, I’m coming.", "Ee, m na-abịa.",R.raw.phrase_where_are_you_going))
        words.add(Word("I’m coming.","Ana m abịa.",R.raw.phrase_where_are_you_going))
        words.add(Word("Let's go.", "Ka a pụọ",R.raw.phrase_where_are_you_going))
        words.add(Word("Come here", "Bịa ebe a",R.raw.phrase_where_are_you_going))



        val adapter :WordAdapter = WordAdapter(this, words,R.color.category_phrases)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter=adapter
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