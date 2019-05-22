package android.montreal.devfest.stuff.presentation.navigation

import android.content.Context

internal class NavigatorWrapper(private val context: Context, private val navigator: AppNavigator) : Navigator.ViewMore, Navigator.Website {

    override fun showViewMore() {
        this.navigator.showViewMore(context)
    }

    override fun showWebsite() {
        this.navigator.showWebsite(context)
    }
}
