package com.jsalazar.costaricatravel.ui.Bus;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jsalazar.costaricatravel.adapters.busAdapter;
import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.FragmentBusBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.jsalazar.costaricatravel.itemGenerator.busGenerator;
import com.jsalazar.costaricatravel.models.Bus;
import com.jsalazar.costaricatravel.utils.AdsController;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusFragment extends Fragment {

    private busAdapter adapter = null;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentInit) {
            fragmentInit mListener = (fragmentInit) context;
            mListener.onFragmentInteraction(fragmentId.BUS);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBusBinding binding = FragmentBusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView list= binding.listBus;
        ArrayList<Bus> busArray = busGenerator.generate();
        adapter=new busAdapter(this.getActivity(), busArray);
        list.setAdapter(adapter);

        AdsController.displayBanner(binding.adView);
        return root;
    }
}