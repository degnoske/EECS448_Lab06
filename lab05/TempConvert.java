package lab05;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TempConvert 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	private JComboBox combobox;
	public TempConvert()
	{
		String[] converts = { "F to C", "F to K", "C to K", "C to F", "K to C", "K to F", "" };

		panel = new JPanel();
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from:");
		combobox = new JComboBox(converts);
		combobox.setSelectedIndex(6);

		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	
		panel.add(combobox);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				double parseinput=0;
				Boolean isNumber=true;
				String newText;
				try{
					 parseinput=Double.parseDouble(input);
				}
				 catch(NumberFormatException nfe)  
				  {  
				     newText="Not A Number or No Text"; 
				     label.setText(newText);
						System.out.println(newText);
						isNumber=false;
				  } 
				
				double output=0;
				String character="0";
				if(combobox.getSelectedIndex()==6){
					isNumber=false;
					label.setText("Choose an Option");
					
				}
				if(combobox.getSelectedIndex()==0){
					output = (parseinput-32)*(5.0/9.0);
					character="C";
				}
				if(combobox.getSelectedIndex()==1){
					output = (parseinput+459.67)*(5.0/9.0);
					character="K";
				}
				
				if(combobox.getSelectedIndex()==2){
					output = (parseinput+273.15);
					character="K";
				}
				if(combobox.getSelectedIndex()==3){
					output = (parseinput*(9/5) + 32);
					character="F";
				}
				if(combobox.getSelectedIndex()==4){
					output = (parseinput- 273.15);
					character="C";
				}
				if(combobox.getSelectedIndex()==5){
					output = (parseinput* (9/5) - 459.67);
					character="F";
				}
				if (isNumber==true){
				 newText = "Temp in "+ character+": " + String.format("%.2f",output);//convert double to String and
				 	                           //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
				}
			}
		};
		
		return listener;
	}
	
}