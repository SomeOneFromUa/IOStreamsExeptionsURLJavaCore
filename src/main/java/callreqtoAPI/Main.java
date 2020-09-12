package callreqtoAPI;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users"); // як з новим файлом - ми просто можемо отримати інфу
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); // кастуєм до HTTP протоколу
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {  // хороший тон - використовувати заготовлені константи замість responseCode == 200
                InputStream inputStream = urlConnection.getInputStream();
                int i;
                StringBuilder stringBuilder = new StringBuilder(); // економія памяті що не створювати лишні стрічки при конкатенації
                while ((i = inputStream.read()) != -1 ){
                    stringBuilder.append((char) i);
                }
                System.out.println(stringBuilder);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
