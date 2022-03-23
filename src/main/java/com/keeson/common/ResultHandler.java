package com.keeson.common;
import java.util.HashMap;

public class ResultHandler extends HashMap<String,Object> {

    private static  final  long serialVersionUID = 1L;

    private static  final  String Code = "code";
    private static  final  String MSG = "msg";
    private static  final  String Data = "data";
    private static  final  String SUCCESS_MSG= "操作成功";
    private static  final  String ERROR_MSG= "操作失败";

    private static  final  Integer SUCCESS_CODE = 200;
    private static  final  Integer ERROR_CODE = 400;

    public  ResultHandler(){}


    public  ResultHandler(int code,String msg){
        super.put(Code,code);
        super.put(MSG,msg);
    }


    public  ResultHandler(int code,String msg,Object data){
        super.put(Code,code);
        super.put(MSG,msg);
        if(data!=null){
            super.put(Data,data);
        }
    }

    //正确的返回
    public  static  ResultHandler success(){
        return  new ResultHandler(SUCCESS_CODE,SUCCESS_MSG);
    }


    public  static  ResultHandler success(String msg){
        if(msg.isEmpty()){
            return   ResultHandler.success();
        }
        return  new ResultHandler(SUCCESS_CODE,msg);
    }

    public  static  ResultHandler success(String msg,Object data){
        return  new ResultHandler(SUCCESS_CODE,msg,data);
    }



    // 错误返回
    public  static  ResultHandler error(){
        return  new ResultHandler(ERROR_CODE,ERROR_MSG);
    }


    public  static  ResultHandler error(String msg){
        if(msg.isEmpty()){
            return  ResultHandler.error();
        }
        return  new ResultHandler(ERROR_CODE,msg);
    }

    public  static  ResultHandler error(String msg,Object data){
        return  new ResultHandler(ERROR_CODE,msg,data);
    }


}
