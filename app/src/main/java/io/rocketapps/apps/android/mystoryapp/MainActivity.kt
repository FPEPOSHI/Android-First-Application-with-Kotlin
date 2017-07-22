package io.rocketapps.apps.android.mystoryapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import io.rocketapps.apps.android.mystoryapp.fragments.HomeFragment
import io.rocketapps.apps.android.mystoryapp.fragments.SearchStoryFragment

class MainActivity : AppCompatActivity() {


    private var fragment: Fragment? = null
    private var searchFragment: SearchStoryFragment? = null
    private var homeFragment: HomeFragment? = null
    private var fragmentManager: FragmentManager? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance()
                }
                fragment = homeFragment
            }
            R.id.navigation_dashboard -> {
                if (searchFragment == null) {
                    searchFragment = SearchStoryFragment.newInstance()
                }
                fragment = searchFragment
            }
        }
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.content, fragment).commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_main)


        fragmentManager = supportFragmentManager

        homeFragment = HomeFragment.newInstance()
        fragment = homeFragment
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.content, fragment).commit()

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


}
