package com.example.igbo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class ColorsActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    var mp: MediaPlayer.OnCompletionListener =
        MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)


        val words = ArrayList<Word>()
        words.add(Word("black", "oji",R.drawable.color_black,R.raw.color_black))
        words.add(Word("brown", "uri",R.drawable.color_brown,R.raw.color_brown))
        words.add(Word("green", "ndụ-ndu",R.drawable.color_green,R.raw.number_one))
        words.add(Word("grey", " ntụ-ntụ",R.drawable.color_gray,R.raw.number_one))
        words.add(Word("red", "acha ọbara ọbara",R.drawable.color_red,R.raw.number_one))
        words.add(Word("dusty yellow", "edo edo edo",R.drawable.color_dusty_yellow,R.raw.number_one))
        words.add(Word("white", "ọcha",R.drawable.color_white,R.raw.number_one))
        words.add(Word("mustard yellow", "Mọstad edo edo",R.drawable.color_mustard_yellow,R.raw.number_one))



        val adapter :WordAdapter = WordAdapter(this, words,R.color.category_colors)
        val listView:ListView = findViewById(R.id.list)
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