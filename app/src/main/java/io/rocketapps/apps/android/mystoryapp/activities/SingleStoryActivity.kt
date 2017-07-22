package io.rocketapps.apps.android.mystoryapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import io.rocketapps.apps.android.mystoryapp.R


class SingleStoryActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var firstLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_story)

        toolbar = findViewById(R.id.toolbar) as Toolbar
        firstLayout = findViewById(R.id.layout_first) as View
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setHomeButtonEnabled(true)


        title = ""

        val params = firstLayout.layoutParams
        params.height = (getHeight() - convertDpToPixel(56F, applicationContext)).toInt()
        firstLayout.layoutParams = params
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.single_story_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun getHeight(): Int {

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
//        val width = displayMetrics.widthPixels
        return height
//        return convertPixelsToDp(height, applicationContext)
    }

    fun convertPixelsToDp(px: Int, context: Context): Float {
        val resources = context.getResources()
        val metrics = resources.getDisplayMetrics()
        val dp = px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        return dp
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        val px = dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        return px
    }


}
