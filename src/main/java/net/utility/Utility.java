package net.utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

public class Utility {
  // ?��비스?��?��?�� ?��메인?���? �?경됨.
  private static final String root = "/mymelon";

  public static synchronized String getRoot() {
    return root;
  }

  /**
   * 2048 -> 2�? 리턴?��
   * 
   * @param filesize
   * @return
   */
  public static synchronized long toUnit(long filesize) {
    long size = 0;

    if (filesize > 1024) {
      size = filesize / 1024; // KB
    } else {
      size = filesize / (1024 * 1024); // MB
    }

    return size;
  }

  /**
   * 2048 -> 2 KB�? 리턴?��
   * 
   * @param filesize
   * @return
   */
  public static synchronized String toUnitStr(long filesize) {
    String size = "";

    if (filesize > 1024) {
      size = filesize / 1024 + " KB"; // KB
    } else {
      size = filesize / (1024 * 1024) + " MB"; // MB
    }

    return size;
  }

  /**
   * ?��?�� ?��짜�?? 문자?���? 리턴?��?��?��.
   * 
   * @return
   */
  public static synchronized String getCalendarDay() {
    String str = "";
    Calendar cal = Calendar.getInstance();
    str = "" + cal.get(Calendar.DATE); // ?���?

    return str;
  }

  /**
   * 2010-12-14 ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * 
   * @return 2008-01-30 ?��?��?�� 문자?�� 리턴
   */
  public static synchronized String getDate() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214 ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * 
   * @return 20101214 ?��?��?�� 문자?�� 리턴
   */
  public static synchronized String getDate2() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");

    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * yyyyMMdd_hhmiss ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * @return 20110601_121003 ?��?��?�� 문자?�� 리턴
   */
  public static String getDate3(){
      SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd_hhmmss");
      
      String date = sd.format(new Date());

      // System.out.println(date);        
      return date;
  }
  /**
   * 20101214 ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * 
   * @param _date
   * @return
   */
  public static synchronized String getDate3(Date _date) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
    String date = sd.format(_date);

    // System.out.println(date);
    return date;
  }

  /**
   * 2010?�� 12?�� 14?�� ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * 
   * @return
   */
  public static synchronized String getDate4() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy?�� MM?�� dd?��");
    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214?�� ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * 
   * @param _date
   * @return
   */
  public static synchronized String getDate5(Date _date) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
    String date = sd.format(_date);

    // System.out.println(date);
    return date;
  }

  /**
   * 2010-12-14 ?��?��?�� ?��짜�?? 리턴?��?��?��.
   * 
   * @return 2008-01-30 ?��?��?�� 문자?�� 리턴
   */
  public static synchronized String getDate6(int year, int month, int day) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    new Date();
    String date = sd.format(new Date(year - 1900, month, day));

    // System.out.println(date);
    return date;
  }

  /**
   * ?��?��중에 ?��?��문자 ?��?��?�� ?��?�� HTML ?��?��문자�? �??��?��?��?��. 
   * ?��) ?��?���? ?���?
   *     <TABLE> -> &lt;TABLE&gt;
   */
  public static synchronized String convertChar(String str) {

    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("'", "&apos;");   // '
    str = str.replaceAll("\"", "&quot;"); // "
    str = str.replaceAll("\r\n", "<BR>");  // ?��?�� �?�?
    
    return str;
  }
  
  public static synchronized String convertCharTA(String str) {

    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("'", "&apos;");   // '
    str = str.replaceAll("\"", "&quots;"); // "
    
    return str;
  }
  
  public static synchronized String getString(HttpServletRequest request, String variable) {
    String value = "";

    variable = request.getParameter(variable);
    if (variable != null) {
      variable = variable.trim();
      if (variable.length() > 0) {
        value = variable;
      }

    } else {
      value = variable;
    }

    return value;
  }

  public static synchronized int getInt(HttpServletRequest request, String variable) {
    int value = 0;

    variable = request.getParameter(variable);
    if (variable != null) {
      variable = variable.trim();
      if (variable.length() > 0) {
        value = Integer.parseInt(variable);
      }
    } else {
      value = 0;
    }

    return value;
  }

  // �? 바꾸�?
  public static synchronized String getConvertCharTextArea(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '&') {
        str = str.substring(0, i) + "&" + str.substring(i + 1, str.length());
      }
    }
    return str;
  }

  public static synchronized String convertToDBMSforTextArea(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '<') {
        str = str.substring(0, i) + "<" + str.substring(i + 1, str.length());
      } else if (str.charAt(i) == '>') {
        str = str.substring(0, i) + ">" + str.substring(i + 1, str.length());
      }
    }
    return str;
  }

  public static synchronized String convertToHTMLforTextArea(String str) {
    str.replaceAll("<", "<");
    str.replaceAll(">", ">");

    return str;
  }

  /**
   * 로그?��?�� �?리자 ?���? �??��
   * 
   * @param session
   * @return
   */
  public static synchronized boolean isAdmin(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_id = Utility.checkNull((String) session.getAttribute("s_id"));
    // System.out.println("?��?�� 로그?�� �?리자 s_id: " + s_id);
    if (s_id.equals("") == true) { // 로그?��?���? ?��?? 경우
      sw = false;
    } else {
      sw = true;
    }

    return sw;
  }

  /**
   * 로그?��?�� ?��?��?��?���? �??��
   * 
   * @param request
   * @return
   */
  public static synchronized boolean isMember(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_member_id = Utility.checkNull((String) session
        .getAttribute("s_member_id"));
    // System.out.println("?��?�� 로그?�� ?��?��?�� s_member_id: " + s_member_id);
    if (s_member_id.equals("") == true) { // 로그?��?���? ?��?? 경우
      sw = false;
    } else {
      sw = true;
    }

    return sw;
  }

  /**
   * 로그?��?�� ?��?��?�� ?���? �??��
   * 
   * @param session
   * @return
   */
  public static synchronized boolean isUser(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_member_id = Utility.checkNull((String) session
        .getAttribute("s_member_id"));
    if (s_member_id.length() > 1) { // 로그?��?���? ?��?? 경우
      sw = true;
    } else {
      sw = false;
    }

    return sw;
  }

  public static synchronized boolean checkImageFile(String filename) {
    boolean sw = false;

    if (filename != null) {
      sw = filename.endsWith(".jpg") || filename.endsWith(".jpeg")
          || filename.endsWith(".gif") || filename.endsWith(".png")
          || filename.endsWith(".bmp");
    }

    return sw;
  }

  public static synchronized String getBrowser(HttpServletRequest request) {
    String header = request.getHeader("User-Agent");
    if (header.indexOf("MSIE") > -1) {
      return "MSIE";
    } else if (header.indexOf("Chrome") > -1) {
      return "Chrome";
    } else if (header.indexOf("Opera") > -1) {
      return "Opera";
    }
    return "Firefox";
  }

  public static synchronized String getDisposition(String filename, String browser) {
    String dispositionPrefix = "attachment;filename=";
    String encodedFilename = null;
    try {
      if (browser.equals("MSIE")) {
        encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll(
            "\\+", "%20");
      } else if (browser.equals("Firefox")) {
        encodedFilename =

        "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
      } else if (browser.equals("Opera")) {
        encodedFilename =

        "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
      } else if (browser.equals("Chrome")) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < filename.length(); i++) {
          char c = filename.charAt(i);
          if (c > '~') {
            sb.append(URLEncoder.encode("" + c, "UTF-8"));
          } else {
            sb.append(c);
          }
        }
        encodedFilename = sb.toString();
      } else {
        System.out.println("Not supported browser");
      }
    } catch (Exception e) {

    }

    return dispositionPrefix + encodedFilename;
  }

  /**
   * ?��?��?�� ?��?���? 리턴?��?��?��.
   * 
   * @param range
   *          ?��?��범위 0 ~ 범위-1
   * @return ?��?�� 리턴
   */
  public static synchronized int random(int range) {
    // 0 ~ range-1까�? ?��출됨.
    int rnd = 0;
    Random random = new Random();
    rnd = random.nextInt(range);

    return rnd;
  }

  public static synchronized Date getDate(String date) {
    Date currentTime = new Date();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      currentTime = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    return currentTime;
  }

  public static synchronized String progress(String enddate) {
    java.util.Date nowtime = new java.util.Date();
    java.util.Date endtime = getDate(enddate);

    // System.out.println("nowtime: " + nowtime.toLocaleString());
    // System.out.println("endtime: " + nowtime.toLocaleString());
    String progress = null;

    if (nowtime.after(endtime) == true) {
      progress = "종료";
    } else {
      progress = "진행";
    }

    return progress;
  }

  /**
   * 천단?��마다 컴마�? 출력?��?��?��.
   * 
   * @param price
   *          금액
   * @return 컴마�? ?��?��?�� 문자?��
   */
  public static synchronized String comma(int price) {
    DecimalFormat comma = new DecimalFormat("###,##0");
    String cs = comma.format(price);

    return cs;
  }

  public static synchronized String comma(long price) {
    DecimalFormat comma = new DecimalFormat("###,##0");
    String cs = comma.format(price);

    return cs;
  }

  /**
   * null 문자�? 공백 문자�? �?경합?��?��.
   * 
   * @param str
   *          �??��?�� 문자?��
   * @return null 값을 �?�?�? ?��?�� 객체?�� 공백 문자?���? 리턴?��
   */
  public static synchronized String checkNull(String str) {
    if (str == null) {
      return "";  // null ?���? 빈공백으�? 리턴
    } else {
      return str; // ?��?��?�� 문자?�� 리턴
    }
  }

  /**
   * request 객체?��?�� 문자?��?�� 추출?��?��?��.
   * 
   * @param request
   * @param str
   *          추출?�� �??��
   * @return �??��?�� 문자?��
   */
  public static synchronized String checkNull(HttpServletRequest request, String str) {
    String rstr = "";

    if (request.getParameter(str) != null) {
      rstr = request.getParameter(str);
    } else {
      rstr = "";
    }

    return rstr;
  }

  /**
   * 문자?��?�� Object ???��?���? ?��?��?�� 것을 null 처리
   * 
   * @param str
   * @return
   */
  public static String checkNull(Object str) {
    if ((String) str == null) {
      return "";
    } else {
      return (String) str;
    }
  }

  /**
   * FileUpload 1.2 ?���? �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncodFileUpload12(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * MVC, Tomcat 7.0기반 JSP ?��?���? ?���? �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncodeMVC(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * fileupload 1.2.2 ?���? 처리
   * 
   * @param ko
   * @return
   */
  public static synchronized String fileupload122Enc(String ko) {
    String corean = null;
    try {
      // corean= new String(ko.getBytes("8859_1"), "euc-kr");
      corean = new String(ko.getBytes("ISO-8859-1"), "utf-8");
      // corean= new String(ko.getBytes("8859_1"), "iso-8859-1");
      // corean= new String(ko.getBytes("utf-8"), "8859_1");
      // corean= new String(ko.getBytes("8859_1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * fileupload 1.2.2 ?���? 처리
   * 
   * @param ko
   * @return
   */
  public static synchronized String fileupload122DownEnc(String ko) {
    // charsetTest(ko);

    String corean = null;
    try {
      // corean= new String(ko.getBytes("iso-8859-1"), "euc-kr");
      // corean= new String(ko.getBytes("iso-8859-1"), "utf-8");
      // corean= new String(ko.getBytes("8859_1"), "iso-8859-1");
      // corean= new String(ko.getBytes("utf-8"), "8859_1");
      // corean= new String(ko.getBytes("iso-8859-1"), "KSC5601");
      corean = new String(ko.getBytes("KSC5601"), "EUC-KR");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  public static synchronized String getType(String fileUrl) {
    String type = "";
    fileUrl = "file:" + fileUrl;
    try {
      URL u = new URL(fileUrl);
      URLConnection uc = u.openConnection();
      type = uc.getContentType();

    } catch (Exception e) {
      System.out.println(e.toString());
    }

    return type;
  }

  /**
   * 주어�? 문자?��?�� 문자코드�? �??��?��?��?��.
   * 
   * @param ko
   * @return
   */
  public static synchronized String ko(String ko) {
    String str = null;
    try {
      // corean= new String(ko.getBytes("8859_1"), "euc-kr");
      // corean= new String(ko.getBytes("8859_1"), "utf-8");
      // corean= new String(ko.getBytes("8859_1"), "iso-8859-1");
      // corean= new String(ko.getBytes("8859_1"), "utf-8");
      str = new String(ko.getBytes("8859_1"), "KSC5601");
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
          str = str.substring(0, i) + "%20"
              + str.substring(i + 1, str.length());
          i = i + 3;
        }
      }

    } catch (Exception e) {

    }
    return str;
  }

  /**
   * ?��?��중에 ?��?��문자 ?��?��?�� ?��?�� HTML ?��?��문자�? �??��?��?��?��.
   */
  public static synchronized String getConvertBR(String str) {
    return str.replace("\n", "<BR>");
  }

  /**
   * ?��?�� Download?�� ?���? ?��?�� ?��코딩
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncod(String str) {
    try {
      // resin UTF-8 �? �??��
      // str = java.net.URLEncoder.encode(str, "EUC-KR");
      // str = java.net.URLEncoder.encode(str, "UTF-8");
      str = java.net.URLEncoder.encode(str, "KSC5601");
    } catch (Exception e) {

    }

    // System.out.println(str);

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '+') {
        str = str.substring(0, i) + "%20" + str.substring(i + 1, str.length());
        i = i + 3;
      }
    }
    // System.out.println("최종�??�� ?��?��: "+str);
    return str;
  }

  /**
   * Struts2 GET방식 ?���? 문자?�� ?��코딩
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncodGet(String str) {
    try {

      str = java.net.URLEncoder.encode(str, "EUC-KR");
      // str = java.net.URLEncoder.encode(str, "UTF-8");
      // str = java.net.URLEncoder.encode(str, "KSC5601");

      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '+') {
          str = str.substring(0, i) + "%20"
              + str.substring(i + 1, str.length());
          i = i + 3;
        }
      }
    } catch (Exception e) {

    }

    return str;
  }

  /**
   * ?��?��?���? ?��료실 ?���? 출력 메소?��
   * 
   * @param str
   * @return
   */
  public static synchronized String encodStruts2(String str) {
    try {
      // str = java.net.URLEncoder.encode(str, "EUC-KR");
      // str = java.net.URLEncoder.encode(str, "UTF-8");
      str = java.net.URLEncoder.encode(str, "KSC5601");

      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '+') {
          str = str.substring(0, i) + "%20"
              + str.substring(i + 1, str.length());
          i = i + 3;
        }
      }
    } catch (Exception e) {

    }

    return str;
  }

  /**
   * FCKEditor 2.6.8 ?���? �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String encodFCK268(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * ?��?��?�� ?��?��?��?��?��.
   * 
   * @param folder
   *          ?��?��?�� ???��?�� ?��?��
   * @param filename
   *          ?��?��?�� ?��?���?
   * @return true-?��?�� ?���?, false-?��?�� ?��?��
   */
  public static synchronized boolean deleteFile(String folder, String filename) {
    boolean ret = false;

    try {
      if (filename != null) { // 기존?�� ?��?��?�� 존재?��?�� 경우 ?��?��
        File file = new File(folder + "/" + filename);
        // ?��?��?�� 존재?��?���? ?��?�� ?�� ?��?��
        if (file.exists()) {
          ret = file.delete();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return ret;
  }

  /**
   * application?��름을 ?��?��받아 ?��?? 경로�? ?��출합?��?��. ?��) getRealPath(request, "WEB-INF/config")
   * 
   * @param request
   * @param dir
   *          application ?���?
   * @return ?��?? 경로 리턴
   * @throws IOException
   */
  public static synchronized String getRealPath(HttpServletRequest request, String dir) {
    // ByteArrayOutputStream baos = new ByteArrayOutputStream();
    String path = "";
    
    try{
      path = request.getRealPath(dir) + "/";  
      System.out.println("Upload path: " + path);
    }catch(Exception e){
      System.out.println(e.toString());
    }

    return path;
  }

  /**
   * ?���? �??�� 코드�? 찾는 기능?�� �??��
   * 
   * @param s
   */
  public static synchronized void charsetTest(String s) {
    try {
      String[] charset = { "EUC-KR", "KSC5601", "ISO-8859-1", "8859_1",
          "ASCII", "UTF-8" };
      for (int i = 0; i < charset.length; i++) {
        for (int j = 0; j < charset.length; j++) {
          if (i == j)
            continue;
          System.out.print(charset[i] + " -> " + charset[j] + " : ");
          System.out.println(new String(s.getBytes(charset[i]), charset[j]));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * null 문자�? ?��?�� 0?���? �?경합?��?��.
   * 
   * @param request
   *          request 객체
   * @param str
   *          �??��?�� 문자?��
   * @return ?��?���? 리턴
   */
  public static synchronized int checkInt(HttpServletRequest request, String str) {
    int su = 0;
    if (request.getParameter(str) != null) {
      su = Integer.parseInt(request.getParameter(str));
    }

    return su;
  }

  public static int checkInt(String str) {
    int su = 0;
    if (str != null) {
      su = Integer.parseInt(str);
    }

    return su;
  }

  /**
   * null 문자�? ?��?�� 0?���? �?경합?��?��.
   * 
   * @param request
   *          request 객체
   * @param str
   *          �??��?�� 문자?��
   * @return ?��?���? 리턴
   */
  public static synchronized int checkAttrInt(HttpServletRequest request, String str) {
    int su = 0;
    if (request.getAttribute(str) != null) {
      Integer itg = (Integer) (request.getAttribute(str));
      su = itg.intValue();
    }

    return su;
  }

  /**
   * Ajax ?���? �??��
   * 
   * @param ko
   * @return
   */
  public static synchronized String koAjax(String ko) {
    String corean = null;
    try {
      // corean= new String(ko.getBytes("ISO-8859-1"), "UTF-8");
      corean = new String(ko.getBytes("KSC5601"), "EUC-KR");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * ?��바스?��립트 ?��?��문자, 줄바�? 문자 �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String toJS(String str) {
    if (str != null) {
      return str.replace("\\", "\\\\").replace("\'", "\\\'")
          .replace("\"", "\\\"").replace("\r\n", "\\n").replace("\n", "\\n");

    } else {
      return "";
    }
  }

  /**
   * Ajax ?���? �??��
   * 
   * @param ko
   * @return
   */
  public static synchronized String koAndroid(String ko) {
    String corean = null;
    try {
      // corean= new String(ko.getBytes("UTF-8"), "EUC-KR");
      // corean= new String(ko.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(ko.getBytes("KSC5601"), "EUC-KR");
      corean = new String(ko.getBytes("8859_1"), "UTF-8");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * 문자?�� 경로�? 받아 모든 ?��?�� 목록?�� 리턴
   * 
   * @param dir
   * @return
   */
  public static synchronized String[] fileNameList(String dir) {
    File sdDir = null;
    String[] str = null;

    try {
      // Check SD Card mount.
      sdDir = new File("."); // /sdcard
      // 존재/?���? ?���? ?��?��
      if (sdDir.exists() && sdDir.canWrite()) {
        File _dir = new File(dir);
        if (_dir.exists() && _dir.canRead()) {
          str = _dir.list();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return str;
  }

  /**
   * ?��?�� 객체�? 받아 ?��?�� 목록?�� 리턴
   * 
   * @param dir
   * @return
   */
  public static synchronized String[] fileNameList(File dir) {
    String[] str = null;

    try {
      str = dir.list();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return str;
  }

  /**
   * ?��?�� 목록?��?�� ?��?��?���? ?��거함
   * 
   * @param str
   * @return
   */
  public static synchronized ArrayList convertFilenameNotExtend(String[] str) {
    ArrayList retVal = new ArrayList();
    ;

    for (int i = 0; i < str.length; i++) {
      int point = str[i].indexOf(".");
      retVal.add(str[i].substring(0, point));
    }

    return retVal;
  }

  /**
   * ?��?��?��?�� ?��?��?���? ?��거함. ?��) data.txt --> data
   * 
   * @param str
   * @return
   */
  public static synchronized String convertFilenameNotExtend(String str) {
    String noExt = "";
    int point = str.indexOf(".");
    noExt = str.substring(0, point);

    return noExt;
  }

  // ?��?���? ?��?��
  public static synchronized void makeFolder(String _dir) {
    File sdDir = null; // ?��?���?
    File dir = null;

    sdDir = new File(".");
    dir = new File(sdDir.toString() + "/" + _dir);

    if (sdDir.exists() && sdDir.canWrite()) {
      if (dir.exists() == false) {
        dir.mkdir();
      }
    }

  }

  public static synchronized String onlyFilename(String _str) {
    // /sdcard/smartalbum/20101201_090101.jpg
    int ps = _str.lastIndexOf("/");
    // System.out.println("ps: " + ps);

    String str = _str.substring(ps + 1); // 20101201_090101.jpg

    int pd = str.lastIndexOf(".");
    System.out.println("pd: " + pd);

    str = str.substring(0, pd);

    return str;
  }

  public static synchronized String convertFilename(String str) {
    // 20101201_090101
    // 012345678901234
    // 2010?�� 12?�� 1?�� 09?�� 01�? 01�?
    String year = str.substring(0, 4);
    String month = str.substring(4, 6);
    String day = str.substring(6, 8);
    String hour = str.substring(9, 11);
    String minute = str.substring(11, 13);
    String second = str.substring(13);

    String _str = year + "?�� " + month + "?�� " + day + "?�� " + hour + "?�� "
        + minute + "�? " + second + "�? ";

    return _str;
  }

  /**
   * ?��?�� ?��?��
   * @param fname
   * @return
   */
  public static synchronized boolean deleteFile(String fname) {
    File file = new File(fname);
    boolean ret = false;
    
    if (file.exists()){
      ret = file.delete();
    }
    
    return ret;
  }

  /**
   * 바이?��배열�? ?��?�� ?��?�� 문자?��?�� 받아 ?��?��?�� 문자?���? �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String byteToString(String str) {
    String retVal = "";

    try {
      StringTokenizer st = new StringTokenizer(str, ",");
      byte[] _str = new byte[st.countTokens()];
      int i = -1;

      while (st.hasMoreTokens()) {
        i++;
        _str[i] = Byte.parseByte(st.nextToken());
      }
      retVal = new String(_str, 0, _str.length, "UTF-8");
    } catch (Exception e) {

    }

    return retVal;
  }

  /**
   * 문자?��?�� 바이?�� 배열 문자?���? �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String stringToByte(String str) {
    String deli = ","; // 구분?��
    String retVal = "";
    try {
      byte[] bstr = str.getBytes("UTF-8");

      for (int i = 0; i < bstr.length; i++) {
        retVal = retVal + deli + bstr[i];
      }
    } catch (Exception e) {

    }
    return retVal;

  }

  /**
   * ?��?�� ?��간을 1970?�� 1?�� 1?���??�� ?��치형?��?���? 리턴
   * 
   * @return
   */
  public static synchronized long getTimeNumber() {
    long time = System.currentTimeMillis();

    return time;
  }

  /**
   * 주어�? ?��간을 1970?�� 1?�� 1?���??�� ?��치형?��?���? 리턴
   * 
   * @return
   */
  public static synchronized long getTimeNumber(String date) {
    Date _date = new Date();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      _date = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    long time = _date.getTime();

    return time;
  }

  /**
   * 주어�? ?��짜�? 기간?�� 계산?��?�� ?���? ?���? ?��?�� ?��?�� ?��짜�? 2013-02-04 �??�� ?��록날�? 2013-02-02
   * getTimeNew("2013-02-04", 2) : ?���? 처리, true getTimeNew("2013-02-04", 3) : ?���?
   * 처리, false
   * 
   * @param date
   *          문자?���? ?�� ?���?
   * @param period
   *          ?���?�? �??��?�� 기간
   * @return
   */
  public static synchronized boolean getTimeNew(String date, int period) {
    boolean sw = false;

    Date _date = new Date();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      _date = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    // 1970?��1?��1?���??�� ?��간을 1000?�� 1초로?��?�� 계산?��?�� 리턴
    long time = _date.getTime(); // �??�� ?��?��?�� ?���?

    // ?��?�� ?��간을 1970?�� 1?�� 1?���??�� ?��치형?��?���? 리턴
    long currentTime = System.currentTimeMillis();

    // ?��?�� ?��간과 �? ?��록시간의 차이�? 계산
    long diff = currentTime - time;

    // 1?�� 86,400,000: 1초�?? 1000?���? ?��루�?? 계산
    // 0.0001 --> 1: ?��?�� ?���?
    // 1.00002 --> 2: ?��?�� ?���?
    int day = (int) Math.ceil(((double) diff / 86400000));

    if (day <= period) {
      sw = true; // 최신�? 처리
    }
    return sw;
  }

  /**
   * ?��미�? ?��?��즈�?? �?경하?�� ?��로운 ?��미�?�? ?��?��?��?��?��. ?���? ?��미�??�� 축소?�� ?��?��?��?��?��.
   * 
   * @param dir
   *          기�? ?��?��
   * @param _src
   *          ?���? ?��미�?
   * @param width
   *          ?��?��?�� ?��미�? ?���?
   * @param height
   *          ?��?��?�� ?��미�? ?��?��, ImageUtil.RATIO?�� ?��?�� 비�? 비율
   * @throws IOException
   */
  public static synchronized String imgResize(String dir, String filename, int width,
      int height) throws IOException {

    File src = new File(dir + "/" + filename);
    File dest = new File(dir + "/" + Utility.convertFilenameNotExtend(filename)
        + "_s.jpg");

    int RATIO = 0;
    int SAME = -1;

    Image srcImg = null;
    // ?��?��?�� ?��?��?�� 추출
    String suffix = src.getName().substring(src.getName().lastIndexOf('.') + 1)
        .toLowerCase();
    // ?��미�??�� ?��?��?���? �??��?��?�� ?��미�? ?��?��?���? �??��
    if (suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("png")
        || suffix.equals("gif")) {
      srcImg = ImageIO.read(src); // 메모리에 ?��미�? ?��?��
    } else {
      srcImg = new ImageIcon(src.getAbsolutePath()).getImage();
    }

    int srcWidth = srcImg.getWidth(null); // ?���? ?��미�? ?���? 추출
    int srcHeight = srcImg.getHeight(null); // ?���? ?��미�? ?��?�� 추출

    int destWidth = -1, destHeight = -1; // ???�� ?��미�? ?���? 초기?��

    if (width == SAME) { // ?��비�? 같�? 경우
      destWidth = srcWidth;
    } else if (width > 0) {
      destWidth = width;
    }

    if (height == SAME) { // ?��?���? 같�? 경우
      destHeight = srcHeight;
    } else if (height > 0) {
      destHeight = height;
    }

    // 비율?�� ?���? ?���? 계산
    if (width == RATIO && height == RATIO) {
      destWidth = srcWidth;
      destHeight = srcHeight;
    } else if (width == RATIO) {
      double ratio = ((double) destHeight) / ((double) srcHeight);
      destWidth = (int) ((double) srcWidth * ratio);
    } else if (height == RATIO) {
      double ratio = ((double) destWidth) / ((double) srcWidth);
      destHeight = (int) ((double) srcHeight * ratio);
    }

    // 메모리에 ???�� ?��미�? ?��?��
    Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight,
        Image.SCALE_SMOOTH);
    int pixels[] = new int[destWidth * destHeight];
    PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight,
        pixels, 0, destWidth);
    try {
      pg.grabPixels();
    } catch (InterruptedException e) {
      throw new IOException(e.getMessage());
    }
    BufferedImage destImg = new BufferedImage(destWidth, destHeight,
        BufferedImage.TYPE_INT_RGB);
    destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);

    // ?��?��?�� 기록
    ImageIO.write(destImg, "jpg", dest);

    System.out.println(dest.getName() + " ?��미�?�? ?��?��?��?��?��?��.");

    // ?���? ?��?�� ?��?��
    boolean ret = Utility.deleteFile(dir + "/" + filename);
    if (ret == true) {
      System.out.println("?��?��?�� ?��?�� ?��?��?��?��.: " + filename);
    }

    return dest.getName();
  }

  /**
   * ?��미�? ?��?��즈�?? �?경하?�� ?��로운 ?��미�?�? ?��?��?��?��?��.
   * 
   * @param src
   *          ?���? ?��미�?
   * @param dest
   *          ?��?��?��?�� ?��미�?
   * @param width
   *          ?��?��?�� ?��미�? ?���?
   * @param height
   *          ?��?��?�� ?��미�? ?��?��, ImageUtil.RATIO?�� ?��?�� 비�? 비율
   * @throws IOException
   */
  public static synchronized String imgResize(File src, File dest, int width, int height)
      throws IOException {
    int RATIO = 0;
    int SAME = -1;

    Image srcImg = null;
    // ?��?��?�� ?��?��?�� 추출
    String suffix = src.getName().substring(src.getName().lastIndexOf('.') + 1)
        .toLowerCase();
    // ?��미�??�� ?��?��?���? �??��?��?�� ?��미�? ?��?��?���? �??��
    if (suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("png")
        || suffix.equals("gif")) {
      srcImg = ImageIO.read(src); // 메모리에 ?��미�? ?��?��
    } else {
      srcImg = new ImageIcon(src.getAbsolutePath()).getImage();
    }

    int srcWidth = srcImg.getWidth(null); // ?���? ?��미�? ?���? 추출
    int srcHeight = srcImg.getHeight(null); // ?���? ?��미�? ?��?�� 추출

    int destWidth = -1, destHeight = -1; // ???�� ?��미�? ?���? 초기?��

    if (width == SAME) { // ?��비�? 같�? 경우
      destWidth = srcWidth;
    } else if (width > 0) {
      destWidth = width;
    }

    if (height == SAME) { // ?��?���? 같�? 경우
      destHeight = srcHeight;
    } else if (height > 0) {
      destHeight = height;
    }

    // 비율?�� ?���? ?���? 계산
    if (width == RATIO && height == RATIO) {
      destWidth = srcWidth;
      destHeight = srcHeight;
    } else if (width == RATIO) {
      double ratio = ((double) destHeight) / ((double) srcHeight);
      destWidth = (int) ((double) srcWidth * ratio);
    } else if (height == RATIO) {
      double ratio = ((double) destWidth) / ((double) srcWidth);
      destHeight = (int) ((double) srcHeight * ratio);
    }

    // 메모리에 ???�� ?��미�? ?��?��
    Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight,
        Image.SCALE_SMOOTH);
    int pixels[] = new int[destWidth * destHeight];
    PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight,
        pixels, 0, destWidth);
    try {
      pg.grabPixels();
    } catch (InterruptedException e) {
      throw new IOException(e.getMessage());
    }
    BufferedImage destImg = new BufferedImage(destWidth, destHeight,
        BufferedImage.TYPE_INT_RGB);
    destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);

    // ?��?��?�� 기록
    ImageIO.write(destImg, "jpg", dest);

    System.out.println(dest.getName() + " ?��미�?�? ?��?��?��?��?��?��.");

    return dest.getName();
  }

  /**
   * FileUpload 1.2 ?���? �??��
   * 
   * @param str
   * @return
   */
  public static synchronized String encodFileUpload12(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * ?��미�??���? �??��
   * @param filename
   * @return
   */
  public static synchronized boolean isImage(String filename) {
    boolean sw = false;

    if (filename != null) {
      filename = filename.toLowerCase();
      sw = filename.endsWith(".jpg") || filename.endsWith(".jpeg")
          || filename.endsWith(".gif") || filename.endsWith(".png")
          || filename.endsWith(".bmp");
    }

    return sw;
  }

  public static synchronized String trim(String str, int length) {
    String _str = "";
    if (str.length() > length) {
      _str = str.substring(0, length);
    } else {
      _str = str;
    }

    return _str;
  }

  /**
   * ?��로운 ?��미�? ?��?��?�� ?��?��?��?��?��.
   * @return 20110601_121003_1 ?��?��?�� 문자?�� 리턴
   */
  public static String getNewPDSFilename(String extention){
      String filename = "";
      Random rnd = new Random();
      
      // filename = ""+rnd.nextInt(10)+1;
      String rndStr = String.valueOf((rnd.nextInt(10))+1);
      
      filename = getDate3() + "_" + rndStr + extention;
      
      return filename;
  }
  
}//class end 
