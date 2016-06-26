package biz.laenger.android.together.example.pager.shifting;

import javax.inject.Inject;

import biz.laenger.android.together.BasePresenter;

@ShiftingScope
public class ShiftingPresenter extends BasePresenter<ShiftingView, ShiftingComponent> {

    @Inject Shifter shifter;

    @Inject
    public ShiftingPresenter() {
        // ;
    }

    @Override
    public void bindView(ShiftingView view) {
        super.bindView(view);
        view.showText(shifter.getCurrent());
    }

    public void onShiftClick() {
        getView().showText(shifter.shift());
    }

}
