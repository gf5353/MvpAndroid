package org.gf535.mvpandroid.core;

import android.util.Log;

import org.gf535.mvpandroid.presenter.action.I_UserPresenter;


/**
 * Created by gf535 on 2016/3/20 0020.
 */
public class CorePresenter {
    protected String TAG = getClass().getSimpleName();

    protected void log(String msg) {
        Log.d(TAG, msg);
    }


    public void addListener(PresenterListener listener) {
    }

    protected void removeAllListener() {
    }

    public void release() {
        removeAllListener();
    }

}
