package com.cist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;*/

public class PoiWordToHtml {

public static final int WORD_HTML = 8;
 
public static final int WORD_TXT = 7;
 
public static final int EXCEL_HTML = 44;
public static void main(String[] args) throws IOException {
/*	String a="[3894948, 3894952, 3894953]";
	a=a.substring(1,a.length()-1);
	String h[]=a.split(",");
	for (String string : h) {
		System.err.println(string.trim());
	}
	
	change(
            "E:\\资料\\DNF游戏数据分析第六课.doc",
            "E:\\资料\\78.jsp");
}
public static void change(String filename, String htmlFilename) throws IOException {
    ActiveXComponent xl = new ActiveXComponent("Word.Application");
    //打开一个word，不显示窗口      
   try {
        Dispatch.put(xl, "Visible", new Variant(false));
        Object workbooks = xl.getProperty("Documents").toDispatch();
        Object workbook = Dispatch.call((Dispatch) workbooks, "Open",filename).toDispatch();
        System.err.println(3);  
        Dispatch.invoke((Dispatch) workbook, "SaveAs", Dispatch.Method,new Object[] { htmlFilename, new Variant(8) }, new int[1]);
        Variant f = new Variant(false);
        System.err.println(2);  
        //Close关闭文件，不关闭窗口
        Dispatch.call((Dispatch) workbooks, "Close", f);
        System.err.println(1);     
    } catch (Exception e) {
        // 调用office关闭方法，关闭窗口和word进程         
        e.printStackTrace();
        xl.invoke("Quit", new Variant[] {});                 
        xl = null;
        Process process;
        int pid = 0;
        process = Runtime.getRuntime().exec("tasklist");
        Scanner in = new Scanner(process.getInputStream());
        while (in.hasNextLine()) {
        	String p = in.nextLine();
            // 打印所有进程
            System.out.println(p);
            if (p.contains("WINWORD.EXE")) {
                StringBuffer buf = new StringBuffer();
               for (int i = 0; i < p.length(); i++) {
                   char ch = p.charAt(i);
                   if (ch != ' ') {
                       buf.append(ch);
                    }
                }
               // 打印pid，根据pid关闭进程
               System.out.println(buf.toString().split("Console")[0].substring("WINWORD.EXE".length()));
               pid = Integer.parseInt(buf.toString().split("Console")[0].substring("WINWORD.EXE".length()));
               Runtime.getRuntime().exec("tskill"+" "+pid);
            }
        }
    } finally {

        // 调用office关闭方法，关闭窗口和word进程         

        xl.invoke("Quit", new Variant[] {});                 
        xl = null;
        html2utf("E:\\\\资料\\\\74545.html");
    }
}
public static void html2utf(String filePath) {
try {


String content = "charset=utf-8";
String templateContent = "";
FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
// 下面四行：获得输入流的长度，然后建一个该长度的数组，然后把输入流中的数据以字节的形式读入到数组中，然后关闭流
int lenght = fileinputstream.available();
byte bytes[] = new byte[lenght];
fileinputstream.read(bytes);
fileinputstream.close();
// 通过使用默认字符集解码指定的 byte 数组，构造一个新的 
//因为原来的html文件是gb2312格式，所以转为string时也要以GBK格式读取，不然依旧是乱码
templateContent = new String(bytes, "GBK");
System.err.println(templateContent);
templateContent = templateContent.replaceFirst("charset=gb2312", content);
// 因为已经替换字符串了，所以使用UTF-8字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
byte tag_bytes[] = templateContent.getBytes("UTF-8");
FileOutputStream fileoutputstream = new FileOutputStream(filePath);// 建立文件输出流
fileoutputstream.write(tag_bytes);
fileoutputstream.close();


} catch (Exception e) {
System.out.print(e.toString());
}


}*/
}}
