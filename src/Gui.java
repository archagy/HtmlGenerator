
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import org.jsoup.nodes.Document;



public class Gui {

	private JFrame frame;
	private JFileChooser chooser = new JFileChooser();
	private Elements elem = new Elements();
	private Folder folder = new Folder();
	private final Action action = new SwingAction();
	private JPanel inicioPanel = new JPanel();
	private JLabel et_p1=new JLabel("Seleccione Carpeta"); 
	private final Action action_1 = new SwingAction_1();
	private JComboBox comboBox = new JComboBox();
	private JProgressBar progressBar_1 = new JProgressBar();
	private JTextArea textArea = new JTextArea();
	private GetHtml gh = new GetHtml();
	private int month =0;
	private JScrollPane scroll;
	private JButton btnNewButton_1 = new JButton("New button");
	JButton btnNewButton = new JButton("Cambiar Carpeta");
	private boolean flag=true;
	private final Action action_2 = new SwingAction_2();
	private JButton btnNewButton_2 = new JButton("New button");
	private Thread t1;
	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
		folder.setFolder(elem.getFolder());
		if(!folder.FolderExists()){
			JOptionPane.showMessageDialog(frame, "Se ha creado la carpeta GenerateHtml");
		}else{
			JOptionPane.showMessageDialog(frame, "La carpeta GenerateHtml ya existe. Puede continuar");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Frame (Ventana)
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);
		frame.setResizable(false);
		//Alerta 
		JOptionPane.showMessageDialog(frame, "Seleccione una carpeta donde se guardaran los archivos");
		inicioPanel.setLayout(null);
		et_p1.setBounds(56, 10, 595, 16);
		

		//componentes de panel 1
		
		inicioPanel.add(et_p1);
		tabbedPane.addTab("Inicio", inicioPanel);
		
		// Seleccionar una carpeta
		chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
		//inicioPanel.add(chooser);
		int returnVal = chooser.showOpenDialog(inicioPanel);
		elem.setFolder(chooser.getSelectedFile());
		et_p1.setText("Carpeta: "+elem.getFolder());
		
		
		btnNewButton.setBounds(677, 5, 146, 29);
		btnNewButton.setAction(action);
		inicioPanel.add(btnNewButton);
		
		JLabel lblFecha = new JLabel("Año: ");
		lblFecha.setBounds(39, 109, 61, 16);
		inicioPanel.add(lblFecha);
		
		
		comboBox.setBounds(87, 105, 135, 27);
		comboBox.addItem("2009");
		comboBox.addItem("2010");
		comboBox.addItem("2011");
		comboBox.addItem("2012");
		comboBox.addItem("2013");
		comboBox.addItem("2014");
		comboBox.addItem("2015");
		inicioPanel.add(comboBox);
		
		
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(56, 253, 163, 29);
		inicioPanel.add(btnNewButton_1);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(267, 262, 299, 20);
		progressBar_1.setMinimum(0);
		progressBar_1.setMaximum(11);
		inicioPanel.add(progressBar_1);
		
	
		textArea.setBounds(56, 327, 510, 175);
		textArea.setEditable(false);
		textArea.setVisible(true);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret(); // ←
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);       // ←
		
	    scroll = new JScrollPane (textArea);
		
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	          scroll.setBounds(56, 327, 510, 175);
	          scroll.setViewportView(textArea);
	          inicioPanel.add(scroll);
	          
	          
	          btnNewButton_2.setAction(action_2);
	          btnNewButton_2.setBounds(648, 253, 117, 29);
	          btnNewButton_2.setEnabled(false);
	          inicioPanel.add(btnNewButton_2);

	}
	
	




	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cambiar carpeta");
			putValue(SHORT_DESCRIPTION, "Haz click para cambiar la ruta de la carpeta");
		}
		public void actionPerformed(ActionEvent e) {
			int returnVal = chooser.showOpenDialog(inicioPanel);
			elem.setFolder(chooser.getSelectedFile());
			et_p1.setText("Carpeta: "+elem.getFolder());
			folder.setFolder(elem.getFolder());
			if(!folder.FolderExists()){
				JOptionPane.showMessageDialog(frame, "Se ha creado la carpeta GenerateHtml");
			}else{
				JOptionPane.showMessageDialog(frame, "La carpeta GenerateHtml ya existe. Puede continuar");
			}
		}
	}
	
	public void DisableButtons  (boolean bol){
		comboBox.setEnabled(bol);
		btnNewButton.setEnabled(bol);
		btnNewButton_1.setEnabled(bol);
	}
	
	
	private class SwingAction_1 extends AbstractAction {
	
		public SwingAction_1() {
			putValue(NAME, "Empezar Descarga");
			putValue(SHORT_DESCRIPTION, "Iniciar Descarga");
		}
		public void actionPerformed(ActionEvent e) {
			DisableButtons(false);
			btnNewButton_2.setEnabled(true);
			elem.setAno(comboBox.getSelectedItem().toString());
			month=0;
			
			if(!folder.CreateFolderAno(elem.getAno())){
				JOptionPane.showMessageDialog(frame, "Ya existe la carpeta, puede continuar");
			}else{
				JOptionPane.showMessageDialog(frame, "Se ha creado la carpeta: "+elem.getAno());
			}
			// i = dias
			
				
			 t1 = new Thread(new Runnable() {
			          public void run() {
			        	  System.out.println(flag);
			        	 
			        		  
			        	  for(int i=1; month <= 11; i++){
			        			if(i==elem.getDayMonth(month, elem.getAno())){
			        				month++;
			        				i=1;
			        			}
			        			
			        			if(flag){
			        				
			        			}else{
			        				flag=true;
			        				DisableButtons(true);
			        				break;
			        				
			        				
			        				
			        			}
			        		
			        			System.out.println("Día: "+i+" Mes: "+elem.getStringMonth(month));	
			        			//textArea.append("Día: "+i+" Mes: "+elem.getStringMonth(month)+"\n");
			        			
			        			progressBar_1.setValue(month);
						            progressBar_1.repaint();
						            progressBar_1.update(progressBar_1.getGraphics());
						            System.out.println("*****Actualizando****");
						            
						            
						            	Document doc = gh.setInfo(elem.getAno(), Integer.toString(i) ,Integer.toString(month+1));	
						            
						            
						            
						            String titulo = gh.getTitle(doc);
						            String color = gh.getColor(doc);
						            String resumen = gh.getResumen(doc);
						            try {
										if(folder.CreateCSSFile(elem.getAno())){
											textArea.append("Generando el CSS \n");
										}else{
											textArea.append("El CSS ya existe. \n");
										}
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
						            
						            textArea.append("Obteniendo Información... \n");
						            if(!titulo.isEmpty()){
						            	textArea.append("dia: "+i+" Mes: "+elem.getStringMonth(month)+" Titulo: "+titulo+"\n");
						            	try {
											if(folder.CreateHTMLFile(Integer.toString(i), elem.getStringMonth(month), elem.getAno(), titulo,color, resumen )){
												textArea.append("Generando HTML \n");
											}else{
												textArea.append("El HTML ya existe. \n");
											}
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						            	textArea.update(textArea.getGraphics());
					        			scroll.update(scroll.getGraphics());
						            }else{
						            	textArea.append("No existe elementos para este día.\n");
						            	textArea.append("dia: "+i+" Mes: "+elem.getStringMonth(month)+"\n");
						            	textArea.update(textArea.getGraphics());
					        			scroll.update(scroll.getGraphics());
						            }
						            
			        	  }
			           
			          }
			          
			        }); t1.start(); 
			 
			 
			 progressBar_1.setValue(0);
			 progressBar_1.repaint();
			 progressBar_1.update(progressBar_1.getGraphics());
		}
		
		
		
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Detener");
			putValue(SHORT_DESCRIPTION, "Cancela la descarga");
		}
		public void actionPerformed(ActionEvent e) {
			flag=false;
			System.out.println(flag);
		}
	}
}




