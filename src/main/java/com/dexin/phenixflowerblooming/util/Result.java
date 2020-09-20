package com.dexin.phenixflowerblooming.util;

import lombok.Data;

/**
 * Created by biuld on 2019/8/20.
 */
@Data
public class Result<T> {

    private Integer code;// 操作状态
    private String msg;// 返回信息
    private T data;// 返回数据

    public enum ErrCode {

        DONATION_MISSING(5021, "捐款异常，请稍后再试"),
        LOGIN_ERROR(5022, "用户名或者密码错误");

        private Integer code;
        private String msg;

        ErrCode(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getMsg() {
            return this.msg;
        }

        public Integer getCode() {
            return this.code;
        }
    }

    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static Result<String> success() {
        return success("ok", null);
    }

    public static Result<String> success(String msg) {
        return success(msg, null);
    }

    public static <T> Result<T> success(T data) {
        return success("ok", data);
    }


    public static <T> Result<T> error(ErrCode errCode) {
        Result<T> result = new Result<>();
        result.code = errCode.code;
        result.msg = errCode.msg;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 400;
        result.msg = msg;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
            "\"code\":" + code +
            ", \"msg\":\"" + msg + "\"" +
            ", \"data\":\"" + data + "\"" +
            '}';
    }
}

