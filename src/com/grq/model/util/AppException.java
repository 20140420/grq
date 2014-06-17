package com.grq.model.util;
/**
 * 异常
 * @author JiangQuan
 *
 */
public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	private String[] args;
	private String defaultMessage;
	
	public AppException(String message){
		this.message = message;
	}
	public AppException(String message, String...args){
		this.message = message;
		if(args != null && args.length > 0){
			System.out.println("^V^ args is not null!:"+args);
		}
	}
	public AppException(String message, String[] args, String defaultMessage) {
		this.message = message;
		this.args = args;
		this.defaultMessage = defaultMessage;
	}
	/**
	 * 获取异常message
	 */
	@Override
	public String getMessage() {
		return message;
	}
	public String[] getArgs() {
		return args;
	}
	public String getDefaultMessage() {
		return defaultMessage;
	}
}
