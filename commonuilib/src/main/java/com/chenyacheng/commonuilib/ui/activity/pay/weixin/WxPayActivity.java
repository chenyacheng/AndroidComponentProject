package com.chenyacheng.commonuilib.ui.activity.pay.weixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.chenyacheng.commonuilib.constant.StringConstant;
import com.chenyacheng.commonuilib.config.AppConfig;
import com.chenyacheng.wxannotaion.WXAppId;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 微信支付回调
 *
 * @author chenyacheng
 * @date 2019/03/16
 */
@WXAppId("com.chenyacheng.component")
public class WxPayActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, AppConfig.WX_APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        /*
        0	成功	展示成功页面
        -1	错误	可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
        -2	用户取消	无需处理。发生场景：用户不支付了，点击取消，返回APP。
        */
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            Intent intent = new Intent();
            switch (resp.errCode) {
                case 0:
                    intent.setAction(StringConstant.BROADCAST_PAY_SUCCESS);
                    sendBroadcast(intent);
                    break;
                case -2:
                    intent.setAction(StringConstant.BROADCAST_PAY_CANCEL);
                    sendBroadcast(intent);
                    break;
                default:
                    intent.setAction(StringConstant.BROADCAST_PAY_ERROR);
                    sendBroadcast(intent);
                    break;
            }
            finish();
        }
    }
}
