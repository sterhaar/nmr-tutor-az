package edu.sbu.cs.android.NMR.core;

import edu.sbu.cs.android.NMR.core.ImageAdapter;
import edu.sbu.cs.android.NMR.core.HomeFragment;
import edu.sbu.cs.android.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class HomeFragment extends Fragment {
	  public interface OnItemSelectedListener {
	        public void onItemSelected();
	    }
	  OnItemClickListener mListener;
	  @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        try {
	            mListener = (OnItemClickListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
	        }
	    }
//	    public void onGridItemClick(GridView gridview, View v, int position, long id) {
//	        // Append the clicked item's row ID with the content provider Uri
//	        
//	    	jsonAsset = id);
//	        // Send the event and Uri to the host activity
//	        mListener.onItemSelected(JsonAsset);
//	    }
GridView gridview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		gridview = (GridView)rootView.findViewById(R.id.gridView1);
        gridview.setAdapter(new ImageAdapter(gridview.getContext()));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((MainActivity) getActivity()).setProblem(position);
              //  ((MainActivity) getActivity()).recreate();
 //               Fragment spectraFragment = getActivity().getSupportFragmentManager().findFragmentById(R.layout.fragment_spectra);
//                if (spectraFragment instanceof Fragment) {
//                    android.support.v4.app.FragmentTransaction fragTran;
//                    fragTran = (getActivity()).getSupportFragmentManager().beginTransaction();
//                    fragTran.detach(spectraFragment);
//                    fragTran.attach(spectraFragment);
//                    fragTran.commit();
//                }
                ((MainActivity) getActivity()).onItemSelected();
              //  Toast.makeText(getActivity(), " " + ((MainActivity) getActivity()).getProblem(), Toast.LENGTH_SHORT).show();
            }
        });


      return rootView;

	}

}
        