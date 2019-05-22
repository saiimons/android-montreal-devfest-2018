package android.montreal.devfest.stuff.presentation.presenters

import android.montreal.devfest.stuff.usecases.GetRandomStuffException
import android.montreal.devfest.stuff.usecases.ManageRandomStuffUseCase
import android.montreal.devfest.stuff.usecases.RandomStuffData
import android.montreal.devfest.stuff.usecases.SetRandomStuffException

internal class MainPresenterImpl(
        private val view: MainPresenter.MainView,
        private val manageRandomStuff: ManageRandomStuffUseCase
) : MainPresenter {

    override fun onViewReady() {
        try {
            val (text, number) = this.manageRandomStuff.getRandomStuff()
            this.view.showRandomStuff(text!!, number)
        } catch (e: GetRandomStuffException) {
            this.view.showMissingError()
        }

    }

    override fun updateRandomStuff(text: String, number: Int) {
        try {
            this.manageRandomStuff.setRandomStuff(RandomStuffData(text, number))
            this.view.showUpdateSuccess()
        } catch (e: SetRandomStuffException) {
            this.view.showUpdateError()
        }
    }
}
