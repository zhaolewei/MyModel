package com.zlw.mymodel.main.bean;

import java.util.List;

/**
 * 数据返回包（与json对应）
 */
public class Datagram {

    private int showapi_res_code;

    private String showapi_res_error;

    private Showapi_res_body showapi_res_body;

    static class Showapi_res_body {
        public int ret_code;

        public Pagebean pagebean;

        static class Pagebean {
            public int allPages;
            public List<ContentEntity> contentlist;
            public int currentPage;
            public int allNum;
            public int maxResult;
        }
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public Showapi_res_body getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(Showapi_res_body showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }


    public List<ContentEntity> getDataContent() {
        return this.showapi_res_body.pagebean.contentlist;
    }
}
