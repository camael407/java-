package lotto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class lotto_random extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 7460776130748644032L;

	lotto_random() throws IOException {

		setTitle("로또번호 랜덤 추출기 v.0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		setLayout(new BorderLayout(0, 5));
//		System.out.println("1test");
		makeElements();
	
	}

	public void makeElements() throws IOException {

		BufferedImage btimg = ImageIO.read(new File("C:/Users/admin/git/java-/lotto/icon.png"));
		Image afimg = btimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		

		JTextPane text = new JTextPane();
		JScrollPane textPanel = new JScrollPane(text);
		JLabel[] numbutBtn = new JLabel[6];
		JPanel numPane = new JPanel();
		numPane.setLayout(new GridLayout(1, 6, 10, 0));

		
		
		for (int i = 0; i < numbutBtn.length; i++) {
			numbutBtn[i] = new JLabel(new ImageIcon(afimg));
			numPane.add(numbutBtn[i]);
			numbutBtn[i].setFocusable(false);
			numbutBtn[i].setOpaque(false);
			numbutBtn[i].setHorizontalTextPosition(JLabel.CENTER);
		}
		JButton btn = new JButton("로또 번호 생성하기");
		btn.setFocusable(false);
		btn.setOpaque(false);
		btn.addActionListener(new Lottoset(numbutBtn, text));
		northPanel.add(numPane);
		southPanel.add(btn);
		
		JButton clnbtn= new JButton("CLEAN");
		clnbtn.setFocusable(false);
		clnbtn.setOpaque(false);
		clnbtn.addActionListener(new reset(numbutBtn, text));
		southPanel.add(clnbtn);

		add(textPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		

	}
	
	class reset implements ActionListener { 
		JLabel[] clnbtn;
		JTextPane clnfld;
		public reset(JLabel[] clnbtn, JTextPane clnfld) {
			this.clnbtn = clnbtn;
			this.clnfld = clnfld;
		}

		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i< 6; i++) {
				clnbtn[i].setText("");
			}
			
			clnfld.setText("");
			clnfld.setCaretPosition(clnfld.getDocument().getLength());
		}
	}

	class Lottoset implements ActionListener {
		JLabel[] buttons;
		JTextPane textArea;

		public Lottoset(JLabel[] buttons, JTextPane textArea) {
			this.buttons = buttons;
			this.textArea = textArea;
		}



		public void actionPerformed(ActionEvent e) {
			HashSet<String> set = new HashSet<String>();
			ArrayList<String> lottoNum = new ArrayList<String>(set);

			int i = 0;
			while (i < 6) {
				Integer choose = (int) (Math.random() * 45 + 1);
				String element;
				if (choose < 10) {
					element = "0" + String.valueOf(choose);
				} else {
					element = String.valueOf(choose);
				}
				lottoNum.add(element);
				i++;

			}

			String message = "                                   ";

			for (int j = 0; j < buttons.length; j++) {
				buttons[j].setText(lottoNum.get(j));
				message += lottoNum.get(j) + "       ";
			}
			//textpane에서 append역할하는 매서드는?
			//없으면 textarea에서 중앙정렬 or 자동정렬 하는 매서드는?
			textArea.in(message + "\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}

	}

	public static void main(String[] args) throws IOException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new lotto_random();

	}



}
