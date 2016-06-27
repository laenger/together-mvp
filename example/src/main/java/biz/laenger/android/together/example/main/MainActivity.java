package biz.laenger.android.together.example.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import biz.laenger.android.together.BasePresenterActivity;
import biz.laenger.android.together.example.R;
import butterknife.BindView;
import butterknife.ButterKnife;

import static biz.laenger.android.together.example.di.InjectionHelper.getAppComponent;

public class MainActivity extends BasePresenterActivity<MainView, MainPresenter, MainComponent> implements MainView {

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initViewPager();
    }

    private void initViewPager() {
        final MainPagerAdapter sectionsPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getPresenter().onPagerItemSelected(position);
            }
        });
    }

    @Override
    public void showPagerItem(int position) {
        viewPager.setCurrentItem(position, false);
    }

    @Override
    protected void inject(MainComponent component) {
        component.inject(this); // no-op for this activity
    }

    @Override
    protected MainComponent createComponent() {
        return getAppComponent(this).mainComponent(new MainModule());
    }

    @Override
    public Class<? extends MainPresenter> getTypeClazz() {
        return MainPresenter.class;
    }

}
