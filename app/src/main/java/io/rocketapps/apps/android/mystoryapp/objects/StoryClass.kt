package io.rocketapps.apps.android.mystoryapp.objects

/**
 * Created by macbook on 7/11/17.
 */
class StoryClass {

    var title : String get
    lateinit var image: String get

    var viewType: Int get

    companion object {
        const val POPULAR_SEARCH: Int = 100
        const val HISTORY_SEARCH: Int = 110
        const val HOME: Int = 120
    }



    constructor(title: String, image: String, viewType: Int) {
        this.title = title
        this.image = image
        this.viewType = viewType
    }

    constructor(title: String, viewType: Int) {
        this.title = title
        this.viewType = viewType
    }


}