package io.rocketapps.apps.android.mystoryapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import io.rocketapps.apps.android.mystoryapp.R
import io.rocketapps.apps.android.mystoryapp.adapters.StoriesRecyclerAdapter
import io.rocketapps.apps.android.mystoryapp.design.GridAutofitLayoutManager
import io.rocketapps.apps.android.mystoryapp.objects.StoryClass
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IRowBreaker
import android.view.Gravity
import com.beloo.widget.chipslayoutmanager.SpacingItemDecoration
import com.beloo.widget.chipslayoutmanager.gravity.IChildGravityResolver



/**
 * Created by macbook on 7/10/17.
 */
class SearchStoryFragment : Fragment() {


    var mPopularRecyclerView: RecyclerView? = null
    var mHistoryRecyclerView: RecyclerView? = null
    var mLinearLayout: LinearLayoutManager? = null

    lateinit var mPopularItems: ArrayList<StoryClass>
    lateinit var mHistoryItems: ArrayList<StoryClass>
    lateinit var mAdapter: StoriesRecyclerAdapter
    lateinit var mAdapterHistory: StoriesRecyclerAdapter

    companion object Factory {
        fun newInstance(): SearchStoryFragment = SearchStoryFragment()
    }



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater?.inflate(R.layout.fragment_search, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mPopularItems = ArrayList<StoryClass>()
        mPopularItems.add(StoryClass("TEst jhg","fdsfds", StoryClass.POPULAR_SEARCH))
        mPopularItems.add(StoryClass("TEst jhg","fdsfds", StoryClass.POPULAR_SEARCH))
        mPopularItems.add(StoryClass("TEst jhg","fdsfds", StoryClass.POPULAR_SEARCH))
        mPopularItems.add(StoryClass("TEst jhg","fdsfds", StoryClass.POPULAR_SEARCH))
        mPopularItems.add(StoryClass("TEst jhg","fdsfds", StoryClass.POPULAR_SEARCH))
        mPopularItems.add(StoryClass("TEst jhg","fdsfds", StoryClass.POPULAR_SEARCH))

        mHistoryItems = ArrayList<StoryClass>()
        mHistoryItems.add(StoryClass("T lEst jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TE jjst k jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TE st jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TEs kmt jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("T Est jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TEst jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TEs t jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TEs t jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TEs lt jhg", StoryClass.HISTORY_SEARCH))
        mHistoryItems.add(StoryClass("TEst jhg", StoryClass.HISTORY_SEARCH))

        mAdapter = StoriesRecyclerAdapter(activity, mPopularItems)
        mPopularRecyclerView?.adapter = mAdapter


        mAdapterHistory = StoriesRecyclerAdapter(activity, mHistoryItems)
        mHistoryRecyclerView?.adapter = mAdapterHistory
    }


    fun initView( view : View?){

        mPopularRecyclerView = view?.findViewById(R.id.recycler_popular_search) as RecyclerView
        mHistoryRecyclerView = view.findViewById(R.id.recycler_history_search) as RecyclerView
        mHistoryRecyclerView!!.setHasFixedSize(true)
        mLinearLayout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mPopularRecyclerView?.layoutManager = mLinearLayout

        val chipsLayoutManager = ChipsLayoutManager.newBuilder(activity)
                //set vertical gravity for all items in a row. Default = Gravity.CENTER_VERTICAL
                .setChildGravity(Gravity.LEFT)
                //whether RecyclerView can scroll. TRUE by default
                .setScrollingEnabled(true)
                //set maximum views count in a particular row
                .setMaxViewsInRow(4)
                //set gravity resolver where you can determine gravity for item in position.
                //This method have priority over previous one
                .setGravityResolver { Gravity.LEFT }
                //you are able to break row due to your conditions. Row breaker should return true for that views
//                .setRowBreaker { position -> position == 6 || position == 11 || position == 2 }
                //a layoutOrientation of layout manager, could be VERTICAL OR HORIZONTAL. HORIZONTAL by default
                .setOrientation(ChipsLayoutManager.HORIZONTAL)
                // row strategy for views in completed row, could be STRATEGY_DEFAULT, STRATEGY_FILL_VIEW,
                //STRATEGY_FILL_SPACE or STRATEGY_CENTER
                .setRowStrategy(ChipsLayoutManager.HORIZONTAL)
                // whether strategy is applied to last row. FALSE by default
                .withLastRow(true)
                .build()

        mHistoryRecyclerView!!.addItemDecoration( SpacingItemDecoration(resources.getDimensionPixelOffset(R.dimen.item_space),
                resources.getDimensionPixelOffset(R.dimen.item_space)))
        mHistoryRecyclerView?.layoutManager = chipsLayoutManager






    }





}