package net.evgenru22.MushroomFight.android;

import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import net.evgenru22.MushroomFight.Main;

/** Launches the Android application. */
public class AndroidLauncher extends AndroidApplication {
    private RelativeLayout layout;
    private RelativeLayout.LayoutParams params;
    private AdView bannerAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
        configuration.useImmersiveMode = true; // Recommended, but not required.
        View gameView = initializeForView(new Main(), configuration);

        layout = new RelativeLayout(this);
        layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT);

        params = new RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        bannerAd = new AdView(this);
        bannerAd.setAdUnitId("ca-app-pub-3940256099942544/92145897");
        bannerAd.setAdSize(AdSize.BANNER);

        layout.addView(bannerAd, params);
        setContentView(layout);

        AdRequest ad = new AdRequest.Builder().build();
        bannerAd.loadAd(ad);
    }
}
