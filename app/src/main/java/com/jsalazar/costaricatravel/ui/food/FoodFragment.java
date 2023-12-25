package com.jsalazar.costaricatravel.ui.food;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jsalazar.costaricatravel.adapters.foodAdapter;
import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.FragmentFoodBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.jsalazar.costaricatravel.itemGenerator.foodGenerator;
import com.jsalazar.costaricatravel.models.FoodRow;
import com.jsalazar.costaricatravel.utils.AdsController;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    private foodAdapter adapter = null;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentInit) {
            fragmentInit mListener = (fragmentInit) context;
            mListener.onFragmentInteraction(fragmentId.FOOD);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFoodBinding binding = FragmentFoodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView list= binding.listFood;
        ArrayList<FoodRow> foodArray = foodGenerator.generate();
        adapter=new foodAdapter(this.getActivity(), foodArray);
        list.setAdapter(adapter);

        AdsController.displayBanner(binding.adView);
        return root;
    }

    @Override
    public void onStop() {
        super.onStop();
        if(adapter!=null){
            adapter.onClose();
        }
    }
}