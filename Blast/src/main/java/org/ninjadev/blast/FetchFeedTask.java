package org.ninjadev.blast;

import android.content.Context;
import android.os.AsyncTask;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FetchFeedTask extends AsyncTask<Void, Void, Void> {
    private final OnTaskCompleted mListener;
    private ArrayList<Photo> mPhotos;

    public FetchFeedTask(OnTaskCompleted listener, ArrayList<Photo> mPhotos) {
        this.mListener = listener;
        this.mPhotos = mPhotos;
    }

    @Override
    protected Void doInBackground(Void... params) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        PhotoWrapper photoWrapper = restTemplate.getForObject(((Context) mListener).getString(R.string.api_feed), PhotoWrapper.class);

        HashSet<Photo> photoPool = new HashSet<Photo>();
        photoPool.addAll(mPhotos);
        photoPool.addAll(Arrays.asList(photoWrapper.getPhotos()));

        mPhotos.clear();
        mPhotos.addAll(photoPool);
        Collections.sort(mPhotos, Collections.reverseOrder());

        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        mListener.onTaskCompleted();
    }
}