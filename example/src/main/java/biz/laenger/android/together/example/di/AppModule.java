package biz.laenger.android.together.example.di;

import com.squareup.leakcanary.RefWatcher;

import biz.laenger.android.together.example.ExampleApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final ExampleApplication application;
    private final RefWatcher refWatcher;

    public AppModule(ExampleApplication application, RefWatcher refWatcher) {
        this.application = application;
        this.refWatcher = refWatcher;
    }

    @Provides
    ExampleApplication provideApplication() {
        return application;
    }

    @Provides
    RefWatcher provideRefWatcher() {
        return refWatcher;
    }

}
