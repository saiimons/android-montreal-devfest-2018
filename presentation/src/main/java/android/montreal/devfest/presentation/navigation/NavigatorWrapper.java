package android.montreal.devfest.presentation.navigation;

import android.content.Context;

class NavigatorWrapper implements Navigator.ViewMore, Navigator.Website {

    private final Context context;
    private final AppNavigator navigator;

    NavigatorWrapper(Context context, AppNavigator navigator) {
        this.context = context;
        this.navigator = navigator;
    }

    @Override
    public void showViewMore() {
        this.navigator.showViewMore(context);
    }

    @Override
    public void showWebsite() {
        this.navigator.showWebsite(context);
    }
}
