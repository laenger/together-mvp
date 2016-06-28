package biz.laenger.android.together.example.pager.shifting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import biz.laenger.android.together.example.R;
import biz.laenger.android.together.example.pager.BasePagerFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static biz.laenger.android.together.example.di.InjectionHelper.getAppComponent;

public class ShiftingFragment extends BasePagerFragment<ShiftingView, ShiftingPresenter, ShiftingComponent> implements ShiftingView {

    @BindView(R.id.fragment_text) TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_shifting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }

    @OnClick(R.id.fragment_button)
    void onShiftClick() {
        getPresenter().onShiftClick();
    }

    @Override
    protected void inject(ShiftingComponent component) {
        component.inject(this); // no-op for this fragment
    }

    @Override
    protected ShiftingComponent createComponent() {
        return getAppComponent(this).shiftingComponent(new ShiftingModule("together."));
    }

    @Override
    public Class<? extends ShiftingPresenter> getTypeClazz() {
        return ShiftingPresenter.class;
    }

}
