package in.ezeon.capp.util;
//This class contains utility methods related to string operations.
public class StringUtil {
	public static String toCommaSeperatedString(Object[] items) {
		StringBuilder sb = new StringBuilder();
		for (Object item : items) {
			sb.append(item).append(",");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(sb);
		return sb.toString();
	}
}
