package biz.laenger.android.together.example.pager.counting;

import biz.laenger.android.together.BaseComponent;
import dagger.Subcomponent;

@CountingScope
@Subcomponent(modules = {CountingModule.class})
public interface CountingComponent extends BaseComponent<CountingFragment, CountingPresenter> {
}
