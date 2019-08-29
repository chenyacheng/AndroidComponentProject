package com.chenyacheng.homecomponent.ui.activity.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.chenyacheng.commoblib.base.BaseInnerActivity;
import com.chenyacheng.homecomponent.R;

/**
 * @author Administrator
 * @date 2019/08/28
 */
public class TestActivity extends BaseInnerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_test);
        // 构建ViewModel对象
        final TestViewModel testViewModel = new ViewModelProvider(this).get(TestViewModel.class);
        TextView tvTest = findViewById(R.id.tv_test);
        Button btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(view -> testViewModel.getContentData());
        testViewModel.getContent().observe(this, tvTest::setText);
    }
}
