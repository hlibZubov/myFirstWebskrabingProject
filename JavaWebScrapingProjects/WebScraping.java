////////////////////////////////////////////////////////////
//                     WebSkraping                        //
////////////////////////////////////////////////////////////
//  If you want to repeat this project you must install   //
//    Jsoup libreris to your projekt and add in your IDE  //
//       URl to Jsoup https://jsoup.org/download          //
// All information was taken https://www.kitco.com/market //

package JavaWebScrapingProjects;

import java.io.IOException;
//Importting Jsoup librery 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScraping {
    private static final String url = "https://www.kitco.com/market/";// webSite what I was scraping
    private static int HowManyRowsYouWantToScrap = 1;

    public static int getHowManyRowsYouWantToScrap() {
        return HowManyRowsYouWantToScrap;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {

        }

        // Get connection with website
        final Document document = Jsoup.connect(url).get();
        ////////////////////////////////////////////////////////////
        // Create for each to scraping all rows in the table but //
        // in my situation, I want to scrape only one row //
        ///////////////////////////////////////////////////////////
        for (int i = 0; i < getHowManyRowsYouWantToScrap(); i++) { // scraping only one row
            if (document.select("div.table_container.spot_price tr").select("td.name").text().equals("")) {
            } else {
                String auBid = document.select("div.table_container.spot_price tr").select("td#AU-bid").text();
                String auAsk = document.select("div.table_container.spot_price tr").select("td#AU-ask").text();
                System.out.println("AU-bid" + "  | " + "AU-ask");
                System.out.println(auBid + " | " + auAsk);
            }
        }
    }
}
