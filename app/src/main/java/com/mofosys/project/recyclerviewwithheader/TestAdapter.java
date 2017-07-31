package com.mofosys.project.recyclerviewwithheader;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by girish on 31/7/17.
 */

public class TestAdapter extends BaseAdapter {
    private ArrayList<Object> personArray;
    private LayoutInflater inflater;
    private static final int TYPE_PERSON = 0;
    private static final int TYPE_DIVIDER = 1;
    private Activity activity;

    public TestAdapter(Activity context, ArrayList<Object> personArray) {
        this.personArray = personArray;
        this.activity = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return personArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return personArray.get(position);
    }

    @Override
    public int getViewTypeCount() {
        // TYPE_PERSON and TYPE_DIVIDER
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof TestModel) {
            return TYPE_PERSON;
        }
        return TYPE_DIVIDER;
    }

    @Override
    public boolean isEnabled(int position) {
        return (getItemViewType(position) == TYPE_PERSON);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_PERSON:
                    convertView = inflater.inflate(R.layout.row_item, parent, false);
                    break;
                case TYPE_DIVIDER:
                    convertView = inflater.inflate(R.layout.row_header, parent, false);
                    break;
            }
        }

        switch (type) {
            case TYPE_PERSON:
                TestModel testModel = (TestModel) getItem(position);
                TextView name = (TextView) convertView.findViewById(R.id.nameLabel);
                TextView address = (TextView) convertView.findViewById(R.id.addressLabel);
                name.setText(testModel.getProduct_name());
                address.setText(testModel.getProduct_ref_number());
                TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);
                TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);

                /*CardView cardView = (CardView) convertView.findViewById(R.id.card_view);

                int[] androidColors = activity.getResources().getIntArray(R.array.androidcolors);
                int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
                cardView.setCardBackgroundColor(randomAndroidColor);*/

                textView1.setText(testModel.getSupplier_product_price());
                textView2.setText(testModel.getDate_d() + "");

                break;
            case TYPE_DIVIDER:
                TextView title = (TextView) convertView.findViewById(R.id.headerTitle);
                String titleString = (String) getItem(position);
                title.setText(titleString.split("/")[0]);

                TextView textView = (TextView) convertView.findViewById(R.id.textView);
                String titleString1 = (String) getItem(position);
                String[] aa = titleString1.split("/");
                textView.setText(aa[1]);

                break;

        }
        return convertView;
    }
}
