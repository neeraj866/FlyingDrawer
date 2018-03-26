package com;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

import com.sliding2.R;


/**
 * @author Lakhwinder Singh
 *         This class is a main dashboard class which holds all the
 *         fragments(Show all sns on dashboard fragment and other individual
 *         fragments (Individual SNS fragments and leaderboard ,profile,offers
 *         )). It also holds the fuctionality of Connekd Button.
 */
public class DashboardActivity extends FragmentActivity implements
        OnClickListener {
    public DrawerLayout drawer;
    private Button openDrawer, rightDrawer;
    private FrameLayout circularMenu;
    private FoldingLayout mFoldLayout;
    private float factor;
    // FRAGMENTS
    private Dashboard dashboard_fragment;


    public static final boolean IS_JBMR2 = Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rightDrawer = (Button) findViewById(R.id.rightDrawer);
        circularMenu = (FrameLayout) findViewById(R.id.circularMenu);
        circularMenu.setVisibility(View.GONE);
        rightDrawer.setOnClickListener(this);
        dashboard_fragment = new Dashboard();
        mFoldLayout = (FoldingLayout) findViewById(R.id.main_fold);
        mFoldLayout.setBackgroundColor(Color.WHITE);
        mFoldLayout.setNumberOfFolds(4);
        mFoldLayout.setFoldListener(mOnFoldListener);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setOnClickListener(this);
        drawer.setScrimColor(Color.TRANSPARENT);
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onDrawerSlide(View v, float fl) {
                // TODO Auto-generated method stub

                if (v.getId() == R.id.left_drawer) {
                    mFoldLayout.setAnchorFactor(1.0f);
                    factor = (55.5f / 100f) * fl;
                    mFoldLayout.setFoldFactor(factor);
                } else {
                    mFoldLayout.setAnchorFactor(0);
                    factor = (22.5f / 100f) * fl;
                    mFoldLayout.setFoldFactor(factor);
                }
            }

            @Override
            public void onDrawerClosed(View arg0) {


            }

            @Override
            public void onDrawerOpened(View arg0) {
                // TODO Auto-generated method stub
            }

        });

        openDrawer = (Button) findViewById(R.id.openDrawer);
        openDrawer.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_container, dashboard_fragment).commit();

    }

    private OnFoldListener mOnFoldListener = new OnFoldListener() {
        @Override
        public void onStartFold() {
        }

        @Override
        public void onEndFold() {
        }
    };

    public DrawerLayout getDrawer() {
        if (drawer != null) {
            return drawer;
        }
        return null;
    }

    @SuppressLint("InlinedApi")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.openDrawer:
                // drawer.set
                drawer.openDrawer(Gravity.START);
                break;

            case R.id.rightDrawer:
                drawer.openDrawer(Gravity.END);
                break;

        }

    }
}
