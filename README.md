# together

Loader-based Android MVP framework supporting Dagger 2 custom scopes, based on [Tomorrow MVP][tmvp] with some inspiration from [Compartment][cmprtmnt].

## What else? Custom scopes!
Maintaining a dedicated scope for each Activity/Fragment instance allows them to immediately access all information relevant in their context, not just singleton controllers.
This small library provides the boilerplate for scope creation, view-presenter binding and injection, inherently making your life easier.
It doesn't have any Dagger 2 dependency but it's made to be used with Dagger 2 (see example later).

## Need more background info

* Please refer to [this article][ldrmvp] to read about the motivation behind a loader-based MVP implementation.
* If you are not familiar with custom scopes in Dagger 2 read more [here][dggrscps].

## Why would I use this?

Consider a "details" screen and it's presenter.
Beside some application scoped objects (e.g. `preferences`), such a presenter can additionally rely on screen specific objects (e.g. `jobId`, `jobObservable`).
These objects are provided by a `@Module` similar to the one below.
Just like the presenter itself they live as long as the Activity/Fragment but no longer (yes, they survive configuration changes).

```java
@JobDetailsScope
public class JobDetailsPresenter extends DetailsPresenter {

    @Inject String jobId;                     // @JobDetailsScope
    @Inject Observable<Job> jobObservable;    // @JobDetailsScope
    @Inject SharedPreferences preferences;    // @Singleton

    @Inject
    JobDetailsPresenter() {
    }

    @Override
    public void bindView(JobDetailsView view) {
        // subscribe to jobObservable ...
        // or maybe view.showId(jobId) ...
    }

}
```

```java
@Module
public class JobDetailsModule {

    private final String jobId;

    public JobDetailsModule(String jobId) {
        this.jobId = jobId;
    }

    @Provides
    String provideJobId() {
        return jobId;
    }

    @Provides
    @JobDetailsScope
    Observable<Job> provideJob(JobDetailsController detailsController) {
        return detailsController.observe(jobId);
    }

}
```


## I would really like to see more code
Have a look at the example application in this project. It demonstrates a simple Dagger 2, custom scope, fragment viewpager MVP setup.
It utilizes three custom scopes: one for the main Activity hosting the Fragments (`@MainScope`) and one for both kinds of Fragments (`@CountingScope` and `@ShiftingScope`).
Scopes for the Fragments allow their presenters to access objects and use controllers that are specific to them and it's less troublesome to get that access.
Naturally two instances of the same Fragment will never share their individually scoped dependencies.

![Example App](assets/viewpager.gif)

## Which classes do I have to create for each Activity/Fragment?

You need Scope, Module, View, Component, Presenter, Fragment/Activity

**MyScope.java:**
```java
@Scope
@Retention(RetentionPolicy.RUNTIME)
@interface MyScope {
}
```

**MyModule.java:**
```java
@Module
public class MyModule {
    @Provides
    @MyScope
    Foo provideFoo() {
        return new Foo();
    }
}
```

**MyView.java:**
```java
interface MyView {
    void showFoo(Foo foo);
}
```

**MyComponent.java:**
```java
@MyScope
@Subcomponent(modules = {MyModule.class})
public interface MyComponent extends BaseComponent<MyFragment, MyPresenter> {
}
```

**MyPresenter.java:**
```java
@MyScope
public class MyPresenter extends BasePresenter<MyView, MyComponent> {

    @Inject Foo foo;

    @Inject
    MyPresenter() {
    }

    @Override
    public void bindView(MyView view) {
        super.bindView(view);
        view.showFoo(foo);
    }

}
```

**MyFragment.java:**
```java
public class MyFragment extends BasePresenterFragment<MyView, MyPresenter, MyComponent> implements MyView {

    @Inject Foo foo;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void showFoo(Foo foo) {
        // ...
    }

    @Override
    protected void inject(MyComponent component) {
        component.inject(this);
    }

    @Override
    protected MyComponent createComponent() {
        return getAppComponent(this).myComponent();
    }

    @Override
    public Class<? extends MyPresenter> getTypeClazz() {
        return MyPresenter.class;
    }

}
```

**Adjustments in your global AppComponent.java:**
```java
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MyComponent myComponent();

    // components for other Fragments/Activities

}
```


## Where can I get this?

Add the maven repo URL to your `build.gradle`:

```groovy
repositories {
    maven { url "https://raw.github.com/laenger/maven-releases/master/releases" }
}
```

Add the library to the dependencies:

```groovy
dependencies {
    compile "biz.laenger.android:together:1.0.0"
}
```

[tmvp]: <https://github.com/michal-luszczuk/tomorrow-mvp>
[cmprtmnt]: <https://github.com/grandstaish/compartment>
[ldrmvp]: <http://blog.propaneapps.com/android/mvp-for-android>
[dggrscps]: <http://frogermcs.github.io/dependency-injection-with-dagger-2-custom-scopes>
