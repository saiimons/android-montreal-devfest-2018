package android.montreal.devfest.presentation.presenters;

import android.montreal.devfest.presentation.navigation.Navigator;
import android.montreal.devfest.stuff.usescases.GetRandomStuffException;
import android.montreal.devfest.stuff.usescases.ManageRandomStuffUseCase;
import android.montreal.devfest.stuff.usescases.RandomStuffData;
import android.montreal.devfest.stuff.usescases.SetRandomStuffException;

class MainPresenterImpl implements MainPresenter {
    private final MainPresenter.MainView view;
    private final ManageRandomStuffUseCase manageRandomStuff;
    private Navigator.ViewMore viewMore;

    public MainPresenterImpl(
            MainView view,
            ManageRandomStuffUseCase manageRandomStuff,
            Navigator.ViewMore viewMore
    ) {
        this.view = view;
        this.manageRandomStuff = manageRandomStuff;
        this.viewMore = viewMore;
    }

    @Override
    public void onViewReady() {
        try {
            final RandomStuffData data = this.manageRandomStuff.getRandomStuff();
            this.view.showRandomStuff(data.text, data.number);
        } catch (GetRandomStuffException e) {
            this.view.showMissingError();
        }
    }

    @Override
    public void updateRandomStuff(String text, int value) {
        try {
            this.manageRandomStuff.setRandomStuff(new RandomStuffData(text, value));
            this.view.showUpdateSuccess();
        } catch (SetRandomStuffException e) {
            this.view.showUpdateError();
        }
    }

    @Override
    public void openViewMoreLink() {
        viewMore.showViewMore();
    }
}
