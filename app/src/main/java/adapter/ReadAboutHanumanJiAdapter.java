package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.hanumanji.R;
import com.example.shiva.hanumanji.YouTubeActivity;

import java.util.ArrayList;

import base.AppConstants;
import data.ReadAboutHanumanJiData;
import data.Video;
import tabPrayers.AudioVideoHanumanJi;

/**
 * Created by DELL on 08-05-2016.
 */
public class ReadAboutHanumanJiAdapter extends ArrayAdapter<ReadAboutHanumanJiData> {


    ArrayList<ReadAboutHanumanJiData> arrayListReadAboutHanumanJiData;
    private Context context;

    public ReadAboutHanumanJiAdapter(Context context, int resource, ArrayList<ReadAboutHanumanJiData> arrayListReadAboutHanumanJiData) {
        super(context, resource,arrayListReadAboutHanumanJiData);
        this.context = context;
        this.arrayListReadAboutHanumanJiData = arrayListReadAboutHanumanJiData;
    }


    public static class ViewHolder{

        TextView textViewTitle;
        TextView textViewDescription;
        ImageView imageViewTitle;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.read_about_hanuman_ji_item, parent, false);

            viewHolder.textViewTitle = (TextView)convertView.findViewById(R.id.textViewAudioVideoTitle);
            viewHolder.textViewDescription = (TextView)convertView.findViewById(R.id.textViewDescriptionAudio);
            viewHolder.imageViewTitle = (ImageView)convertView.findViewById(R.id.imageViewReadAbout);
            convertView.setTag(viewHolder);



        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }


        viewHolder.textViewTitle.setText(getItem(position).getTitle());

        if(getItem(position).getTitle().equalsIgnoreCase("Hanuman Aartis")){

            viewHolder.imageViewTitle.setImageResource(R.mipmap.hanumanaartis);

        }else if(getItem(position).getTitle().equalsIgnoreCase("Hanuman Mantras")){

            viewHolder.imageViewTitle.setImageResource(R.mipmap.hanumanmantras);

        }else if(getItem(position).getTitle().equalsIgnoreCase("Shree Hanuman Chalisa")){

            viewHolder.imageViewTitle.setImageResource(R.mipmap.shreehanumanchalisa);
        }else if(getItem(position).getTitle().equalsIgnoreCase("The Full Story of Hanuman")){

            viewHolder.imageViewTitle.setImageResource(R.mipmap.fullstory);

        }else if(getItem(position).getTitle().equalsIgnoreCase("The Story of Hanuman For Kids")){

            viewHolder.imageViewTitle.setImageResource(R.mipmap.story);
        }
        viewHolder.textViewDescription.setVisibility(View.GONE);

        
        return convertView;
    }

    @Override
    public int getCount() {
        return arrayListReadAboutHanumanJiData.size();
    }

}
