package com.capsule.vpf.frag;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import capsule.bamboo.Logger;
import com.capsule.vpf.R;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/30.
 */

public class FragActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("Activity --> onCreate");
        setContentView(R.layout.activity_frag);

        toolbar = findViewById(R.id.toolbar);
        if (null != toolbar) {
            setSupportActionBar(toolbar);
            if (toolbar.getNavigationIcon() == null) {
                return;
            }
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override protected void onRestart() {
        super.onRestart();
        Logger.i("Activity --> onRestart");
    }

    @Override protected void onStart() {
        super.onStart();
        Logger.i("Activity --> onStart");
    }

    @Override protected void onResume() {
        super.onResume();
        Logger.i("Activity --> onResume");
    }

    @Override protected void onPause() {
        super.onPause();
        Logger.i("Activity --> onPause");
    }

    @Override protected void onStop() {
        super.onStop();
        Logger.i("Activity --> onStop");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Logger.i("Activity --> onDestroy");
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        Logger.v("Activity --> onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.frag_activity, menu);
        return true;
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.w("Activity --> onSaveInstanceState");
    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.w("Activity --> onRestoreInstanceState");
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Logger.w("Activity --> onConfigurationChanged");
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (item.getItemId()) {
            case R.id.add:
                fragment = SingleFragment.newInstance(getCurrentTime(System.currentTimeMillis()));
                transaction.add(R.id.fragment_container, fragment, "single");
                break;
            case R.id.remove:
                fragment = fm.findFragmentByTag("single");
                if (fragment == null) {
                    return true;
                }
                transaction.remove(fragment);
                break;
            case R.id.replace:
                break;
            case R.id.show:
                fragment = fm.findFragmentByTag("single");
                if (fragment == null) {
                    return true;
                }
                transaction.show(fragment);
                break;
            case R.id.hide:
                fragment = fm.findFragmentByTag("single");
                if (fragment == null) {
                    return true;
                }
                transaction.hide(fragment);
                break;
        }
        transaction.commit();
        return true;
    }

    private String getCurrentTime(long stamp) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //long lt = Long.valueOf(stamp);
        Date date = new Date(stamp);
        res = simpleDateFormat.format(date);
        return res;
    }
}
