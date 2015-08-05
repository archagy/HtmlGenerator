import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.SwingUtilities;


public class Elements {
	
	private File Folder;
	private String ano;
	
	public File getFolder(){
		return Folder;
	}
	
	public void setFolder(File Folder){
		this.Folder = Folder;
	}

	public void setAno(String ano) {
		this.ano = ano;
		
	}
	
	public String getAno(){
		return ano;
	}
	
	public int getAllDays(String Year){
		int year = Integer.parseInt(Year);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.YEAR,year);

		int numOfDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(numOfDays);
		return numOfDays;
	}
	
	public int getDayMonth(int month, String Year){
		int year = Integer.parseInt(Year);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		int dayMonth =  cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println(dayMonth);
		return dayMonth;
	}
	
	public String getStringMonth(int month){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH,month);
		String nameMonth = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es","ES")); 
		// System.out.println(nameMonth);
		return nameMonth;
	}
	
	
	
	
	
	
	
}
