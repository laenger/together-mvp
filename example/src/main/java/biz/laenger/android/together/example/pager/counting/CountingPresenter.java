package biz.laenger.android.together.example.pager.counting;

import javax.inject.Inject;

import biz.laenger.android.together.BasePresenter;

@CountingScope
public class CountingPresenter extends BasePresenter<CountingView, CountingComponent> {

    @Inject Counter counter;

    @Inject
    CountingPresenter() {
        // ;
    }

    @Override
    public void bindView(CountingView view) {
        super.bindView(view);
        view.showText(String.valueOf(counter.getCurrent()));
    }

    void onCountClick() {
        getView().showText(String.valueOf(counter.countUp()));
    }

}
