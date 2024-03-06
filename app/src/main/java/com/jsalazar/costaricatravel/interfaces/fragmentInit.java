package com.jsalazar.costaricatravel.interfaces;

import com.google.android.gms.ads.AdView;
import com.jsalazar.costaricatravel.constants.fragmentId;

public interface fragmentInit {
    void onFragmentInteraction(fragmentId fragment);

    void setBannerAdView(AdView view);
}
