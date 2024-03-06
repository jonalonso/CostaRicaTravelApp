package com.jsalazar.costaricatravel.ui.Places;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.FragmentPlacesBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;

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
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}