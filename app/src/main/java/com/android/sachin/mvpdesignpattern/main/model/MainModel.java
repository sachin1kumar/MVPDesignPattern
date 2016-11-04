package com.android.sachin.mvpdesignpattern.main.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.sachin.mvpdesignpattern.main.MainContract;

/**
 * Created by sachin.
 */

//In an application with a good layered architecture,
// this model would only be the gateway to the domain layer or business logic.
// See it as the provider of the data we want to display in the view.

//The code of Model is pure JAVA code.
public class MainModel implements MainContract.RequiredModelOperations {

    private Context context;

    public MainModel(Context context) {
        this.context = context;
    }

    @Override
    public void insertData(int counter) {

        SharedPreferences preferences = context.getSharedPreferences("Counter",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("VALUE",counter);
        editor.commit();

    }

    @Override
    public int getData() {

        SharedPreferences preferences = context.getSharedPreferences("Counter",Context.MODE_PRIVATE);
        return preferences.getInt("VALUE",0);

    }

}
