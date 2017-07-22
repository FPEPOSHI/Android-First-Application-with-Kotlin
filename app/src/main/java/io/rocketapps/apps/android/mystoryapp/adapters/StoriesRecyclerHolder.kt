package io.rocketapps.apps.android.mystoryapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import io.rocketapps.apps.android.mystoryapp.R
import io.rocketapps.apps.android.mystoryapp.objects.StoryClass

/**
 * Created by macbook on 7/11/17.
 */
class StoriesRecyclerHolder(view: View, viewType: Int) : RecyclerView.ViewHolder(view) {


    lateinit var txtTitle: TextView

    fun bind(context: Context, story: StoryClass){
        if(story.viewType == StoryClass.POPULAR_SEARCH){

            txtTitle.text = story.title

        }else if(story.viewType == StoryClass.HISTORY_SEARCH){

            txtTitle.text = story.title

        }else if(story.viewType == StoryClass.HOME){

            txtTitle.text = story.title

        }
    }

    init {
        if(viewType == StoryClass.POPULAR_SEARCH){
            txtTitle = view.findViewById(R.id.story_title) as TextView

        }else if(viewType == StoryClass.HISTORY_SEARCH){
            txtTitle = view.findViewById(R.id.story_title) as TextView

        }else if(viewType == StoryClass.HOME){
            txtTitle = view.findViewById(R.id.story_title) as TextView

        }
    }
}