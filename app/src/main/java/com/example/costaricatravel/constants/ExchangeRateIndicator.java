package com.example.costaricatravel.constants;

import com.example.costaricatravel.R;

public enum ExchangeRateIndicator {
    Dolar("318","NONE", R.string.currency_dolar,R.drawable.united_states_flag),
    Euro("333","USD",R.string.currency_eur, R.drawable.european_union),
    LibraEsterlina("330","USD",R.string.currency_pound,R.drawable.united_kingdom),
    PesoMex("332","CRC",R.string.currency_mx,R.drawable.mexican_flag),
    Cordoba("340","CRC",R.string.currency_cor,R.drawable.nicaragua_flag),
    RealBrasilero("346","CRC",R.string.currency_br,R.drawable.brazil_flag),
    PesoColombiano("345","CRC",R.string.currency_cop,R.drawable.colombia_flag),
    SolPeruano("3057","CRC",R.string.currency_pen,R.drawable.peru_flag);

    private final String value;
    private final String conversion;

    private final Integer labelId;

    private final Integer iconId;
    ExchangeRateIndicator(String value, String conversion,Integer labelId, Integer iconId) {
        this.value = value;
        this.conversion = conversion;
        this.labelId = labelId;
        this.iconId = iconId;
    }

    public String getValue() {
        return this.value;
    }
    public String getConversion() {
        return this.conversion;
    }
    public Integer getLabelId() {
        return this.labelId;
    }

    public Integer getIconId() {
        return this.iconId;
    }

}