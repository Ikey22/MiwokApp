package com.example.igbo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class PhrasesActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    var mp: MediaPlayer.OnCompletionListener =
        MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

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

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val word: Word = words[i]


            releaseMediaPlayer()
            Toast.makeText(this, "List item clicked $i", Toast.LENGTH_SHORT).show()
            mediaPlayer = MediaPlayer.create(this, word.getAudioResource()!!)
            mediaPlayer!!.start()

            mediaPlayer!!.setOnCompletionListener {
                mp
            }

        }
    }

    private fun releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
}