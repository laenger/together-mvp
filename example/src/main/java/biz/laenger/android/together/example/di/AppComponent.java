package biz.laenger.android.together.example.di;

import com.squareup.leakcanary.RefWatcher;

import javax.inject.Singleton;

import biz.laenger.android.together.example.main.MainComponent;
import biz.laenger.android.together.example.main.MainModule;
import biz.laenger.android.together.example.pager.counting.CountingComponent;
import biz.laenger.android.together.example.pager.shifting.ShiftingComponent;
import biz.laenger.android.together.example.pager.shifting.ShiftingModule;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainComponent mainComponent(MainModule mainModule);

    CountingComponent countingComponent();

    ShiftingComponent shiftingComponent(ShiftingModule shiftingModule);

    RefWatcher refWatcher();

}
