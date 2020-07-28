package com.example.igbo

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class PhrasesActivity : AppCompatActivity() {

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


        val aC = supportActionBar
        aC!!.setDisplayHomeAsUpEnabled(true)


        AudioManager.OnAudioFocusChangeListener {AudioManager.OnAudioFocusChangeListener {

        }}

        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager


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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}