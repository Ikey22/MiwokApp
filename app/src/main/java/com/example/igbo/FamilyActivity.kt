package com.example.igbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        val words = ArrayList<Word>()


        words.add(Word("father", "nna"))
        words.add(Word("mother", "nne"))
        words.add(Word("son", "nwa nwoke"))
        words.add(Word("daughter", "nwa nwanyi"))
        words.add(Word("older brother", " nwanne nwoke nke okenye"))
        words.add(Word("younger brother", "nwanne nwoke"))
        words.add(Word("older sister", "nwanne nwanyi nke okenye"))
        words.add(Word("younger sister", "nwanne nwanyi"))
        words.add(Word("grandmother", "nne nne"))
        words.add(Word("grandfather", "nna nna"))



        val adapter :WordAdapter = WordAdapter(this, words)
        val listView:ListView = findViewById(R.id.list)
        listView.adapter=adapter



    }
}