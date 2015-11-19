package kodutöö;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JLabel text1; 
	private JTextField start;
	private JTextField stop;
	private JTextField goal;

	public GUI() {

		super("Sõidupäevik");
		setLayout(new FlowLayout());
		text1 = new JLabel("See on sinu isiklik sõidupäevik ");
		add(text1);
		start = new JTextField("Sõidu alguspunkt");
		add(start);
		stop = new JTextField("Sõidu lõpp-punkt");
		add(stop);
		goal = new JTextField("Sõidu eesmärk");
		add(goal);
		
		evHandler handler = new evHandler();
		start.addActionListener(handler);
		stop.addActionListener(handler);
		goal.addActionListener(handler);
	}
	private class evHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			String string ="";
			if(event.getSource()==start) 
				string = String.format("input1 : %s", event.getActionCommand());
			else if(event.getSource()==stop)
				string = String.format("input2 : %s", event.getActionCommand());
			else if(event.getSource()==goal)
				string = String.format("input3 : %s", event.getActionCommand());
			
			JOptionPane.showMessageDialog(null, string);
		}
	}

}
