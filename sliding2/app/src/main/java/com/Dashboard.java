package com;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sliding2.R;

public class Dashboard extends Fragment implements AbsListView.OnScrollListener,
        AdapterView.OnItemClickListener {
    public ListView feeds;
    private ProgressBar bar;
    private TextView infoText;
    private boolean isYoutbeConnected, isInstagramConnected,
            isLinkedinConnected, isTwitterConnected, isFacebookConnected,
            isFlickrConnected;
    private boolean isInstagramLoaded = false;
    private boolean isTwitterLoaded = false;
    private boolean isLinkedInLoaded = false;
    private boolean isFacebookLoaded = false;
    private boolean isFlickrLoaded = false;
    private ProgressBar mFooterView;


    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater
                .inflate(R.layout.fragment_dashboard, container, false);
        bar = (ProgressBar) v.findViewById(R.id.bar);
        infoText = (TextView) v.findViewById(R.id.infoText);
        if (isFacebookConnected || isInstagramConnected || isLinkedinConnected
                || isTwitterConnected || isYoutbeConnected) {
            infoText.setVisibility(View.GONE);
            bar.setVisibility(View.VISIBLE);
        } else {
            infoText.setVisibility(View.VISIBLE);
            bar.setVisibility(View.GONE);
        }

        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT, 100);
        mFooterView = new ProgressBar(getActivity());
        mFooterView.setBackgroundColor(Color.TRANSPARENT);
        mFooterView.setLayoutParams(lp);
        feeds = (ListView) v.findViewById(R.id.feedlist);
        feeds.setOnScrollListener(this);
        feeds.setOnItemClickListener(this);

        return v;
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        int threshold = 1;
        int count = feeds.getCount();
        if (scrollState == SCROLL_STATE_IDLE) {

        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

    }

}
