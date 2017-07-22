package io.rocketapps.apps.android.mystoryapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rocketapps.apps.android.mystoryapp.R
import io.rocketapps.apps.android.mystoryapp.adapters.StoriesRecyclerAdapter
import io.rocketapps.apps.android.mystoryapp.objects.StoryClass

/**
 * Created by macbook on 7/22/17.
 */
class HomeFragment : Fragment() {



    var mHistoryRecyclerView: RecyclerView? = null
    var mLinearLayout: LinearLayoutManager? = null

    lateinit var mHistoryItems: ArrayList<StoryClass>
    lateinit var mAdapter: StoriesRecyclerAdapter
    
    
    companion object Factory {
        fun newInstance(): HomeFragment = HomeFragment()
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

        val view: View = inflater?.inflate(R.layout.fragment_home, container, false) as View

        initView(view)
        return view;
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mHistoryItems = ArrayList<StoryClass>()
        mHistoryItems.add(StoryClass("T lEst jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TE jjst k jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TE st jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TEs kmt jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("T Est jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TEst jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TEs t jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TEs t jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TEs lt jhg", StoryClass.HOME))
        mHistoryItems.add(StoryClass("TEst jhg", StoryClass.HOME))

        mAdapter = StoriesRecyclerAdapter(activity, mHistoryItems)
        mHistoryRecyclerView?.adapter = mAdapter
    }
    
    fun initView (view: View){

        //recycler
        mHistoryRecyclerView = view.findViewById(R.id.recycler) as RecyclerView

        mLinearLayout = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mHistoryRecyclerView?.layoutManager = mLinearLayout



        
    }
}