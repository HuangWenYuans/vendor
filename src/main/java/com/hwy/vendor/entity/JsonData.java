/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: JsonData
 * Author:   huangwenyuan
 * Date:     2019/06/20 上午 10:39
 * Description:
 */

package com.hwy.vendor.entity;


/**
 * 功能描述: 
 * @author huangwenyuan
 * @create 2019/06/20
 * @since 1.0.0
 */
public class JsonData {

    private Integer code;
    private String msg;

    public JsonData() {
    }

    public JsonData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

    