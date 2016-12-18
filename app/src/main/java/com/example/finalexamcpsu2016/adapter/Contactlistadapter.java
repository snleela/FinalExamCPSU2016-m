package com.example.finalexamcpsu2016.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.finalexamcpsu2016.R;
import com.example.finalexamcpsu2016.model.Contact;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by TOSHIBA on 18/12/2559.
 */

public class Contactlistadapter extends ArrayAdapter<Contact> {


    private Context mContext;
    private int mLayoutResId;
    private ArrayList<Contact> mContactList;


    public Contactlistadapter(Context context, int resource, ArrayList<Contact> contactList) {
        super(context, resource, contactList);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mContactList = contactList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = convertView;

        if (itemLayout == null) {
            itemLayout = View.inflate(mContext, mLayoutResId, null);
        }

        TextView name = (TextView) itemLayout.findViewById(R.id.editTextUserName);
        TextView Username = (TextView) itemLayout.findViewById(R.id.editTextUser);


        // เข้าถึงออบเจ็ค Contact หนึ่งๆใน mContactList
        Contact contact = mContactList.get(position);

        String contactCakeName = contact.getName();///-------------
        //cakenameTextView.setText(contactCakeName);

        String contactImage = contact.getUsername();


        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(contactImage);
            Drawable imageDrawable = Drawable.createFromStream(stream, null);
            //imageView.setImageDrawable(imageDrawable);
        } catch (IOException e) {
            Log.e("ContactListAdapter", "Error open image file: " + contactImage);
            e.printStackTrace();
        }


        return itemLayout;
    }


}
