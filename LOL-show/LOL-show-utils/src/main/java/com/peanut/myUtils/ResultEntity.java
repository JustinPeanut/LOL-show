package com.peanut.myUtils;

/**
 * @author Peanut
 * 用于定义返回json数据的正确还是错误
 */
public class  ResultEntity <T>{
    /**
     * FAILED:失败的状态信息
     * SUCCEED:成功的状态信息
     * data：定义返回的json数据
     * message:失败返回的信息
     */
    public static final  String FAILED="failed";
    public static final String SUCCEED = "succeed";
    private T data;
    private String message;
    private String status;

    public ResultEntity(T data, String message,String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultEntity(){}

    /**
     * @param message
     * @return ResultEntity
     * 失败返回信息即可
     */
    public static ResultEntity failedWithOutData(String message){
        return new ResultEntity(null,message,FAILED);
    }

    /**
     * 成功并且返回数据
     * @param data
     * @param status
     * @param <T>
     * @return
     */
    public static <T> ResultEntity succeedWithData(T data,String status){
        return new ResultEntity(data,null,SUCCEED);
    }

    /**
     * 成功但是不返回数据
     * @param status
     * @return
     */
    public static ResultEntity succeedWithOutData(String status){
        return new ResultEntity(null,null,status);
    }



}
