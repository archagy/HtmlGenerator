import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					//GetHtml getHTML = new GetHtml();
					//Elements elem = new Elements();
					//elem.getStringMonth(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
