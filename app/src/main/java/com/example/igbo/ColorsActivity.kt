package com.example.igbo

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class ColorsActivity : AppCompatActivity() {


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
        words.add(Word("black", "kululli",R.drawable.color_black,R.raw.color_black))
        words.add(Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown))
        words.add(Word("green", "chokokki",R.drawable.color_green,R.raw.color_green))
        words.add(Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray))
        words.add(Word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red))
        words.add(Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow))
        words.add(Word("white", "kelelli",R.drawable.color_white,R.raw.color_white))
        words.add(Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow))



        val adapter :WordAdapter = WordAdapter(this, words,R.color.category_colors)
        val listView:ListView = findViewById(R.id.list)
        listView.adapter=adapter
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