package biz.laenger.android.together.example.main;


import biz.laenger.android.together.BaseComponent;
import dagger.Subcomponent;

@MainScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent extends BaseComponent<MainActivity, MainPresenter> {
}
