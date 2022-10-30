package lotto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class lotto_random extends JFrame {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 7460776130748644032L;

	lotto_random() {
		
		setTitle("로또번호 랜덤 추출기 v.0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setVisible(true);
		setLayout(new BorderLayout(0, 5));
		makeElements();
	 }
	
    public void makeElements() {
    	
    	JPanel northPanel = new JPanel();
    	JPanel southPanel = new JPanel();
    	
    	JTextArea text = new JTextArea();
    	JScrollPane textPane= new JScrollPane(text);
    	
    	JButton[] numbutBtn = new JButton[6];
    	JPanel numPane = new JPanel();
    	numPane.setLayout(new GridLayout(1, 6, 10, 0));
    	
    	for(int i = 0; i < numbutBtn.length; i++) {
    		numbutBtn[i] = new JButton(" ");
			numPane.add(numbutBtn[i]);
		}
//    	3
    	
		JButton btn = new JButton("로또 번호 생성하기");
		btn.addActionListener(new Lottoset(numbutBtn, text));
		
		northPanel.add(numPane);
		southPanel.add(btn);
		
		add(text, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
    	
	}
    
    class Lottoset implements ActionListener {
    	JButton[] buttons;
    	JTextArea textArea;
    	
    	Lottoset(JButton[] buttons, JTextArea textArea) {
    		this.buttons = buttons;
    		this.textArea = textArea;
    	}

		public void actionPerformed(ActionEvent e) {
			HashSet<Integer> set = new HashSet<Integer>();		
    		while (set.size() < 6) {			
    			set.add((int) ( Math.random() * 45) + 1);
    		}
    		
    	ArrayList<Integer> lottoNum = new ArrayList<Integer>(set);
		
        	
    	String message = " ";
    			
		
		for(int i = 0; i <6 ; i++) {
			buttons[i].setText(lottoNum.get(i).toString()); 
			message += lottoNum.get(i) + "             " ;
			
		}
			
		
		
		textArea.append(message + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
    
 }
    
    public static void main(String[] args) {
 		JFrame.setDefaultLookAndFeelDecorated(true);
 		new lotto_random();
 	}
}

    
//버튼 이미지 바꿔보기
// textArea 가운데 정렬
//스크롤 왜?
// 한자릿수 두자리출력

    

    
    


