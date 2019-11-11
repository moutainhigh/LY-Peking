package com.zscat.mallplus;

import com.zscat.mallplus.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/3.
 */
public class T {
    public static void main(String[] args) {

            String host = "https://kdwlcxf.market.alicloudapi.com";
            String path = "/kdwlcx";
            String method = "GET";
            String appcode = "436e99b5b81044698cbaf100d164aa63";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("no", "801132164062135036");
            querys.put("type", "zto");
            //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip

            try {
                /**
                 * 重要提示如下:
                 * HttpUtils请从
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                 * 下载
                 *
                 * 相应的依赖请参照
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                 */
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(response.toString()); //如不输出json, 请打开这行代码，打印调试头部状态码。
                //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
                //获取response的body
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    public static int numJewelsInStones(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
    public static int numJewelsInStones1(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char s : S.toCharArray())
            map.put(s, map.getOrDefault(s, 0) + 1);

        for(int i = 0; i < J.length(); i++)
            count += map.getOrDefault(J.charAt(i), 0);

        return count;
    }


}