package android.montreal.devfest.stuff.presentation.presenters

interface MainPresenter {
    fun onViewReady()

    fun updateRandomStuff(text: String, number: Int)

    interface MainView {
        fun showRandomStuff(text: String, number: Int)

        fun showUpdateSuccess()

        fun showMissingError()

        fun showUpdateError()
    }
}
