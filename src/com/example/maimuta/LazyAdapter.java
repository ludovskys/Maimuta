package com.example.maimuta;

import java.util.ArrayList;
import java.util.HashMap;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class LazyAdapter extends BaseAdapter {
 
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    // sert à savoir le type de test courant
    private int testType;
 
    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d, int testT) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        testType = testT;
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.listview_parameters_row, null);
 
        TextView parameterName = (TextView)vi.findViewById(R.id.textViewParameterName); // title
        TextView parameterValue = (TextView)vi.findViewById(R.id.textViewParameterValue); // duration
 
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);
 
        // Setting all values in listview
        parameterName.setText(song.get(SystemUtils.KEY_PARAMETER_NAME));
        parameterName.setTag(R.string.key_parameter_tag_1,song.get(SystemUtils.KEY_PARAMETER_TAG_1));
        parameterName.setTag(R.string.key_parameter_tag_2,song.get(SystemUtils.KEY_PARAMETER_TAG_2));
        parameterValue.setText(song.get(SystemUtils.KEY_PARAMETER_VALUE));
        
        return vi;
    }
}
