package tabPrayers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hanumanji.R;

import base.AppConstants;
import base.AppMainTabActivity;
import base.BaseFragment;
import constant.Constant;

/**
 * Created by DELL on 09-05-2016.
 */
public class HanumanChalisaEnglish extends BaseFragment {


    WebView browser;
    private View view;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private ImageView imageViewBack;
    private float x1, x2;
    private RelativeLayout linearLayoutSettings;
    private TextView imageViewChangeAarti;

    boolean flagChange = false;

    public static final HanumanChalisaEnglish newInstance(String message)
    {
        HanumanChalisaEnglish f = new HanumanChalisaEnglish();
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
        linearLayoutSettings = (RelativeLayout)view.findViewById(R.id.mainSetting);
        imageViewChangeAarti = (TextView)view.findViewById(R.id.imageViewChangeAarti);
        WebSettings webSettings = browser.getSettings();
        browser.getSettings().setBuiltInZoomControls(true);
        browser.getSettings().setDisplayZoomControls(false);
        browser.setWebViewClient(new Callback());

        loadTime(Constant.hanuman_chalisa);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((AppMainTabActivity) getActivity()).onBackPressed();

            }
        });

        browser.setOnTouchListener(

                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        // TODO Auto-generated method stub

                        switch (event.getAction()) {

                            case MotionEvent.ACTION_DOWN:
                                //scrollView.requestDisallowInterceptTouchEvent(true);
                                x1 = event.getX();
                                break;
                            case MotionEvent.ACTION_UP:
                                //scrollView.requestDisallowInterceptTouchEvent(true);
                                x2 = event.getX();
                                float deltaX = x2 - x1;
                                if (deltaX < 0) {
                                    //scrollView.requestDisallowInterceptTouchEvent(true);
//                                    Toast.makeText(getActivity(),
//                                            "Right to Left swipe",
//                                            Toast.LENGTH_SHORT).show();
                                    mActivity.pushFragments(AppConstants.TAB_PRAYERS, new HanumanChalisaHindi(), true, true);
//                                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(
//                                            R.anim.slide_in_right_new, 0, 0, R.anim.slide_out_right_new
//                                    ).add(R.id.container, new HanumanChalisaEnglish()).addToBackStack("animation").commit();
                                } else if (deltaX > 0) {
                                    Toast.makeText(getActivity(),
                                            "Left to Right swipe",
                                            Toast.LENGTH_SHORT).show();
//                                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(
//                                            R.anim.slide_in_left_new, 0, 0, R.anim.slide_out_left_new
//                                    ).add(R.id.container, new HanumanChalisaHindi()).addToBackStack("animation").commit();
                                }
                                break;
                        }

                        return false;
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
                "                </td><td><td><td><td><td><td><td><td><td><td><td>\n" +
                "                <td>\n" +
                "                     <font color=\"#521302\"><b>Hanuman Chalisa</b>\n" +
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
