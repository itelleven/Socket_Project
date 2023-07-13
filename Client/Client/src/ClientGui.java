

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public Person p;
	
	public ClientGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(12, 10, 410, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입 창입니다.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(142, 22, 232, 38);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 85, 123, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("   이름 입력");
		lblNewLabel_1.setBounds(34, 88, 67, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("나이 입력");
		lblNewLabel_2.setBounds(44, 140, 57, 15);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.setBounds(277, 84, 97, 74);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 137, 123, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		setVisible(true);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getName = textField.getText();
				String getAge = textField_1.getText();
				System.out.println(getName);
				System.out.println(getAge);
				textField.setText("");
				textField_1.setText("");
				
				//DB에 insert는 서버가 해요
				p = new Person(getName, Integer.parseInt(getAge));
				new Event(p);
				
			}
		});
	}
	
	
	
	
}
