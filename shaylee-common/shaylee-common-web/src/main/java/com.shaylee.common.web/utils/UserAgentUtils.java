package com.shaylee.common.web.utils;

import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Title: UserAgent工具类(解析IP，操作系统，浏览器等)
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-15
 */
public class UserAgentUtils {
	private static Logger logger = LoggerFactory.getLogger(UserAgentUtils.class);
    private static final String IP_DELIMETER = ",";

	/**
	 * 获取IP地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
	    String unknown = "unknown";
        String ipv6Local = "0:0:0:0:0:0:0:1";
        String ipv4Local = "127.0.0.1";
    	if (request == null) {
    	    return unknown;
        }
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isNotEmpty(ip) && !unknown.equalsIgnoreCase(ip) && ip.contains(IP_DELIMETER)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            ip = ip.split(IP_DELIMETER)[0];
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ipv6Local.equals(ip) ? ipv4Local : ip;
    }

    /**
     * 解析客户端操作系统、浏览器
     */
    public static UserAgent parseUserAgent(HttpServletRequest request) {
        return UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
    }
}
