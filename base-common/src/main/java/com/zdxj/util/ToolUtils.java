package com.zdxj.util;

import org.apache.commons.lang3.StringUtils;

public class ToolUtils {

    /**
     * 处理不安全的字符
     * @param str
     * @return
     */
    public static String CheckStr(String str){
        if(StringUtils.isBlank(str)){
            return str ;
        }
        str = str.replaceAll(">", "＞");
        str = str.replaceAll("<", "＜");
        str = str.replaceAll("\'", "＇");
        str = str.replaceAll("\"", "＂");
        str = str.replaceAll("&", "＆");
        str = str.replaceAll("#", "＃");
        return str ;
    }
    /**
     * 处理搜索时不安全的字符
     * @param str
     * @return
     */
    public static String CheckSearchStr(String str){
        if(StringUtils.isBlank(str)){
            return str ;
        }
        str = str.replaceAll(">", "＞");
        str = str.replaceAll("<", "＜");
        str = str.replaceAll("\'", "＇");
        str = str.replaceAll("\"", "＂");
        str = str.replaceAll("&", "＆");
        str = str.replaceAll("#", "＃");
        str = str.replaceAll("%", "/%");
        str = str.replaceAll("_", "/_");
        str = str.replaceAll("/", "//");
        return str ;
    }
}
