package com.example.igbo

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NumbersActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var mAudioManager: AudioManager


    var mp: MediaPlayer.OnCompletionListener =
        MediaPlayer.OnCompletionListener { releaseMediaPlayer() }


    private var mOnAudioFocusChangeListener: AudioManager.OnAudioFocusChangeListener = AudioManager.OnAudioFocusChangeListener {
        if (it == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || it == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
            mediaPlayer!!.pause()
            mediaPlayer!!.seekTo(0)
        }
        else if (it == AudioManager.AUDIOFOCUS_GAIN){
            mediaPlayer!!.start()
        }
        else if(it == AudioManager.AUDIOFOCUS_LOSS) {
            releaseMediaPlayer()
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)

        AudioManager.OnAudioFocusChangeListener {AudioManager.OnAudioFocusChangeListener {

        }}

        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val words = ArrayList<Word>()

        words.add(Word("one", "lutti", R.drawable.number_one, R.raw.number_one))
        words.add(Word("two", "otiiko", R.drawable.number_two, R.raw.number_two))
        words.add(Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three))
        words.add(Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four))
        words.add(Word("five", "massokka", R.drawable.number_five, R.raw.number_five))
        words.add(Word("six", "temmokka", R.drawable.number_six, R.raw.number_six))
        words.add(Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven))
        words.add(Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight))
        words.add(Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine))
        words.add(Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten))

        val adapter: WordAdapter = WordAdapter(this, words, R.color.category_numbers)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val word: Word = words[i]

            val result = mAudioManager.requestAudioFocus(
                mOnAudioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN
            )

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                releaseMediaPlayer()
                mediaPlayer = MediaPlayer.create(this, word.getAudioResource()!!)
                mediaPlayer!!.start()

                mediaPlayer!!.setOnCompletionListener {
                    mp
                }
            }


        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener)
    }
}