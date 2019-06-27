package com.example.retrofitcountryapi.adaptor

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.detail_layout.view.*

class DetailViewAdaptor(var context: Context, var CountryList: List<Country>) :
    RecyclerView.Adapter<DetailViewAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        println("got it")
        Log.e(TAG,"got it")
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_layout,
            parent, false))
    }

    override fun getItemCount(): Int {
        return CountryList.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.name?.text = CountryList[position].name
        holder?.capital?.text = "\uD835\uDDD6\uD835\uDDEE\uD835\uDDFD\uD835\uDDF6\uD835\uDE01\uD835\uDDEE\uD835\uDDF9 - "+ CountryList[position].capital
        holder?.alpha2Code?.text = "Alpha2Code - "+CountryList[position].alpha2Code
        holder?.alpha3Code?.text = "Alpha3Code - "+CountryList[position].alpha3Code
        holder?.region?.text ="Region - "+ CountryList[position].region
        holder?.area?.text = "Area - "+CountryList[position].area.toString()
        holder?.cioc?.text ="Cioc - "+ CountryList[position].cioc
        holder?.gini?.text ="Gini - "+ CountryList[position].gini.toString()
        holder?.nativeName?.text ="Native Name - "+ CountryList[position].nativeName
        holder?.numericCode?.text ="Numaric Code - "+ CountryList[position].numericCode
        holder?.population?.text = "Population - "+CountryList[position].population.toString()
        holder?.subregion?.text ="SubRegion - "+ CountryList[position].subregion
        holder?.demonym?.text ="Demonym - "+ CountryList[position].demonym

        val borders_len = CountryList[position].borders
        if(borders_len.isEmpty()){
            var borders:String = " \uD835\uDDD5\uD835\uDDFC\uD835\uDDFF\uD835\uDDF1\uD835\uDDF2\uD835\uDDFF\uD835\uDE00 \n Boders Not Available "
            holder?.borders?.text = borders.trim()
        }else{
            var borders:String = " \uD835\uDDD5\uD835\uDDFC\uD835\uDDFF\uD835\uDDF1\uD835\uDDF2\uD835\uDDFF\uD835\uDE00 "
            borders+="\n"
            var count_border = 1
            for(item in borders_len){
                borders=  borders + count_border + ". "+ item
                borders+="\n"
                count_border++
            }
            holder?.borders?.text = borders.trim()
        }


        val callingCodes_len = CountryList[position].callingCodes
        if(callingCodes_len.isEmpty()){
            var callingCodes:String = " \uD835\uDDD6\uD835\uDDEE\uD835\uDDF9\uD835\uDDF9\uD835\uDDF6\uD835\uDDFB\uD835\uDDF4 \uD835\uDDD6\uD835\uDDFC\uD835\uDDF1\uD835\uDDF2\uD835\uDE00 \n Calling Codes Not Available"
            holder?.callingCodes?.text = callingCodes.trim()
        }else{

            var callingCodes:String = "\uD835\uDDD6\uD835\uDDEE\uD835\uDDF9\uD835\uDDF9\uD835\uDDF6\uD835\uDDFB\uD835\uDDF4 \uD835\uDDD6\uD835\uDDFC\uD835\uDDF1\uD835\uDDF2\uD835\uDE00"
            callingCodes+="\n"
            var count_calling = 1
            for(item in callingCodes_len){
                callingCodes= callingCodes +count_calling +". "+ "`"+item+"`"
                callingCodes+="\n"
            }
            holder?.callingCodes?.text = callingCodes.trim()
        }

        val latlng_len = CountryList[position].latlng
        if(latlng_len.isEmpty()){
            var latlng:String = " \uD835\uDDDF\uD835\uDDEE\uD835\uDE01\uD835\uDDF6\uD835\uDE01\uD835\uDE02\uD835\uDDF1\uD835\uDDF2 \uD835\uDDEE\uD835\uDDFB\uD835\uDDF1 \uD835\uDDDF\uD835\uDDFC\uD835\uDDFB\uD835\uDDF4\uD835\uDDF6\uD835\uDE01\uD835\uDE02\uD835\uDDF1\uD835\uDDF2 \n Latitude and Longitude Not Available"
            holder?.latlng?.text = latlng
        }else{

            var latlng:String = " \uD835\uDDDF\uD835\uDDEE\uD835\uDE01\uD835\uDDF6\uD835\uDE01\uD835\uDE02\uD835\uDDF1\uD835\uDDF2 \uD835\uDDEE\uD835\uDDFB\uD835\uDDF1 \uD835\uDDDF\uD835\uDDFC\uD835\uDDFB\uD835\uDDF4\uD835\uDDF6\uD835\uDE01\uD835\uDE02\uD835\uDDF1\uD835\uDDF2 "
            latlng+="\n"
            for(item in latlng_len){
                latlng+= " " +item.toString() + " , "
            }
            holder?.latlng?.text = latlng.dropLast(2)
        }


        val timezones_len = CountryList[position].timezones
        if(timezones_len.isEmpty()){
            var timezones:String = " \uD835\uDDE7\uD835\uDDF6\uD835\uDDFA\uD835\uDDF2\uD835\uDE07\uD835\uDDFC\uD835\uDDFB\uD835\uDDF2 \n Timezone Not Available"
            holder?.timezones?.text = timezones.trim()
        }else{

            var timezones:String = " \uD835\uDDE7\uD835\uDDF6\uD835\uDDFA\uD835\uDDF2\uD835\uDE07\uD835\uDDFC\uD835\uDDFB\uD835\uDDF2 "
            timezones+="\n"
            var count_timezon = 1
            for(item in timezones_len){
                timezones = timezones + count_timezon + ". " + item
                timezones+="\n"
                count_timezon++
            }
            holder?.timezones?.text = timezones.trim()
        }


        val topLevelDomain_len = CountryList[position].topLevelDomain
        if(topLevelDomain_len.isEmpty()){
            var topLevelDomain:String = " \uD835\uDDE7\uD835\uDDFC\uD835\uDDFD \uD835\uDDDF\uD835\uDDF2\uD835\uDE03\uD835\uDDF2\uD835\uDDF9 \uD835\uDDD7\uD835\uDDFC\uD835\uDDFA\uD835\uDDEE\uD835\uDDF6\uD835\uDDFB\n  Domain Not Available"
            holder?.topLevelDomain?.text = topLevelDomain.trim()
        }else{

            var topLevelDomain:String = " \uD835\uDDE7\uD835\uDDFC\uD835\uDDFD \uD835\uDDDF\uD835\uDDF2\uD835\uDE03\uD835\uDDF2\uD835\uDDF9 \uD835\uDDD7\uD835\uDDFC\uD835\uDDFA\uD835\uDDEE\uD835\uDDF6\uD835\uDDFB\n "
            topLevelDomain+="\n"
            var count_toplevedomain  = 1
            for(item in topLevelDomain_len){
                topLevelDomain = topLevelDomain + count_toplevedomain +  ". "+ '"'+item+'"'
                topLevelDomain+="\n"
                count_toplevedomain++
            }
            holder?.topLevelDomain?.text = topLevelDomain.trim()
        }


        val altSpellings_len = CountryList[position].altSpellings
        if(altSpellings_len.isEmpty()){
            var altSpellings:String = " \uD835\uDDD4\uD835\uDDF9\uD835\uDE01 \uD835\uDDE6\uD835\uDDFD\uD835\uDDF2\uD835\uDDF9\uD835\uDDF9\uD835\uDDF6\uD835\uDDFB\uD835\uDDF4\uD835\uDE00 \n Alt Spellings Not Available"
            holder?.altSpellings?.text = altSpellings.trim()
        }else{

            var altSpellings:String = " \uD835\uDDD4\uD835\uDDF9\uD835\uDE01 \uD835\uDDE6\uD835\uDDFD\uD835\uDDF2\uD835\uDDF9\uD835\uDDF9\uD835\uDDF6\uD835\uDDFB\uD835\uDDF4\uD835\uDE00 "
            altSpellings+="\n"
            var count_altspellings = 1
            for(item in altSpellings_len){
                altSpellings= altSpellings + count_altspellings+ " - "+item
                altSpellings+="\n"
                count_altspellings++
            }
            holder?.altSpellings?.text = altSpellings.trim()
        }


        val language_len = CountryList[position].languages
        var name:String = " \uD835\uDDDF\uD835\uDDEE\uD835\uDDFB\uD835\uDDF4\uD835\uDE02\uD835\uDDEE\uD835\uDDF4\uD835\uDDF2 "
        name+="\n"
        var count_language = 1
        for(item in language_len){
            name= name + count_language +". "+"Name - "+item.name
            name+="\n"
            name= name + "    Native Name - "+item.nativeName
            name+="\n"
            name = name +"    iso6391 - "+ item.iso6391
            name+="\n"
            name= name +"    iso6392 - "+item.iso6392
            name+="\n"
            name+="\n"
            count_language++
        }
        holder?.lang_name?.text = name.trim()


        val Translations_len = CountryList[position].translations
        var Translations:String = " \uD835\uDDE7\uD835\uDDFF\uD835\uDDEE\uD835\uDDFB\uD835\uDE00\uD835\uDDF9\uD835\uDDEE\uD835\uDE01\uD835\uDDF6\uD835\uDDFC\uD835\uDDFB\uD835\uDE00 "
            Translations+="\n"
            Translations= Translations+ "  it - "+ Translations_len.it
            Translations+="\n"
            Translations= Translations+ "  br - "+Translations_len.br
            Translations+="\n"
            Translations= Translations+ "  de - "+Translations_len.de
            Translations+="\n"
            Translations= Translations+ "  es - "+Translations_len.es
            Translations+="\n"
            Translations= Translations+ "  fa - "+Translations_len.fa
            Translations+="\n"
            Translations= Translations+ "  fr - "+Translations_len.fr
            Translations+="\n"
            Translations= Translations+ "  hr - "+Translations_len.hr
            Translations+="\n"
            Translations= Translations+ "  ja - "+Translations_len.ja
            Translations+="\n"
            Translations= Translations+ "  nl - "+Translations_len.nl
            Translations+="\n"
            Translations= Translations+ "  pt - "+Translations_len.pt
            Translations+="\n"

        holder?.Translations?.text = Translations.trim()


        val Currency_len = CountryList[position].currencies
        var Currency:String = " \uD835\uDDD6\uD835\uDE02\uD835\uDDFF\uD835\uDDFF\uD835\uDDF2\uD835\uDDFB\uD835\uDDF0\uD835\uDE06"
            Currency+= "\n"
        var count_currency = 1
        for(item in Currency_len){
            Currency= Currency+ count_currency + ". Name - "+item.name
            Currency+="\n"
            Currency= Currency + "    Code - "+item.code
            Currency+="\n"
            Currency= Currency + "    Symbol - "+item.symbol
            Currency+="\n"
            count_currency++
        }
        holder?.Currency?.text = Currency.trim()


        val RegionalBloc_len = CountryList[position].regionalBlocs
        if(RegionalBloc_len.isEmpty()){
            var RegionalBloc:String = " \uD835\uDDE5\uD835\uDDF2\uD835\uDDF4\uD835\uDDF6\uD835\uDDFC\uD835\uDDFB\uD835\uDDEE\uD835\uDDF9 \uD835\uDDD5\uD835\uDDF9\uD835\uDDFC\uD835\uDDF0 \n Regional Bloc Not Available"
            holder?.regionalBloc?.text = RegionalBloc.trim()
        }else{
            var RegionalBloc:String = " \uD835\uDDE5\uD835\uDDF2\uD835\uDDF4\uD835\uDDF6\uD835\uDDFC\uD835\uDDFB\uD835\uDDEE\uD835\uDDF9 \uD835\uDDD5\uD835\uDDF9\uD835\uDDFC\uD835\uDDF0"
            RegionalBloc+="\n"
            var count_RegionalBloc = 1
            for(item in RegionalBloc_len){
                RegionalBloc =RegionalBloc + count_RegionalBloc+ ". "+ "Name - "+item.name
                RegionalBloc+="\n"
                RegionalBloc= RegionalBloc + "    Acronym - "+ item.acronym
                RegionalBloc+="\n"
                val otherAcronyms_len = item.otherAcronyms
                if(otherAcronyms_len.isEmpty()){
                    var otherAcronyms:String = ""
                    RegionalBloc = RegionalBloc +"    \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC00\uD835\uDC1C\uD835\uDC2B\uD835\uDC28\uD835\uDC27\uD835\uDC32\uD835\uDC26 -\n     Other Acronyms Not Available " + otherAcronyms
                    RegionalBloc+="\n"
                }else{

                    var otherAcronyms:String = ""
                    var count_otherAcronyms = 1
                    for(newItem in otherAcronyms_len){
                        otherAcronyms= "     "+otherAcronyms+ count_otherAcronyms +". "+newItem
                        otherAcronyms+="\n"
                        count_otherAcronyms++
                    }
                    RegionalBloc = RegionalBloc +"    \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC00\uD835\uDC1C\uD835\uDC2B\uD835\uDC28\uD835\uDC27\uD835\uDC32\uD835\uDC26 -\n     " + otherAcronyms
                    RegionalBloc+="\n"
                }


                val otherNames_len = item.otherNames
                if(otherNames_len.isEmpty()){
                    var otherNames:String = ""
                    RegionalBloc= RegionalBloc +"    \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC0D\uD835\uDC1A\uD835\uDC26\uD835\uDC1E -\n     Other Names Not Available "+otherNames
                    RegionalBloc+="\n"
                }else{

                    var otherNames:String = ""
                    var count_othername = 1
                    for(newItems in otherNames_len){
                        otherNames= "     "+otherNames + count_othername + ". "+newItems
                        otherNames+="\n"
                        count_othername++
                    }
                    RegionalBloc= RegionalBloc +"    \uD835\uDC0E\uD835\uDC2D\uD835\uDC21\uD835\uDC1E\uD835\uDC2B \uD835\uDC0D\uD835\uDC1A\uD835\uDC26\uD835\uDC1E -\n     "+otherNames
                    RegionalBloc+="\n"
                }
                count_RegionalBloc++
            }
            holder?.regionalBloc?.text = RegionalBloc.trim()
        }




        var thumbnailImageView = holder?.image
        GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(CountryList[position].flag), thumbnailImageView)

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



