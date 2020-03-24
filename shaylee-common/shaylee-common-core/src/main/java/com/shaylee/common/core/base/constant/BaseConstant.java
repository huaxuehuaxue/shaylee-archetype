package com.shaylee.common.core.base.constant;

/**
 * 自定义常量的基类。放一些通用的常量，如：delfag的常量等
 * 
 * @author Max
 * @version 1.0
 * @since 2019年1月18日 上午10:28:31
 */
public interface BaseConstant {

	/** 删除标识：0，正常 */
	Integer DEL_FLAG_NORMAL = 0;
	/** 删除标识：1删除 */
	Integer DEL_FLAG_DELETE = 1;

	/** 默认起始页 */
	Integer PAGE_NO = 0;
	/** 默认页数大小 */
	Integer PAGE_SIZE = 10;
	
}
