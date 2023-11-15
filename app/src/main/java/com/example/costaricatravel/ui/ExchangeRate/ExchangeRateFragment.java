package com.example.costaricatravel.ui.ExchangeRate;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.costaricatravel.R;
import com.example.costaricatravel.adapters.currencyAdapter;
import com.example.costaricatravel.constants.ExchangeRateIndicator;
import com.example.costaricatravel.databinding.FragmentExchangeRateBinding;
import com.example.costaricatravel.models.Currency;
import com.example.costaricatravel.utils.AdsController;
import com.example.costaricatravel.utils.HttpRequest;
import com.example.costaricatravel.utils.HttpRequestParams;
import com.example.costaricatravel.utils.XMLHandler;

import java.util.ArrayList;

public class ExchangeRateFragment extends Fragment {
    private FragmentExchangeRateBinding binding;
    private currencyAdapter adapter = null;
    private String BCCR_API = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicos";

    private ArrayList<Currency> currencyArray = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExchangeRateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        HttpRequest request = new HttpRequest();
        ListView list= binding.listCurrency;
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
                        for(Currency cur: currencyArray){
                            cur.setCustomValue(Integer.valueOf(s.toString()));
                        }
                    }
                    ((BaseAdapter) list.getAdapter()).notifyDataSetChanged();
                }
            }
        });

        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                currencyArray.clear();
                String xmlDolar = request.getRequest(BCCR_API, HttpRequestParams.getMoneyExchangeRateParam(ExchangeRateIndicator.Dolar.getValue()));
                double DolarValue = Double.valueOf(XMLHandler.readCurrencyValue(xmlDolar));
                currencyArray.add(new Currency(ExchangeRateIndicator.Dolar.getIconId(),ExchangeRateIndicator.Dolar.getLabelId(),DolarValue));
                for(ExchangeRateIndicator rate: ExchangeRateIndicator.values()){
                    if(rate.getConversion().equals("NONE")){ //skipping dolar call
                        continue;
                    }
                    String xmlCurrency = request.getRequest(BCCR_API, HttpRequestParams.getMoneyExchangeRateParam(rate.getValue()));
                    double CurrencyValue = Double.valueOf(XMLHandler.readCurrencyValue(xmlCurrency));
                    if(CurrencyValue==0){
                        continue;
                    }
                    if(rate.getConversion().equals("USD")){
                        currencyArray.add(new Currency(rate.getIconId(),rate.getLabelId(),DolarValue * CurrencyValue));
                    }else if(rate.getConversion().equals("CRC")){
                        currencyArray.add(new Currency(rate.getIconId(),rate.getLabelId(),DolarValue / CurrencyValue));
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                if(currencyArray.size()>0){
                    editText.setEnabled(true);
                    editText.setText("");
                }
                adapter=new currencyAdapter(ExchangeRateFragment.this.getActivity(), currencyArray);
                list.setAdapter(adapter);

            }
        }.execute();

        AdsController.displayBanner(binding.adView);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}