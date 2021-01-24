package com.zulham.filmntv

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_film.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FilmFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var dataTitle: Array<String>? = null
    private var dataReleaseDate: Array<String>? = null
    private var dataGenre: Array<String>? = null
    private var dataDescription: Array<String>? = null
    private var dataPH: Array<String>? = null
    private var dataPoster: TypedArray? = null
    private var films: ArrayList<DataModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data()
        plusItem()

        recyclerV_movie.apply {
            adapter = FilmAdapter(films!!, context, object : FilmAdapter.OnItemClicked{
                override fun onItemClick(position: Int) {
                    Toast.makeText(context, films!![position].title+" Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("film", films!![position])
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    private fun plusItem() {
        films = ArrayList()

        for (i in 0 until dataTitle!!.size){
            val film = DataModel(
                dataTitle!![i],
                dataReleaseDate!![i],
                dataGenre!![i],
                dataPH!![i],
                dataDescription!![i],
                dataPoster!!.getResourceId(i, -1)

            )

            films!!.add(film)
        }
    }

    private fun data() {
        dataTitle = resources.getStringArray(R.array.film_title)
        dataReleaseDate = resources.getStringArray(R.array.film_daterelease)
        dataGenre = resources.getStringArray(R.array.film_genre)
        dataPH = resources.getStringArray(R.array.film_ph)
        dataDescription = resources.getStringArray(R.array.film_desc)
        dataPoster = resources.obtainTypedArray(R.array.img_film)
    }
}