package android.montreal.devfest.stuff.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import android.montreal.devfest.stuff.presentation.activities.AboutActivity;
import android.net.Uri;

class AppNavigatorImpl implements AppNavigator {

    AppNavigatorImpl() {

    }

    public void showViewMore(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override
    public void showWebsite(Context context) {
        final Intent  i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://devfest2018.android-montreal.com/"));
        context.startActivity(i);
    }
}
