package com.android.sachin.mvpdesignpattern.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.sachin.mvpdesignpattern.R;

/* View Layer in MVP and this view layer has nothing to do
*  with Model layer ,it is just in communication with Presenter layer which is dealing
*  with Model layer to insert and retrieve the data.
*
*  The View, usually implemented by an Activity, will contain a reference to the presenter. The only thing that
*  the view will do is to call a method from the Presenter every time there is an interface action.
* */
public class MainActivity extends AppCompatActivity implements MainContract.RequiredViewOperations{

    private Button button;
    private TextView textView;
    private MainContract.RequiredPresenterOperations mainPresenter;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.counter);
        mainPresenter = new MainPresenter(this);

        value = mainPresenter.readSharedPref();

        textView.setText(String.valueOf(value));

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                value++;
                textView.setText(String.valueOf(value));
                mainPresenter.writeSharedPref(value);
                showToast("Button Clicked!!");
            }
        });

    }



    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
