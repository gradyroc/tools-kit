package cn.grady.exceptions;

import cn.grady.interfaces.BasicEnum;

/**
 * @author rociss
 * @version 1.0, on 22:31 2020/4/1.
 */
public class DataFlowsException extends RuntimeException{

    private static final long serialVersionUID = 8093596867786502598L;

    /*
    错误码，int 或者 String
     */
    private String code;

    public DataFlowsException(){
        super();
    }

    public DataFlowsException(Throwable cause){
        super(cause);
    }
    public DataFlowsException(String code, Throwable cause){
        super(cause);
        this.code = code;

    }

    public DataFlowsException(String code, String message, Throwable cause){
        super(message,cause);
        this.code = code;
    }


    /*
    增加兼容enum 统一处理异常的构造函数
     */
    public DataFlowsException(BasicEnum<String > errorEnum, String ... param){
        super(String.format(errorEnum.getDescription(),param));
        this.code = errorEnum.getValue();

    }

    public DataFlowsException(BasicEnum<String > errorEnum, Throwable cause, String ... param){
        super(String.format(errorEnum.getDescription(),param),cause);
        this.code = errorEnum.getValue();

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
