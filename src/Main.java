import java.awt.EventQueue;

import org.jsoup.nodes.Document;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					//GetHtml getHTML = new GetHtml();
					//Elements elem = new Elements();
					//elem.getStringMonth(0);
				//Document doc = getHTML.setInfo("2009"," 1" ,"1");
					//System.out.println(getHTML.getResumen(doc));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
