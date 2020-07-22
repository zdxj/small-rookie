package com.zdxj.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.zdxj.core.Result;


/**
 * 系统全局错误捕捉
 * @author zhaodx
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 实体类字段绑定属性验证错误
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = BindException.class)
	public Result<Object> bindExceptionHandler(BindException e) throws Exception {
	    return Result.failed(e.getBindingResult().getFieldError().getDefaultMessage());
	}
	
	/**
	 * 全部错误
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public Result<Object> exceptionErrorHandler(Exception e) throws Exception {
		if(e instanceof HttpRequestMethodNotSupportedException) {
			return Result.failed("错误的请求方式");
		}
		if(e instanceof MissingServletRequestParameterException) {
			String paramsName =((MissingServletRequestParameterException) e).getParameterName();
			return Result.failed(paramsName+"字段不能为空");
		}
		if(e instanceof MethodArgumentTypeMismatchException) {
			String paramsName =((MethodArgumentTypeMismatchException) e).getName();
			return Result.failed(paramsName+"字段格式错误");
		}
		if(e instanceof HttpMessageNotReadableException) {
			return Result.failed("请求体为空或者错误的请求体");
		}
		if(e instanceof HttpMediaTypeNotSupportedException) {
			return Result.failed("错误的Content type");
		}
		logger.error("全局拦截错误:",e);
		return Result.failed("系统错误，请稍后重试");
	}
}
