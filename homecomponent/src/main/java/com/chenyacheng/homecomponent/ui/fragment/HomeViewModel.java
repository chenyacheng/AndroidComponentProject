package com.chenyacheng.homecomponent.ui.fragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * 首页相关的UI数据
 *
 * @author chenyacheng
 * @date 2019/08/23
 */
class HomeViewModel extends ViewModel {

    private final String key;
    private MutableLiveData<String> content;

    private HomeViewModel(String key) {
        this.key = key;
    }

    /**
     * 获取数据
     */
    void getContentData() {
        //这里可以加一层Repository从网络/缓存加载数据
        //执行完毕后调用 setValue/postValue方法,最终会回调Activity中的onChange方法
        getContent().setValue("我是获取到的数据" + key);
    }

    MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
        }
        return content;
    }

    public static class Factory implements ViewModelProvider.Factory {

        private String mKey;

        Factory(String key) {
            mKey = key;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return createFactory(modelClass);
        }

        private <T extends ViewModel> T createFactory(Class<T> modelClass) {
            return modelClass.cast(new HomeViewModel(mKey));
        }
    }
}
