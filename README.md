Floating Action Button Toolbar
==============================
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-fab--toolbar-green.svg?style=flat)](https://android-arsenal.com/details/1/2241)

Provides the Floating Action Button Toolbar [as specified in the Material Design Guide](http://www.google.com/design/spec/components/buttons-floating-action-button.html#buttons-floating-action-button-transitions) in a simple library.

![demo](https://github.com/bowyer-app/fab-toolbar/blob/master/art/demo.gif)

Usage
====
### build.gradle

```
repositories {
    jcenter()
}

dependencies {
    compile 'com.bowyer.app:fab-toolbar:1.0.0@aar'
}
```

### Layout XML

```
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             xmlns:app="http://schemas.android.com/apk/res-auto"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             tools:context=".MainActivity">

    <com.github.ksoichiro.android.observablescrollview.ObservableListView
            android:id="@+id/list_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            />

    <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_marginBottom="32dp"
            android:layout_marginRight="32dp"
            android:src="@drawable/ic_add_white_24dp"
            app:borderWidth="0dp"
            app:fabSize="normal"
            app:rippleColor="@color/primary"
            />

    <com.bowyer.app.fabtoolbar.FabToolbar
            android:id="@+id/fabtoolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            app:tb_container_gravity="center"
            app:tb_color="@color/primary">
            
        <!--add your original layout-->
    </com.bowyer.app.fabtoolbar.FabToolbar>
</FrameLayout>

```

### Set up

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
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

Feature
====
- [ ] Android 5.0 lower animation support

License
--------
```
Copyright (c) 2015 Bowyer
Released under the MIT license
http://opensource.org/licenses/mit-license.php
```
