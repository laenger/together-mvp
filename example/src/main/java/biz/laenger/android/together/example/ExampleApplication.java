package biz.laenger.android.together.example;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import biz.laenger.android.together.example.di.AppComponent;
import biz.laenger.android.together.example.di.AppModule;
import biz.laenger.android.together.example.di.DaggerAppComponent;

public class ExampleApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        final RefWatcher refWatcher = LeakCanary.install(this);

        initDependencyInjection(refWatcher);
    }

    private void initDependencyInjection(RefWatcher refWatcher) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, refWatcher))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
