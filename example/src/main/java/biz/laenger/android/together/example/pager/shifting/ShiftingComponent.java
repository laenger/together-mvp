package biz.laenger.android.together.example.pager.shifting;

import biz.laenger.android.together.BaseComponent;
import dagger.Subcomponent;

@ShiftingScope
@Subcomponent(modules = {ShiftingModule.class})
public interface ShiftingComponent extends BaseComponent<ShiftingFragment, ShiftingPresenter> {
}
