package edu.zk.controller;

import edu.zk.exception.BusinessException;
import edu.zk.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp exceptionHandler(Exception e){
        CommonResp<Object> commonResp = new CommonResp<>();
        LOG.error("系统异常：",e);
        commonResp.setSuccess(false);
//        commonResp.setMessage(e.getMessage());
        commonResp.setMessage("系统异常，请联系管理员");
        return commonResp;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp businessExceptionHandler(BusinessException e){
        CommonResp<Object> commonResp = new CommonResp<>();
        LOG.error("业务异常：{}",e.getE().getDesc());
        commonResp.setSuccess(false);
//        commonResp.setMessage(e.getMessage());
        commonResp.setMessage(e.getE().getDesc());
        return commonResp;
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp bindExceptionHandler(BindException e){
        CommonResp<Object> commonResp = new CommonResp<>();
        LOG.error("校验异常：{}",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResp.setSuccess(false);
//        commonResp.setMessage(e.getMessage());
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }
}
