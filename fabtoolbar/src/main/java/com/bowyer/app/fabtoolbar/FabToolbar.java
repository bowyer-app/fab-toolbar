package com.bowyer.app.fabtoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Bowyer on 2015/07/15.
 */
public class FabToolbar extends FrameLayout {

    private static final int DEFAULT_ANIMATION_DURATION = 600;
    private int animationDuration = DEFAULT_ANIMATION_DURATION;

    private float screenWidth;
    private ImageButton button;

    private LinearLayout container;

    public FabToolbar(Context context) {
        super(context);
        init();
    }

    public FabToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        loadAttributes(attrs);
    }

    public FabToolbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        loadAttributes(attrs);
    }

    private void init() {
        screenWidth = getResources().getDisplayMetrics().widthPixels;

        inflate(getContext(), R.layout.fab_toolbar, this);
        container = ((LinearLayout) findViewById(R.id.container));
    }

    private void loadAttributes(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FabToolbar,
                0, 0);

        int containerGravity;
        try {
            setColor(a.getColor(R.styleable.FabToolbar_tb_color,
                    getResources().getColor(R.color.blue)));
            animationDuration = a.getInteger(R.styleable.FabToolbar_tb_anim_duration,
                    DEFAULT_ANIMATION_DURATION);
            containerGravity = a.getInteger(R.styleable.FabToolbar_tb_container_gravity, 1);

        } finally {
            a.recycle();
        }

        container.setGravity(getGravity(containerGravity));
    }

    private int getGravity(int gravityEnum) {
        return (gravityEnum == 0 ? Gravity.START
                : gravityEnum == 1 ? Gravity.CENTER_HORIZONTAL : Gravity.END)
                | Gravity.CENTER_VERTICAL;
    }

    public void setColor(int color) {
        container.setBackgroundColor(color);
    }

    @Override
    public void addView(@NonNull View child) {
        if (canAddViewToContainer(child)) {
            container.addView(child);
        } else {
            super.addView(child);
        }
    }

    @Override
    public void addView(@NonNull View child, int width, int height) {
        if (canAddViewToContainer(child)) {
            container.addView(child, width, height);
        } else {
            super.addView(child, width, height);
        }
    }

    @Override
    public void addView(@NonNull View child, ViewGroup.LayoutParams params) {
        if (canAddViewToContainer(child)) {
            container.addView(child, params);
        } else {
            super.addView(child, params);
        }
    }

    @Override
    public void addView(@NonNull View child, int index, ViewGroup.LayoutParams params) {
        if (canAddViewToContainer(child)) {
            container.addView(child, index, params);
        } else {
            super.addView(child, index, params);
        }
    }
    private boolean canAddViewToContainer(View child) {
        return container != null;
    }
}
