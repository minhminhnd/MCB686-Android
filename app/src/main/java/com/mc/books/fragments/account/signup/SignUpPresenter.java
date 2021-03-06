package com.mc.books.fragments.account.signup;

import android.os.Handler;
import android.util.Log;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;


public class SignUpPresenter<V extends ISignUpView> extends BaseDataPresenter<V> implements ISignUpPresenter<V> {

    public SignUpPresenter(AppComponent appComponent) {
        super(appComponent);
    }

    @Override
    public void onSignUp(String userName, String password) {
        getOptView().doIfPresent(v -> v.showLoading(true));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userName.isEmpty()) {
                    Log.e("DashboardPresenter", "userName");
                    getOptView().doIfPresent(ISignUpView::onEmptyUsername);
                    getOptView().doIfPresent(v -> v.showLoading(false));
                } else if (password.isEmpty()) {
                    Log.e("password", "userName");
                    getOptView().doIfPresent(ISignUpView::onEmptyPassword);
                    getOptView().doIfPresent(v -> v.showLoading(false));
                } else {
                    Log.e("DashboardPresenter", "else");
                    getOptView().doIfPresent(v -> v.onSignUpSuccess());
                    getOptView().doIfPresent(v -> v.showLoading(false));
                }
            }
        }, 2000);
    }
}
