import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExamplePool {
    static int count = 1;

    public static void main(String[] args) throws java.lang.Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<String> urlList = new ArrayList<>();
        urlList.add("https://www.deskera.com/");
        urlList.add("https://mail.google.com/mail/u/0/#inbox");
        urlList.add("https://en.wikipedia.org/wiki/Main_Page");
        urlList.add("https://www.google.com/");
        urlList.add("https://en.wikipedia.org/wiki/Wikipedia");
        urlList.add("https://en.wikipedia.org/wiki/Wikipedia_(disambiguation)");
        urlList.add("https://en.wikipedia.org/wiki/Wikipedia:Wikipedia_for_Schools");
        urlList.add("https://en.wikipedia.org/wiki/Wikipedia:Wikipedia_for_Schools#History_of_the_project");
        urlList.add("http://news.bbc.co.uk/2/hi/technology/6566749.stm");
        urlList.add("https://en.wikipedia.org/wiki/Computer_technology_for_developing_areas");
        urlList.add("https://en.wikipedia.org/wiki/Digital_divide#The_global_digital_divide");
        urlList.add("https://en.wikipedia.org/wiki/Unit_of_analysis");
        for (String urlStr: urlList) {
            String future = executor.submit(() -> {
//                Thread.sleep(2000);

                URL obj = new URL(urlStr);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    System.out.println("Got Response");
                } else {
                    System.out.println("GET request not worked");
                }
                return "Thread Execution Done - " + (count++);
            }).get();
            System.out.println(future);
        }
        executor.shutdown();
        System.out.println("Finished all threads");
    }
}