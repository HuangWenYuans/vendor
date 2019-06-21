/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: AjaxResult
 * Author:   huangwenyuan
 * Date:     2019/06/08 上午 12:54
 * Description:
 */

package com.hwy.vendor.entity;

/**
 * 功能描述: 封装ajax的实体类
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
public class AjaxResult {
    private boolean success;
    private Object data;
    private String msg;

    public AjaxResult() {
    }

    public AjaxResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {

        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
    