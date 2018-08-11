package cn.xry.common.util;

/**
 * 账号ID生成工具
 */
public class NumberUtils {

   public static String getId(){
       long timeMillis = System.currentTimeMillis();
       return String.valueOf(timeMillis/1000);
   }
}
