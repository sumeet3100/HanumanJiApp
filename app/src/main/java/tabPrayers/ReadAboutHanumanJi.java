package tabPrayers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.app.hanumanji.R;

import java.util.ArrayList;

import adapter.ReadAboutHanumanJiAdapter;
import base.AppConstants;
import base.AppMainTabActivity;
import base.BaseFragment;
import data.ReadAboutHanumanJiData;


public class ReadAboutHanumanJi extends BaseFragment {


	View view;

	private ListView listViewReadAboutHanumanJi;
	private ArrayList<ReadAboutHanumanJiData> arrayListReadAboutHanumanJi;
	private ReadAboutHanumanJiAdapter readAboutHanumanJiAdapter;
	private ImageView imageViewBack;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        view   =   inflater.inflate(R.layout.readabouthanumanji, container, false);

		initialiseViews();
		addData();


        return view;
	}



	private void initialiseViews() {


		listViewReadAboutHanumanJi = (ListView)view.findViewById(R.id.listViewReadAboutHanumanJi);
		imageViewBack = (ImageView)view.findViewById(R.id.imageViewBack);
	}


	private void addData() {

		ReadAboutHanumanJiData readAboutHanumanJiAartis = new ReadAboutHanumanJiData("Hanuman Aartis");
		ReadAboutHanumanJiData readAboutHanumanJiMantra = new ReadAboutHanumanJiData("Hanuman Mantras");
		ReadAboutHanumanJiData readAboutHanumanJiShree = new ReadAboutHanumanJiData("Shree Hanuman Chalisa");
		ReadAboutHanumanJiData readAboutHanumanJiFullStory = new ReadAboutHanumanJiData("The Full Story of Hanuman");
		ReadAboutHanumanJiData readAboutHanumanJiStory = new ReadAboutHanumanJiData("The Story of Hanuman For Kids");


		arrayListReadAboutHanumanJi = new ArrayList<>();

		arrayListReadAboutHanumanJi.add(readAboutHanumanJiAartis);
		arrayListReadAboutHanumanJi.add(readAboutHanumanJiMantra);
		arrayListReadAboutHanumanJi.add(readAboutHanumanJiShree);
		//arrayListReadAboutHanumanJi.add(readAboutHanumanJiShree);
		arrayListReadAboutHanumanJi.add(readAboutHanumanJiFullStory);
		arrayListReadAboutHanumanJi.add(readAboutHanumanJiStory);

		readAboutHanumanJiAdapter = new ReadAboutHanumanJiAdapter(getActivity(),R.layout.video_audio_item,arrayListReadAboutHanumanJi);

		listViewReadAboutHanumanJi.setAdapter(readAboutHanumanJiAdapter);

		listViewReadAboutHanumanJi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


				if (arrayListReadAboutHanumanJi.get(position).getTitle().equalsIgnoreCase("Hanuman Aartis")) {

					mActivity.pushFragments(AppConstants.TAB_PRAYERS, new MainAarti(), true, true);

				} else if (arrayListReadAboutHanumanJi.get(position).getTitle().equalsIgnoreCase("Hanuman Mantras")) {
					mActivity.pushFragments(AppConstants.TAB_PRAYERS, new HanumanMantraHindi(), true, true);

				} else if (arrayListReadAboutHanumanJi.get(position).getTitle().equalsIgnoreCase("Shree Hanuman Chalisa")) {
					mActivity.pushFragments(AppConstants.TAB_PRAYERS, new HanumanChalisaEnglish(), true, true);


				} else if (arrayListReadAboutHanumanJi.get(position).getTitle().equalsIgnoreCase("The Full Story of Hanuman")) {
					mActivity.pushFragments(AppConstants.TAB_PRAYERS, new FullStoryHanuman(), true, true);

				} else if (arrayListReadAboutHanumanJi.get(position).getTitle().equalsIgnoreCase("The Story of Hanuman For Kids")) {

					mActivity.pushFragments(AppConstants.TAB_PRAYERS, new FullStoryHanumanForKids(), true, true);
				}

			}
		});


		imageViewBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				((AppMainTabActivity) getActivity()).onBackPressed();

			}
		});

	}

}
