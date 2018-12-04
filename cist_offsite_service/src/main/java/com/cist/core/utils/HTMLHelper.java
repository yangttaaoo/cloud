package com.cist.core.utils;

import org.jdom.Element;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.regexp.internal.RESyntaxException;

public final class HTMLHelper {

	private HTMLHelper() {
	}

	public static String toHTMLString(String str) {
		String s = str;
		if (str == null || str.trim().length() == 0)
			s = "";
		else
			s = StringHelper.convert(str, ES_DEF$OUTPUT);
		return s;
	}

	public static String toHTMLEXTString(String str) {
		String s = str;
		if (str == null || str.trim().length() == 0)
			s = "";
		else
			s = StringHelper.convert(str, ES_DEF_EXT$OUTPUT);
		return s;
	}

	public static String toHTMLString(String str, String esDef[][]) {
		if (str != null && str.trim().length() != 0)
			str = StringHelper.convert(str, esDef);
		else
			str = "&nbsp;";
		return str;
	}

	public static String toHTMLString(String str, Element esDef) {
		if (str != null && str.trim().length() != 0)
			str = StringHelper.convert(str, esDef);
		else
			str = "&nbsp;";
		return str;
	}

	public static String bbsToHTMLTag(String srcText, String tagName)
			throws RESyntaxException {
		for (RE patt = new RE("\\[" + tagName + "([^\\]]*)\\]([^\\]]*)\\[/"
				+ tagName + "\\]|\\[" + tagName + "([^\\]]*)\\]", 1); patt
				.match(srcText);)
			if (patt.getParenCount() == 4)
				srcText = StringHelper.replaceOnce(srcText, patt.getParen(0),
						"<" + tagName + patt.getParen(3) + ">");
			else
				srcText = StringHelper.replaceOnce(
						srcText,
						patt.getParen(0),
						"<" + tagName + patt.getParen(1) + ">"
								+ patt.getParen(2) + "</" + tagName + ">");

		return srcText;
	}

	public static final String ES_DEF$INPUT[][] = { { "'", "&#39;" },
			{ "\"", "&#34;" }, { "<", "&lt;" }, { ">", "&gt;" } };
	public static final String ES_DEF$OUTPUT[][] = { { "'", "&#39;" },
			{ "\"", "&quot;" }, { "<", "&lt;" }, { ">", "&gt;" },
			{ "\n", "<BR>" }, { " ", "&nbsp;" } };
	public static final String ES_DEF_EXT$OUTPUT[][] = { { "'", "‘" },
			{ "\"", "“" }, { "<", "〈" }, { ">", "〉" }, { "\n", "<BR>" },
			{ " ", "　" } };
}