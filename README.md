Floating Action Button Toolbar
==============================
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-fab--toolbar-green.svg?style=flat)](https://android-arsenal.com/details/1/2241)

Provides the Floating Action Button Toolbar [as specified in the Material Design Guide](http://www.google.com/design/spec/components/buttons-floating-action-button.html#buttons-floating-action-button-transitions) in a simple library.

![demo](https://github.com/SikoraMichal/fab-toolbar/blob/animation-improvement/art/demo.gif)

Usage
====
### build.gradle

```
repositories {
    jcenter()
}

dependencies {
    compile 'com.bowyer.app:fab-toolbar:1.1.0@aar'
}
```

### Layout XML

```
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.github.ksoichiro.android.observablescrollview.ObservableListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_margin="16dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:src="@drawable/ic_fab_icon"/>

    <com.bowyer.app.fabtoolbar.FabToolbar
        android:id="@+id/fabtoolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        app:tb_color="@color/primary"
        app:tb_container_gravity="center"
        app:tb_anim_duration="400"
        app:tb_fab_type="normal">

        <!--add your original layout-->

    </com.bowyer.app.fabtoolbar.FabToolbar>

</android.support.design.widget.CoordinatorLayout>
```

Make sure to user CoordinatorLayout as your container for the Floating Action Button if you want to
preserve same margin values for both Lollipop and pre Lollipop devices.

### Set up

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListView();
        //set floating button to FabToolbar
        mFabToolbar.setFab(mFab);
    }
```

### Show Hide

```java
//expand FabToolbar
mFabToolbar.expandFab();

//if mFabToolbar is expand,mFabToolbar contract. else fab slide out.
mFabToolbar.slideOutFab();

//fab slide in
mFabToolbar.slideInFab();


```

# Credits
This library use following libraries.
* [CircularReveal](https://github.com/ozodrukh/CircularReveal)

Feature
====
- [x] Android 5.0 lower animation support

License
--------
```
Copyright (c) 2015 Bowyer
Released under the MIT license
http://opensource.org/licenses/mit-license.php
```
