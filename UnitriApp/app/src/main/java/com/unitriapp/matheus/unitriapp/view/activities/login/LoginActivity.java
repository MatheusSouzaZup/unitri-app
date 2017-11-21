package com.unitriapp.matheus.unitriapp.view.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.request.SignInRequest;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.presenter.LoginPresenter;
import com.unitriapp.matheus.unitriapp.repository.login.LoginHttpRepository;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Matheus on 15/11/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.et_login_email)
    EditText etLoginEmail;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;
    Unbinder unbinder;
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this, new LoginHttpRepository());

    }


    @Override
    public void showLoading() {
        multiStateLayout.setState(MultiStateLayout.State.LOADING);
    }

    @Override
    public void hideLoading() {
        multiStateLayout.setState(MultiStateLayout.State.CONTENT);
    }

    @Override
    public void showError(ResponseError responseError) {
        multiStateLayout.setState(MultiStateLayout.State.ERROR);
    }

    @Override
    public void showToast(@StringRes int texto) {
        Toast.makeText(getApplicationContext(),texto, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showHome() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void clear() {
        etLoginEmail.setText("");
        etLoginPassword.setText("");
    }

    @OnClick(R.id.signInButton)
    public void onClick() {
        mPresenter.singIn(new SignInRequest(etLoginEmail.getText().toString(),etLoginPassword.getText().toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
