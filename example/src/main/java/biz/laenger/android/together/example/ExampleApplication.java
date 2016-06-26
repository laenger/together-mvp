package biz.laenger.android.together.example;

import android.app.Application;

import biz.laenger.android.together.example.di.AppComponent;
import biz.laenger.android.together.example.di.AppModule;
import biz.laenger.android.together.example.di.DaggerAppComponent;

public class ExampleApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependencyInjection();
    }

    private void initDependencyInjection() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
