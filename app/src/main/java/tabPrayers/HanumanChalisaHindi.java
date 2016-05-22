package tabPrayers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.app.hanumanji.R;

import base.AppMainTabActivity;
import base.BaseFragment;
import constant.Constant;

/**
 * Created by DELL on 09-05-2016.
 */
public class HanumanChalisaHindi extends BaseFragment {


    WebView browser;
    private View view;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private ImageView imageViewBack;

    public static final HanumanChalisaHindi newInstance(String message)
    {
        HanumanChalisaHindi f = new HanumanChalisaHindi();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view   =   inflater.inflate(R.layout.hanuman_chalisa_hindi, container, false);
        browser=(WebView)view.findViewById(R.id.webkit);
        imageViewBack = (ImageView)view.findViewById(R.id.imageViewBack);
        WebSettings webSettings = browser.getSettings();
        browser.getSettings().setBuiltInZoomControls(true);
        browser.getSettings().setDisplayZoomControls(false);
        browser.setWebViewClient(new Callback());

        loadTime(Constant.hanuman_chalisa_hindi);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((AppMainTabActivity) getActivity()).onBackPressed();

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
                "                </td><td><td><td><td><td><td><td><td><td><td><td>\n" +
                "                <td>\n" +
                "                    <style=\"font-family:Georgia;color:black;font-size:17px;\"><b>Hanuman Chalisa</b>\n" +
                "                    \n" +
                "                </td><td><td><td><td><td><td><td><td><td><td><td>\n" +
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
