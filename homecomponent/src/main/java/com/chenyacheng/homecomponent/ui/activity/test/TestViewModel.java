package com.chenyacheng.homecomponent.ui.activity.test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Administrator
 * @date 2019/08/28
 */
class TestViewModel extends ViewModel {

    private MutableLiveData<String> content;

    /**
     * 获取数据
     */
    void getContentData() {
        //这里可以加一层Repository从网络/缓存加载数据
        //执行完毕后调用 setValue/postValue方法,最终会回调Activity中的onChange方法
        getContent().setValue("获取到新的数据");
    }

    MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
        }
        return content;
    }
}
