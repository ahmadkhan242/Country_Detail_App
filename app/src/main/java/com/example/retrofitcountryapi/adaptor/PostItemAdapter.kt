package com.example.retrofitcountryapi.adaptor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofitcountryapi.Country
import com.example.retrofitcountryapi.Main2Activity
import com.example.retrofitcountryapi.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_layout.view.*
import kotlinx.android.synthetic.main.post_item_layout.view.*
var TAG: String  = "PostItemAdapter"
class PostItemAdapter(val context: Context, var postList: List<Country>) :


    RecyclerView.Adapter<PostItemAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CustomViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(
            R.layout.post_item_layout,
            parent, false
        )
        return CustomViewHolder(layoutInflater)
    }
    override fun getItemCount(): Int {
        return postList.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        var name = postList[position].callingCodes[0]

        holder.view.txtPostTitle?.text = postList[position].name
        holder.view.txtPostBody?.text = "Capital - " +postList[position].capital

        var thumbnailImageView = holder.view.flag_imageView
        GlideToVectorYou.justLoadImage(holder.view.context as Activity?, Uri.parse(postList[position].flag), thumbnailImageView)

        holder.name = name
    }

    class CustomViewHolder(var view: View,var name: String? = null): RecyclerView.ViewHolder(view){
    companion object {
        var country_name = "name"
    }
        init{
            view.setOnClickListener{
                var intent = Intent(view.context, Main2Activity::class.java)
                intent.putExtra(country_name, name)
                view.context.startActivity(intent)
            }
        }
    }

}