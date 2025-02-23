package com.timedancing.easyfirewall.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.timedancing.easyfirewall.R;
import com.timedancing.easyfirewall.util.PhoneStateUtil;

/**
 * Created by zengzheying on 16/1/20.
 */
public class AboutActivity extends AppCompatActivity {

    private TextView mTVVersion;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        mTVVersion = (TextView) findViewById(R.id.tv_version);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setUpViews();
    }


    private void setUpViews() {
        mTVVersion.setText(getString(R.string.about_version, PhoneStateUtil.getVersionName(this)));
        mToolbar.setNavigationIcon(R.drawable.back);
        mToolbar.setTitle(R.string.setting_about);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
