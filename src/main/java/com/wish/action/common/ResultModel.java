package com.wish.action.common;

import org.apache.commons.lang3.StringUtils;

/**
 * json api返回数据信息
 * Created by fqh on 2015/12/7.
 */
public class ResultModel{

    private String tip;//提示信息
    private Object data;//数据信息

    public ResultModel(String tip, Object data) {
        this.tip = tip;
        this.data = data;
    }

    public ResultModel() {
    }

    public String getTip() {
        if(StringUtils.isEmpty(tip)|| StringUtils.isBlank(tip)){
            return "success";
        }
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * 错误
     */
    public void setErrorTip() {
        this.tip = Constants.TIP_ERROR;
    }
    /**
     * 错误
     */
    public void setErrorTip(String errorMsg) {
        this.tip = errorMsg;
    }

    /**
     * 错误：参数不全
     */
    public void setErrorParamTip() {
        this.tip = Constants.TIP_ERROR;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "tip='" + tip + '\'' +
                ", data=" + data +
                "} " + super.toString();
    }
}
