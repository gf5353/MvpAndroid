package org.gf535.mvpandroid.presenter.action;

import org.gf535.mvpandroid.core.PresenterListener;

import java.util.Objects;

/**
 * 定义些给View操作的方法
 * View->Presenter   进行通信
 */
public interface I_UserPresenter {

    void login();

    void getInfo();

    interface OnGetUserInfoListener extends PresenterListener {
        void onGetUserInfo(Object info);
    }


    /**
     * 向Presenter触发业务操作
     *
     * @param roomId
     */
    void subUser(String roomId);

    void unSubUser(String roomId);

    /**
     * 向View通知状态
     */
    interface OnSubListener extends PresenterListener {
        /**
         * 返回订阅状态
         *
         * @param isSub
         */
        void onSubChange(boolean isSub);

    }

}
