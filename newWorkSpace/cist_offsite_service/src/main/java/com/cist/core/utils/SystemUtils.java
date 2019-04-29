package com.cist.core.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class SystemUtils {

	private final static Logger log = LoggerFactory.getLogger(SystemUtils.class
			.getName());

	final static byte[] HEX_CHAR_TABLE = { (byte) '0', (byte) '1', (byte) '2',
			(byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7',
			(byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c',
			(byte) 'd', (byte) 'e', (byte) 'f' };

	final static char[] CHANG_256_64 = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', ':', ';', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };

	public static final int MAX_CACHE_SIZE = 2000;

	/**
	 * 
	 * @param n
	 *            必须是int类型byte[]
	 * 
	 * @return
	 */
	public final static byte[] BytestoHL(byte[] n) {
		int size = n.length;
		byte[] b = new byte[size];
		for (int i = 0; i < size; i++) {
			b[size - 1 - i] = n[i];
		}
		return b;
	}

	public static byte[] intToByteArray(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	public static String getSetupDirectory(String defaultValue) {
		if (defaultValue != null) {
			return defaultValue;
		}
		String path = SystemUtils.class.getResource("/").getPath();
		int index = path.indexOf("cnznjt");
		if (isLiunx())
			return path.substring(0, index).replace("%20", " ");
		else
			return path.substring(1, index).replace("%20", " ");

	}
	
	public static String getFileDirectory(String defaultValue){
		
		if(defaultValue!=null)
		{
			return defaultValue.replace("%20", " ");
		}
		return defaultValue;
		
	}

	public static String getDirectory(String file) {
		return SystemUtils.class.getResource(file).getPath();
	}

	public static String char_256_64(String msg) {
		String _256_64 = "";
		int len = -1;
		try {
			byte[] data = msg.getBytes("gb2312");
			String binary = "";
			for (int i = 0; i < data.length; i++) {
				binary += SystemUtils.intAsString(data[i] & 0xFF, 2, 8);
			}
			len = binary.length() / 6;
			int s = binary.length() % 6 != 0 ? len + 1 : len;
			for (int i = 0; i < s; i++) {

				if (i == (s - 1)) {
					len = binary.substring(i * 6).length();
					if (len == 6) {
						len = Integer.parseInt(binary.substring(i * 6), 2);
					} else {
						len = Integer.parseInt(SystemUtils.cover(
								binary.substring(i * 6), "0", 6, 0), 2);
					}
					_256_64 += CHANG_256_64[len];
				} else {
					len = Integer.parseInt(
							binary.substring(i * 6, (i + 1) * 6), 2);
					_256_64 += CHANG_256_64[len];
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("错误006", e);
		}
		return _256_64;
	}

	public static String char_64_256(String msg)
			throws UnsupportedEncodingException {

		char[] a = msg.toCharArray();
		int[] b = new int[a.length];
		int i = 0;
		int j = 0;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < CHANG_256_64.length; j++) {
				if (a[i] == CHANG_256_64[j]) {
					b[i] = j;
				}
			}
		}
		String binary = "";
		String temp = "";
		for (i = 0; i < b.length; i++) {
			temp = SystemUtils.intAsString(b[i] & 0xFF, 2, 8);
			binary += temp.substring(2);
		}
		j = binary.length() / 8;
		byte[] c = new byte[j];
		for (i = 0; i < j; i++) {
			c[i] = (byte) Integer.parseInt(
					binary.substring(i * 8, (i + 1) * 8), 2);
		}
		return new String(c, "GB2312");
	}

	public static String intAsString(int val, int radix, int pc) {

		String temp = Integer.toString(val, radix);
		int len = temp.length();
		if (len < pc) {
			for (int i = 0; i < (pc - len); i++) {
				temp = "0" + temp;
			}
		}
		return temp;
	}

	public static List<String> matches(CharSequence input, String regex) {
		List<String> list = new LinkedList<String>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			list.add(matcher.group());
		}
		return list;
	}

	/**
	 * 判断当前系统是windows,liunx
	 * 
	 * @return
	 */
	public static boolean isLiunx() {

		if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
			return false;
		}
		return true;
	}

	public static String getHexString(byte[] raw)
			throws UnsupportedEncodingException {
		byte[] hex = new byte[2 * raw.length];
		int index = 0;
		for (byte b : raw) {
			int v = b & 0xFF;
			hex[index++] = HEX_CHAR_TABLE[v >>> 4];
			hex[index++] = HEX_CHAR_TABLE[v & 0xF];
		}
		return new String(hex, "ASCII");
	}

	public static byte[] byteToC(byte[] raw, int len) {
		byte[] fill = raw;
		if (raw.length < len) {
			fill = Arrays.copyOf(raw, len);
		}
		byte[] c = BytestoHL(fill);
		return Arrays.copyOfRange(c, 0, len);
	}

	/**
	 * n个byte[]数组合并为一个byte[]
	 * 
	 * @param args
	 * @return
	 */
	public static byte[] arrayscopy(byte[]... args) {
		int len = 0;
		for (byte[] b : args) {
			len += b.length;
		}
		byte[] c = new byte[len];
		len = 0;
		for (byte[] b : args) {
			System.arraycopy(b, 0, c, len, b.length);
			len += b.length;
		}
		return c;
	}

	/**
	 * 返回指定长度的byte[]
	 * 
	 * @param a
	 * @param len
	 * @return
	 */
	public static byte[] limit(byte[] a, int len) {
		byte[] c = new byte[len];
		if (len == a.length) {
			return a;
		} else if (len > a.length) {
			System.arraycopy(a, 0, c, len - a.length, a.length);
			Arrays.fill(c, 0, len - a.length, (byte) 48);
		} else if (len < a.length) {
			System.arraycopy(a, a.length - len, c, 0, len);
		}
		return c;
	}

	public static String cover(String str, int len) {
		StringBuilder context = new StringBuilder(str);
		int l = str.length();
		for (int i = 0; i < len - l; i++) {
			context.append(' ');
		}
		return context.toString();
	}

	public static String cover(String str, String val, int len, int pos) {

		int l = str.length() < len ? len - str.length() : 0;
		if (l == 0) {
			return str;
		}
		String temp = "";
		for (int i = 0; i < l; i++) {
			temp += 0;
		}
		if (pos == 0) {
			str += val;
		} else {
			str = val + str;
		}
		return str;
	}

	public static Long CRawASLong(byte[] raw, int radix)
			throws NumberFormatException, UnsupportedEncodingException {

		return Long.parseLong(getHexString(BytestoHL(raw)), radix);
	}

	public static Long JavaRawASLong(byte[] raw, int radix)
			throws NumberFormatException, UnsupportedEncodingException {
		return Long.parseLong(getHexString(raw), radix);
	}

	public static int CRawAsInt(byte[] raw, int radix)
			throws NumberFormatException, UnsupportedEncodingException {
		return Integer.parseInt(getHexString(BytestoHL(raw)), radix);
	}

	public static int JavaRawAsInt(byte[] raw, int radix)
			throws NumberFormatException, UnsupportedEncodingException {
		return Integer.parseInt(getHexString(raw), radix);
	}

	public static byte[] byteToC(int i, int len) {
		return byteToC(intToByteArray(i), len);
	}

	/**
	 * long max is Integer.MAX_VALUE
	 * 
	 * @param i
	 * @param len
	 * @return
	 */
	public static byte[] byteToC(long i, int len) {

		ByteBuffer buff = ByteBuffer.allocate(8);
		buff.putLong(i);
		return byteToC(Arrays.copyOfRange(buff.array(), 4, 8), len);
	}

	// long类型转成byte数组
	public static byte[] longToByte(long number) {
		long temp = number;
		byte[] b = new byte[8];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Long(temp & 0xff).byteValue();
			// 将最低位保存在最低位
			temp = temp >> 8; // 向右移8位
		}
		return b;
	}

	// byte数组转成long
	public static long byteToLong(byte[] b) {
		long s = 0;
		long s0 = b[0] & 0xff;
		// 最低位
		long s1 = b[1] & 0xff;
		long s2 = b[2] & 0xff;
		long s3 = b[3] & 0xff;
		long s4 = b[4] & 0xff;
		// 最低位
		long s5 = b[5] & 0xff;
		long s6 = b[6] & 0xff;
		long s7 = b[7] & 0xff;
		// s0不变
		s1 <<= 8;
		s2 <<= 16;
		s3 <<= 24;
		s4 <<= 8 * 4;
		s5 <<= 8 * 5;
		s6 <<= 8 * 6;
		s7 <<= 8 * 7;
		s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
		return s;
	}

	/**
	 * * 注释：int到字节数组的转换！ * * @param number * @return
	 * */
	public static byte[] intToByte(int number) {
		int temp = number;
		byte[] b = new byte[4];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Integer(temp & 0xff).byteValue();
			// 将最低位保存在最低位
			temp = temp >> 8;
			// 向右移8位
		}
		return b;
	}

	/**
	 * 注释：字节数组到int的转换！ * * @param b * @return
	 * */
	public static int byteToInt(byte[] b) {
		int s = 0;
		int s0 = b[0] & 0xff;
		// 最低位
		int s1 = b[1] & 0xff;
		int s2 = b[2] & 0xff;
		int s3 = b[3] & 0xff;
		s3 <<= 24;
		s2 <<= 16;
		s1 <<= 8;
		s = s0 | s1 | s2 | s3;
		return s;
	}

	/**
	 * * 注释：short到字节数组的转换！ * * @param s * @return
	 * */
	public static byte[] shortToByte(short number) {
		int temp = number;
		byte[] b = new byte[2];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Integer(temp & 0xff).byteValue();
			// 将最低位保存在最低位
			temp = temp >> 8;
			// 向右移8位
		}
		return b;
	}

	/**
	 * * 注释：字节数组到short的转换！ * * @param b * @return
	 * */
	public static short byteToShort(byte[] b) {
		short s = 0;
		short s0 = (short) (b[0] & 0xff);
		// 最低位
		short s1 = (short) (b[1] & 0xff);
		s1 <<= 8;
		s = (short) (s0 | s1);
		return s;
	}

	// 字符到字节转换
	public static byte[] charToByte(char ch) {
		int temp = (int) ch;
		byte[] b = new byte[2];
		for (int i = b.length - 1; i > -1; i--) {
			b[i] = new Integer(temp & 0xff).byteValue();
			// 将最高位保存在最低位
			temp = temp >> 8;// 向右移8位
		}
		return b;
	}

	// 字节到字符转换
	public static char byteToChar(byte[] b) {
		int s = 0;
		if (b[0] > 0)
			s += b[0];
		else
			s += 256 + b[0];
		s *= 256;
		if (b[1] > 0)
			s += b[1];
		else
			s += 256 + b[1];
		char ch = (char) s;
		return ch;
	}

	 /** 
     * float转换byte 
     * @param bb 
     * @param x 
     * @param index 
     */ 
    public static void putFloat(byte[] bb, float x, int index) {  
        // byte[] b = new byte[4];  
        int l = Float.floatToIntBits(x);  
        for (int i = 0; i < 4; i++) {  
            bb[index + i] = new Integer(l).byteValue();  
            l = l >> 8;  
        }  
    }  
 
    /** 
     * 通过byte数组取得float 
     * @param bb 
     * @param index 
     * @return 
     */ 
    public static float getFloat(byte[] b, int index) {  
        int l;  
        l = b[index + 0];  
        l &= 0xff;  
        l |= ((long) b[index + 1] << 8);  
        l &= 0xffff;  
        l |= ((long) b[index + 2] << 16);  
        l &= 0xffffff;  
        l |= ((long) b[index + 3] << 24);  
        return Float.intBitsToFloat(l);  
    }
    
    public static String getlenstr(String str, int len, String a) {
		if (len > 0) {
			if (str.length() > len) {
				str = str.substring(str.length() - len);
			} else {
				while (str.length() < len) {
					str = a + str;
				}
			}
		}
		return str;
	}
    
 
    
    public static String percent(String divisor,String denominator)
    {
    	BigDecimal a =new BigDecimal(divisor);      
        BigDecimal b = new BigDecimal(denominator); 
        
        if(a.intValue() > 0 && b.intValue() > 0 && a.intValue() > b.intValue())
        {
        	BigDecimal c = a.subtract(b);
        	return c.divide(b,2,BigDecimal.ROUND_DOWN).multiply(Constants.PERCENT).intValue()+"%";
        }
        
    	return "-";
    }

}
