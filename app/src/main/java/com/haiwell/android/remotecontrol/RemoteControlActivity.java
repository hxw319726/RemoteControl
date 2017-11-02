package com.haiwell.android.remotecontrol;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;

public class RemoteControlActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new RemoteControlFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        // requestWindowFeature();的取值
        // 1.DEFAULT_FEATURES：系统默认状态，一般不需要指定
        // 2.FEATURE_CONTEXT_MENU：启用ContextMenu，默认该项已启用，一般无需指定
        // 3.FEATURE_CUSTOM_TITLE：自定义标题。当需要自定义标题时必须指定。如：标题是一个按钮时
        // 4.FEATURE_INDETERMINATE_PROGRESS：不确定的进度
        // 5.FEATURE_LEFT_ICON：标题栏左侧的图标
        // 6.FEATURE_NO_TITLE：无标题
        // 7.FEATURE_OPTIONS_PANEL：启用“选项面板”功能，默认已启用。
        // 8.FEATURE_PROGRESS：进度指示器功能
        // 9.FEATURE_RIGHT_ICON:标题栏右侧的图标
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState, persistentState);
    }
}
