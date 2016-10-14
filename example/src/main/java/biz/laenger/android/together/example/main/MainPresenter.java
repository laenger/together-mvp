package biz.laenger.android.together.example.main;

import javax.inject.Inject;

import biz.laenger.android.together.BasePresenter;
import biz.laenger.android.together.example.ExampleApplication;

@MainScope
public class MainPresenter extends BasePresenter<MainView, MainComponent> {

    @Inject ExampleApplication application;

    private int lastPagerItemPosition = 0;

    @Inject
    MainPresenter() {
        // ;
    }

    @Override
    public void bindView(MainView view) {
        super.bindView(view);
        view.showPagerItem(lastPagerItemPosition);
    }

    void onPagerItemSelected(int position) {
        lastPagerItemPosition = position;
    }

}
