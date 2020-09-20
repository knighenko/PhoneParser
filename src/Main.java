import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage page = client.getPage("https://olx.ua/obyavlenie/otdam-gruzove-shiny-darom-IDJ3JM7.html#2f1a1a1fef");

            List<HtmlElement> items = page.getByXPath("//ul[@id='contact_methods_below']");
            if (items.isEmpty()) {
                System.out.println("No items found!");
            } else {

                items.get(0).dblClick();
            }
            HtmlPage page2 = client.getPage("https://olx.ua/obyavlenie/otdam-gruzove-shiny-darom-IDJ3JM7.html#2f1a1a1fef");
            System.out.println(page2.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
