package com.jsalazar.costaricatravel.constants;

import com.jsalazar.costaricatravel.R;

public enum ExchangeRateIndicator {
    Dolar("317","NONE", R.string.currency_dolar,R.drawable.united_states_flag),
    Euro("333","USD",R.string.currency_eur, R.drawable.european_union),
    LibraEsterlina("330","USD",R.string.currency_pound,R.drawable.united_kingdom),
    PesoMex("332","CRC",R.string.currency_mx,R.drawable.mexican_flag),
    DolarCanadiense("328","CRC",R.string.currency_canada,R.drawable.canada_flag),
    CoronaNoruega("343","CRC",R.string.currency_nok,R.drawable.norway_flag),
    RealBrasilero("346","CRC",R.string.currency_br,R.drawable.brazil_flag),
    PesoColombiano("345","CRC",R.string.currency_cop,R.drawable.colombia_flag),
    SolPeruano("3057","CRC",R.string.currency_pen, R.drawable.peru_flag),
    Quetzal("338","CRC",R.string.currency_gtq,R.drawable.guatemala_flag),
    Yuan("3364","CRC",R.string.currency_yuan,R.drawable.china_flag),
    Rupee("21267","CRC",R.string.currency_india,R.drawable.india_flag),
    Won("337","CRC",R.string.currency_south_korea,R.drawable.south_korea_flag),
    Argentina("344","CRC",R.string.currency_argentina,R.drawable.argentina_flag),
    Dinamarca("342","CRC",R.string.currency_denmark,R.drawable.denmark_flag),
    Thailandia("21262","CRC",R.string.currency_thailand,R.drawable.thailand_flag),
    Cordoba("340","CRC",R.string.currency_cor,R.drawable.nicaragua_flag);

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
