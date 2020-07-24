package com.example.igbo

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class FamilyActivity : AppCompatActivity() {

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

        words.add(Word("father", "әpә",R.drawable.family_father,R.raw.family_father))
        words.add(Word("mother", "әṭa",R.drawable.family_mother,R.raw.family_mother))
        words.add(Word("son", "angsi",R.drawable.family_son,R.raw.family_son))
        words.add(Word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter))
        words.add(Word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother))
        words.add(Word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother))
        words.add(Word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister))
        words.add(Word("younger sister", "koliti",R.drawable.family_younger_sister,R.raw.family_younger_sister))
        words.add(Word("grandmother", "ama",R.drawable.family_grandmother,R.raw.family_grandmother))
        words.add(Word("grandfather", "papa",R.drawable.family_grandfather,R.raw.family_grandfather))



        val adapter :WordAdapter = WordAdapter(this, words,R.color.category_family)
        val listView: ListView = findViewById(R.id.list)
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