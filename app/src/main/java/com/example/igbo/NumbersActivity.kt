package com.example.igbo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NumbersActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    var mp: MediaPlayer.OnCompletionListener =
        MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)


        val words = ArrayList<Word>()

        words.add(Word("one", "otu", R.drawable.number_one, R.raw.number_one))
        words.add(Word("two", "abuo", R.drawable.number_two, R.raw.number_two))
        words.add(Word("three", "ato", R.drawable.number_three, R.raw.number_three))
        words.add(Word("four", "ano", R.drawable.number_four, R.raw.number_four))
        words.add(Word("five", "ise", R.drawable.number_five, R.raw.number_five))
        words.add(Word("six", "isi", R.drawable.number_six, R.raw.number_six))
        words.add(Word("seven", "asa", R.drawable.number_seven, R.raw.number_seven))
        words.add(Word("eight", "asato", R.drawable.number_eight, R.raw.number_eight))
        words.add(Word("nine", "itoolu", R.drawable.number_nine, R.raw.number_nine))
        words.add(Word("ten", "iri", R.drawable.number_ten, R.raw.number_ten))

        val adapter: WordAdapter = WordAdapter(this, words, R.color.category_numbers)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter = adapter




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