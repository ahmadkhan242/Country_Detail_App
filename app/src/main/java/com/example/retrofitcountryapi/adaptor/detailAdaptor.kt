package com.example.retrofitcountryapi.adaptor

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.retrofitcountryapi.Country
import com.example.retrofitcountryapi.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_layout.view.*
import kotlinx.android.synthetic.main.post_item_layout.view.*

class DetailViewAdaptor(var context: Context, var postList: List<Country>) :
    RecyclerView.Adapter<DetailViewAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        println("got it")
        Log.e(TAG,"got it")
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_layout,
            parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.name?.text = postList[position].name
        holder?.capital?.text = postList[position].capital
        holder?.alpha2Code?.text = postList[position].alpha2Code
        holder?.alpha3Code?.text = postList[position].alpha3Code
        holder?.region?.text = postList[position].region
        holder?.area?.text = postList[position].area.toString()
        holder?.cioc?.text = postList[position].cioc
        holder?.demonym?.text = postList[position].demonym
        holder?.gini?.text = postList[position].gini.toString()
        holder?.nativeName?.text = postList[position].nativeName
        holder?.numericCode?.text = postList[position].numericCode
        holder?.population?.text = postList[position].population.toString()
        holder?.subregion?.text = postList[position].subregion
        holder?.demonym?.text = postList[position].demonym

        val borders_len = postList[position].borders
        var borders:String = ""
        for(item in borders_len){
            borders+=item
            borders+="\n"
        }
        holder?.borders?.text = borders

        val callingCodes_len = postList[position].callingCodes
        var callingCodes:String = ""
        for(item in callingCodes_len){
            callingCodes+=item
            callingCodes+="\n"
        }
        holder?.callingCodes?.text = callingCodes

        val latlng_len = postList[position].latlng
        var latlng:String = ""
        for(item in latlng_len){
            latlng+=item.toString()
            latlng+="\n"
        }
        holder?.latlng?.text = latlng

        val timezones_len = postList[position].timezones
        var timezones:String = ""
        for(item in timezones_len){
            timezones+=item
            timezones+="\n"
        }
        holder?.timezones?.text = timezones

        val topLevelDomain_len = postList[position].topLevelDomain
        var topLevelDomain:String = ""
        for(item in topLevelDomain_len){
            topLevelDomain+=item
            topLevelDomain+="\n"
        }
        holder?.topLevelDomain?.text = topLevelDomain

        val altSpellings_len = postList[position].altSpellings
        var altSpellings:String = ""
        for(item in altSpellings_len){
            altSpellings+=item
            altSpellings+="\n"
        }
        holder?.altSpellings?.text = altSpellings

        val language_len = postList[position].languages
        var name:String = ""
        for(item in language_len){
            name+=item.name
            name+="\n"
            name+=item.nativeName
            name+="\n"
            name+=item.iso6391
            name+="\n"
            name+=item.iso6392
            name+="\n"
        }
        holder?.lang_name?.text = name


        val Translations_len = postList[position].translations
        var Translations:String = ""

            Translations+=Translations_len.it
            Translations+="\n"
            Translations+=Translations_len.br
            Translations+="\n"
            Translations+=Translations_len.de
            Translations+="\n"
            Translations+=Translations_len.es
            Translations+="\n"
            Translations+=Translations_len.fa
            Translations+="\n"
            Translations+=Translations_len.fr
            Translations+="\n"
            Translations+=Translations_len.hr
            Translations+="\n"
            Translations+=Translations_len.ja
            Translations+="\n"
            Translations+=Translations_len.nl
            Translations+="\n"
            Translations+=Translations_len.pt
            Translations+="\n"

        holder?.Translations?.text = Translations


        val Currency_len = postList[position].currencies
        var Currency:String = ""
        for(item in Currency_len){
            Currency+=item.name
            Currency+="\n"
            Currency+=item.code
            Currency+="\n"
            Currency+=item.symbol
            Currency+="\n"
        }
        holder?.Currency?.text = Currency


        val RegionalBloc_len = postList[position].regionalBlocs
        var RegionalBloc:String = ""
        for(item in RegionalBloc_len){
            RegionalBloc+=item.name
            RegionalBloc+="\n"
            RegionalBloc+=item.acronym
            RegionalBloc+="\n"
            val otherAcronyms_len = item.otherAcronyms
            var otherAcronyms:String = ""
            for(newItem in otherAcronyms_len){
                otherAcronyms+=newItem
            }
            RegionalBloc+=item.otherAcronyms
            RegionalBloc+="\n"
            val otherNames_len = item.otherNames
            var otherNames:String = ""
            for(newItems in otherNames_len){
                otherNames+=newItems
            }
            RegionalBloc+=item.otherNames
            RegionalBloc+="\n"
        }
        holder?.regionalBloc?.text = RegionalBloc



        var thumbnailImageView = holder?.image
        GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(postList[position].flag), thumbnailImageView)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var name: TextView = view.country_name
        var capital: TextView = view.country_capital
        var alpha2Code: TextView = view.country_alpha2Code
        var alpha3Code: TextView = view.country_alpha3Code
        var region: TextView = view.country_region
        var image: ImageView = view.flagimageView
        var lang_name: TextView = view.lang_name
        var regionalBloc: TextView = view.country_regionalBloc
        var area: TextView = view.country_area
        var cioc: TextView = view.country_cioc
        var demonym: TextView = view.country_demonym
        var gini: TextView = view.country_gini
        var nativeName: TextView = view.country_nativeName
        var numericCode: TextView = view.country_numericCode
        var population: TextView = view.country_population
        var subregion: TextView = view.country_subregion
        var altSpellings: TextView = view.country_altSpellings
        var borders: TextView = view.country_borders
        var callingCodes: TextView = view.country_callingCodes
        var latlng: TextView = view.country_latlng
        var timezones: TextView = view.country_timezones
        var topLevelDomain: TextView = view.country_topLevelDomain
        var Currency: TextView = view.country_Currency
        var Translations: TextView = view.country_Translations
    }
    }



