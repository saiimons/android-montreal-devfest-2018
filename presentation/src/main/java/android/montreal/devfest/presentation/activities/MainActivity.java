package android.montreal.devfest.presentation.activities;

import android.content.Intent;
import android.montreal.devfest.presentation.R;
import android.montreal.devfest.presentation.navigation.Navigator;
import android.montreal.devfest.presentation.presenters.MainPresenter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity
        implements MainPresenter.MainView, Navigator.ViewMore {
    @Inject
    MainPresenter presenter;

    private Button submit;
    private Button about;
    private EditText textField;
    private EditText numberField;

    private View container;

    //@Inject
    //AppNavigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = findViewById(R.id.stuff_text);
        numberField = findViewById(R.id.stuff_number);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener((v) -> submit());

        about = findViewById(R.id.about_btn);
        about.setOnClickListener((v) -> presenter.openViewMoreLink());

        container = findViewById(R.id.container);

        presenter.onViewReady();
    }

    private void submit() {
        presenter.updateRandomStuff(
                textField.getText().toString(),
                Integer.parseInt(numberField.getText().toString())
        );
    }

    @Override
    public void showRandomStuff(String text, int number) {
        textField.setText(text);
        numberField.setText(String.format(Locale.getDefault(), "%d", number));
    }

    @Override
    public void showUpdateSuccess() {
        Snackbar.make(container, R.string.success_updating_stuff, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showMissingError() {
        Snackbar.make(container, R.string.error_missing_stuff, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showUpdateError() {
        Snackbar.make(container, R.string.error_updating_stuff, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showViewMore() {
        startActivity(new Intent(this, AboutActivity.class));
        //navigator.showViewMore(this);
    }
}
