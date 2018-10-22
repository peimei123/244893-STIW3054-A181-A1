package webscaper;


import java.io.IOException;
import java.util.LinkedList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebTableHandle {
    public static LinkedList<Info> findAll() {
        LinkedList<Info> info= new LinkedList<Info>();
        final String url= "https://ms.wikipedia.org/wiki/Malaysia";

        try {
            final Document file = Jsoup.connect(url).get();

            for (Element row : file.select("#mw-content-text > div > table:nth-child(148) > tbody > tr")) {
                String characteristic = row.select("th").text();
                String information = row.select("td").text();
                info.add(new Info(characteristic,information ));
            }return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
