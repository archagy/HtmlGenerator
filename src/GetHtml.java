
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

	public void getResumen(Document doc){
		if(doc != null){
			Elements docResumen = doc.select(".blog-post");
			System.out.println(docResumen);
		}else{
			System.out.println("Error en la descarga");
		}

	}
	
	
	public String getTitle(Document doc){
		if(doc != null){
			Elements docTitle = doc.select(".container h2");
			//System.out.println(docTitle.text());
			return docTitle.text();
		}else{
			System.out.println("Error en la descarga");
			return null;
		}
	}

	
	public void getColor(Document doc){
		if(doc != null){
			Elements docTitle = doc.select(".container em");
			System.out.println(docTitle.text());
		}else{
			System.out.println("Error en la descarga");
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
