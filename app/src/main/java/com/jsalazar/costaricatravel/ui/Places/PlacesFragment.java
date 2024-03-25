package com.jsalazar.costaricatravel.ui.Places;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jsalazar.costaricatravel.adapters.placeAdapter;
import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.FragmentPlacesBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.jsalazar.costaricatravel.itemGenerator.PlaceGenerator;
import com.jsalazar.costaricatravel.models.Place;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    private FragmentPlacesBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentInit) {
            fragmentInit mListener = (fragmentInit) context;
            mListener.onFragmentInteraction(fragmentId.PLACES);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPlacesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (this.getContext() instanceof fragmentInit) {
            fragmentInit mListener = (fragmentInit) this.getContext();
            mListener.setBannerAdView(binding.adView);
        }

        ListView list= binding.listPlaces;
        ArrayList<Place> places = PlaceGenerator.generate();
        placeAdapter adapter = new placeAdapter(this.getActivity(),places);
        list.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}