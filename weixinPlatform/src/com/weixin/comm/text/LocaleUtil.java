package com.weixin.comm.text;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author JINLONG
 *
 */
public class LocaleUtil {
	public static Locale parseLocale(String value) {
		value = StringUtils.stripToNull(value);
		if (value == null)
			return Locale.CHINA;

		StringTokenizer st = new StringTokenizer(value, "_-");
		if (!st.hasMoreTokens())
			return null;

		String language = st.nextToken();
		if (!st.hasMoreTokens())
			return new Locale(language);

		String country = st.nextToken();
		if (!st.hasMoreTokens()) {
			return new Locale(language, country);
		} else {
			String variant = st.nextToken();
			return new Locale(language, country, variant);
		}
	}
}