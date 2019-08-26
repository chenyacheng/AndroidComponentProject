package com.chenyacheng.homecomponent.ui.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 首页相关的UI数据
 *
 * @author chenyacheng
 * @date 2019/08/23
 */
class HomeViewModel extends ViewModel {

    private MutableLiveData<String> content;

    MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
        }
        return content;
    }

    /**
     * 获取数据
     */
    void getContentData() {
        //这里可以加一层Repository从网络/缓存加载数据
        //执行完毕后调用 setValue/postValue方法,最终会回调Activity中的onChange方法
        getContent().setValue("~我是获取到的数据~");
    }
}
