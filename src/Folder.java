import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;





public class Folder {
	private File folderPath;

	public void setFolder(File newFolder){
		this.folderPath = new File(newFolder.getAbsolutePath());
		CreateFolder();
	}


	public Boolean CreateFolderAno(String folder){
		File folderAno = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml/"+folder);
		if(folderAno.exists()){
			return false;
		}else{
			folderAno.mkdir();
			return true;

		}
	}
	public void CreateFolder(){
		File folderHtml = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml");

		if(folderHtml.exists()){

		}else{
			folderHtml.mkdir();
		}
	}

	public Boolean FolderExists(){
		File folderHtml = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml");
		if(folderHtml.exists()){
			return true;
		}else{
			return false;
		}
	}

	public boolean CreateHTMLFile(String dia,String mes, String ano, String title, String color, String resumen) throws IOException{
		File folderHtml = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml/"+ano+"/"+ano+mes+dia+".html");
		if(!folderHtml.exists()){
			folderHtml.createNewFile();
			FileWriter fw = new FileWriter(folderHtml.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//Insertal codigo HTML
			bw.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://w3.org/TR/REC-html40/loose.dtd\">");
			bw.newLine();
			//HEAD
			bw.write("<HTML> <head> <title>"+" Liturgia :: A Palavra de Deus na Vida :: CNBB "+ " </title> <meta charset=\"utf-8\"> <link rel=\"stylesheet\" type=\"text/css\" href=\"liturgia.css\"> </head>");
			bw.newLine();
			//Body
			bw.write("	<body> <div class=\"blog-header\"> <h1> Liturgia Diária </h1> <p class=\"text-right\"> </p> </div> <div class=\"clear\"></div> <div class=\"bs-callout bs-callout-info\">  <h2> "+title+"</h2> <p class=\"pull-right\">"+ color+" </p> </div>");
			bw.newLine();
			//Body Resumen
			bw.write("<div class=\"clear\"></div> <div class=\"cuadro\">");
			bw.newLine();
			bw.write(resumen);
			bw.newLine();
			bw.write("</div> </div>");
			//cierre
			bw.write("</body> </HTML>");
			bw.close();
			return true;
		}else{
			return false;
		}

	}

	public boolean CreateCSSFile(String ano) throws IOException{
		File folderHtml = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml/"+ano+"/liturgia.css");
		if(!folderHtml.exists()){
			folderHtml.createNewFile();
			FileWriter fw = new FileWriter(folderHtml.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//Insertal codigo css
			bw.write(" body { font-family: Georgia, \"Times New Roman\", Times, serif; color: #555; } h1 { font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; color: #333; float: left; width: 50%; } p { margin: 0px; padding: 0px; } .clear { clear: both; } .blog-header { padding-top: 10px; padding-bottom: 20px; border-bottom: 1px solid #cecece; margin-bottom: 10px; } .text-right { text-align: right; } .bs-callout-info { border-left-color: #5bc0de; } .bs-callout { padding: 20px; margin: 20px 0; border: 1px solid #eee; border-left-width: 5px; border-radius: 3px; } .bs-callout h2 { color: #06799C; font-weight: bold; letter-spacing: -0.1em; } .pull-right { float: right; } .cuadro { width: 50%; padding: 10px 30px 10px 30px; }");
			bw.close();
			return true;
		}else{
			return false;
		}

	}







}