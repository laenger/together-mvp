package biz.laenger.android.together.example.pager;

import android.support.v4.app.LoaderManager;

import biz.laenger.android.together.BaseComponent;
import biz.laenger.android.together.BasePresenter;
import biz.laenger.android.together.BasePresenterFragment;
import biz.laenger.android.together.example.di.InjectionHelper;

public abstract class BasePagerFragment<V, P extends BasePresenter<V, C>, C extends BaseComponent<? extends V, P>> extends BasePresenterFragment<V, P, C> {

    @Override
    public LoaderManager getLoaderManager() {
        return getActivity().getSupportLoaderManager(); // use activity's loader manager inside viewpager fragments
    }

    @Override
    protected int getLoaderId() {
        return getTag().hashCode(); // unique within viewpager
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        InjectionHelper.getAppComponent(this).refWatcher().watch(this);
    }

}
