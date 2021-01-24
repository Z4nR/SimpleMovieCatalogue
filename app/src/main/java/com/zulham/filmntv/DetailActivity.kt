package com.zulham.filmntv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<DataModel>("film")

        movie?.let { img_poster_detail.setImageResource(it.img) }
        title_detail.text = movie?.title
        genre_detail.text = movie?.genre
        release_detail.text = movie?.releaseDate
        ph_detail.text = movie?.production
        desc_detail.text = movie?.desc
    }
}