package com.variant.ktapp.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.variant.ktapp.R;


public class ToolBar extends RelativeLayout implements View.OnClickListener {
    private ImageView ivMenu,ivDots,ivIcon;
    private TextView tvTitle;
    private String titleText;
    private OnClickListener onMenuClickListener,onDotsClickListener;

    public ToolBar(Context context) {
        super(context);
        init(null);
    }

    public ToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void setTitleText(String text) {
        this.titleText = text;
        tvTitle.setText(titleText);
    }

    public void setOnMenuClickListener(OnClickListener onMenuClickListener) {
        this.onMenuClickListener = onMenuClickListener;
    }

    public void setOnDotsClickListener(OnClickListener onDotsClickListener) {
        this.onDotsClickListener = onDotsClickListener;
    }

    private void init(AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.layout_toolbar, this);
        ivMenu = view.findViewById(R.id.ivMenu);
        ivDots = view.findViewById(R.id.ivDots);
        ivIcon= view.findViewById(R.id.ivIcon);
        tvTitle = view.findViewById(R.id.tvTitle);
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ToolBar);
            titleText = ta.getString(R.styleable.ToolBar_titleText);
            tvTitle.setText(titleText);

            boolean showDots = ta.getBoolean(R.styleable.ToolBar_showDots, true);

            if (showDots) {
                ivDots.setVisibility(VISIBLE);
                ivIcon.setVisibility(GONE);
            } else {
                ivIcon.setVisibility(VISIBLE);
                ivDots.setVisibility(GONE);
            }
            ivMenu.setOnClickListener(this);
            ivDots.setOnClickListener(this);
            ta.recycle();
        }
    }

    public void setDots(boolean visible){
        if (visible) {
            ivDots.setVisibility(VISIBLE);
            ivIcon.setVisibility(GONE);
        } else {
            ivIcon.setVisibility(VISIBLE);
            ivDots.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == ivMenu) {
            if (onMenuClickListener != null) {
                onMenuClickListener.onClick(ivMenu);
            }
        }
        if (v == ivDots) {
            if (onDotsClickListener != null) {
                onDotsClickListener.onClick(ivDots);
            }
        }
    }
}
