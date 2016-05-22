package tabPrayers;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.hanumanji.R;

import base.AppMainTabActivity;
import base.BaseFragment;
import constant.Constant;

/**
 * Created by DELL on 09-05-2016.
 */
public class FullStoryHanumanForKids extends BaseFragment {


    WebView browser;
    private View view;
    private ImageView imageViewBack;
    private RelativeLayout linearLayoutSettings;
    private TextView imageViewChangeAarti;

    boolean flagChange = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view   =   inflater.inflate(R.layout.full_story_hanuman_kids, container, false);
        browser=(WebView)view.findViewById(R.id.webkit);
        imageViewBack = (ImageView)view.findViewById(R.id.imageViewBack);
        linearLayoutSettings = (RelativeLayout)view.findViewById(R.id.mainSetting);
        imageViewChangeAarti = (TextView)view.findViewById(R.id.imageViewChangeAarti);
        browser.setWebViewClient(new Callback());
        browser.getSettings().setBuiltInZoomControls(true);
        browser.getSettings().setDisplayZoomControls(false);
        loadTime(Constant.Hanuman_story);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((AppMainTabActivity) getActivity()).onBackPressed();

            }
        });
        imageViewChangeAarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flagChange) {

                    linearLayoutSettings.setVisibility(View.GONE);
                    flagChange = false;
                } else {

                    linearLayoutSettings.setVisibility(View.VISIBLE);
                    flagChange = true;
                }

            }
        });
        return view;
    }

    void loadTime(String data) {
        String page="<html><body>" +
                " <br><center><div class=\"header\">\n" +
                "        <table>\n" +
                "            <tr>\n" +
                "                <td>\n" +
                "                    <img src=ic_launcher.png style=\"vertical-align: left\">\n" +
                "                </td><td><td><td><td><td><td><td><td>\n" +
                "                <td>\n" +
                "                    <font color=\"#521302\"><b>Full Story Hanuman For Kids</b>\n" +
                "                    \n" +
                "                </td><td><td><td><td><td><td><td><td>\n" +
                "                <td>\n" +
                "                    <img src=ic_launcher.png style=\"vertical-align: right\">\n" +
                "                </td>\n" +
                "            <tr>\n" +
                "        </table>\n" +
                "    </div></center>"+
                "<center>"
                +data
                +"</a></body></html>";


        browser.loadDataWithBaseURL("file:///android_asset/", page, "text/html", "UTF-8", "");
    }

    private class Callback extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            loadTime(Constant.Hanuman_story);

            return(true);
        }
    }
}
