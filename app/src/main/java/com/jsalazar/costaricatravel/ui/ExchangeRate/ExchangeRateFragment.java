package com.jsalazar.costaricatravel.ui.ExchangeRate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.adapters.currencyAdapter;
import com.jsalazar.costaricatravel.constants.ExchangeRateIndicator;
import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.FragmentExchangeRateBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.jsalazar.costaricatravel.models.Currency;
import com.jsalazar.costaricatravel.utils.AdsController;
import com.jsalazar.costaricatravel.utils.BackgroundTask;
import com.jsalazar.costaricatravel.utils.HttpRequest;
import com.jsalazar.costaricatravel.utils.HttpRequestParams;
import com.jsalazar.costaricatravel.utils.XMLHandler;

import java.util.ArrayList;

public class ExchangeRateFragment extends Fragment {
    private FragmentExchangeRateBinding binding;
    private currencyAdapter adapter = null;
    private final String BCCR_API = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicos";

    private final ArrayList<Currency> currencyArray = new ArrayList<>();

    private final int TOTAL_CURRENCIES = 15;
    private final int MAX_PROGRESS = 100;
    ProgressBar progress = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentInit) {
            fragmentInit mListener = (fragmentInit) context;
            mListener.onFragmentInteraction(fragmentId.EXCHANGE_RATE);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExchangeRateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        HttpRequest request = new HttpRequest();
        ListView list= binding.listCurrency;
        progress = binding.simpleProgressBar;
        progress.setVisibility(View.VISIBLE);
        progress.setProgress(0);
        progress.setMax(MAX_PROGRESS);
        list.setVisibility(View.GONE);
        EditText editText = binding.CurrencyAmount;
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(adapter!=null){
                    if(s.toString().equals("")){
                        for(Currency cur: currencyArray){
                            cur.setCustomValue(cur.getOriginalValue());
                        }
                    }else{
                        try{
                            int textValue = Integer.parseInt(s.toString());
                            for(Currency cur: currencyArray){
                                cur.setCustomValue(textValue);
                            }
                        }catch (Exception e){
                            Toast.makeText(getContext(),getString(R.string.number_validation),Toast.LENGTH_SHORT).show();
                        }

                    }
                    ((BaseAdapter) list.getAdapter()).notifyDataSetChanged();
                }
            }
        });

        new BackgroundTask(this.getActivity()) {
            @Override
            public void doInBackground() {
                currencyArray.clear();
                //
                String xmlDolar = request.getRequest(BCCR_API, HttpRequestParams.getMoneyExchangeRateParam(ExchangeRateIndicator.Dolar.getValue()));
                double DolarValue = Double.parseDouble(XMLHandler.readCurrencyValue(xmlDolar));
                if(DolarValue > 0){
                    currencyArray.add(new Currency(ExchangeRateIndicator.Dolar.getIconId(),ExchangeRateIndicator.Dolar.getLabelId(),DolarValue));
                    int currentPostion=1;
                    for(ExchangeRateIndicator rate: ExchangeRateIndicator.values()){
                        increaseProgress(currentPostion++);
                        if(rate.getConversion().equals("NONE")){ //skipping dolar call
                            continue;
                        }
                        String xmlCurrency = request.getRequest(BCCR_API, HttpRequestParams.getMoneyExchangeRateParam(rate.getValue()));
                        double CurrencyValue = Double.parseDouble(XMLHandler.readCurrencyValue(xmlCurrency));
                        if(CurrencyValue==0){
                            continue;
                        }
                        if(rate.getConversion().equals("USD")){
                            currencyArray.add(new Currency(rate.getIconId(),rate.getLabelId(),DolarValue * CurrencyValue));
                        }else if(rate.getConversion().equals("CRC")){
                            currencyArray.add(new Currency(rate.getIconId(),rate.getLabelId(),DolarValue / CurrencyValue));
                        }
                    }
                }
            }

            @Override
            public void onPostExecute() {
                progress.setVisibility(View.GONE);
                progress.setProgress(0);
                if(currencyArray.size()>0) {
                    editText.setEnabled(true);
                    editText.setText("");
                    adapter=new currencyAdapter(this.getContext(), currencyArray);
                    list.setVisibility(View.VISIBLE);
                    list.setAdapter(adapter);
                }else{
                    Toast.makeText(this.getContext(),R.string.error_exchange_rate,Toast.LENGTH_LONG).show();
                }

            }
        }.execute();

        AdsController.displayBanner(binding.adView);
        return root;
    }

    public void increaseProgress(final int position){
        try {
            Activity activity = this.getActivity();
            if(activity!=null){
                activity.runOnUiThread(() -> {
                    if (progress != null) {
                        double percentage = (double) position / this.TOTAL_CURRENCIES;
                        int value = (int) (percentage * this.MAX_PROGRESS);
                        progress.setProgress(value);
                    }
                });
            }
        }catch (Exception ex){
            Log.d("ExchangeRate", "increaseProgress: " + ex);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}