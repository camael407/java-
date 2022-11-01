package lotto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class lotto_random extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 7460776130748644032L;

	lotto_random() throws IOException {

		setTitle("로또번호 랜덤 추출기 v.0.0.1");
		//x표 눌러서 작동 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLayout(new BorderLayout(0, 0));
//		System.out.println("1test");
		makeElements();
		setVisible(true);
	
	}
	
	

	public void makeElements() throws IOException {

		BufferedImage btimg = ImageIO.read(new File("./img.png"));
		Image afimg = btimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		JTextArea text = new JTextArea();
		JScrollPane textPanel = new JScrollPane(text);
		JLabel[] numbutBtn = new JLabel[6];
		JPanel numPane = new JPanel();
		numPane.setLayout(new GridLayout(1, 6, 10, 0));
		
		JMenuBar menuBar = new JMenuBar();	
		JMenuItem [] menuItem = new JMenuItem [2];
		String[] itemTitle = {
				"Save","Exit"};
		JMenu fileMenu = new JMenu("File");
		MenuActionListener listener = new MenuActionListener(); 
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(listener); 
			fileMenu.add(menuItem[i]);
		}
		
		menuBar.add(fileMenu); 
		setJMenuBar(menuBar);
		
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
		
		JButton clnbtn= new JButton("CLEAR");
		clnbtn.setFocusable(false);
		clnbtn.setOpaque(false);
		clnbtn.addActionListener(new reset(numbutBtn, text));
		southPanel.add(clnbtn);

		add(textPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		
	}
	
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "Exit" : 
				 // JOptionPane.showConfirmDialog( null, "출력메세지", "타이틀", "버튼종료");
			     int result = JOptionPane.showConfirmDialog(null, "끝내시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
			     if(result==JOptionPane.CANCEL_OPTION) {
			      // [X] 버튼 누른 경우
			      break;
			     }
			     else if(result==JOptionPane.YES_OPTION) {
			      System.exit(0); // 예 버튼 누른 경우
			      break;
			     }
			     else {
			      break; // 아니오 버튼 누른 경우
			     }
			}
	}
	}
		
	
	class reset implements ActionListener { 
		JLabel[] clnbtn;
		JTextArea clnfld;
		public reset(JLabel[] clnbtn, JTextArea clnfld) {
			this.clnbtn = clnbtn;
			this.clnfld = clnfld;
		}

		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i< 6; i++) {
				clnbtn[i].setText("");
			}
			
			clnfld.setText("");

		}
	}

	class Lottoset implements ActionListener {
		JLabel[] buttons;
		JTextArea textArea;

		public Lottoset(JLabel[] buttons, JTextArea textArea) {
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
				
				
				if(!lottoNum.contains(element)) {
				lottoNum.add(element);
				i++;
				}
				Collections.sort(lottoNum); 
		    } 

			String message = "";

			for (int j = 0; j < buttons.length; j++) {
				buttons[j].setText(lottoNum.get(j));
				message += lottoNum.get(j) + "       ";
			}

			textArea.append(message + "\n");
			//맨 아래로 스크롤 따라가기
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
 
	}

	public static void main(String[] args) throws IOException {
		// 창위에 최소화 최대화 옵션표시
		JFrame.setDefaultLookAndFeelDecorated(true);
		new lotto_random();

	}



}
