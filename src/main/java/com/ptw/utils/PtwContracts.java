package com.ptw.utils;
 
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
 
public class PtwContracts {
  public final static String YMD = "yyyyMMdd";
  public final static String YYYYMMDD = "yyyy-MM-dd";
  public final static String YMDHM = "yyyy-MM-dd HH:mm";
  public final static String YM = "yyyy-MM";
  public final static String YMDHMS = "yyyy-MM-dd HH:mm:ss";
  public final static String YMDHMS_NO = "yyyyMMddHHmmss";
  public final static String YMDHMSTZ = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  public final static DateTimeFormatter JODA_YM=DateTimeFormat.forPattern(YM);
  //使用时:DateTime end_date = DateTime.parse("2018-01", PtwContracts.JODA_YM);
  //输出时:end_date.toString("yyyy-MM")，或者end_date.getYear等;
  public final static DateTimeFormatter JODA_YMDHM=DateTimeFormat.forPattern(YMDHM);
  public final static DateTimeFormatter JODA_YMDHMS=DateTimeFormat.forPattern(YMDHMS);
  public final static DateTimeFormatter JODA_YMDHMS_NO=DateTimeFormat.forPattern(YMDHMS_NO);
  public final static DateTimeFormatter JODA_YYYYMMDD=DateTimeFormat.forPattern(YYYYMMDD);
  public final static DateTimeFormatter JODA_YMD=DateTimeFormat.forPattern(YMD);
  //30分钟的毫秒数
  public final static Long FEN_30 = TimeUnit.MILLISECONDS.convert(30, TimeUnit.MINUTES);//30分钟
  public final static Long FEN_5  = TimeUnit.MILLISECONDS.convert(3 , TimeUnit.MINUTES);//5分钟
  
  public final static Integer LYB_CODE= 433;//鹿游呗
  public final static Integer BYK_CODE= 434;//北银卡WeekTravel
  public final static Integer API_BYK_CODE= 436;//北银卡对外API
  public final static Integer SECKILL_CODE= 435;//秒杀活动
  public final static String SECKILL_MSG= "2019_916";//秒杀活动
  public final static String EXPIRE_DATE="2020-09-15";//福卡过期时间
}
 
