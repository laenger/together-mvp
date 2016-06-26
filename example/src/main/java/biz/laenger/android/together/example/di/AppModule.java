package biz.laenger.android.together.example.di;

import biz.laenger.android.together.example.ExampleApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final ExampleApplication application;

    public AppModule(ExampleApplication application) {
        this.application = application;
    }

    @Provides
    ExampleApplication provideApplication() {
        return application;
    }

}
