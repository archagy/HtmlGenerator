
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;


public class GetHtml {


	private ArrayList<String> litDiaList = new ArrayList<String>() ;
	private Document doc;

		
	public Document setInfo(String ano,String dia, String mes){
		try {
			String url = "http://liturgiadiaria.cnbb.org.br/app/user/user/UserView.php?ano="+ano+"&mes="+mes+"&dia="+dia;
			 doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
			
			//getTitle(doc);
			//getLiteraturasDia(doc);
			//getResumen(doc);
			//getColor(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

	public String getResumen(Document doc){
		if(doc != null){
			Elements docResumen = doc.select(".blog-post");
			//Whitelist wl = Whitelist.simpleText();
			//wl.addTags("div", "span", "class", "div id=*"); // add additional tags here as necessary
			String clean = Jsoup.clean(docResumen.html(), Whitelist.relaxed());
			return clean;
		}else{
			return "Hubo un error en obtener la informacion";
		}

	}
	
	
	public String getTitle(Document doc){
		if(doc != null){
			
			Elements docTitle = doc.select(".container h2");
			//System.out.println(docTitle.text());
			return docTitle.text().trim();
		}else{
			return "Error en obtener informacion";
		}
	}

	
	public String getColor(Document doc){
		if(doc != null){
			Elements docTitle = doc.select(".container em");
			return docTitle.text();
		}else{
			System.out.println("Error en la descarga");
			return "Error en obtener la informacion";
		}
	}






	public void getLiteraturasDia(Document doc){
		if(doc != null){
			Elements newsHeadlines = doc.select(".list-group-item strong");
			for(Element element : newsHeadlines){
				//	System.out.println(element.text());
				litDiaList.add(element.text());
				System.out.println(litDiaList);
			}



		}else{
			System.out.println("Hubo un error con la descarga.");
		}
	}


	

}
