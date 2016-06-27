package biz.laenger.android.together.example.pager.counting;

import dagger.Module;
import dagger.Provides;

@Module
public class CountingModule {

    @Provides
    @CountingScope
    Counter provideCounter() {
        return new Counter();
    }

}
