package cat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CatMain extends JFrame {
	
	CatDAO dao = new CatDAO();
	CatVO vo = null;
	
	public CatMain() {
		super("유기묘센터에 오신 것을 환영합니다!!!!");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(192, 192, 192));
		pn1.setBounds(0, 0, 784, 110);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblCenter = new JLabel("♥ 유기묘 센터 ♥");
		lblCenter.setForeground(new Color(255, 255, 0));
		lblCenter.setFont(new Font("한컴산뜻돋움", Font.BOLD, 40));
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenter.setBounds(12, 0, 760, 110);
		pn1.add(lblCenter);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 10, 784, 556);
		pn1.add(label);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 109, 520, 452);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/10000.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 519, 452);
		pn2.add(lblNewLabel_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(521, 109, 263, 452);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("유기묘 등록/신고");
		btnInput.setBackground(new Color(255, 255, 255));
		btnInput.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnInput.setBounds(27, 26, 209, 47);
		pn3.add(btnInput);
		
		JButton btnList = new JButton("유기묘 전체목록");
		btnList.setBackground(new Color(255, 255, 255));
		btnList.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnList.setBounds(27, 97, 209, 47);
		pn3.add(btnList);
		
		JButton btnSearch = new JButton("유기묘 검색");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnSearch.setBounds(27, 169, 209, 47);
		pn3.add(btnSearch);
		
		JButton btnClose = new JButton("창 닫 기");
		btnClose.setBackground(new Color(255, 255, 255));
		btnClose.setForeground(new Color(0, 0, 0));
		btnClose.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnClose.setBounds(27, 368, 209, 47);
		pn3.add(btnClose);
		
		setVisible(true);
		
		// -----------위로 UI(디자인) / 아래는 메소드 영역--------------------
		
		// 검색하기 버튼 클릭 시 수행
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "검색할 고양이 이름을 입력하세요.", "고양이 검색", JOptionPane.QUESTION_MESSAGE);
				vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색된 이름이 없습니다.");
				else {	
					dispose();
					new CatSearch(vo);
				}
			}
		});
		
		// 전체조회 버튼 클릭 시 수행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CatList();
			}
		});
		
		// 유기묘 등록/신고 버튼 클릭 시 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CatInput();
			}
		});
		
		// 창닫기
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new CatMain();
	}
}
