package biz.laenger.android.together.example.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import biz.laenger.android.together.example.ExampleApplication;

public class InjectionHelper {

    public static AppComponent getAppComponent(Fragment fragment) {
        return getAppComponent(fragment.getActivity());
    }

    public static AppComponent getAppComponent(Activity activity) {
        return ((ExampleApplication) activity.getApplication()).getAppComponent();
    }

}
