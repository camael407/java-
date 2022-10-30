package lotto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

class MyActionListener implements ActionListener {
	
	JButton[] buttons;
	JTextArea textArea;
	
	MyActionListener(JButton[] buttons, JTextArea textArea) {
		this.buttons = buttons;
		this.textArea = textArea;
	}
	
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> lottoNum = new ArrayList<>();
		
		int i = 0;
		while(i < 6) {
			Integer temp = (int)(Math.random() * 45 + 1);
			String element;
			if(temp < 10) {
				element = "0" + String.valueOf(temp);
			}
			else {
				element = String.valueOf(temp);
			}
			if(!lottoNum.contains(element)) {
				lottoNum.add(element);
				i++;
			}
		}
		
		String message = "                                   ";
		
		for(int j = 0; j < buttons.length; j++) {
			buttons[j].setText(lottoNum.get(j));
			message += lottoNum.get(j) + "       ";
		}
//		.
		textArea.append(message + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
}