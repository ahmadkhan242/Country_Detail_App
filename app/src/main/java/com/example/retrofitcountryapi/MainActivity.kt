package com.example.retrofitcountryapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.widget.EditText
import com.example.retrofitcountryapi.adaptor.CountryNameAdapter
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager

    var countries: MutableList<String> = ArrayList()
    var displayList: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://restcountries.eu/rest/v2/").build()

        val postsApi = retrofit.create(INetworkAPI::class.java)

        var response: Observable<List<Country>> = postsApi.getAllPosts()

        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            layoutManager = LinearLayoutManager(this)
            rv__list_name.layoutManager = layoutManager
            rv__list_name.adapter = CountryNameAdapter(this, it)

            fun addData() {
                for(item in it ){
                    countries.add(item.name)
                }
            }
            addData()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            val editext = searchView.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
            editext.hint = "Search here..."

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    displayList.clear()
                    if (newText!!.isNotEmpty()) {
                        val search = newText.toLowerCase()
                        countries.forEach {

                            if (it.toLowerCase().contains(search)) {
                                Log.d("TAG",it)
                                displayList.add(it)
                            }
                        }
                    } else {
                        displayList.addAll(countries)
                    }
//                    layoutManager = LinearLayoutManager(menu)
                     rv__list_name.adapter?.notifyDataSetChanged()
                    return true
                }

            })
        }

        return super.onCreateOptionsMenu(menu)
    }


}
