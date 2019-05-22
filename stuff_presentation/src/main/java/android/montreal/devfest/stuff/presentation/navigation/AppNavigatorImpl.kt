package android.montreal.devfest.stuff.presentation.navigation

import android.content.Context
import android.content.Intent
import android.montreal.devfest.stuff.presentation.activities.AboutActivity
import android.net.Uri

internal class AppNavigatorImpl : AppNavigator {

    override fun showViewMore(context: Context) {
        context.startActivity(Intent(context, AboutActivity::class.java))
    }

    override fun showWebsite(context: Context) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse("http://devfest2018.android-montreal.com/")
        context.startActivity(i)
    }
}
