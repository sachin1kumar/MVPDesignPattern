package com.android.sachin.mvpdesignpattern.main;

import android.content.Context;
import com.android.sachin.mvpdesignpattern.main.model.MainModel;

/**
 * Created by sachin.
 */

//The Presenter is responsible to act as the middle man between View and Model.
// It retrieves data from the Model and returns it formatted to the View. But unlike the typical MVC,
// it also decides what happens when you interact with the View.

//The code of Presenter is pure JAVA code.
public class MainPresenter implements MainContract.RequiredPresenterOperations {

    private Context context;
    private MainModel mainModel;

    public MainPresenter(Context context) {

         this.context = context;
         this.mainModel = new MainModel(context);
    }

    @Override
    public int readSharedPref() {
        return mainModel.getData();
    }

    @Override
    public void writeSharedPref(int value) {
        mainModel.insertData(value);
    }

    @Override
    public void onError(String errorMsg) {

    }

    @Override
    public void onSuccess(String successMsg) {

    }
}
