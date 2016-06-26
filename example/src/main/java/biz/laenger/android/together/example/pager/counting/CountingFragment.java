package biz.laenger.android.together.example.pager.counting;

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

public class CountingFragment extends BasePagerFragment<CountingView, CountingPresenter, CountingComponent> implements CountingView {

    @BindView(R.id.fragment_text) TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_counting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }

    @OnClick(R.id.fragment_button)
    void onCountClick() {
        getPresenter().onCountClick();
    }

    @Override
    protected void inject(CountingComponent component) {
        component.inject(this); // no-op for this fragment
    }

    @Override
    protected CountingComponent createComponent() {
        return getAppComponent(this).countingComponent();
    }

    @Override
    public Class<? extends CountingPresenter> getTypeClazz() {
        return CountingPresenter.class;
    }

}
