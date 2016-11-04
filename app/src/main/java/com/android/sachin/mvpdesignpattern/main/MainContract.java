package com.android.sachin.mvpdesignpattern.main;

/**
 * Created by sachin .
 * Aggregates all communication operations between MVP pattern layer:
 * Model, View and Presenter.
 *
 */

public interface MainContract {

    /**
     * View mandatory methods.
     */
    interface RequiredViewOperations{
        void showToast(String msg);
    }

    /**
     * Presenter mandatory methods.
     */
    interface RequiredPresenterOperations{
         int readSharedPref();
         void writeSharedPref(int value);
         void onError(String errorMsg);
         void onSuccess(String successMsg);
    }

    /**
     * Model mandatory methods.
     */
    interface RequiredModelOperations{
         void insertData(int counter);
         int getData();
    }
}
