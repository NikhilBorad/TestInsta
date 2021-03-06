package com.test.testinsta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.test.testinsta.R;
import com.test.testinsta.model.GalleryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil-PC on 20/12/17.
 */

public class MyGridListAdapter extends BaseAdapter {
    private List<GalleryModel> galleryModelArrayList;
    private LayoutInflater inflater;
    private Context mContext;

    public MyGridListAdapter(Context context, List<GalleryModel> galleryModelArrayList) {
        mContext = context;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.galleryModelArrayList = galleryModelArrayList;
//        this.imageLoader = new ImageLoader(context);
    }

    @Override
    public int getCount() {
        return galleryModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.photos_list_view, null);
        Holder holder = new Holder();
        holder.ivPhoto = (ImageView) view.findViewById(R.id.ivImage);

        Glide.with(mContext)
                .load(galleryModelArrayList.get(position).getImgThumb())
                .into(holder.ivPhoto);

        return view;
    }

    private class Holder {
        private ImageView ivPhoto;
    }

}
