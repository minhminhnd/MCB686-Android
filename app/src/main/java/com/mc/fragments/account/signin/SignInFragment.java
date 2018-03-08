package com.mc.fragments.account.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;

/**
 * Created by dangpp on 3/1/2018.
 */

public class SignInFragment extends BaseMvpFragment<ISignInView, ISignInPresenter<ISignInView>> implements ISignInView {
    @Override
    public ISignInPresenter<ISignInView> createPresenter() {
        return new SignInPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.sign_in_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onSignIn();
    }

    @Override
    public void showLoading(boolean isLoading) {
        showProgress(isLoading);
    }
}