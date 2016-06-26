package biz.laenger.android.together;

import android.os.Bundle;

import com.propaneapps.tomorrow.common.FactoryWithType;

public abstract class BasePresenterFragment<V, P extends BasePresenter<V, C>, C extends BaseComponent<? extends V, P>> extends
        com.propaneapps.tomorrow.base.BasePresenterFragment<V, P> implements FactoryWithType<P> {

    private P presenter;

    @Override
    public FactoryWithType<P> getPresenterFactory() {
        return this;
    }

    @Override
    public V getViewLayer() {
        return (V) this;
    }

    @Override
    public P create() {
        final C component = createComponent();
        final P presenter = component.getPresenter();
        presenter.component = component;
        return presenter;
    }

    @Override
    public void onPresenterProvided(P presenter) {
        super.onPresenterProvided(presenter);
        this.presenter = presenter;
        inject(presenter.component);
    }

    protected P getPresenter() {
        return presenter;
    }

    @Override
    @Deprecated
    public void onSaveInstanceState(Bundle outState) {
        // ;
    }

    protected void inject(C component) {
        // ;
    }

    protected abstract C createComponent();

}
