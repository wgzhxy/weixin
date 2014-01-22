package com.weixin.comm.text;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author Bing
 * 
 *         2010-1-6 下午03:10:47
 * 
 * @Description:
 */
public class TextUtil {

	public static String getText(String key, String language, String country) {
		Locale locale = new Locale(language, country);
		return getText(key, locale);
	}

	public static String getText(String key, Locale locale) {
		String value = "";
		ResourceBundle bundle = ResourceBundle.getBundle("messageResource", locale);
		value = bundle.getString(key);
		return value;
	}

	public static String getText(String key, String locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("messageResource",
				LocaleUtil.parseLocale(locale));
		return bundle.getString(key);
	}

	public static String getText(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messageResource", LocaleUtil.parseLocale("zh_CN"));
		return bundle.getString(key);
	}

	public static String getText(String key, Object[] params) {
		String message = getText(key);
		return MessageFormat.format(message, params);
	}

	public static String getText(String key, Object[] params, String locale) {
		String message = getText(key, locale);
		return MessageFormat.format(message, params);
	}

	public static String getGenderPron(short gender, String locale) {
		if (gender == 1) {
			return TextUtil.getText("gender_female_pron", locale);
		}
		return TextUtil.getText("gender_male_pron", locale);
	}

	public static String getGenderPron(short gender) 
	{
		if (gender == 1) 
		{
			return TextUtil.getText("gender_female_pron");
		}
		return TextUtil.getText("gender_male_pron");
	}

	public static Properties setProperty(String[] key, String[] value) 
	{
		Properties para = new Properties();
		for (int i = 0; i < key.length; i++) 
		{
			String value_tmp = value[i];
			if (value_tmp != null && !value_tmp.equals("") && !value_tmp.equals("null")) 
			{
				para.setProperty(key[i], value_tmp);
			} else {
				para.setProperty(key[i], "");
			}
		}
		return para;
	}

	public static void main(String[] args) {
		String textArray = TextUtil.getText(
				"group.createapply.email.unsuccess.tips", new String[] { "f",
						"x" });
		System.out.println(textArray);
	}

}
