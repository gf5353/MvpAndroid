package org.gf535.mvpandroid.presenter;

import org.gf535.mvpandroid.core.CorePresenter;
import org.gf535.mvpandroid.core.PresenterListener;
import org.gf535.mvpandroid.presenter.action.I_UserPresenter;

/**
 * Created by gf535 on 2016/3/20 0020.
 */
public class UserPresenter extends CorePresenter implements I_UserPresenter {

    private OnGetUserInfoListener onGetUserInfoListener;
    private OnSubListener onSubListener;

    @Override
    public void login() {
        log("login");
    }

    @Override
    public void getInfo() {//可以根据不同的需求是读缓存还是网络，走不同的逻辑
        log("getinfo");
        if (onGetUserInfoListener != null) {
            onGetUserInfoListener.onGetUserInfo("test infos");
        }
    }

    @Override
    public void subUser(String roomId) {
        if (onSubListener != null) {
            //这里处理订阅的操作..省略
            log("subUser");

            onSubListener.onSubChange(true);
        }
    }


    @Override
    public void unSubUser(String roomId) {
        if (onSubListener != null) {
            //这里处理取消订阅的操作..省略

            log("unSubUser");
            onSubListener.onSubChange(false);
        }
    }

    @Override
    public void addListener(PresenterListener listener) {
        super.addListener(listener);
        if (listener instanceof OnGetUserInfoListener) {
            this.onGetUserInfoListener = (OnGetUserInfoListener) listener;
        } else if (listener instanceof OnSubListener) {
            this.onSubListener = (OnSubListener) listener;
        }

    }
}
