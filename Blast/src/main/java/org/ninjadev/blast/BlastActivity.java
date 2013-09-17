package org.ninjadev.blast;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import uk.co.senab.actionbarpulltorefresh.library.DefaultHeaderTransformer;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

public class BlastActivity extends Activity
        implements PullToRefreshAttacher.OnRefreshListener, OnTaskCompleted {
    private ArrayList<Photo> mPhotos;
    private PhotoListAdapter mPhotoListAdapter;
    private PullToRefreshAttacher mPullToRefreshAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blast);

        // Set actionbar color
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.app_color));
        getActionBar().setBackgroundDrawable(colorDrawable);

        // Instantiate ImageLoader
        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration.Builder(getApplicationContext())
                .build();
        ImageLoader.getInstance().init(config);

        // Initiate listView and bind adapter
        mPhotos = new ArrayList<Photo>();
        ListView mPhotosListView = (ListView) findViewById(R.id.lv_photos);
        mPhotoListAdapter = new PhotoListAdapter(this, mPhotos);
        mPhotosListView.setAdapter(mPhotoListAdapter);

        // Initialize the pullToRefreshAttacher
        mPullToRefreshAttacher = PullToRefreshAttacher.get(this);
        PullToRefreshLayout ptrLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);
        ptrLayout.setPullToRefreshAttacher(mPullToRefreshAttacher, this);

        // Initialize headerTransformer
        DefaultHeaderTransformer ht = (DefaultHeaderTransformer) mPullToRefreshAttacher.getHeaderTransformer();
        ht.setPullText(getString(R.string.ptrf_pull));
        ht.setRefreshingText(getString(R.string.ptrf_refreshing));
        ht.setProgressBarColor(getResources().getColor(R.color.app_color));

        // Fetch photos from the blast servers
        new FetchFeedTask(this, mPhotos).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.blast, menu);
        return true;
    }

    @Override
    public void onTaskCompleted() {
        mPullToRefreshAttacher.setRefreshComplete();
        mPhotoListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onRefreshStarted(View view) {
        new FetchFeedTask(this, mPhotos).execute();
    }
}
