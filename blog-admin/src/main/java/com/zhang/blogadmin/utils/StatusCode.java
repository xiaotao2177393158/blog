package com.zhang.blogadmin.utils;

/**
 * 返回码
 */
public class StatusCode {
    public static final int OK = 200;//成功
    public static final int ERROR = 201;//失败
    public static final int LOGINERROR = 202;//用户名或密码错误
    public static final int ACCESSERROR = 203;//权限不足
    public static final int REMOTEERROR = 204;//远程调用失败
    public static final int REPERROR = 205;//重复操作
    public static final int NOTFOUNDERROR = 206;//没有对应的抢购数据
    public static final int OLDPASSERROR = 207;//旧密码错误
    public static final int SUCCESS_login = 208;//用户登录成功
    public static final int SUCCESS_logout = 209;//用户退出成功
    public static final int NOTLOGIN = 419;// 没有登录

    /* 参数错误：1000～1999 */
    public static final int PARAM_NOT_VALID = 1001; // 参数无效
    public static final int PARAM_IS_BLANK = 1002;  // 参数为空
    public static final int PARAM_TYPE_ERROR = 1003;  // 参数类型错误
    public static final int PARAM_NOT_COMPLETE = 1004;  // 参数缺失
    public static final int USER_ACCOUNT_EXPIRED = 2002;   // 账号已过期
    public static final int USER_CREDENTIALS_ERROR = 2003;  // 密码错误
    public static final int USER_CREDENTIALS_EXPIRED = 2004;  // 密码过期
    public static final int USER_ACCOUNT_DISABLE = 2005;  // 账号不可用
    public static final int USER_ACCOUNT_LOCKED = 2006;  // 账号被锁定
    public static final int USER_ACCOUNT_NOT_EXIST = 2007; //  账号不存在
    public static final int USER_ACCOUNT_ALREADY_EXIST = 2008;  // 账号已存在
    public static final int USER_ACCOUNT_USE_BY_OTHERS = 2009;   //  账号下线

}
