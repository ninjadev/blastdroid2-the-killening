package org.ninjadev.blast;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by aleksanb on 9/17/13.
 */
public class PhotoListAdapter extends BaseAdapter {
    private final ArrayList<Photo> mPhotos;
    private final Context mCtx;
    private LayoutInflater inflater = null;
    private static ImageLoader mImageLoader = ImageLoader.getInstance();

    public PhotoListAdapter(Context ctx, ArrayList<Photo> photos) {
        this.mCtx = ctx;
        this.mPhotos = photos;
        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mPhotos.size();
    }

    @Override
    public Photo getItem(int position) {
        return mPhotos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.photo_element, null);
        }

        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.iv_photo);
        ivPhoto.setMaxHeight(getItem(position).getHeight());
        mImageLoader.displayImage(
                mCtx.getString(R.string.api_uploads) + getItem(position).getPictureUrl(),
                ivPhoto);

        return convertView;
    }
}
