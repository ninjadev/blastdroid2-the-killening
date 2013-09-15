package org.ninjadev.blast;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;

public class BlastActivity extends Activity implements OnTaskCompleted {
    private ArrayList<Photo> mPhotos;
    private final String TAG = "org.ninjadev.blast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blast);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(getString(R.string.blast_color)));
        getActionBar().setBackgroundDrawable(colorDrawable);

        mPhotos = new ArrayList<Photo>();
        new FetchFeedTask(this, mPhotos).execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.blast, menu);
        return true;
    }

    @Override
    public void onTaskCompleted() {
        Log.d("org.ninjadev.blast", "HOLO YOLO" + mPhotos);
    }
}
