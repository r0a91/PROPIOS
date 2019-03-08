import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainApp extends JFrame implements ActionListener {
	private JButton realizarAccionBtn;
	private JButton salirBtn;
	private JRadioButton consolaRBtn;
	private JRadioButton archivoRBtn;
	private ButtonGroup opciones;
	
	public void inicializarComponentes() {
		
		realizarAccionBtn = new JButton("Realizar acción seleccionada");
		salirBtn = new JButton("Salir");
		consolaRBtn = new JRadioButton("Mostrar por consola");
		archivoRBtn = new JRadioButton("Registrar en archivo");
		opciones = new ButtonGroup();
		
		opciones.add(consolaRBtn);
		opciones.add(archivoRBtn);
		
		consolaRBtn.setSelected(true);
		
		this.setSize(400, 300);
		this.setVisible(true);		
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.getContentPane().add(consolaRBtn);
		this.getContentPane().add(archivoRBtn);
		this.getContentPane().add(realizarAccionBtn);
		this.getContentPane().add(salirBtn);
		salirBtn.addActionListener(this);
		realizarAccionBtn.addActionListener(this);		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==salirBtn) {
			System.exit(0);
		}
		
		if (e.getSource()==realizarAccionBtn) {
			LoggerFactory factory = new LoggerFactory();
			if (archivoRBtn.isSelected()) {
				Logger logger = factory.getLogger(true);
				logger.log("A Message to Log");
			}
			
			if (consolaRBtn.isSelected()) {
				Logger logger = factory.getLogger(false);
				logger.log("A Message to Log");
			}
		}		
	}
	

}
