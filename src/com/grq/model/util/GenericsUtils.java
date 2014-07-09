package com.grq.model.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * 泛型工具类
 * @author JiangQuan
 */
public class GenericsUtils {
	/**
	 * 获取泛型的类型
	 * @param clazz
	 * @return Class
	 */
	@SuppressWarnings("unchecked")
	public static Class<Object> getGenericType(Class<?> clazz){
		Type genType = clazz.getGenericSuperclass();//得到泛型父类  
		Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
		if (!(types[0] instanceof Class)) {
            return Object.class;   
        } 
		return (Class<Object>) types[0];
	}
	/**
	 * 获取对象的类名称,可用于获取POJO类数据表名
	 * @param clazz
	 * @return 类名称
	 */
	//@SuppressWarnings("unchecked")
	public static String getGenericName(Class<?> clazz){
		return clazz.getSimpleName();
	}
}
