package homework8.part1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetData {
    private StringBuilder dataGetter(String APIurl) throws IOException {
        URL url = new URL(APIurl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response from ").append(url).append("\n");
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = urlConnection.getInputStream();
            int i;
            while ((i = inputStream.read()) != -1) {
                if (i == 125 || i == 93 || i == 34 || i == 123 || i == 91 || i == 44) {
                    i = 32;
                }
                stringBuilder.append((char) i);
            }
            inputStream.close();
        } else stringBuilder.append("something went wrong");
        stringBuilder.append("\n");
        return stringBuilder;
    }

    private void dataSetter (File file, StringBuilder stringBuilder, Boolean append) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append));
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }

// 1 url - url to API you want to send request


//    option 1 - if you already have file;
// file - file where you want to save response from API
// append flag - if you want to add new data just throw true, otherwise false

//    option 2 - if you don't have file
// fileName - name for new file which will be created by manager in root folder;

    public void manager(String url, File file, Boolean append) {
        try {
            StringBuilder stringBuilder = dataGetter(url);
            dataSetter(file, stringBuilder, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manager(String url, String fileName) {
        File file1 = new File(fileName);
        try {
            StringBuilder stringBuilder = dataGetter(url);
            dataSetter(file1, stringBuilder, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
