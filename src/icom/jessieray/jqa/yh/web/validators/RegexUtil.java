package icom.jessieray.jqa.yh.web.validators;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * Java表单验证工具类
 * 
 * @author jiqinlin
 * 
 */
@SuppressWarnings("unchecked")
public class RegexUtil {

    public static void main(String[] args) {
//        System.out.println("过滤中英文特殊字符: "+RegexUtil.stringFilter("中国~~!#$%%."));
//        System.out.println("是否包含中英文特殊字符: "+RegexUtil.isContainsSpecialChar("12"));
//        System.out.println("过滤html代码: "+RegexUtil.htmltoText("<JAVASCRIPT>12</JAVASCRIPT>DDDDD"));
//        System.out.println("判断中文字符: "+RegexUtil.isChineseChar("中国！"));
        System.out.println("匹配汉字: "+RegexUtil.isMoney("1000"));
//        System.out.println("判断英文字符: "+RegexUtil.isEnglish("abc!"));
//        System.out.println("判断合法字符: "+RegexUtil.isRightfulString("abc_-11AAA"));
//        System.out.println("邮政编码验证: "+RegexUtil.isZipCode("162406"));
//        System.out.println("身份证号码验证: "+RegexUtil.isIdCardNo("35052419880210133e"));
//        System.out.println("手机号码验证: "+RegexUtil.isMobile("18918611111"));
//        System.out.println("电话号码验证: "+RegexUtil.isPhone("8889333"));
//        System.out.println("电话号码验证: "+RegexUtil.isNumeric("888.9333"));
//        System.out.println("匹配密码: "+RegexUtil.isPwd("d888d_ddddd"));
//        System.out.println("匹配密码: "+RegexUtil.isUrl("http://baidu.com"));
        System.out.println("验证字符: "+RegexUtil.stringCheck("中文aabc001_-"));
//        System.out.println(isEmail("416501600@qq.com"));
        //http://baidu.com www.baidu.com baidu.com
//        System.out.println(NumberUtils.toInt("-0000000002"));
    }
    
    /** 
     * Email正则表达式="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
     */
    //public static final String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";; 
    public static final String EMAIL = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
    /** 
     * 电话号码正则表达式= (^(\d{2,4}[-_－—]?)?\d{3,8}([-_－—]?\d{3,8})?([-_－—]?\d{1,7})?$)|(^0?1[35]\d{9}$) 
     */
    public static final String PHONE = "(^(\\d{2,4}[-_－—]?)?\\d{3,8}([-_－—]?\\d{3,8})?([-_－—]?\\d{1,7})?$)|(^0?1[35]\\d{9}$)" ; 
    /** 
     * 手机号码正则表达式=^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$
     */
    public static final String MOBILE ="^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$"; 
    
    /** 
     * Integer正则表达式 ^-?(([1-9]\d*$)|0) 
     */
    public static final String INTEGER = "^-?(([1-9]\\d*$)|0)"; 
    /** 
     * 正整数正则表达式 >=0 ^[1-9]\d*|0$ 
     */
    public static final String INTEGER_NEGATIVE = "^[1-9]\\d*|0$"; 
    /** 
     * 负整数正则表达式 <=0 ^-[1-9]\d*|0$ 
     */
    public static final String INTEGER_POSITIVE = "^-[1-9]\\d*|0$";   
    /** 
     * Double正则表达式 ^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$ 
     */
    public static final String DOUBLE ="^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$"; 
    /** 
     * 正Double正则表达式 >=0 ^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$　 
     */
    public static final String DOUBLE_NEGATIVE ="^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0$";
    
    public static final String MONEY ="[1-9]{1}[0-9]*\\.\\d{1,2}|0\\.\\d{1,2}|0|[1-9]{1}[0-9]*";
    /** 
     * 负Double正则表达式 <= 0 ^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$ 
     */
    public static final String DOUBLE_POSITIVE ="^(-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*))|0?\\.0+|0$";  
    /** 
     * 年龄正则表达式 ^(?:[1-9][0-9]?|1[01][0-9]|120)$ 匹配0-120岁 
     */
    public static final String AGE="^(?:[1-9][0-9]?|1[01][0-9]|120)$"; 
    /** 
     * 邮编正则表达式 [0-9]\d{5}(?!\d) 国内6位邮编 
     */
    public static final String CODE="[0-9]\\d{5}(?!\\d)";  
    /** 
     * 匹配由数字、26个英文字母或者下划线组成的字符串 ^\w+$ 
     */
    public static final String STR_ENG_NUM_="^\\w+$"; 
    /** 
     * 匹配由数字和26个英文字母组成的字符串 ^[A-Za-z0-9]+$ 
     */
    public static final String STR_ENG_NUM="^[A-Za-z0-9]+"; 
    /** 
     * 匹配由26个英文字母组成的字符串 ^[A-Za-z]+$ 
     */
    public static final String STR_ENG="^[A-Za-z]+$"; 
    /** 
     * 过滤特殊字符串正则 
     * regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]"; 
     */
    public static final String STR_SPECIAL="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]"; 
    /*** 
     * 日期正则 支持： 
     * YYYY-MM-DD 
     * YYYY/MM/DD 
     * YYYY_MM_DD 
     * YYYYMMDD 
     * YYYY.MM.DD的形式 
     */
    public static final String DATE_ALL="((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._]?)(10|12|0?[13578])([-\\/\\._]?)(3[01]|[12][0-9]|0?[1-9])$)" + 
        "|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._]?)(11|0?[469])([-\\/\\._]?)(30|[12][0-9]|0?[1-9])$)" + 
        "|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._]?)(0?2)([-\\/\\._]?)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|(^([3579][26]00)" + 
        "([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)" + 
        "|(^([1][89][0][48])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|(^([2-9][0-9][0][48])([-\\/\\._]?)" + 
        "(0?2)([-\\/\\._]?)(29)$)" + 
        "|(^([1][89][2468][048])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._]?)(0?2)" + 
        "([-\\/\\._]?)(29)$)|(^([1][89][13579][26])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$)|" + 
        "(^([2-9][0-9][13579][26])([-\\/\\._]?)(0?2)([-\\/\\._]?)(29)$))"; 
    /*** 
     * 日期正则 支持： 
     * YYYY-MM-DD 
     */
    public static final String DATE_FORMAT1="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
      
    /** 
     * URL正则表达式 
     * 匹配 http www ftp 
     */
    public static final String URL = "^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?" + 
                    "(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*" + 
                    "(\\w*:)*(\\w*\\+)*(\\w*\\.)*" + 
                    "(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";  
    
    /** 
     * 身份证正则表达式 
     */
    public static final String IDCARD="((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})" + 
                      "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" + 
                      "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";
      
    /**
     * 机构代码
     */
    public static final String JIGOU_CODE = "^[A-Z0-9]{8}-[A-Z0-9]$";
      
    /**
     * 匹配数字组成的字符串 ^[0-9]+$ 
     */
    public static final String STR_NUM = "^[0-9]+$"; 
       
  ////------------------验证方法    
    /** 
     * 判断字段是否为空 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static synchronized boolean StrisNull(String str) { 
      return null == str || str.trim().length() <= 0 ? true : false ; 
    } 
    /** 
     * 判断字段是非空 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean StrNotNull(String str) { 
      return !StrisNull(str) ; 
    } 
    
    public static boolean isMoney(String str) { 
    	System.out.println(str);
        return Regular(str,MONEY); 
      } 
    /** 
     * 字符串null转空 
     * @param str 
     * @return boolean 
     */
    public static String nulltoStr(String str) {
      return StrisNull(str)?"":str; 
    }   
    /** 
     * 字符串null赋值默认值 
     * @param str  目标字符串 
     * @param defaut 默认值 
     * @return String 
     */
    public static String nulltoStr(String str,String defaut) { 
      return StrisNull(str)?defaut:str; 
    } 
    /** 
     * 判断字段是否为Email 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isEmail(String str) { 
      return Regular(str,EMAIL); 
    } 
    /** 
     * 判断是否为电话号码 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isPhone(String str) { 
      return Regular(str,PHONE); 
    } 
    /** 
     * 判断是否为手机号码 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isMobile(String str) { 
      return Regular(str,MOBILE); 
    } 
    /** 
     * 判断是否为Url 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isUrl(String str) { 
      return Regular(str,URL); 
    }   
    /** 
     * 判断字段是否为数字 正负整数 正负浮点数 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isNumber(String str) { 
      return Regular(str,DOUBLE); 
    } 
    /** 
     * 判断字段是否为INTEGER 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isInteger(String str) { 
      return Regular(str,INTEGER); 
    } 
    /** 
     * 判断字段是否为正整数正则表达式 >=0 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isINTEGER_NEGATIVE(String str) { 
      return Regular(str,INTEGER_NEGATIVE); 
    } 
    /** 
     * 判断字段是否为负整数正则表达式 <=0 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isINTEGER_POSITIVE(String str) { 
      return Regular(str,INTEGER_POSITIVE); 
    }   
    /** 
     * 判断字段是否为DOUBLE 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isDouble(String str) { 
      return Regular(str,DOUBLE); 
    } 
    /** 
     * 判断字段是否为正浮点数正则表达式 >=0 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isDOUBLE_NEGATIVE(String str) { 
      return Regular(str,DOUBLE_NEGATIVE); 
    } 
    /** 
     * 判断字段是否为负浮点数正则表达式 <=0 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isDOUBLE_POSITIVE(String str) { 
      return Regular(str,DOUBLE_POSITIVE); 
    }   
    /** 
     * 判断字段是否为日期 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isDate(String str) { 
      return Regular(str,DATE_ALL); 
    } 
    /**
     * 验证2010-12-10
     * @param str
     * @return
     */
    public static boolean isDate1(String str) { 
      return Regular(str,DATE_FORMAT1); 
    } 
    /** 
     * 判断字段是否为年龄 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isAge(String str) { 
      return Regular(str,AGE) ; 
    } 
    /** 
     * 判断字段是否超长 
     * 字串为空返回fasle, 超过长度{leng}返回ture 反之返回false 
     * @param str 
     * @param leng 
     * @return boolean 
     */
    public static boolean isLengOut(String str,int leng) {    
      return StrisNull(str)?false:str.trim().length() > leng ; 
    } 
    
    public static boolean isLength(String str, int min, int max){
    	return StrisNull(str)?false:(str.trim().length() >= min && str.trim().length() <= min);
    }
    /** 
     * 判断字段是否为身份证 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isIdCard(String str) { 
      if(StrisNull(str)) return false ; 
      if(str.trim().length() == 15 || str.trim().length() == 18) { 
          return Regular(str,IDCARD); 
      }else { 
        return false ; 
      } 
         
    } 
    /** 
     * 判断字段是否为邮编 符合返回ture 
     * @param str 
     * @return boolean 
     */
    public static boolean isCode(String str) { 
      return Regular(str,CODE) ; 
    } 
    /** 
     * 判断字符串是不是全部是英文字母 
     * @param str 
     * @return boolean 
     */
    public static boolean isEnglish(String str) { 
      return Regular(str,STR_ENG) ; 
    } 
    /** 
     * 判断字符串是不是全部是英文字母+数字 
     * @param str 
     * @return boolean 
     */
    public static boolean isENG_NUM(String str) { 
      return Regular(str,STR_ENG_NUM) ; 
    } 
    /** 
     * 判断字符串是不是全部是英文字母+数字+下划线 
     * @param str 
     * @return boolean 
     */
    public static boolean isENG_NUM_(String str) { 
      return Regular(str,STR_ENG_NUM_) ; 
    } 
    /** 
     * 过滤特殊字符串 返回过滤后的字符串 
     * @param str 
     * @return boolean 
     */
    public static String filterStr(String str) { 
      Pattern p = Pattern.compile(STR_SPECIAL); 
      Matcher m = p.matcher(str); 
      return  m.replaceAll("").trim(); 
    }
      
    /**
     * 校验机构代码格式
     * @return
     */
    public static boolean isJigouCode(String str){
      return Regular(str,JIGOU_CODE) ; 
    }
      
    /** 
     * 判断字符串是不是数字组成 
     * @param str 
     * @return boolean 
     */
    public static boolean isSTR_NUM(String str) { 
      return Regular(str,STR_NUM) ; 
    } 
      
    /** 
     * 匹配是否符合正则表达式pattern 匹配返回true 
     * @param str 匹配的字符串 
     * @param pattern 匹配模式 
     * @return boolean 
     */
    private static boolean Regular(String str,String pattern){ 
      if(null == str || str.trim().length()<=0) 
        return false;      
      Pattern p = Pattern.compile(pattern); 
      Matcher m = p.matcher(str); 
      return m.matches(); 
    } 
    
    public final static boolean isNull(Object[] objs){
        if(objs==null||objs.length==0) return true;
        return false;
    }
    
    public final static boolean isNull(Integer integer){
        if(integer==null||integer==0) return true;
        return false;
    }
    
    public final static boolean isNull(Collection collection){
        if(collection==null||collection.size()==0) return true;
        return false;
    }
    
    public final static boolean isNull(Map map){
        if(map==null||map.size()==0) return true;
        return false;
    }
    
    public final static boolean isNull(String str){
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
    }
    
    
    public final static boolean isNull(Long longs){
        if(longs==null||longs==0) return true;
        return false;
    }
    
    public final static boolean isNotNull(Long longs){
        return !isNull(longs);
    }
    
    public final static boolean isNotNull(String str){
        return !isNull(str);
    }
    
    public final static boolean isNotNull(Collection collection){
        return !isNull(collection);
    }
    
    public final static boolean isNotNull(Map map){
        return !isNull(map);
    }
    
    public final static boolean isNotNull(Integer integer){
        return !isNull(integer);
    }
    
    public final static boolean isNotNull(Object[] objs){
        return !isNull(objs);
    }
    
    /**
     * 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isPwd(String str) {
        return match(str, "^[a-zA-Z]\\w{6,12}$");
    }
    
    /**
     * 验证字符，只能包含中文、英文、数字、下划线等字符。
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean stringCheck(String str) {
        return match(str, "^[a-zA-Z0-9\u4e00-\u9fa5-_]+$");
    }
    
    /**
     * 判断数值类型，包括整数和浮点数
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isNumeric(String str) { 
        if(isFloat(str) || isInteger(str)) return true;
        return false;
    }
    
    /**
     * 只能输入数字
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isDigits(String str) {
        return match(str, "^[0-9]*$");
    }
    
    /**
     * 匹配正浮点数
     * 
     * @param str
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloat(String str) {
        return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
    }
    
    /**
     * 联系电话(手机/电话皆可)验证   
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isTel(String text){
        if(isMobile(text)||isPhone(text)) return true;
        return false;
    }
    
    /**
     * 身份证号码验证 
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isIdCardNo(String text){
        return match(text, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
    }
    
    /**
     * 邮政编码验证 
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isZipCode(String text){
        return match(text, "^[0-9]{6}$");
    }
    
    /**
     * 判断整数num是否等于0
     * 
     * @param num
     * @return
     * @author jiqinlin
     */
    public final static boolean isIntEqZero(int num){ 
         return num==0;
    }
    
    /**
     * 判断整数num是否大于0
     * 
     * @param num
     * @return
     * @author jiqinlin
     */
    public final static boolean isIntGtZero(int num){ 
         return num>0;
    }
    
    /**
     * 判断整数num是否大于或等于0
     * 
     * @param num
     * @return
     * @author jiqinlin
     */
    public final static boolean isIntGteZero(int num){ 
        return num>=0;
    }
    
    /**
     * 判断浮点数num是否等于0
     * 
     * @param num 浮点数
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloatEqZero(float num){ 
         return num==0f;
    }
    
    /**
     * 判断浮点数num是否大于0
     * 
     * @param num 浮点数
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloatGtZero(float num){ 
         return num>0f;
    }
    
    /**
     * 判断浮点数num是否大于或等于0
     * 
     * @param num 浮点数
     * @return
     * @author jiqinlin
     */
    public final static boolean isFloatGteZero(float num){ 
        return num>=0f;
    }
    
    /**
     * 判断是否为合法字符(a-zA-Z0-9-_)
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isRightfulString(String text){
        return match(text, "^[A-Za-z0-9_-]+$"); 
    }
    
    /**
     * 判断中文字符(包括汉字和符号)
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isChineseChar(String text){
        return match(text, "^[\u0391-\uFFE5]+$");
    }
    
    /**
     * 匹配汉字
     * 
     * @param text
     * @return
     * @author jiqinlin
     */
    public final static boolean isChinese(String text){
        return match(text, "^[\u4e00-\u9fa5]+$");
    }
    
    /**
     * 是否包含中英文特殊字符，除英文"-_"字符外
     * 
     * @param str
     * @return
     */
    public static boolean isContainsSpecialChar(String text) {
        if(StringUtils.isBlank(text)) return false;
        String[] chars={"[","`","~","!","@","#","$","%","^","&","*","(",")","+","=","|","{","}","'",
                ":",";","'",",","[","]",".","<",">","/","?","~","！","@","#","￥","%","…","&","*","（","）",
                "—","+","|","{","}","【","】","‘","；","：","”","“","’","。","，","、","？","]"};
        for(String ch : chars){
            if(text.contains(ch)) return true;
        }
        return false;
    }
    
    /**
     * 过滤中英文特殊字符，除英文"-_"字符外
     * 
     * @param text
     * @return
     */
    public static String stringFilter(String text) {
        String regExpr="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
        Pattern p = Pattern.compile(regExpr);
        Matcher m = p.matcher(text);
        return m.replaceAll("").trim();     
    }
    
    /**
     * 过滤html代码
     * 
     * @param inputString 含html标签的字符串
     * @return
     */
    public static String htmlFilter(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        java.util.regex.Pattern p_ba;
        java.util.regex.Matcher m_ba;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String patternStr = "\\s+";

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_ba = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
            m_ba = p_ba.matcher(htmlStr);
            htmlStr = m_ba.replaceAll(""); // 过滤空格

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr;// 返回文本字符串
    }
    
    /**
     * 正则表达式匹配
     * 
     * @param text 待匹配的文本
     * @param reg 正则表达式
     * @return
     * @author jiqinlin
     */
    private final static boolean match(String text, String reg) {
        if (StringUtils.isBlank(text) || StringUtils.isBlank(reg))
            return false;
        return Pattern.compile(reg).matcher(text).matches();
    }
	public static boolean isDayStr(String str) {
		// TODO Auto-generated method stub
		return isINTEGER_NEGATIVE(str) && str.length()== 8;
	}
	public static boolean isMonthStr(String str) {
		// TODO Auto-generated method stub
		return isINTEGER_NEGATIVE(str) && str.length()== 6;
	}
	public static boolean isPayChanel(String paramVal) {
		String payChanels[] = new String[]{"AL","WX","CB","MB"};
		List<String> list = Arrays.asList(payChanels);
		return list.contains(paramVal);
	}
	public static boolean isCardId(String paramVal) {
		return isLength(paramVal, 10, 10) && isInteger(paramVal);
	}
    
    

// 参考地址：http://www.cnblogs.com/yansheng/archive/2010/05/07/1730188.html    

// 附 ： 常用的正则表达式：
//    匹配特定数字：
//    ^[1-9]d*$　 　 //匹配正整数
//    ^-[1-9]d*$ 　 //匹配负整数
//    ^-?[1-9]d*$　　 //匹配整数
//    ^[1-9]d*|0$　 //匹配非负整数（正整数 + 0）
//    ^-[1-9]d*|0$　　 //匹配非正整数（负整数 + 0）
//    ^[1-9]d*.d*|0.d*[1-9]d*$　　 //匹配正浮点数
//    ^-([1-9]d*.d*|0.d*[1-9]d*)$　 //匹配负浮点数
//    ^-?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$　 //匹配浮点数
//    ^[1-9]d*.d*|0.d*[1-9]d*|0?.0+|0$　　 //匹配非负浮点数（正浮点数 + 0）
//    ^(-([1-9]d*.d*|0.d*[1-9]d*))|0?.0+|0$　　//匹配非正浮点数（负浮点数 + 0）
//    评注：处理大量数据时有用，具体应用时注意修正
//
//    匹配特定字符串：
//    ^[A-Za-z]+$　　//匹配由26个英文字母组成的字符串
//    ^[A-Z]+$　　//匹配由26个英文字母的大写组成的字符串
//    ^[a-z]+$　　//匹配由26个英文字母的小写组成的字符串
//    ^[A-Za-z0-9]+$　　//匹配由数字和26个英文字母组成的字符串
//    ^w+$　　//匹配由数字、26个英文字母或者下划线组成的字符串
//
//    在使用RegularExpressionValidator验证控件时的验证功能及其验证表达式介绍如下:
//
//    只能输入数字：“^[0-9]*$”
//    只能输入n位的数字：“^d{n}$”
//    只能输入至少n位数字：“^d{n,}$”
//    只能输入m-n位的数字：“^d{m,n}$”
//    只能输入零和非零开头的数字：“^(0|[1-9][0-9]*)$”
//    只能输入有两位小数的正实数：“^[0-9]+(.[0-9]{2})?$”
//    只能输入有1-3位小数的正实数：“^[0-9]+(.[0-9]{1,3})?$”
//    只能输入非零的正整数：“^+?[1-9][0-9]*$”
//    只能输入非零的负整数：“^-[1-9][0-9]*$”
//    只能输入长度为3的字符：“^.{3}$”
//    只能输入由26个英文字母组成的字符串：“^[A-Za-z]+$”
//    只能输入由26个大写英文字母组成的字符串：“^[A-Z]+$”
//    只能输入由26个小写英文字母组成的字符串：“^[a-z]+$”
//    只能输入由数字和26个英文字母组成的字符串：“^[A-Za-z0-9]+$”
//    只能输入由数字、26个英文字母或者下划线组成的字符串：“^w+$”
//    验证用户密码:“^[a-zA-Z]\\w{5,17}$”正确格式为：以字母开头，长度在6-18之间，
//
//    只能包含字符、数字和下划线。
//    验证是否含有^%&’,;=?$”等字符：“[^%&’,;=?$x22]+”
//    只能输入汉字：“^[u4e00-u9fa5],{0,}$”
//    验证Email地址：“^w+[-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$”
//    验证InternetURL：“^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$”
//    验证电话号码：“^((d{3,4})|d{3,4}-)?d{7,8}$”
//
//    正确格式为：“XXXX-XXXXXXX”，“XXXX-XXXXXXXX”，“XXX-XXXXXXX”，
//
//    “XXX-XXXXXXXX”，“XXXXXXX”，“XXXXXXXX”。
//    验证身份证号（15位或18位数字）：“^d{15}|d{}18$”
//    验证一年的12个月：“^(0?[1-9]|1[0-2])$”正确格式为：“01”-“09”和“1”“12”
//    验证一个月的31天：“^((0?[1-9])|((1|2)[0-9])|30|31)$” 正确格式为：“01”“09”和“1”“31”。
//
//    匹配中文字符的正则表达式： [u4e00-u9fa5]
//    匹配双字节字符(包括汉字在内)：[^x00-xff]
//    匹配空行的正则表达式：n[s| ]*r
//    匹配HTML标记的正则表达式：/< (.*)>.*|< (.*) />/
//    匹配首尾空格的正则表达式：(^s*)|(s*$)
//    匹配Email地址的正则表达式：w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*
//    匹配网址URL的正则表达式：^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$
}