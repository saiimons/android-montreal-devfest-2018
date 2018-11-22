package android.montreal.devfest.presentation.presenters;

public interface MainPresenter {
    void onViewReady();

    void updateRandomStuff(String text, int number);

    void openViewMoreLink();

    interface MainView {
        void showRandomStuff(String text, int number);

        void showUpdateSuccess();

        void showMissingError();

        void showUpdateError();
    }
}
