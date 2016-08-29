package com.zlw.mymodel.service;


/**
 * 数据 回调接口
 */
public interface ILoadDataListener {

    /**
     * 返回成功结果处理事件
     *
     * @param result 返回正确结果，解析后返回的解析结果
     */
    public void onParserSuccess(Object result);


}
