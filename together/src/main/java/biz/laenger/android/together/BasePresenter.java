package biz.laenger.android.together;

import android.os.Bundle;
import android.support.annotation.NonNull;

public abstract class BasePresenter<V, C> extends com.propaneapps.tomorrow.presenter.BasePresenter<V> {

    C component;

    @Override
    @Deprecated
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

}
