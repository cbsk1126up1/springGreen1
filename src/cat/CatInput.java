package cat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings({"serial","rawtypes","static-access","unused"})
public class CatInput extends JFrame{
	private final JPanel pn1 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName, txtSingoja, tel2, tel3;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JComboBox comboYear, comboMonth, comboDay, comboClock;
	
	CatVO vo = null;
	String filePath = "";
	CatDAO dao = new CatDAO();
	
	@SuppressWarnings({ "unchecked" })
	public CatInput() {
		super("유기묘센터 등록/신고");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		setResizable(false);
		getContentPane().setLayout(null);
		pn1.setBackground(new Color(128, 128, 128));
		pn1.setBounds(0, 0, 984, 81);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고양이 등록/신고");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY엽서M", Font.BOLD, 37));
		lblNewLabel.setBounds(12, 0, 960, 81);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 81, 633, 457);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lbl = new JLabel("분   류");
		lbl.setForeground(new Color(128, 128, 64));
		lbl.setFont(new Font("HY엽서M", Font.BOLD, 20));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(50, 12, 68, 38);
		pn2.add(lbl);
		
		JLabel lbl_1 = new JLabel("종   류");
		lbl_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1.setBounds(50, 58, 68, 38);
		pn2.add(lbl_1);
		
		JLabel lbl_2 = new JLabel("이   름");
		lbl_2.setForeground(new Color(128, 128, 64));
		lbl_2.setFont(new Font("HY엽서M", Font.BOLD, 20));
		lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2.setBounds(50, 104, 68, 38);
		pn2.add(lbl_2);
		
		JLabel lbl_3 = new JLabel("성   별");
		lbl_3.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_3.setBounds(50, 152, 68, 38);
		pn2.add(lbl_3);
		
		JLabel lbl_4 = new JLabel("특   징");
		lbl_4.setForeground(new Color(128, 128, 64));
		lbl_4.setFont(new Font("HY엽서M", Font.BOLD, 20));
		lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_4.setBounds(50, 200, 68, 38);
		pn2.add(lbl_4);
		
		JRadioButton rdMissing = new JRadioButton("실종신고");
		rdMissing.setSelected(true);
		buttonGroup.add(rdMissing);
		rdMissing.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		rdMissing.setBounds(195, 20, 121, 23);
		pn2.add(rdMissing);
		
		JRadioButton rdYougi = new JRadioButton("유기신고");
		buttonGroup.add(rdYougi);
		rdYougi.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		rdYougi.setBounds(325, 20, 121, 23);
		pn2.add(rdYougi);
		
		JComboBox comboKind = new JComboBox();
		comboKind.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		comboKind.setModel(new DefaultComboBoxModel(new String[] {"페르시안", "터키시앙고라", "코리안숏헤어", "아메리칸 숏헤어", "아비시니안", "스코티시폴드", "스핑크스", "샴", "뱅갈", "먼치킨", "러시안블루", "노르웨이숲고양이"}));
		comboKind.setBounds(195, 58, 262, 28);
		pn2.add(comboKind);
		
		txtName = new JTextField();
		txtName.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		txtName.setBounds(195, 104, 132, 28);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		JRadioButton rdFmale = new JRadioButton("암컷");
		buttonGroup_1.add(rdFmale);
		rdFmale.setSelected(true);
		rdFmale.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		rdFmale.setBounds(195, 152, 121, 23);
		pn2.add(rdFmale);
		
		JRadioButton rdMale = new JRadioButton("수컷");
		buttonGroup_1.add(rdMale);
		rdMale.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		rdMale.setBounds(325, 152, 121, 23);
		pn2.add(rdMale);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 200, 351, 100);
		pn2.add(scrollPane);
		
		JTextArea txtFeatures = new JTextArea();
		txtFeatures.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		scrollPane.setViewportView(txtFeatures);
		
		JLabel lbl_3_1 = new JLabel("발견/신고일자");
		lbl_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_3_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lbl_3_1.setBounds(23, 345, 147, 38);
		pn2.add(lbl_3_1);
		
		
		String[] yy = new String[27];
		String[] mm = new String[12];
		String[] dd = new String[31];
		String[] cc = new String[24];
		
		int su = 0;
		int su1 = 0;
		for(int i=0; i<yy.length; i++) {
			su = 2026 - i;
			yy[i] = su + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		for(int i=0; i<cc.length; i++) {
			su1 = 0 + i;
			cc[i] = su1 + "";
		}
		
		comboYear = new JComboBox(yy);
		comboYear.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		comboYear.setBounds(196, 352, 82, 28);
		pn2.add(comboYear);
		
		comboMonth = new JComboBox(mm);
		comboMonth.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		comboMonth.setBounds(317, 352, 55, 28);
		pn2.add(comboMonth);
		
		JComboBox comboDay = new JComboBox(dd);
		comboDay.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		comboDay.setBounds(413, 352, 55, 28);
		pn2.add(comboDay);
		
		JComboBox comboClock = new JComboBox(cc);
		comboClock.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		comboClock.setBounds(507, 352, 55, 28);
		pn2.add(comboClock);
		
		JLabel lblNewLabel_1 = new JLabel("년");
		lblNewLabel_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(276, 347, 41, 38);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("월");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(372, 347, 41, 38);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("일");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(468, 347, 41, 38);
		pn2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("시 경");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(566, 347, 55, 38);
		pn2.add(lblNewLabel_1_1_2);
		
		JLabel lbl_4_1 = new JLabel("신고자");
		lbl_4_1.setBounds(50, 409, 68, 38);
		pn2.add(lbl_4_1);
		lbl_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_4_1.setForeground(new Color(128, 128, 64));
		lbl_4_1.setFont(new Font("HY엽서M", Font.BOLD, 20));
		
		txtSingoja = new JTextField();
		txtSingoja.setBounds(195, 414, 132, 28);
		pn2.add(txtSingoja);
		txtSingoja.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		txtSingoja.setColumns(10);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 539, 633, 122);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lbl_3_2 = new JLabel("신고자 연락처");
		lbl_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_3_2.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lbl_3_2.setBounds(26, 20, 137, 38);
		pn3.add(lbl_3_2);
		
		JComboBox tel1 = new JComboBox();
		tel1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		tel1.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "012", "043", "02"}));
		tel1.setBounds(197, 20, 78, 23);
		pn3.add(tel1);
		
		tel2 = new JTextField();
		tel2.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		tel2.setBounds(301, 20, 68, 23);
		pn3.add(tel2);
		tel2.setColumns(10);
		
		tel3 = new JTextField();
		tel3.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		tel3.setColumns(10);
		tel3.setBounds(397, 20, 68, 23);
		pn3.add(tel3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 66, 632, 56);
		pn3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(264, 15, 48, 32);
		pn3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("-");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(361, 15, 48, 32);
		pn3.add(lblNewLabel_3_1);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(630, 81, 354, 364);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JButton btnPhoto = new JButton("사 진 등 록 ! ! !");
		btnPhoto.setBackground(new Color(255, 255, 255));
		btnPhoto.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnPhoto.setBounds(103, 10, 171, 29);
		pn4.add(btnPhoto);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBackground(Color.YELLOW);
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setBounds(12, 49, 330, 305);
		pn4.add(lblPhoto);
		
		lblPhoto.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1));
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 49, 330, 305);
		pn4.add(panel);
		
		JPanel pn5 = new JPanel();
		pn5.setBounds(630, 445, 354, 216);
		getContentPane().add(pn5);
		pn5.setLayout(null);
		
		JButton btnInput = new JButton("등   록");
		btnInput.setBackground(new Color(255, 255, 255));
		btnInput.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnInput.setBounds(124, 10, 115, 55);
		pn5.add(btnInput);
		
		JButton btnInput_1 = new JButton("다시입력");
		btnInput_1.setBackground(new Color(255, 255, 255));
		btnInput_1.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnInput_1.setBounds(124, 77, 115, 55);
		pn5.add(btnInput_1);
		
		JButton btnInput_1_1 = new JButton("창닫기");
		btnInput_1_1.setBackground(new Color(255, 255, 255));
		btnInput_1_1.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btnInput_1_1.setBounds(124, 144, 115, 55);
		pn5.add(btnInput_1_1);
		
		setVisible(true);
		
		// -------------------------------------------------------------------
		
		// 등록 버튼 클릭 시
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tel = "";
				String t1 = tel1.getSelectedItem().toString();
				String t2 = tel2.getText().trim();
				String t3 = tel3.getText().trim();
				String name = txtName.getText().trim();
				String singoja = txtSingoja.getText().trim();
				String features = txtFeatures.getText().trim();
				String missing = "1";
				String gender = "수컷";
				String kind = comboKind.getSelectedItem().toString();
				String fdate = "";
				String year = comboYear.getSelectedItem().toString();
				String month = comboMonth.getSelectedItem().toString();
				String day = comboDay.getSelectedItem().toString();
				String clock = comboClock.getSelectedItem().toString();
				
				if(rdMissing.isSelected()) missing = "0";
				if(rdFmale.isSelected()) gender = "암컷";
				
				//if(name.equals("")) {
				if(!Pattern.matches("^[a-zA-Z가-힣]+$", name)) {
					JOptionPane.showMessageDialog(null, "고양이 이름을 한글 또는 영문으로 입력해주세요.");
					txtName.requestFocus();
				}
				else if(features.equals("")) {
					JOptionPane.showMessageDialog(null, "특징을 입력하세요.");
					txtFeatures.requestFocus();
				}
				else if(!Pattern.matches("^[a-zA-Z가-힣]+$", singoja)) {
					JOptionPane.showMessageDialog(null, "신고자명을 바르게 입력하세요.");
					txtSingoja.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]{4}$", t2) || !Pattern.matches("^[0-9]{4}$", t3)) {
					JOptionPane.showMessageDialog(null, "전화번호 형식에 맞게 입력하세요.");
					tel2.requestFocus();
				}
				else {
					tel = t1 + "-" + t2 + "-" + t3;
					fdate = year + "-" + month + "-" + day + "-" + clock;
					String photo = "noimage.jpg";
					if(!filePath.equals("")) {
						if(filePath.indexOf("/") != -1) photo = filePath.substring(filePath.lastIndexOf("/")+1);
						if(filePath.indexOf("\\") != -1) photo = filePath.substring(filePath.lastIndexOf("\\")+1);
					}
					vo = new CatVO();
					vo.setKind(kind);
					vo.setName(name);
					vo.setGender(gender);
					vo.setfDate(fdate);
					vo.setFeatures(features);
					vo.setPhoto(photo);
					vo.setMissing(missing);
					vo.setSingoja(singoja);
					vo.setSingotel(tel);
					
					int res = dao.setCatInput(vo);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
						dao.connClose();
						dispose();
						new CatMain();
					}
					else {
						JOptionPane.showMessageDialog(null, "등록이 실패되었습니다.");
					}
				}
			}
		});
		
		//다시입력 버튼 클릭 시
		btnInput_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tel2.setText("");
				tel3.setText("");
				txtName.setText("");
				txtSingoja.setText("");
				txtFeatures.setText("");
				rdMissing.setSelected(true);
				rdFmale.setSelected(true);
				tel1.setSelectedIndex(0);
				comboKind.setSelectedIndex(0);
				comboYear.setSelectedIndex(0);
				comboMonth.setSelectedIndex(0);
				comboDay.setSelectedIndex(0);
				comboClock.setSelectedIndex(0);
				lblPhoto.setIcon(null);
			}
		});
		
		// 사진등록 버튼 클릭 시
		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg","gif","png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택해 주세요","경고",JOptionPane.WARNING_MESSAGE);
				}
				else {
					//String filePath = chooser.getSelectedFile().getPath();
					filePath = chooser.getSelectedFile().getPath();
					lblPhoto.setIcon(new ImageIcon(filePath));
				}
			}
		});
		
		// 창 닫 기
		btnInput_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CatMain();
			}
		});
		
	}
	

	public static void main(String[] args) {
		new CatInput();
	}
}
