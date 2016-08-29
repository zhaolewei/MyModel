package com.zlw.mymodel.service;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zlw.mymodel.common.Const;
import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.main.bean.Datagram;
import com.zlw.mymodel.utils.JsonTools;
import com.zlw.mymodel.utils.LogUtil;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zlw on 2016/6/30 0030
 */
public class DataService2 {

    private static final String text_url = "https://route.showapi.com/255-1";
    private List<ContentEntity> data;

    public void getData(int type, int page, final ILoadDataListener listener) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();

        params.put("showapi_appid", Const.API_APPID);
        params.put("page", page);
        params.put("showapi_sign", Const.API_SIGN);
        params.put("type", type);
        client.post(text_url, params, new AsyncHttpResponseHandler() {
                    // 回调接口
                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          byte[] responseBody) {
                        if (statusCode == 200) {
                            try {
                                String result = new String(responseBody, "UTF-8");
                                LogUtil.i("result:" + result);
                                Datagram datagram = JsonTools.fromJson(result, new TypeToken<Datagram>() {
                                }.getType());

                                data = datagram.getDataContent();
                                listener.onParserSuccess(data);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                                          Throwable arg3) {
                    }
                }
        );

        return;
    }


}
