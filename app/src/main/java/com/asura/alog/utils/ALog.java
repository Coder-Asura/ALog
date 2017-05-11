package com.asura.alog.utils;

import com.asura.alog.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Asura on 2017/5/11 15:27.
 * <p>
 * ALog提供INFO、DEBUG、ERROR级别的日志输出，配合Logger的优化，让日志打印输出工作变得更美好一点
 */
public class ALog {
    private static final String TAG = "ALog";
    private static final String METHOD_LINE = "() : \n";
    private static final String SPLIT_LINE = "<---------->%s";
    private static final String SPLIT_LINE2 = "<---------->%s\n";

    /**
     * INFO 级别日志输出
     *
     * @param object 打印的对象，因为使用 Logger ，所以 object 可以为集合对象
     */
    public static void i(Object object) {
        Logger.i(object.toString());
    }

    /**
     * DEBUG级别日志输出
     *
     * @param title 要打印的信息名称
     * @param args  可变参数，对不同长度做了大致划分,日志大致如下：
     *              methodName() :
     *              title<---------->message1
     *              title2<---------->message2
     *              title3<---------->message3
     */
    public static void d(Object title, Object... args) {
        if (args != null) {
            if (args.length == 0) {
                Logger.d(title);
            } else if (args.length == 1) {
                Logger.d(title + SPLIT_LINE, args[0]);
            } else if (args.length == 2) {
                Logger.d(title + METHOD_LINE + (String) args[0] + SPLIT_LINE, args[1]);
            } else if (args.length == 3) {
                Logger.d(title + SPLIT_LINE2 + args[1] + SPLIT_LINE, args[0], args[2]);
            } else if (args.length == 4) {
                Logger.d(title + METHOD_LINE + (String) args[0] + SPLIT_LINE2 + args[2] + SPLIT_LINE, args[1], args[3]);
            } else if (args.length == 5) {
                Logger.d(title + SPLIT_LINE2 + args[1] + SPLIT_LINE2 + args[3] + SPLIT_LINE, args[0], args[2], args[4]);
            } else if (args.length == 6) {
                Logger.d(title + METHOD_LINE + (String) args[0] + SPLIT_LINE2 + args[2] + SPLIT_LINE2 + args[4] + SPLIT_LINE, args[1], args[3], args[5]);
            } else {
                Logger.d((String) title, args);
            }
        }
    }

    /**
     * ERROR 级别日志输出
     *
     * @param title 要打印的信息名称
     * @param args  可变参数，对不同长度做了大致划分,日志大致如下：
     *              title<---------->message
     */
    public static void e(Object title, Object... args) {
        if (args != null) {
            if (args.length == 0) {
                Logger.e((String) title);
            } else if (args.length == 1) {
                Logger.e(title + SPLIT_LINE, args[0]);
            } else {
                Logger.e((String) title, args);
            }
        }
    }

    /**
     * ERROR 级别日志输出
     *
     * @param throwable 抛出的异常
     * @param title     异常信息的名称
     * @param args      可变参数，对不同长度做了大致划分,日志大致如下：
     *                  title<---------->message
     */
    public static void e(Throwable throwable, Object title, Object... args) {
        if (args != null) {
            if (args.length == 0) {
                Logger.e(throwable, (String) title);
            } else if (args.length == 1) {
                Logger.e(throwable, title + SPLIT_LINE, args[0]);
            } else {
                Logger.e(throwable, (String) title, args);
            }
        }
    }

    /**
     * 替换默认TAG后，DEBUG级别日志输出
     *
     * @param newTag 更换新的tag
     * @param title  要打印的信息名称
     * @param args   可变参数，对不同长度做了大致划分,日志大致如下：
     *               methodName() :
     *               title1<---------->message1
     *               title2<---------->message2
     *               title3<---------->message3
     */
    public static void t(String newTag, Object title, Object... args) {
        if (args != null) {
            if (args.length == 0) {
                Logger.t(newTag).d(title);
            } else if (args.length == 1) {
                Logger.t(newTag).d(title + SPLIT_LINE, args[0]);
            } else if (args.length == 2) {
                Logger.t(newTag).d(title + METHOD_LINE + (String) args[0] + SPLIT_LINE, args[1]);
            } else if (args.length == 3) {
                Logger.t(newTag).d(title + SPLIT_LINE2 + args[1] + SPLIT_LINE, args[0], args[2]);
            } else if (args.length == 4) {
                Logger.t(newTag).d(title + METHOD_LINE + (String) args[0] + SPLIT_LINE2 + args[2] + SPLIT_LINE, args[1], args[3]);
            } else if (args.length == 5) {
                Logger.t(newTag).d(title + SPLIT_LINE2 + args[1] + SPLIT_LINE2 + args[3] + SPLIT_LINE, args[0], args[2], args[4]);
            } else if (args.length == 6) {
                Logger.t(newTag).d(title + METHOD_LINE + (String) args[0] + SPLIT_LINE2 + args[2] + SPLIT_LINE2 + args[4] + SPLIT_LINE, args[1], args[3], args[5]);
            } else {
                Logger.t(newTag).d((String) title, args);
            }
        }
    }

    /**
     * JSON 字符串的输出
     *
     * @param title 要打印的信息名称
     * @param json  JSON 字符串
     */
    public static void json(String title, String json) {
        d(title);
        Logger.json(json);
    }

    /**
     * XML 字符串的输出
     *
     * @param title 要打印的信息名称
     * @param xml   XML 字符串
     */
    public static void xml(String title, String xml) {
        d(title);
        Logger.xml(xml);
    }

    /**
     * 这里对Logger的一些初始化设置
     */
    public static void resetSetting() {
        Logger.init(TAG)//设置tag
                .logLevel(BuildConfig.LOG_ENABLE ? LogLevel.FULL : LogLevel.NONE)//日志等级
                .hideThreadInfo()//隐藏线程信息
                .methodCount(0)//方法数
                .methodOffset(2);
    }
}
