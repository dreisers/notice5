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
  // ?λΉμ€??? ?λ©μΈ?Όλ‘? λ³?κ²½λ¨.
  private static final String root = "/mymelon";

  public static synchronized String getRoot() {
    return root;
  }

  /**
   * 2048 -> 2κ°? λ¦¬ν΄?¨
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
   * 2048 -> 2 KBκ°? λ¦¬ν΄?¨
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
   * ?€? ? μ§λ?? λ¬Έμ?΄λ‘? λ¦¬ν΄?©??€.
   * 
   * @return
   */
  public static synchronized String getCalendarDay() {
    String str = "";
    Calendar cal = Calendar.getInstance();
    str = "" + cal.get(Calendar.DATE); // ? μ§?

    return str;
  }

  /**
   * 2010-12-14 ??? ? μ§λ?? λ¦¬ν΄?©??€.
   * 
   * @return 2008-01-30 ??? λ¬Έμ?΄ λ¦¬ν΄
   */
  public static synchronized String getDate() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214 ??? ? μ§λ?? λ¦¬ν΄?©??€.
   * 
   * @return 20101214 ??? λ¬Έμ?΄ λ¦¬ν΄
   */
  public static synchronized String getDate2() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");

    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * yyyyMMdd_hhmiss ??? ? μ§λ?? λ¦¬ν΄?©??€.
   * @return 20110601_121003 ??? λ¬Έμ?΄ λ¦¬ν΄
   */
  public static String getDate3(){
      SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd_hhmmss");
      
      String date = sd.format(new Date());

      // System.out.println(date);        
      return date;
  }
  /**
   * 20101214 ??? ? μ§λ?? λ¦¬ν΄?©??€.
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
   * 2010? 12? 14?Ό ??? ? μ§λ?? λ¦¬ν΄?©??€.
   * 
   * @return
   */
  public static synchronized String getDate4() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy? MM? dd?Ό");
    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214?Ό ??? ? μ§λ?? λ¦¬ν΄?©??€.
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
   * 2010-12-14 ??? ? μ§λ?? λ¦¬ν΄?©??€.
   * 
   * @return 2008-01-30 ??? λ¬Έμ?΄ λ¦¬ν΄
   */
  public static synchronized String getDate6(int year, int month, int day) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    new Date();
    String date = sd.format(new Date(year - 1900, month, day));

    // System.out.println(date);
    return date;
  }

  /**
   * ?΄?©μ€μ ?Ή?λ¬Έμ ??? ??΄ HTML ?Ή?λ¬Έμλ‘? λ³???©??€. 
   * ?) ??΄λΈ? ?κ·?
   *     <TABLE> -> &lt;TABLE&gt;
   */
  public static synchronized String convertChar(String str) {

    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("'", "&apos;");   // '
    str = str.replaceAll("\"", "&quot;"); // "
    str = str.replaceAll("\r\n", "<BR>");  // ?Ό?Έ λ³?κ²?
    
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

  // μ€? λ°κΎΈκΈ?
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
   * λ‘κ·Έ?Έ? κ΄?λ¦¬μ ?Έμ§? κ²??¬
   * 
   * @param session
   * @return
   */
  public static synchronized boolean isAdmin(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_id = Utility.checkNull((String) session.getAttribute("s_id"));
    // System.out.println("??¬ λ‘κ·Έ?Έ κ΄?λ¦¬μ s_id: " + s_id);
    if (s_id.equals("") == true) { // λ‘κ·Έ?Έ?μ§? ??? κ²½μ°
      sw = false;
    } else {
      sw = true;
    }

    return sw;
  }

  /**
   * λ‘κ·Έ?Έ? ?¬?©??Έμ§? κ²??¬
   * 
   * @param request
   * @return
   */
  public static synchronized boolean isMember(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_member_id = Utility.checkNull((String) session
        .getAttribute("s_member_id"));
    // System.out.println("??¬ λ‘κ·Έ?Έ ?¬?©? s_member_id: " + s_member_id);
    if (s_member_id.equals("") == true) { // λ‘κ·Έ?Έ?μ§? ??? κ²½μ°
      sw = false;
    } else {
      sw = true;
    }

    return sw;
  }

  /**
   * λ‘κ·Έ?Έ? ?¬?©? ?Έμ§? κ²??¬
   * 
   * @param session
   * @return
   */
  public static synchronized boolean isUser(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_member_id = Utility.checkNull((String) session
        .getAttribute("s_member_id"));
    if (s_member_id.length() > 1) { // λ‘κ·Έ?Έ?μ§? ??? κ²½μ°
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
   * ??? ? ?λ₯? λ¦¬ν΄?©??€.
   * 
   * @param range
   *          ? ?λ²μ 0 ~ λ²μ-1
   * @return ?? λ¦¬ν΄
   */
  public static synchronized int random(int range) {
    // 0 ~ range-1κΉμ? ?°μΆλ¨.
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
      progress = "μ’λ£";
    } else {
      progress = "μ§ν";
    }

    return progress;
  }

  /**
   * μ²λ¨?λ§λ€ μ»΄λ§λ₯? μΆλ ₯?©??€.
   * 
   * @param price
   *          κΈμ‘
   * @return μ»΄λ§κ°? ?¬?¨? λ¬Έμ?΄
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
   * null λ¬Έμλ₯? κ³΅λ°± λ¬Έμλ‘? λ³?κ²½ν©??€.
   * 
   * @param str
   *          κ²??¬?  λ¬Έμ?΄
   * @return null κ°μ κ°?μ§?κ³? ?? κ°μ²΄? κ³΅λ°± λ¬Έμ?΄λ‘? λ¦¬ν΄?¨
   */
  public static synchronized String checkNull(String str) {
    if (str == null) {
      return "";  // null ?΄λ©? λΉκ³΅λ°±μΌλ‘? λ¦¬ν΄
    } else {
      return str; // ??? λ¬Έμ?΄ λ¦¬ν΄
    }
  }

  /**
   * request κ°μ²΄?? λ¬Έμ?΄? μΆμΆ?©??€.
   * 
   * @param request
   * @param str
   *          μΆμΆ?  λ³??
   * @return λ³??? λ¬Έμ?΄
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
   * λ¬Έμ?΄?΄ Object ????Όλ‘? ? ?‘? κ²μ null μ²λ¦¬
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
   * FileUpload 1.2 ?κΈ? λ³??
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
   * MVC, Tomcat 7.0κΈ°λ° JSP ??΄μ§? ?κΈ? λ³??
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
   * fileupload 1.2.2 ?κΈ? μ²λ¦¬
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
   * fileupload 1.2.2 ?κΈ? μ²λ¦¬
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
   * μ£Όμ΄μ§? λ¬Έμ?? λ¬Έμμ½λλ₯? λ³???©??€.
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
   * ?΄?©μ€μ ?Ή?λ¬Έμ ??? ??΄ HTML ?Ή?λ¬Έμλ‘? λ³???©??€.
   */
  public static synchronized String getConvertBR(String str) {
    return str.replace("\n", "<BR>");
  }

  /**
   * ??Ό Download? ?κΈ? ??Ό ?Έμ½λ©
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncod(String str) {
    try {
      // resin UTF-8 λ‘? μ§?? 
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
    // System.out.println("μ΅μ’λ³?? ??: "+str);
    return str;
  }

  /**
   * Struts2 GETλ°©μ ?κΈ? λ¬Έμ? ?Έμ½λ©
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
   * ?€?Έ?ΏμΈ? ?λ£μ€ ?κΈ? μΆλ ₯ λ©μ?
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
   * FCKEditor 2.6.8 ?κΈ? λ³??
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
   * ??Ό? ?­? ?©??€.
   * 
   * @param folder
   *          ??Ό?΄ ???₯? ?΄?
   * @param filename
   *          ?­? ?  ??Όλͺ?
   * @return true-?­?  ?±κ³?, false-?­?  ?€?¨
   */
  public static synchronized boolean deleteFile(String folder, String filename) {
    boolean ret = false;

    try {
      if (filename != null) { // κΈ°μ‘΄? ??Ό?΄ μ‘΄μ¬?? κ²½μ° ?­? 
        File file = new File(folder + "/" + filename);
        // ??Ό?΄ μ‘΄μ¬??μ§? ??Έ ? ?­? 
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
   * application?΄λ¦μ ?? ₯λ°μ ? ?? κ²½λ‘λ₯? ?°μΆν©??€. ?) getRealPath(request, "WEB-INF/config")
   * 
   * @param request
   * @param dir
   *          application ?΄λ¦?
   * @return ? ?? κ²½λ‘ λ¦¬ν΄
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
   * ?κΈ? λ³?? μ½λλ₯? μ°Ύλ κΈ°λ₯? μ§??
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
   * null λ¬Έμλ₯? ?«? 0?Όλ‘? λ³?κ²½ν©??€.
   * 
   * @param request
   *          request κ°μ²΄
   * @param str
   *          κ²??¬?  λ¬Έμ?΄
   * @return ?«?λ₯? λ¦¬ν΄
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
   * null λ¬Έμλ₯? ?«? 0?Όλ‘? λ³?κ²½ν©??€.
   * 
   * @param request
   *          request κ°μ²΄
   * @param str
   *          κ²??¬?  λ¬Έμ?΄
   * @return ?«?λ₯? λ¦¬ν΄
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
   * Ajax ?κΈ? λ³??
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
   * ?λ°μ€?¬λ¦½νΈ ?Ή?λ¬Έμ, μ€λ°κΏ? λ¬Έμ λ³??
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
   * Ajax ?κΈ? λ³??
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
   * λ¬Έμ?΄ κ²½λ‘λ₯? λ°μ λͺ¨λ  ??Ό λͺ©λ‘? λ¦¬ν΄
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
      // μ‘΄μ¬/?°κΈ? ?¬λΆ? ??Έ
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
   * ??Ό κ°μ²΄λ₯? λ°μ ??Ό λͺ©λ‘? λ¦¬ν΄
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
   * ??Ό λͺ©λ‘?? ??₯?λ₯? ? κ±°ν¨
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
   * ??Ό?? ??₯?λ₯? ? κ±°ν¨. ?) data.txt --> data
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

  // ?΄?λ₯? ??±
  public static synchronized void makeFolder(String _dir) {
    File sdDir = null; // ?΄?λͺ?
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
    // 2010? 12? 1?Ό 09? 01λΆ? 01μ΄?
    String year = str.substring(0, 4);
    String month = str.substring(4, 6);
    String day = str.substring(6, 8);
    String hour = str.substring(9, 11);
    String minute = str.substring(11, 13);
    String second = str.substring(13);

    String _str = year + "? " + month + "? " + day + "?Ό " + hour + "? "
        + minute + "λΆ? " + second + "μ΄? ";

    return _str;
  }

  /**
   * ??Ό ?­? 
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
   * λ°μ΄?Έλ°°μ΄λ‘? ??΄ ?? λ¬Έμ?΄? λ°μ ??? λ¬Έμ?΄λ‘? λ³??
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
   * λ¬Έμ?΄? λ°μ΄?Έ λ°°μ΄ λ¬Έμ?΄λ‘? λ³??
   * 
   * @param str
   * @return
   */
  public static synchronized String stringToByte(String str) {
    String deli = ","; // κ΅¬λΆ?
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
   * ??¬ ?κ°μ 1970? 1? 1?ΌλΆ??° ?μΉν??Όλ‘? λ¦¬ν΄
   * 
   * @return
   */
  public static synchronized long getTimeNumber() {
    long time = System.currentTimeMillis();

    return time;
  }

  /**
   * μ£Όμ΄μ§? ?κ°μ 1970? 1? 1?ΌλΆ??° ?μΉν??Όλ‘? λ¦¬ν΄
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
   * μ£Όμ΄μ§? ? μ§μ? κΈ°κ°? κ³μ°??¬ ?κΈ? ?¬λΆ? ??¨ ??¬ ? μ§κ? 2013-02-04 κΈ?? ?±λ‘λ μ§? 2013-02-02
   * getTimeNew("2013-02-04", 2) : ?κΈ? μ²λ¦¬, true getTimeNew("2013-02-04", 3) : ?κΈ?
   * μ²λ¦¬, false
   * 
   * @param date
   *          λ¬Έμ?΄λ‘? ? ? μ§?
   * @param period
   *          ?κΈ?λ‘? μ§?? ?  κΈ°κ°
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
    // 1970?1?1?ΌλΆ??° ?κ°μ 1000? 1μ΄λ‘??¬ κ³μ°??¬ λ¦¬ν΄
    long time = _date.getTime(); // κΈ?? ??±? ?κ°?

    // ??¬ ?κ°μ 1970? 1? 1?ΌλΆ??° ?μΉν??Όλ‘? λ¦¬ν΄
    long currentTime = System.currentTimeMillis();

    // ??¬ ?κ°κ³Ό κΈ? ?±λ‘μκ°μ μ°¨μ΄λ₯? κ³μ°
    long diff = currentTime - time;

    // 1?Ό 86,400,000: 1μ΄λ?? 1000?Όλ‘? ?λ£¨λ?? κ³μ°
    // 0.0001 --> 1: ?€? ? μ§?
    // 1.00002 --> 2: ?΄?  ? μ§?
    int day = (int) Math.ceil(((double) diff / 86400000));

    if (day <= period) {
      sw = true; // μ΅μ κΈ? μ²λ¦¬
    }
    return sw;
  }

  /**
   * ?΄λ―Έμ? ?¬?΄μ¦λ?? λ³?κ²½ν?¬ ?λ‘μ΄ ?΄λ―Έμ?λ₯? ??±?©??€. ?λ³? ?΄λ―Έμ?? μΆμ? ?­? ?©??€.
   * 
   * @param dir
   *          κΈ°μ? ?΄?
   * @param _src
   *          ?λ³? ?΄λ―Έμ?
   * @param width
   *          ??±?  ?΄λ―Έμ? ?λΉ?
   * @param height
   *          ??±?  ?΄λ―Έμ? ??΄, ImageUtil.RATIO? ?? λΉλ? λΉμ¨
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
    // ??Ό? ??₯? μΆμΆ
    String suffix = src.getName().substring(src.getName().lastIndexOf('.') + 1)
        .toLowerCase();
    // ?΄λ―Έμ?? ??₯?λ₯? κ²????¬ ?΄λ―Έμ? ??Ό?Έμ§? κ²??¬
    if (suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("png")
        || suffix.equals("gif")) {
      srcImg = ImageIO.read(src); // λ©λͺ¨λ¦¬μ ?΄λ―Έμ? ??±
    } else {
      srcImg = new ImageIcon(src.getAbsolutePath()).getImage();
    }

    int srcWidth = srcImg.getWidth(null); // ?λ³? ?΄λ―Έμ? ?λΉ? μΆμΆ
    int srcHeight = srcImg.getHeight(null); // ?λ³? ?΄λ―Έμ? ??΄ μΆμΆ

    int destWidth = -1, destHeight = -1; // ??? ?΄λ―Έμ? ?¬κΈ? μ΄κΈ°?

    if (width == SAME) { // ?λΉκ? κ°μ? κ²½μ°
      destWidth = srcWidth;
    } else if (width > 0) {
      destWidth = width;
    }

    if (height == SAME) { // ??΄κ°? κ°μ? κ²½μ°
      destHeight = srcHeight;
    } else if (height > 0) {
      destHeight = height;
    }

    // λΉμ¨? ?°λ₯? ?¬κΈ? κ³μ°
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

    // λ©λͺ¨λ¦¬μ ??? ?΄λ―Έμ? ??±
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

    // ??Ό? κΈ°λ‘
    ImageIO.write(destImg, "jpg", dest);

    System.out.println(dest.getName() + " ?΄λ―Έμ?λ₯? ??±??΅??€.");

    // ?λ³? ??Ό ?­? 
    boolean ret = Utility.deleteFile(dir + "/" + filename);
    if (ret == true) {
      System.out.println("??Ό? ?­?  ??΅??€.: " + filename);
    }

    return dest.getName();
  }

  /**
   * ?΄λ―Έμ? ?¬?΄μ¦λ?? λ³?κ²½ν?¬ ?λ‘μ΄ ?΄λ―Έμ?λ₯? ??±?©??€.
   * 
   * @param src
   *          ?λ³? ?΄λ―Έμ?
   * @param dest
   *          ??±?? ?΄λ―Έμ?
   * @param width
   *          ??±?  ?΄λ―Έμ? ?λΉ?
   * @param height
   *          ??±?  ?΄λ―Έμ? ??΄, ImageUtil.RATIO? ?? λΉλ? λΉμ¨
   * @throws IOException
   */
  public static synchronized String imgResize(File src, File dest, int width, int height)
      throws IOException {
    int RATIO = 0;
    int SAME = -1;

    Image srcImg = null;
    // ??Ό? ??₯? μΆμΆ
    String suffix = src.getName().substring(src.getName().lastIndexOf('.') + 1)
        .toLowerCase();
    // ?΄λ―Έμ?? ??₯?λ₯? κ²????¬ ?΄λ―Έμ? ??Ό?Έμ§? κ²??¬
    if (suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("png")
        || suffix.equals("gif")) {
      srcImg = ImageIO.read(src); // λ©λͺ¨λ¦¬μ ?΄λ―Έμ? ??±
    } else {
      srcImg = new ImageIcon(src.getAbsolutePath()).getImage();
    }

    int srcWidth = srcImg.getWidth(null); // ?λ³? ?΄λ―Έμ? ?λΉ? μΆμΆ
    int srcHeight = srcImg.getHeight(null); // ?λ³? ?΄λ―Έμ? ??΄ μΆμΆ

    int destWidth = -1, destHeight = -1; // ??? ?΄λ―Έμ? ?¬κΈ? μ΄κΈ°?

    if (width == SAME) { // ?λΉκ? κ°μ? κ²½μ°
      destWidth = srcWidth;
    } else if (width > 0) {
      destWidth = width;
    }

    if (height == SAME) { // ??΄κ°? κ°μ? κ²½μ°
      destHeight = srcHeight;
    } else if (height > 0) {
      destHeight = height;
    }

    // λΉμ¨? ?°λ₯? ?¬κΈ? κ³μ°
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

    // λ©λͺ¨λ¦¬μ ??? ?΄λ―Έμ? ??±
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

    // ??Ό? κΈ°λ‘
    ImageIO.write(destImg, "jpg", dest);

    System.out.println(dest.getName() + " ?΄λ―Έμ?λ₯? ??±??΅??€.");

    return dest.getName();
  }

  /**
   * FileUpload 1.2 ?κΈ? λ³??
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
   * ?΄λ―Έμ??Έμ§? κ²??¬
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
   * ?λ‘μ΄ ?΄λ―Έμ? ??Ό? ??±?©??€.
   * @return 20110601_121003_1 ??? λ¬Έμ?΄ λ¦¬ν΄
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
