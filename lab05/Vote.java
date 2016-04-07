package lab05;
import javax.swing.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;
import java.io.IOException;
public class Vote
{
	private JPanel panel;
	private JButton button;
	private JTextField first;
	private JTextField last;
	private JLabel label;
	private JLabel label2;
	private JComboBox combobox;
	public Vote()
	{
		String[] candidates = { "John Jackson", "Jack Johnson", "George Jankinson", "Jank Georgeson","" };

		
		panel = new JPanel();
		button = new JButton("Vote");
		first = new JTextField(3);//3 cols, not 20 chars
		last= new JTextField(3);
		label = new JLabel("Enter Your First Name");
		label2=new JLabel("Enter Your Last Name");
		combobox = new JComboBox(candidates);
		combobox.setSelectedIndex(4);

		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(label);
		panel.add(first);
		panel.add(label2);
		panel.add(last);
		panel.add(combobox);
		panel.add(button);
		
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
				String firstname = first.getText();
				String lastname = last.getText();
				
				String value = combobox.getSelectedItem().toString();
				String newText;
				if(combobox.getSelectedIndex()==5){
					label.setText("Choose an Option");
				}
				
				
				else{
	
				 newText = "Thanks For Voting";
				 try {
		    		 
				      File file = new File(firstname+"_"+lastname+".txt");
				      FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(value);
						bw.close();
				      if (file.createNewFile()){
				        System.out.println("File is created!");
				      }else{
				        System.out.println("File already exists.");
				      }
				      
			    	} catch (IOException e1) {
				      e1.printStackTrace();
				}
					 
					
						
						
				 
					
				
					
			    
				label.setText(newText);
				label2.setText("");
				System.out.println(newText);
				}
				
			}
		};
		
		return listener;
	}
	
}
