package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		String s1 = "今天是@19@21@14@4@1@25，天气非常@7@15@15@4。 大家@2@25@5，我先走了。"; // 密文
		char[] tables = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };

		String patternStr = "@([3-9]|1\\d?|2[0-6]?)";
		Pattern pattern =  Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(s1);
		StringBuffer sb = new StringBuffer();
		
		while(matcher.find()) {
			String str = matcher.group(1);
			String result = tables[Integer.valueOf(str)-1]+"";
			matcher.appendReplacement(sb, result);
			
		
		}
		
		System.out.println(sb.toString());
	}

}
