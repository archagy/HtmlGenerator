
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;

public class GetHtml {


	private ArrayList<String> litDiaList = new ArrayList<String>() ;
	private Document doc;

		
	public Document setInfo(String ano,String dia, String mes){
		try {
			doc = Jsoup.connect("http://liturgiadiaria.cnbb.org.br/app/user/user/UserView.php?ano="+ano+"&mes="+mes+"&dia="+dia).get();
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
			return "Hubo un error en obtener la información";
		}

	}
	
	
	public String getTitle(Document doc){
		if(doc != null){
			Elements docTitle = doc.select(".container h2");
			//System.out.println(docTitle.text());
			return docTitle.text();
		}else{
			return "Error en obtener información";
		}
	}

	
	public String getColor(Document doc){
		if(doc != null){
			Elements docTitle = doc.select(".container em");
			return docTitle.text();
		}else{
			System.out.println("Error en la descarga");
			return "Error en obtener la información";
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



