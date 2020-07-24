package com.example.igbo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NumbersActivity : AppCompatActivity() {

    private lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)


    val words = ArrayList<Word>()

        words.add(Word( "one", "lutti", R.drawable.number_one,R.raw.number_one))
        words.add(Word( "two", "otiiko", R.drawable.number_two,R.raw.number_two))
        words.add(Word( "three", "tolookosu", R.drawable.number_three,R.raw.number_three))
        words.add(Word( "four", "oyyisa", R.drawable.number_four,R.raw.number_four))
        words.add(Word( "five", "massokka", R.drawable.number_five,R.raw.number_five))
        words.add(Word( "six", "temmokka", R.drawable.number_six,R.raw.number_six))
        words.add(Word( "seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven))
        words.add(Word( "eight", "kawinta", R.drawable.number_eight,R.raw.number_eight))
        words.add(Word( "nine", "wo’e", R.drawable.number_nine,R.raw.number_nine))
        words.add(Word( "ten", "na’aacha", R.drawable.number_ten,R.raw.number_ten))

//        words.add("one")
//        words.add("two")
//        words.add("three")
//        words.add("four")
//        words.add("five")
//        words.add("six")
//        words.add("seven")
//        words.add("eight")
//        words.add("nine")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")
//        words.add("ten")

//       val rootView: LinearLayout = findViewById<LinearLayout>(R.id.rootView)

//        for (i in 0 until words.size){
//            val wordView: TextView = TextView(this)
//        wordView.text = words[i]
//        rootView.addView(wordView)
//
//////        }
        val adapter :WordAdapter = WordAdapter(this, words,R.color.category_numbers)
        val listView:ListView = findViewById(R.id.list)
        listView.adapter=adapter


//listView.setOnItemClickListener { adapterView, view, i, l ->
//
//    Toast.makeText(this, "List item clicked $i", Toast.LENGTH_SHORT).show()
//    mediaPlayer = MediaPlayer.create(this, R.raw.number_one)
//    mediaPlayer.start()
//
//}

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
           val word:Word =  words.get(i)

            Toast.makeText(this, "List item clicked $i", Toast.LENGTH_SHORT).show()
            mediaPlayer = MediaPlayer.create(this, word.getAudioResource()!!)
            mediaPlayer.start()

     }
    }
}