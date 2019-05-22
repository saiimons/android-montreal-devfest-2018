package android.montreal.devfest.stuff.presentation.activities

import android.content.Intent
import android.montreal.devfest.stuff.presentation.R
import android.montreal.devfest.stuff.presentation.navigation.AppNavigator
import android.montreal.devfest.stuff.presentation.navigation.Navigator
import android.montreal.devfest.stuff.presentation.presenters.MainPresenter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.MainView {
    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var navigator: AppNavigator

    @Inject
    lateinit var viewMore: Navigator.ViewMore

    private var submit: Button? = null
    private var about: Button? = null
    private var textField: EditText? = null
    private var numberField: EditText? = null

    private var container: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textField = findViewById(R.id.stuff_text)
        numberField = findViewById(R.id.stuff_number)

        submit = findViewById(R.id.submit)
        submit!!.setOnClickListener { submit() }

        about = findViewById(R.id.about_btn)
        about!!.setOnClickListener { showViewMore() }

        container = findViewById(R.id.container)

        presenter.onViewReady()
    }

    private fun submit() {
        presenter.updateRandomStuff(
                textField!!.text.toString(),
                Integer.parseInt(numberField!!.text.toString())
        )
    }

    override fun showRandomStuff(text: String?, number: Int) {
        textField!!.setText(text)
        numberField!!.setText(String.format(Locale.getDefault(), "%d", number))
    }

    override fun showUpdateSuccess() {
        Snackbar.make(container!!, R.string.success_updating_stuff, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMissingError() {
        Snackbar.make(container!!, R.string.error_missing_stuff, Snackbar.LENGTH_SHORT).show()
    }

    override fun showUpdateError() {
        Snackbar.make(container!!, R.string.error_updating_stuff, Snackbar.LENGTH_SHORT).show()
    }

    private fun showViewMore() {
        startActivity(Intent(this, AboutActivity::class.java))
        //navigator.showViewMore(this)
        //viewMore.showViewMore()
    }
}
