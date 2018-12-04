package com.cist.core.utils;

import java.io.Reader;
import java.util.*;

import org.jdom.Element;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.regexp.internal.CharacterIterator;
import com.sun.org.apache.regexp.internal.ReaderCharacterIterator;
import com.sun.org.apache.regexp.internal.StringCharacterIterator;

public final class StringHelper {

	private static final String exceptionStr = "参数不正确,不能是null对象!";

	private StringHelper() {
	}

	public static String[] add(String x[], String sep, String y[]) {
		String result[] = new String[x.length];
		for (int i = 0; i < x.length; i++)
			result[i] = x[i] + sep + y[i];

		return result;
	}

	public static String repeat(String string, int times) {
		StringBuffer buf = new StringBuffer(string.length() * times);
		for (int i = 0; i < times; i++)
			buf.append(string);

		return buf.toString();
	}

	public static String replace(String template, String placeholder,
			String replacement) {
		return replace(template, placeholder, replacement, false);
	}

	public static String replace(String template, String placeholder,
			String replacement, boolean wholeWords) {
		if (template == null || replacement == null || placeholder == null)
			throw new IllegalArgumentException(exceptionStr);
		int loc = template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			boolean actuallyReplace = !wholeWords
					|| loc + placeholder.length() == template.length()
					|| !Character.isJavaIdentifierPart(template.charAt(loc
							+ placeholder.length()));
			String actualReplacement = actuallyReplace ? replacement
					: placeholder;
			return template.substring(0, loc)
					+ actualReplacement
					+ replace(template.substring(loc + placeholder.length()),
							placeholder, replacement, wholeWords);
		}
	}

	public static String replaceOnce(String template, String placeholder,
			String replacement) {
		if (template == null || replacement == null || placeholder == null)
			throw new IllegalArgumentException(exceptionStr);
		int loc = template.indexOf(placeholder);
		if (loc < 0)
			return template;
		else
			return template.substring(0, loc) + replacement
					+ template.substring(loc + placeholder.length());
	}

	public static String replaceAll(String str, String oldStr, String newStr)
			throws Exception {
		if (str == null || newStr == null || oldStr == null)
			throw new IllegalArgumentException(exceptionStr);
		String reStr = str;
		String patt = oldStr;
		RE r = new RE(patt);
		if (r.match(str))
			reStr = r.subst(str, newStr);
		return reStr;
	}

	public static String getMatchString(String str, String patt)
			throws Exception {
		if (str == null || patt == null)
			throw new IllegalArgumentException(exceptionStr);
		String reStr = "";
		RE r = new RE(patt);
		if (r.match(str))
			reStr = r.getParen(0);
		return reStr != null ? reStr : "";
	}

	public static String[] getMatchString(Reader r, String str)
			throws Exception {
		if (r == null || str == null)
			throw new IllegalArgumentException(exceptionStr);
		List<Object> strList = new ArrayList<Object>();
		RE patt = new RE(str);
		CharacterIterator in = new ReaderCharacterIterator(r);
		int start;
		for (int end = 0; patt.match(in, end); strList.add(in.substring(start,
				end))) {
			start = patt.getParenStart(0);
			end = patt.getParenEnd(0);
		}

		String tempStr[] = (String[]) strList
				.toArray(new String[strList.size()]);
		return tempStr;
	}

	public static String[] getMatchStrings(String srclongStr, String str)
			throws Exception {
		if (srclongStr == null || str == null)
			throw new IllegalArgumentException(exceptionStr);
		List<Object> strList = new ArrayList<Object>();
		RE patt = new RE(str);
		StringCharacterIterator in = new StringCharacterIterator(srclongStr);
		int start;
		for (int end = 0; patt.match(in, end); strList.add(in.substring(start,
				end))) {
			start = patt.getParenStart(0);
			end = patt.getParenEnd(0);
		}

		String tempStr[] = (String[]) strList
				.toArray(new String[strList.size()]);
		return tempStr;
	}

	public static String[] splitAll(String srcStr, String splitStr)
			throws Exception {
		if (srcStr == null || splitStr == null) {
			throw new IllegalArgumentException(exceptionStr);
		} else {
			String reStr[] = (String[]) null;
			RE r = new RE(splitStr);
			reStr = r.split(srcStr);
			return reStr;
		}
	}

	public static String[] split(String list, String seperator) {
		return split(list, seperator, false);
	}

	public static String[] split(String list, String seperator, boolean include) {
		StringTokenizer tokens = new StringTokenizer(list, seperator, include);
		String result[] = new String[tokens.countTokens()];
		int i = 0;
		while (tokens.hasMoreTokens())
			result[i++] = tokens.nextToken();
		return result;
	}

	public static String join(String strs[], String separator) {
		int length = strs.length;
		if (length == 0)
			return "";
		StringBuffer buf = (new StringBuffer(length * strs[0].length()))
				.append(strs[0]);
		for (int i = 1; i < length; i++)
			buf.append(separator).append(strs[i]);

		return buf.toString();
	}

	public static String join(Iterator<Object> objects, String separator) {
		StringBuffer buf = new StringBuffer();
		if (objects.hasNext())
			buf.append(objects.next());
		for (; objects.hasNext(); buf.append(separator).append(objects.next()))
			;
		return buf.toString();
	}

	public static String convert(String str, String esDef[][]) {
		if (str != null && str.trim().length() != 0) {
			for (int i = 0; i < esDef.length; i++)
				if (esDef[i][0].equals("\n")) {
					str = replace(str, "\r\n", esDef[i][1]);
					str = replace(str, "\n", esDef[i][1]);
				} else {
					str = replace(str, esDef[i][0], esDef[i][1]);
				}

		}
		return str;
	}

	@SuppressWarnings("unchecked")
	public static String convert(String str, Element esDef) {
		if (str != null && str.trim().length() != 0) {
			List<Object> esDefs = esDef.getChildren();
			int len = esDefs.size();
			for (int i = 0; i < len; i++) {
				Element esEL = (Element) esDefs.get(i);
				String srcStr = esEL.getChild("source").getText();
				String tgtStr = esEL.getChild("target").getText();
				if (srcStr.equals("\n")) {
					str = replace(str, "\r\n", tgtStr);
					str = replace(str, "\n", tgtStr);
				} else {
					str = replace(str, srcStr, tgtStr);
				}
			}

		}
		return str;
	}

	public static String FilterStr(String str) {
		int len = str.length();
		if (new Character('0').equals(str.charAt(len - 1))) {
			return FilterStr(str.substring(0, len - 1));
		}
		return str;

	}
}