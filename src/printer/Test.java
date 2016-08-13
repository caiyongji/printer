package printer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws Exception{
		String uri="http://**********:8888/s/p?";
		String name="test1111";
		name=URLEncoder.encode(name, "UTF-8");
		String content="《归去来兮辞》\n是晋宋之际文学家陶渊明创作的抒情小赋，也是一篇脱离仕途回归田园的宣言。\n\n\n\n";
		content=URLEncoder.encode(content, "UTF-8");
		uri+="name="+name+"&content="+content;
		URL url=new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String result="";
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			result += line;
		}
		bufferedReader.close();
		inputStreamReader.close();
		// 释放资源
		inputStream.close();
		inputStream = null;
		connection.disconnect();
		System.out.println(result);
	}
}
