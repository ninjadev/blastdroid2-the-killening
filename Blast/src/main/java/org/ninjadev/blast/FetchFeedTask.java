package org.ninjadev.blast;

import android.content.Context;
import android.os.AsyncTask;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class FetchFeedTask extends AsyncTask<Void, Void, Void> {
    private final OnTaskCompleted mListener;
    private final ArrayList<Photo> mPhotos;

    public FetchFeedTask(OnTaskCompleted listener, ArrayList<Photo> mPhotos) {
        this.mListener = listener;
        this.mPhotos = mPhotos;
    }

    @Override
    protected Void doInBackground(Void... params) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        PhotoWrapper photoWrapper = restTemplate.getForObject(((Context) mListener).getString(R.string.api_feed), PhotoWrapper.class);

        for (int i=0; i<photoWrapper.getPhotos().length; i++) {
            mPhotos.add(photoWrapper.getPhotos()[i]);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        mListener.onTaskCompleted();
    }
}