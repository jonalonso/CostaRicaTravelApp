package com.jsalazar.costaricatravel.ui.Places;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jsalazar.costaricatravel.databinding.FragmentPlacesBinding;
import com.jsalazar.costaricatravel.utils.AdsController;

public class PlacesFragment extends Fragment {

    private FragmentPlacesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPlacesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        AdsController.displayBanner(binding.adView);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}