package biz.laenger.android.together;

public interface BaseComponent<V, P> {
    void inject(V v);

    P getPresenter();
}
