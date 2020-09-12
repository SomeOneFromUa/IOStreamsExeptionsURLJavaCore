package homework8.part1;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.*;
import netscape.javascript.JSObject;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//         витягнути данні із json api і записати в файл
        GetData getData = new GetData();
        File file = new File("task1.txt");
        getData.manager("https://jsonplaceholder.typicode.com/users", file, false);
        getData.manager("https://reqres.in/api/users?page=2", file, false);
        getData.manager("https://jsonplaceholder.typicode.com/users", "test.txt");


    }
}
