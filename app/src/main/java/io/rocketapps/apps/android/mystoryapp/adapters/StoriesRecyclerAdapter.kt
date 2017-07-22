package io.rocketapps.apps.android.mystoryapp.adapters

import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rocketapps.apps.android.mystoryapp.R
import io.rocketapps.apps.android.mystoryapp.objects.StoryClass
import android.widget.Toast
import io.rocketapps.apps.android.mystoryapp.MainActivity
import android.R.id.button1
import android.content.Intent
import io.rocketapps.apps.android.mystoryapp.activities.SingleStoryActivity


/**
 * Created by macbook on 7/11/17.
 */


class StoriesRecyclerAdapter : RecyclerView.Adapter<StoriesRecyclerHolder>{

    var mData : ArrayList<StoryClass>
    var mContext : Context



    constructor(context: Context, data : ArrayList<StoryClass>) : super(){
        mData = data
        mContext = context

    }

    override fun getItemCount(): Int {

       return mData.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StoriesRecyclerHolder {
        var view: View? = null

        Log.d("ADAPTER", viewType.toString())
        when(viewType){
            StoryClass.POPULAR_SEARCH -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.recycler_row_popular_search, parent, false)
            }
            StoryClass.HISTORY_SEARCH -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.recycler_row_search_history, parent, false)
            }
            StoryClass.HOME -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.recycler_row_home_item, parent, false)
            }

        }



        return StoriesRecyclerHolder(view!!, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return mData.get(position).viewType
    }


    override fun onBindViewHolder(holder: StoriesRecyclerHolder, position: Int) {


        holder.bind(mContext, mData.get(position))
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(mContext, SingleStoryActivity::class.java)
                mContext.startActivity(intent)

            }
        })
    }

}