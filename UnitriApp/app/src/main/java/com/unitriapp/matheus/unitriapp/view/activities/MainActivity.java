package com.unitriapp.matheus.unitriapp.view.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.view.activities.login.LoginActivity;
import com.unitriapp.matheus.unitriapp.view.fragments.TransactionAvaliacaoFragment;
import com.unitriapp.matheus.unitriapp.view.fragments.chamada.ChamadaFragment;
import com.unitriapp.matheus.unitriapp.view.fragments.home.HomeFragment;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    public static Toolbar toolbar;
    public static TextView toolbarTitle;
    @BindView(R.id.toolbar_bottom)
    BottomNavigationView toolbarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpToolbars();
        replaceFragment(HomeFragment.newInstance());
    }

    private void setUpToolbars() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("");
        toolbarBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home:
                        replaceFragment(HomeFragment.newInstance());
                        break;

                    case R.id.notas:
                       // getMatter();
                        //replaceFragment(ShopFragment.newInstance());
                       replaceFragment(TransactionAvaliacaoFragment.newInstance("5a104979e225fc1a78c016e4"));
                        break;

                    case R.id.chamada:
                      //  getMatter();
                        replaceFragment(ChamadaFragment.newInstance("5a104979e225fc1a78c016e4"));
                        break;

                    case R.id.sair:
                        signOut();
                      break;

                    default:
                        replaceFragment(HomeFragment.newInstance());
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
        ft.replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();

    }
    private void signOut() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.msg_logout)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }


}
