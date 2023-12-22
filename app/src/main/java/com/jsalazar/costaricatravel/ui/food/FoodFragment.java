package com.jsalazar.costaricatravel.ui.food;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jsalazar.costaricatravel.adapters.foodAdapter;
import com.jsalazar.costaricatravel.databinding.FragmentFoodBinding;
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

    // TODO: Rename parameter arguments, choose names that match
    private FragmentFoodBinding binding;
    private foodAdapter adapter = null;
    private ArrayList<FoodRow> foodArray = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFoodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView list= binding.listFood;
        foodArray = foodGenerator.generate();
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