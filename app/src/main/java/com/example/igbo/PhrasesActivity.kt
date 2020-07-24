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


    private lateinit var mediaPlayer : MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)


        val words = ArrayList<Word>()

        words.add(Word("Where are you going?", "minto wuksus?",R.raw.phrase_where_are_you_going))
        words.add(Word("What is your name?", "tinnә oyaase'nә?",R.raw.phrase_what_is_your_name))
        words.add(Word("My name is...", "oyaaset...",R.raw.phrase_my_name_is))
        words.add(Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling))
        words.add(Word("I’m feeling good", "kuchi achit",R.raw.phrase_im_feeling_good))
        words.add(Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming))
        words.add(Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming))
        words.add(Word("I’m coming.","әәnәm.",R.raw.phrase_im_coming))
        words.add(Word("Let's go.", "yoowutis",R.raw.phrase_lets_go))
        words.add(Word("Come here", "әnni'nem",R.raw.phrase_come_here))



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

            val word:Word =  words.get(i)

            Toast.makeText(this, "List item clicked $i", Toast.LENGTH_SHORT).show()
            mediaPlayer = MediaPlayer.create(this, word.getAudioResource()!!)
            mediaPlayer.start()

    }
}
    }