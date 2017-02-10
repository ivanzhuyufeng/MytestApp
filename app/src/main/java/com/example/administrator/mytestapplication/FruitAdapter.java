package com.example.administrator.mytestapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int ResourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> object){
        super(context, textViewResourceId, object);
        ResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view ;
        ViewHolder viewHolder = null;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(ResourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.fruitname = (TextView)view.findViewById(R.id.Tex_fruit);
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.img_fruit);
            view.setTag(viewHolder);
        }
        else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitname.setText(fruit.getName());
        return view;
    }

    static private class ViewHolder{
        TextView fruitname;
        ImageView   fruitImage;
    }
}
