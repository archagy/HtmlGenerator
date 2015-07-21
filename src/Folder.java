import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;




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
	
	public boolean CreateHTMLFile(String dia,String mes, String ano) throws IOException{
		File folderHtml = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml/"+ano+"/"+dia+"_"+mes+"_"+ano+".html");
		if(!folderHtml.exists()){
		    folderHtml.createNewFile();
		    FileWriter fw = new FileWriter(folderHtml.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//Insertal codigo HTML
			bw.write("Se genera HTML");
			bw.close();
		    return true;
		 }else{
			 return false;
		 }
	
	}
	
	public boolean CreateCSSFile(String ano) throws IOException{
		File folderHtml = new File(folderPath.getAbsoluteFile().toString()+"/GenerateHtml/"+ano+"/default.css");
		if(!folderHtml.exists()){
		    folderHtml.createNewFile();
		    FileWriter fw = new FileWriter(folderHtml.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//Insertal codigo css
			bw.write("se genera css");
			bw.close();
		    return true;
		 }else{
			 return false;
		 }
	
	}

}