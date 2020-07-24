package com.example.igbo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class FamilyActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    var mp: MediaPlayer.OnCompletionListener =
        MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)


        val words = ArrayList<Word>()

        words.add(Word("father", "nna",R.drawable.family_father,R.raw.family_father))
        words.add(Word("mother", "nne",R.drawable.family_mother,R.raw.family_mother))
        words.add(Word("son", "nwa nwoke",R.drawable.family_son,R.raw.family_father))
        words.add(Word("daughter", "nwa nwanyị",R.drawable.family_daughter,R.raw.family_father))
        words.add(Word("older brother", " nwanne nwoke nke okenye",R.drawable.family_older_brother,R.raw.family_father))
        words.add(Word("younger brother", "nwanne",R.drawable.family_younger_brother,R.raw.family_father))
        words.add(Word("older sister", "nwanne nwanyị nke okenye",R.drawable.family_older_sister,R.raw.family_father))
        words.add(Word("younger sister", "nwanne",R.drawable.family_younger_sister,R.raw.family_father))
        words.add(Word("grandmother", "nne nne",R.drawable.family_grandmother,R.raw.family_father))
        words.add(Word("grandfather", "nna nna",R.drawable.family_grandfather,R.raw.family_father))



        val adapter :WordAdapter = WordAdapter(this, words,R.color.category_family)
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