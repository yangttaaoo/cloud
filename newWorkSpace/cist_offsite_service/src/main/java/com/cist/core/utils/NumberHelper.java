package com.cist.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public final class NumberHelper {
	public static final String NUMBER_I_1 = "#,##0.#";
	public static final String NUMBER_I_2 = "#,##0.##";
	public static final String NUMBER_I_3 = "#,##0.###";
	public static final String NUMBER_I_4 = "#,##0.####";
	public static final String NUMBER_I_5 = "#,##0.#####";
	public static final String NUMBER_I_6 = "#,##0.######";
	public static final String NUMBER_I_1_0 = "#,##0.0";
	public static final String NUMBER_I_2_0 = "#,##0.00";
	public static final String NUMBER_I_3_0 = "#,##0.000";
	public static final String NUMBER_I_4_0 = "#,##0.0000";
	public static final String NUMBER_I_5_0 = "#,##0.00000";
	public static final String NUMBER_I_6_0 = "#,##0.000000";
	public static final String NUMBER_IN_1 = "##0.#";
	public static final String NUMBER_IN_2 = "##0.##";
	public static final String NUMBER_IN_3 = "##0.###";
	public static final String NUMBER_IN_4 = "##0.####";
	public static final String NUMBER_IN_5 = "##0.#####";
	public static final String NUMBER_IN_6 = "##0.######";
	public static final String NUMBER_IN_1_0 = "##0.0";
	public static final String NUMBER_IN_2_0 = "##0.00";
	public static final String NUMBER_IN_3_0 = "##0.000";
	public static final String NUMBER_IN_4_0 = "##0.0000";
	public static final String NUMBER_IN_5_0 = "##0.00000";
	public static final String NUMBER_IN_6_0 = "##0.000000";
	public static final String NUMBER_I = "#,##0";
	public static final String NUMBER_IN = "##0";
	public static final String NUMBER_E_I_0 = "0E0";
	public static final String NUMBER_E_I_1 = "0.#E0";
	public static final String NUMBER_E_I_2 = "0.##E0";
	public static final String NUMBER_E_I_3 = "0.###E0";
	public static final String NUMBER_E_I_4 = "0.####E0";
	public static final String NUMBER_E_I_5 = "0.#####E0";
	public static final String NUMBER_E_I_6 = "0.######E0";
	public static final String NUMBER_E_I_1_0 = "0.0E0";
	public static final String NUMBER_E_I_2_0 = "0.00E0";
	public static final String NUMBER_E_I_3_0 = "0.000E0";
	public static final String NUMBER_E_I_4_0 = "0.0000E0";
	public static final String NUMBER_E_I_5_0 = "0.00000E0";
	public static final String NUMBER_E_I_6_0 = "0.000000E0";
	public static final String NUMBER_P_I_0 = "0%";
	public static final String NUMBER_P_I_1 = "0.#%";
	public static final String NUMBER_P_I_2 = "0.##%";
	public static final String NUMBER_P_I_3 = "0.###%";
	public static final String NUMBER_P_I_4 = "0.####%";
	public static final String NUMBER_P_I_5 = "0.#####%";
	public static final String NUMBER_P_I_6 = "0.######%";
	public static final String NUMBER_P_I_1_0 = "0.0%";
	public static final String NUMBER_P_I_2_0 = "0.00%";
	public static final String NUMBER_P_I_3_0 = "0.000%";
	public static final String NUMBER_P_I_4_0 = "0.0000%";
	public static final String NUMBER_P_I_5_0 = "0.00000%";
	public static final String NUMBER_P_I_6_0 = "0.000000%";
	public static final String NUMBER_M_I_0 = "0‰";
	public static final String NUMBER_M_I_1 = "0.#‰";
	public static final String NUMBER_M_I_2 = "0.##‰";
	public static final String NUMBER_M_I_3 = "0.###‰";
	public static final String NUMBER_M_I_4 = "0.####‰";
	public static final String NUMBER_M_I_5 = "0.#####‰";
	public static final String NUMBER_M_I_6 = "0.######‰";
	public static final String NUMBER_M_I_1_0 = "0.0‰";
	public static final String NUMBER_M_I_2_0 = "0.00‰";
	public static final String NUMBER_M_I_3_0 = "0.000‰";
	public static final String NUMBER_M_I_4_0 = "0.0000‰";
	public static final String NUMBER_M_I_5_0 = "0.00000‰";
	public static final String NUMBER_M_I_6_0 = "0.000000‰";
	public static final String MONEY_I_0 = "\2440";
	public static final String MONEY_I_1 = "\2440.0";
	public static final String MONEY_I_2 = "\2440.00";
	public static final String MONEY_I_1_0 = "\2440.#";
	public static final String MONEY_I_2_0 = "\2440.##";

	private NumberHelper() {
	}

	public static String formatNumberCN(double number, String formatStr) {
		DecimalFormat df = (DecimalFormat) DecimalFormat
				.getInstance(Locale.CHINA);
		df.applyPattern(formatStr);
		return df.format(number);
	}

	public static String formatNumberCN(String number, String formatStr) {
		if (number == null || number.length() < 1) {
			return "";
		} else {
			DecimalFormat df = (DecimalFormat) DecimalFormat
					.getInstance(Locale.CHINA);
			df.applyPattern(formatStr);
			String numberStr = df.format(Double.parseDouble(number));
			return numberStr;
		}
	}

	public static String formatNumberCN(double number) {
		DecimalFormat df = (DecimalFormat) DecimalFormat
				.getInstance(Locale.CHINA);
		df.applyPattern("##0.00");
		return df.format(number);
	}

	public static String formatNumberCN(String number) {
		if (number == null || number.length() < 1) {
			return "";
		} else {
			DecimalFormat df = (DecimalFormat) DecimalFormat
					.getInstance(Locale.CHINA);
			df.applyPattern("##0.00");
			return df.format(Double.parseDouble(number));
		}
	}

	public static String formatNumberLocale(double number, String formatStr,
			Locale locale) {
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
		df.applyPattern(formatStr);
		return df.format(number);
	}

	public static String formatNumberLocale(String number, String formatStr,
			Locale locale) {
		if (number == null || number.length() < 1) {
			return "";
		} else {
			DecimalFormat df = (DecimalFormat) DecimalFormat
					.getInstance(locale);
			df.applyPattern(formatStr);
			String numberStr = df.format(Double.parseDouble(number));
			return numberStr;
		}
	}

	public static String formatNumberLocale(double number, Locale locale) {
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
		df.applyPattern("##0.00");
		return df.format(number);
	}

	public static String formatNumberLocale(String number, Locale locale) {
		if (number == null || number.length() < 1) {
			return "";
		} else {
			DecimalFormat df = (DecimalFormat) DecimalFormat
					.getInstance(locale);
			df.applyPattern("##0.00");
			return df.format(Double.parseDouble(number));
		}
	}

	public static String formatNumber(double number, String formatStr) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(formatStr);
		return df.format(number);
	}

	public static String formatNumber(String number, String formatStr) {
		if (number == null || number.length() < 1) {
			return "";
		} else {
			try {
				DecimalFormat df = new DecimalFormat();
				df.applyPattern(formatStr);
				String numberStr = df.format(Double.parseDouble(number));
				return numberStr;
			} catch (Exception e) {
				return "";
			}
		}
	}

	public static String formatNumber(double number) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("##0.00");
		return df.format(number);
	}

	public static String formatNumber(String number) {
		if (number == null || number.length() < 1) {
			return "";
		} else {
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("##0.00");
			return df.format(Double.parseDouble(number));
		}
	}

	public static double unFormatCommaNumber(String formatedNumber) {
		String numbers[] = StringHelper.split(formatedNumber, ",");
		int numbersLength = numbers.length;
		String number = "";
		for (int i = 0; i < numbersLength; i++)
			number = number + numbers[i];

		if (number.length() == 0)
			number = "0.0";
		return Double.parseDouble(number);
	}

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static double div(double v1, double v2) {
		return div(v1, v2, 6);
	}

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		} else {
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.divide(b2, scale, 4).doubleValue();
		}
	}

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		} else {
			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, 4).doubleValue();
		}
	}

	public static String getCNofNumber(int num) {
		if (num < 0 || num > 10)
			throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
		String reCNStr = "";
		switch (num) {
		case 0: // '\0'
			reCNStr = "零";
			break;

		case 1: // '\001'
			reCNStr = "一";
			break;

		case 2: // '\002'
			reCNStr = "二";
			break;

		case 3: // '\003'
			reCNStr = "三";
			break;

		case 4: // '\004'
			reCNStr = "四";
			break;

		case 5: // '\005'
			reCNStr = "五";
			break;

		case 6: // '\006'
			reCNStr = "六";
			break;

		case 7: // '\007'
			reCNStr = "七";
			break;

		case 8: // '\b'
			reCNStr = "八";
			break;

		case 9: // '\t'
			reCNStr = "九";
			break;

		case 10: // '\n'
			reCNStr = "十";
			break;
		}
		return reCNStr;
	}

	public static String getCNofNumber(String numStr) {
		int num = Integer.parseInt(numStr);
		if (num < 0 || num > 10)
			throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
		String reCNStr = "";
		switch (num) {
		case 0: // '\0'
			reCNStr = "零";
			break;

		case 1: // '\001'
			reCNStr = "一";
			break;

		case 2: // '\002'
			reCNStr = "二";
			break;

		case 3: // '\003'
			reCNStr = "三";
			break;

		case 4: // '\004'
			reCNStr = "四";
			break;

		case 5: // '\005'
			reCNStr = "五";
			break;

		case 6: // '\006'
			reCNStr = "六";
			break;

		case 7: // '\007'
			reCNStr = "七";
			break;

		case 8: // '\b'
			reCNStr = "八";
			break;

		case 9: // '\t'
			reCNStr = "九";
			break;

		case 10: // '\n'
			reCNStr = "十";
			break;
		}
		return reCNStr;
	}

	public static String getBigCNofNumber(int num) {
		if (num < 0 || num > 10)
			throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
		String reCNStr = "";
		switch (num) {
		case 0: // '\0'
			reCNStr = "零";
			break;

		case 1: // '\001'
			reCNStr = "壹";
			break;

		case 2: // '\002'
			reCNStr = "贰";
			break;

		case 3: // '\003'
			reCNStr = "叁";
			break;

		case 4: // '\004'
			reCNStr = "肆";
			break;

		case 5: // '\005'
			reCNStr = "伍";
			break;

		case 6: // '\006'
			reCNStr = "陆";
			break;

		case 7: // '\007'
			reCNStr = "柒";
			break;

		case 8: // '\b'
			reCNStr = "捌";
			break;

		case 9: // '\t'
			reCNStr = "玖";
			break;

		case 10: // '\n'
			reCNStr = "拾";
			break;
		}
		return reCNStr;
	}

	public static String getBigCNofNumber(String numStr) {
		int num = Integer.parseInt(numStr);
		if (num < 0 || num > 10)
			throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
		String reCNStr = "";
		switch (num) {
		case 0: // '\0'
			reCNStr = "零";
			break;

		case 1: // '\001'
			reCNStr = "壹";
			break;

		case 2: // '\002'
			reCNStr = "贰";
			break;

		case 3: // '\003'
			reCNStr = "叁";
			break;

		case 4: // '\004'
			reCNStr = "肆";
			break;

		case 5: // '\005'
			reCNStr = "伍";
			break;

		case 6: // '\006'
			reCNStr = "陆";
			break;

		case 7: // '\007'
			reCNStr = "柒";
			break;

		case 8: // '\b'
			reCNStr = "捌";
			break;

		case 9: // '\t'
			reCNStr = "玖";
			break;

		case 10: // '\n'
			reCNStr = "拾";
			break;
		}
		return reCNStr;
	}

	public static String getCNStringOfNumber(int num) {
		String reStr = "";
		String numStr = String.valueOf(num).trim();
		int length = numStr.length();
		for (int i = 0; i < length; i++)
			reStr = reStr + getCNofNumber(numStr.substring(i, i + 1));

		return reStr;
	}

	public static String getCNStringOfNumber(String num) {
		String reStr = "";
		String numStr = num.trim();
		int length = numStr.length();
		for (int i = 0; i < length; i++)
			reStr = reStr + getCNofNumber(numStr.substring(i, i + 1));

		return reStr;
	}

	public static String getBigCNStringOfNumber(int num) {
		String reStr = "";
		String numStr = String.valueOf(num).trim();
		int length = numStr.length();
		for (int i = 0; i < length; i++)
			reStr = reStr + getBigCNofNumber(numStr.substring(i, i + 1));

		return reStr;
	}

	public static String getBigCNStringOfNumber(String num) {
		String reStr = "";
		String numStr = num.trim();
		int length = numStr.length();
		for (int i = 0; i < length; i++)
			reStr = reStr + getBigCNofNumber(numStr.substring(i, i + 1));

		return reStr;
	}

	protected static String getReadCNStringOfNumber(String num) {
		num = num.trim();
		String reStr = "";
		int numI = Integer.parseInt(num);
		num = String.valueOf(numI);
		int numLength = num.length();
		if (num == null || numLength < 1)
			throw new IllegalArgumentException("参数不正确");
		switch (numLength) {
		default:
			break;

		case 1: // '\001'
			reStr = getCNofNumber(num);
			break;

		case 2: // '\002'
			if (!num.substring(0, 1).equals("1"))
				reStr = getCNofNumber(num.substring(0, 1)) + "十";
			else
				reStr = "十";
			if (!num.substring(1, 2).equals("0"))
				reStr = reStr + getCNofNumber(num.substring(1, 2));
			break;

		case 3: // '\003'
			reStr = getCNofNumber(num.substring(0, 1)) + "百";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0"))
				break;
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")) {
				reStr = reStr + "零" + getCNofNumber(num.substring(2, 3));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")) {
				reStr = reStr + getCNofNumber(num.substring(1, 2)) + "十"
						+ getCNofNumber(num.substring(2, 3));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")) {
				reStr = reStr + getCNofNumber(num.substring(1, 2)) + "十";
				break;
			}
			// fall through

		case 4: // '\004'
			reStr = getCNofNumber(num.substring(0, 1)) + "千";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0"))
				break;
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + "零" + getCNofNumber(num.substring(3, 4));
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + "零" + getCNofNumber(num.substring(2, 3)) + "十";
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + "零" + getCNofNumber(num.substring(2, 3)) + "十"
						+ getCNofNumber(num.substring(3, 4));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + getCNofNumber(num.substring(1, 2)) + "百";
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + getCNofNumber(num.substring(1, 2)) + "百" + "零"
						+ getCNofNumber(num.substring(3, 4));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + getCNofNumber(num.substring(1, 2)) + "百"
						+ getCNofNumber(num.substring(2, 3)) + "十";
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0"))
				reStr = reStr + getCNofNumber(num.substring(1, 2)) + "百"
						+ getCNofNumber(num.substring(2, 3)) + "十"
						+ getCNofNumber(num.substring(3, 4));
			break;

		case 5: // '\005'
			String wan = num.substring(0, 1);
			String qian = num.substring(1, 5);
			String bai = num.substring(2, 5);
			String shi = num.substring(3, 5);
			String ge = num.substring(4, 5);
			reStr = getCNofNumber(wan) + "万";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0"))
				break;
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(qian);
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(bai);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(shi);
			} else {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(ge);
			}
			break;

		case 6: // '\006'
			String shiwan = num.substring(0, 1);
			String wan6 = num.substring(1, 6);
			String qian6 = num.substring(2, 6);
			String bai6 = num.substring(3, 6);
			String shi6 = num.substring(4, 6);
			String ge6 = num.substring(5, 6);
			reStr = getCNofNumber(shiwan) + "十";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")
					&& num.substring(5, 6).equals("0")) {
				reStr = reStr + "万";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(wan6);
				break;
			}
			reStr = reStr + "万";
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(qian6);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(bai6);
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(shi6);
			} else {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(ge6);
			}
			break;

		case 7: // '\007'
			String baiwan = num.substring(0, 1);
			String shiwan7 = num.substring(1, 7);
			String wan7 = num.substring(2, 7);
			String qian7 = num.substring(3, 7);
			String bai7 = num.substring(4, 7);
			String shi7 = num.substring(5, 7);
			String ge7 = num.substring(6, 7);
			reStr = (new StringBuffer(String.valueOf(getCNofNumber(baiwan))))
					.toString();
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")
					&& num.substring(5, 6).equals("0")
					&& num.substring(6, 7).equals("0")) {
				reStr = reStr + "百万";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + "百";
				reStr = reStr + getReadCNStringOfNumber(shiwan7);
				break;
			}
			reStr = reStr + "百";
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(wan7);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "万零";
				reStr = reStr + getReadCNStringOfNumber(qian7);
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "万零";
				reStr = reStr + getReadCNStringOfNumber(bai7);
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "万零";
				reStr = reStr + getReadCNStringOfNumber(shi7);
			} else {
				reStr = reStr + "万零";
				reStr = reStr + getReadCNStringOfNumber(ge7);
			}
			break;

		case 8: // '\b'
			String left = num.substring(0, 4);
			String qian8 = num.substring(4, 5);
			String bai8 = num.substring(5, 6);
			String shi8 = num.substring(6, 7);
			String ge8 = num.substring(7, 8);
			String right = num.substring(4, 8);
			reStr = getReadCNStringOfNumber(left) + "万";
			if (qian8.equals("0") && bai8.equals("0") && shi8.equals("0")
					&& ge8.equals("0"))
				break;
			if (!qian8.equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(right);
				break;
			}
			if (!bai8.equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(5, 8));
				break;
			}
			if (!shi8.equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(6, 8));
			} else {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(7, 8));
			}
			break;

		case 9: // '\t'
			reStr = getReadCNStringOfNumber(num.substring(0, 1)) + "亿";
			String middle9 = num.substring(1);
			String right9 = num.substring(5);
			if (num.substring(1).equals("00000000"))
				break;
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(middle9);
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(2, 5));
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(3, 5));
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(4, 5));
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(right9);
				break;
			}
			if (!num.substring(6, 7).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(6, 9));
				break;
			}
			if (!num.substring(7, 8).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(7, 9));
				break;
			}
			if (!num.substring(8, 9).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(8));
				break;
			}
			// fall through

		case 10: // '\n'
			reStr = getReadCNStringOfNumber(num.substring(0, 2)) + "亿";
			String middle10 = num.substring(2);
			String right10 = num.substring(6);
			if (num.substring(2).equals("000000000"))
				break;
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadCNStringOfNumber(middle10);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(3, 6));
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(4, 6));
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(5, 6));
				break;
			}
			if (!num.substring(6, 7).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(right10);
				break;
			}
			if (!num.substring(7, 8).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(7, 10));
				break;
			}
			if (!num.substring(8, 9).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(8, 10));
				break;
			}
			if (!num.substring(9, 10).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadCNStringOfNumber(num.substring(9));
			}
			break;
		}
		return reStr;
	}

	/**
	 * @deprecated Method getReadCNStringOfNumber is deprecated
	 */

	protected static String getReadCNStringOfNumber(int num) {
		return getReadCNStringOfNumber(String.valueOf(num));
	}

	/**
	 * @deprecated Method getReadMoneyCNStringOfNumber is deprecated
	 */

	protected static String getReadMoneyCNStringOfNumber(String num) {
		num = num.trim();
		String reStr = "";
		int numI = Integer.parseInt(num);
		num = String.valueOf(numI);
		int numLength = num.length();
		if (num == null || numLength < 1)
			return "";
		switch (numLength) {
		default:
			break;

		case 1: // '\001'
			reStr = getBigCNofNumber(num);
			break;

		case 2: // '\002'
			reStr = getBigCNofNumber(num.substring(0, 1)) + "拾";
			if (!num.substring(1, 2).equals("0"))
				reStr = reStr + getBigCNofNumber(num.substring(1, 2));
			break;

		case 3: // '\003'
			reStr = getBigCNofNumber(num.substring(0, 1)) + "佰";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")) {
				reStr = reStr + "零拾零";
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")) {
				reStr = reStr + "零拾" + getBigCNofNumber(num.substring(2, 3));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "拾"
						+ getBigCNofNumber(num.substring(2, 3));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "拾零";
				break;
			}
			// fall through

		case 4: // '\004'
			reStr = getBigCNofNumber(num.substring(0, 1)) + "仟";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + "零佰零拾零";
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + "零佰零拾" + getBigCNofNumber(num.substring(3, 4));
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + "零佰" + getBigCNofNumber(num.substring(2, 3))
						+ "拾零";
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + "零佰" + getBigCNofNumber(num.substring(2, 3))
						+ "拾" + getBigCNofNumber(num.substring(3, 4));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰零拾零";
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰"
						+ "零拾" + getBigCNofNumber(num.substring(3, 4));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰"
						+ getBigCNofNumber(num.substring(2, 3)) + "拾零";
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0"))
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰"
						+ getBigCNofNumber(num.substring(2, 3)) + "拾"
						+ getBigCNofNumber(num.substring(3, 4));
			break;

		case 5: // '\005'
			String wan = num.substring(0, 1);
			String qian = num.substring(1, 5);
			String bai = num.substring(2, 5);
			String shi = num.substring(3, 5);
			String ge = num.substring(4, 5);
			reStr = getBigCNofNumber(wan) + "万";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")) {
				reStr = reStr + "零仟零佰零拾零";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadMoneyCNStringOfNumber(qian);
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + "零仟" + getReadMoneyCNStringOfNumber(bai);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零仟零佰";
				reStr = reStr + getReadMoneyCNStringOfNumber(shi);
			} else {
				reStr = reStr + "零仟零佰零拾";
				reStr = reStr + getReadMoneyCNStringOfNumber(ge);
			}
			break;

		case 6: // '\006'
			String shiwan = num.substring(0, 1);
			String wan6 = num.substring(1, 6);
			String qian6 = num.substring(2, 6);
			String bai6 = num.substring(3, 6);
			String shi6 = num.substring(4, 6);
			String ge6 = num.substring(5, 6);
			reStr = getBigCNofNumber(shiwan) + "拾";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")
					&& num.substring(5, 6).equals("0")) {
				reStr = reStr + "万零仟零佰零拾零";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadMoneyCNStringOfNumber(wan6);
				break;
			}
			reStr = reStr + "万";
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadMoneyCNStringOfNumber(qian6);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零仟";
				reStr = reStr + getReadMoneyCNStringOfNumber(bai6);
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零仟零佰";
				reStr = reStr + getReadMoneyCNStringOfNumber(shi6);
			} else {
				reStr = reStr + "零仟零佰零拾";
				reStr = reStr + getReadMoneyCNStringOfNumber(ge6);
			}
			break;

		case 7: // '\007'
			String baiwan = num.substring(0, 1);
			String shiwan7 = num.substring(1, 7);
			String wan7 = num.substring(2, 7);
			String qian7 = num.substring(3, 7);
			String bai7 = num.substring(4, 7);
			String shi7 = num.substring(5, 7);
			String ge7 = num.substring(6, 7);
			reStr = (new StringBuffer(String.valueOf(getBigCNofNumber(baiwan))))
					.toString();
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")
					&& num.substring(5, 6).equals("0")
					&& num.substring(6, 7).equals("0")) {
				reStr = reStr + "佰万零仟零佰零拾零";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + "佰";
				reStr = reStr + getReadMoneyCNStringOfNumber(shiwan7);
				break;
			}
			reStr = reStr + "佰";
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadMoneyCNStringOfNumber(wan7);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "万";
				reStr = reStr + getReadMoneyCNStringOfNumber(qian7);
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "万零仟";
				reStr = reStr + getReadMoneyCNStringOfNumber(bai7);
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "万零仟零佰";
				reStr = reStr + getReadMoneyCNStringOfNumber(shi7);
			} else {
				reStr = reStr + "万零零仟零佰零拾";
				reStr = reStr + getReadMoneyCNStringOfNumber(ge7);
			}
			break;

		case 8: // '\b'
			String left = num.substring(0, 4);
			String qian8 = num.substring(4, 5);
			String bai8 = num.substring(5, 6);
			String shi8 = num.substring(6, 7);
			String ge8 = num.substring(7, 8);
			String right = num.substring(4, 8);
			reStr = getReadBigCNStringOfNumber(left) + "万";
			if (qian8.equals("0") && bai8.equals("0") && shi8.equals("0")
					&& ge8.equals("0")) {
				reStr = reStr + "零仟零佰零拾零";
				break;
			}
			if (!qian8.equals("0")) {
				reStr = reStr + getReadMoneyCNStringOfNumber(right);
				break;
			}
			if (!bai8.equals("0")) {
				reStr = reStr + "零仟";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(5, 8));
				break;
			}
			if (!shi8.equals("0")) {
				reStr = reStr + "零仟零佰";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(6, 8));
			} else {
				reStr = reStr + "零仟零佰零拾";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(7, 8));
			}
			break;

		case 9: // '\t'
			reStr = getReadMoneyCNStringOfNumber(num.substring(0, 1)) + "亿";
			String middle9 = num.substring(1);
			String right9 = num.substring(5);
			if (num.substring(1).equals("00000000")) {
				reStr = reStr + "零万零仟零佰零拾零";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadMoneyCNStringOfNumber(middle9);
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(2, 5));
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(3, 5));
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(4, 5));
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "零万";
				reStr = reStr + getReadMoneyCNStringOfNumber(right9);
				break;
			}
			if (!num.substring(6, 7).equals("0")) {
				reStr = reStr + "零万零仟";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(6, 9));
				break;
			}
			if (!num.substring(7, 8).equals("0")) {
				reStr = reStr + "零万零仟零佰";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(7, 9));
				break;
			}
			if (!num.substring(8, 9).equals("0")) {
				reStr = reStr + "零万零仟零佰零拾";
				reStr = reStr + getReadMoneyCNStringOfNumber(num.substring(8));
				break;
			}
			// fall through

		case 10: // '\n'
			reStr = getReadMoneyCNStringOfNumber(num.substring(0, 2)) + "亿";
			String middle10 = num.substring(2);
			String right10 = num.substring(6);
			if (num.substring(2).equals("000000000")) {
				reStr = reStr + "零万零仟零佰零拾零";
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadMoneyCNStringOfNumber(middle10);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(3, 6));
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(4, 6));
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(5, 6));
				break;
			}
			if (!num.substring(6, 7).equals("0")) {
				reStr = reStr + "零万";
				reStr = reStr + getReadMoneyCNStringOfNumber(right10);
				break;
			}
			if (!num.substring(7, 8).equals("0")) {
				reStr = reStr + "零万零仟";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(7, 10));
				break;
			}
			if (!num.substring(8, 9).equals("0")) {
				reStr = reStr + "零万零仟零佰";
				reStr = reStr
						+ getReadMoneyCNStringOfNumber(num.substring(8, 10));
				break;
			}
			if (!num.substring(9, 10).equals("0")) {
				reStr = reStr + "零万零仟零佰零拾";
				reStr = reStr + getReadMoneyCNStringOfNumber(num.substring(9));
			}
			break;
		}
		return reStr;
	}

	/**
	 * @deprecated Method getReadMoneyCNStringOfNumber is deprecated
	 */

	protected static String getReadMoneyCNStringOfNumber(int num) {
		return getReadMoneyCNStringOfNumber(String.valueOf(num));
	}

	/**
	 * @deprecated Method getReadBigCNStringOfNumber is deprecated
	 */

	protected static String getReadBigCNStringOfNumber(String num) {
		num = num.trim();
		String reStr = "";
		int numI = Integer.parseInt(num);
		num = String.valueOf(numI);
		int numLength = num.length();
		if (num == null || numLength < 1)
			return "";
		switch (numLength) {
		default:
			break;

		case 1: // '\001'
			reStr = getBigCNofNumber(num);
			break;

		case 2: // '\002'
			if (!num.substring(0, 1).equals("1"))
				reStr = getBigCNofNumber(num.substring(0, 1)) + "拾";
			else
				reStr = "拾";
			if (!num.substring(1, 2).equals("0"))
				reStr = reStr + getBigCNofNumber(num.substring(1, 2));
			break;

		case 3: // '\003'
			reStr = getBigCNofNumber(num.substring(0, 1)) + "佰";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0"))
				break;
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")) {
				reStr = reStr + "零" + getBigCNofNumber(num.substring(2, 3));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "拾"
						+ getBigCNofNumber(num.substring(2, 3));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "拾";
				break;
			}
			// fall through

		case 4: // '\004'
			reStr = getBigCNofNumber(num.substring(0, 1)) + "仟";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0"))
				break;
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + "零" + getBigCNofNumber(num.substring(3, 4));
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + "零" + getBigCNofNumber(num.substring(2, 3))
						+ "拾";
				break;
			}
			if (num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + "零" + getBigCNofNumber(num.substring(2, 3))
						+ "拾" + getBigCNofNumber(num.substring(3, 4));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰";
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰"
						+ "零" + getBigCNofNumber(num.substring(3, 4));
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")) {
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰"
						+ getBigCNofNumber(num.substring(2, 3)) + "拾";
				break;
			}
			if (!num.substring(1, 2).equals("0")
					&& !num.substring(2, 3).equals("0")
					&& !num.substring(3, 4).equals("0"))
				reStr = reStr + getBigCNofNumber(num.substring(1, 2)) + "佰"
						+ getBigCNofNumber(num.substring(2, 3)) + "拾"
						+ getBigCNofNumber(num.substring(3, 4));
			break;

		case 5: // '\005'
			String wan = num.substring(0, 1);
			String qian = num.substring(1, 5);
			String bai = num.substring(2, 5);
			String shi = num.substring(3, 5);
			String ge = num.substring(4, 5);
			reStr = getBigCNofNumber(wan) + "万";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0"))
				break;
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(qian);
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(bai);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(shi);
			} else {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(ge);
			}
			break;

		case 6: // '\006'
			String shiwan = num.substring(0, 1);
			String wan6 = num.substring(1, 6);
			String qian6 = num.substring(2, 6);
			String bai6 = num.substring(3, 6);
			String shi6 = num.substring(4, 6);
			String ge6 = num.substring(5, 6);
			reStr = getBigCNofNumber(shiwan) + "拾";
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")
					&& num.substring(5, 6).equals("0")) {
				reStr = reStr + "万";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(wan6);
				break;
			}
			reStr = reStr + "万";
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(qian6);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(bai6);
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(shi6);
			} else {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(ge6);
			}
			break;

		case 7: // '\007'
			String baiwan = num.substring(0, 1);
			String shiwan7 = num.substring(1, 7);
			String wan7 = num.substring(2, 7);
			String qian7 = num.substring(3, 7);
			String bai7 = num.substring(4, 7);
			String shi7 = num.substring(5, 7);
			String ge7 = num.substring(6, 7);
			reStr = (new StringBuffer(String.valueOf(getBigCNofNumber(baiwan))))
					.toString();
			if (num.substring(1, 2).equals("0")
					&& num.substring(2, 3).equals("0")
					&& num.substring(3, 4).equals("0")
					&& num.substring(4, 5).equals("0")
					&& num.substring(5, 6).equals("0")
					&& num.substring(6, 7).equals("0")) {
				reStr = reStr + "佰万";
				break;
			}
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + "佰";
				reStr = reStr + getReadBigCNStringOfNumber(shiwan7);
				break;
			}
			reStr = reStr + "佰";
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(wan7);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "万零";
				reStr = reStr + getReadBigCNStringOfNumber(qian7);
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "万零";
				reStr = reStr + getReadBigCNStringOfNumber(bai7);
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "万零";
				reStr = reStr + getReadBigCNStringOfNumber(shi7);
			} else {
				reStr = reStr + "万零";
				reStr = reStr + getReadBigCNStringOfNumber(ge7);
			}
			break;

		case 8: // '\b'
			String left = num.substring(0, 4);
			String qian8 = num.substring(4, 5);
			String bai8 = num.substring(5, 6);
			String shi8 = num.substring(6, 7);
			String ge8 = num.substring(7, 8);
			String right = num.substring(4, 8);
			reStr = getReadBigCNStringOfNumber(left) + "万";
			if (qian8.equals("0") && bai8.equals("0") && shi8.equals("0")
					&& ge8.equals("0"))
				break;
			if (!qian8.equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(right);
				break;
			}
			if (!bai8.equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(5, 8));
				break;
			}
			if (!shi8.equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(6, 8));
			} else {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(7, 8));
			}
			break;

		case 9: // '\t'
			reStr = getReadBigCNStringOfNumber(num.substring(0, 1)) + "亿";
			String middle9 = num.substring(1);
			String right9 = num.substring(5);
			if (num.substring(1).equals("00000000"))
				break;
			if (!num.substring(1, 2).equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(middle9);
				break;
			}
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(2, 5));
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(3, 5));
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(4, 5));
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(right9);
				break;
			}
			if (!num.substring(6, 7).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(6, 9));
				break;
			}
			if (!num.substring(7, 8).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(7, 9));
				break;
			}
			if (!num.substring(8, 9).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(8));
				break;
			}
			// fall through

		case 10: // '\n'
			reStr = getReadBigCNStringOfNumber(num.substring(0, 2)) + "亿";
			String middle10 = num.substring(2);
			String right10 = num.substring(6);
			if (num.substring(2).equals("000000000"))
				break;
			if (!num.substring(2, 3).equals("0")) {
				reStr = reStr + getReadBigCNStringOfNumber(middle10);
				break;
			}
			if (!num.substring(3, 4).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(3, 6));
				break;
			}
			if (!num.substring(4, 5).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(4, 6));
				break;
			}
			if (!num.substring(5, 6).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(5, 6));
				break;
			}
			if (!num.substring(6, 7).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(right10);
				break;
			}
			if (!num.substring(7, 8).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr
						+ getReadBigCNStringOfNumber(num.substring(7, 10));
				break;
			}
			if (!num.substring(8, 9).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr
						+ getReadBigCNStringOfNumber(num.substring(8, 10));
				break;
			}
			if (!num.substring(9, 10).equals("0")) {
				reStr = reStr + "零";
				reStr = reStr + getReadBigCNStringOfNumber(num.substring(9));
			}
			break;
		}
		return reStr;
	}

	/**
	 * @deprecated Method getReadBigCNStringOfNumber is deprecated
	 */

	protected static String getReadBigCNStringOfNumber(int num) {
		return getReadBigCNStringOfNumber(String.valueOf(num));
	}

	/**
	 * @deprecated Method getCNMoneyStringOfNumber is deprecated
	 */

	protected static String getCNMoneyStringOfNumber(double num) {
		int pointPos = String.valueOf(num).indexOf(".");
		String numStr = formatNumber(num, "##0.00");
		int pos = numStr.indexOf(".");
		String reStr = "";
		String intPart = numStr.substring(0, pos);
		String floatPart1 = numStr.substring(pos + 1, pos + 2);
		String floatPart2 = numStr.substring(pos + 2);
		String bigCNStr = getReadMoneyCNStringOfNumber(intPart);
		reStr = bigCNStr + "圆";
		if (pointPos == -1) {
			reStr = reStr + "整";
		} else {
			reStr = reStr + getBigCNofNumber(floatPart1) + "角";
			reStr = reStr + getBigCNofNumber(floatPart2) + "分";
		}
		return reStr;
	}

	/**
	 * @deprecated Method getCNMoneyStringOfNumber is deprecated
	 */

	protected static String getCNMoneyStringOfNumber(String numStr) {
		double numN = Double.parseDouble(numStr);
		return getCNMoneyStringOfNumber(numN);
	}
}