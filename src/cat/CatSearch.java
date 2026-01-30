package cat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

@SuppressWarnings({ "rawtypes", "unchecked", "serial"})
public class CatSearch extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboYear, comboMonth, comboDay, comboClock, tel1, comboKind;
	private JTextField txtName, tel2, tel3, txtSingoja;
	private JTextArea txtFeatures;
	private JButton btnSearch, btnUpdate, btnDelete, btnExit, btnPhotoChange;
	private JRadioButton rdFemale, rdMale;
	private JLabel lblPhoto;
	String filePath = "";
	int res = 0;
	
	CatVO vo = null;
	CatDAO dao = new CatDAO();
	private JLabel lblIdx;
	private JRadioButton rdMissing;
	private JRadioButton rdYougi;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	public CatSearch(CatVO vo) {
		super("유기묘 검색/찾기");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(128, 128, 128));
		pn1.setBounds(0, 0, 784, 81);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고양이 검색");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY엽서M", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 0, 759, 81);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 81, 784, 409);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		txtName = new JTextField();
		txtName.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		txtName.setBounds(116, 29, 109, 29);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(12, 74, 330, 300);
		pn2.add(lblPhoto);
		lblPhoto.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1));
		
		JLabel lblNewLabel_2 = new JLabel("종   류");
		lblNewLabel_2.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(356, 67, 94, 37);
		pn2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("이   름");
		lblNewLabel_2_1.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(12, 27, 54, 37);
		pn2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("성   별");
		lblNewLabel_2_2.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(356, 109, 94, 37);
		pn2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("발견/신고날짜");
		lblNewLabel_2_3.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setBounds(348, 151, 124, 37);
		pn2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("구   분");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_5.setBounds(356, 25, 94, 37);
		pn2.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("신고자");
		lblNewLabel_2_6.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setBounds(362, 223, 94, 37);
		pn2.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("특   징");
		lblNewLabel_2_7.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7.setBounds(362, 326, 94, 37);
		pn2.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("신고자 연락처");
		lblNewLabel_2_6_1.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		lblNewLabel_2_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6_1.setBounds(354, 262, 124, 37);
		pn2.add(lblNewLabel_2_6_1);
		
		btnSearch = new JButton("검색하기");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("HY엽서M", Font.PLAIN, 15));
		btnSearch.setBounds(237, 33, 97, 23);
		pn2.add(btnSearch);
		
		rdFemale = new JRadioButton("암컷");
		rdFemale.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		rdFemale.setSelected(true);
		buttonGroup.add(rdFemale);
		rdFemale.setBounds(467, 117, 121, 23);
		pn2.add(rdFemale);
		
		rdMale = new JRadioButton("수컷");
		rdMale.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		buttonGroup.add(rdMale);
		rdMale.setBounds(605, 117, 121, 23);
		pn2.add(rdMale);
		
		String[] yy = new String[27];
		String[] mm = new String[12];
		String[] dd = new String[31];
		String[] cc = new String[24];
		
		int su = 0;
		int su1 = 0;
		for(int i=0; i<yy.length; i++) {
			su = 2000 + i;
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
		comboYear.setBounds(411, 187, 68, 23);
		pn2.add(comboYear);
		
		comboMonth = new JComboBox(mm);
		comboMonth.setBounds(509, 187, 45, 23);
		pn2.add(comboMonth);
		
		comboDay = new JComboBox(dd);
		comboDay.setBounds(580, 187, 45, 23);
		pn2.add(comboDay);
		
		comboClock = new JComboBox(cc);
		comboClock.setBounds(653, 187, 45, 23);
		pn2.add(comboClock);
		
		tel1 = new JComboBox();
		tel1.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		tel1.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "012", "043", "02"}));
		tel1.setBounds(486, 270, 68, 23);
		pn2.add(tel1);
		
		tel2 = new JTextField();
		tel2.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		tel2.setColumns(10);
		tel2.setBounds(566, 271, 74, 21);
		pn2.add(tel2);
		
		tel3 = new JTextField();
		tel3.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		tel3.setColumns(10);
		tel3.setBounds(652, 271, 74, 21);
		pn2.add(tel3);
		
		comboKind = new JComboBox();
		comboKind.setModel(new DefaultComboBoxModel(new String[] {"페르시안", "터키시앙고라", "코리안숏헤어", "아메리칸숏헤어", "아비시니안", "스코티시폴드", "스핑크스", "샴", "뱅갈", "먼치킨", "러시안블루", "노르웨이숲고양이"}));
		comboKind.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		comboKind.setBounds(497, 67, 166, 30);
		pn2.add(comboKind);
		
		txtSingoja = new JTextField();
		txtSingoja.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		txtSingoja.setColumns(10);
		txtSingoja.setBounds(497, 229, 116, 25);
		pn2.add(txtSingoja);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(486, 326, 286, 73);
		pn2.add(scrollPane);
		
		txtFeatures = new JTextArea();
		txtFeatures.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		scrollPane.setViewportView(txtFeatures);
		
		lblIdx = new JLabel("");
		lblIdx.setFont(new Font("HY엽서M", Font.PLAIN, 12));
		lblIdx.setBounds(74, 29, 35, 29);
		pn2.add(lblIdx);
		
		rdMissing = new JRadioButton("실종신고");
		buttonGroup_1.add(rdMissing);
		rdMissing.setSelected(true);
		rdMissing.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		rdMissing.setBounds(467, 29, 121, 23);
		pn2.add(rdMissing);
		
		rdYougi = new JRadioButton("유기신고");
		buttonGroup_1.add(rdYougi);
		rdYougi.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		rdYougi.setBounds(605, 29, 121, 23);
		pn2.add(rdYougi);
		
		btnPhotoChange = new JButton("사진변경");
		btnPhotoChange.setBackground(new Color(255, 255, 255));
		btnPhotoChange.setFont(new Font("HY엽서M", Font.PLAIN, 15));
		btnPhotoChange.setBounds(245, 376, 97, 23);
		pn2.add(btnPhotoChange);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 488, 784, 73);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnUpdate = new JButton("수  정");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		btnUpdate.setBounds(12, 16, 125, 40);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭  제");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		btnDelete.setBounds(330, 16, 125, 40);
		pn3.add(btnDelete);
		
		btnExit = new JButton("창 닫 기");
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		btnExit.setBounds(647, 16, 125, 40);
		pn3.add(btnExit);
		
		setVisible(true);
		
		// 검색된 자료를 vo에 담아왔기에 현재 조회창에 vo의 값을 출력처리한다.
		catSearch(vo);
		
		// -----------위로 UI(디자인) / 아래는 메소드 영역--------------------
		
		// 삭제하기
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCatDelete();
			}
		});
		
		// 이름으로 검색후 텍스트필드에서 엔터키를 입력하였을때 수행하는곳
		txtName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String name = txtName.getText();
					CatVO vo = dao.getNameSearch(name);
					if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 이름이 존재하지 않습니다."); 
					else catSearch(vo);
				}
			}
		});
		
		// 사진변경하기
		btnPhotoChange.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
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
		
		// 수정 버튼 클릭 시 수행
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tel = "";
				String t1 = tel1.getSelectedItem().toString();
				String t2 = tel2.getText().trim();
				String t3 = tel3.getText().trim();
				String name = txtName.getText().trim();
				String singoja = txtSingoja.getText().trim();
				String features = txtFeatures.getText().trim();
				String kind = comboKind.getSelectedItem().toString();
				String fdate = "";
				String year = comboYear.getSelectedItem().toString();
				String month = comboMonth.getSelectedItem().toString();
				String day = comboDay.getSelectedItem().toString();
				String clock = comboClock.getSelectedItem().toString();
				String photo = lblPhoto.getIcon().toString();
				
				if(photo.indexOf("/") != -1) photo = photo.substring(photo.lastIndexOf("/")+1);
				if(photo.indexOf("\\") != -1) photo = photo.substring(photo.lastIndexOf("\\")+1);
				
				String missing = "1";
				if(rdMissing.isSelected()) missing = "0";
				
				String gender = "수컷";
				if(rdFemale.isSelected()) gender = "암컷";
				
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
					//String photo = filePath.substring(filePath.lastIndexOf("\\")+1);
					
					CatVO vo = new CatVO();
					int idx = Integer.parseInt(lblIdx.getText().toString().replace("(", "").replace(")", ""));
					vo.setIdx(idx);
					vo.setKind(kind);
					vo.setName(name);
					vo.setGender(gender);
					vo.setfDate(fdate);
					vo.setFeatures(features);
					vo.setPhoto(photo.toString());
					vo.setMissing(missing);
					vo.setSingoja(singoja);
					vo.setSingotel(tel);
					
					int res = dao.setCatUpdate(vo);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, "수정이 실패되었습니다.");
					}
				}
			}
		});
		
		// 개별검색처리
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				CatVO vo = dao.getNameSearch(name);
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 이름이 존재하지 않습니다.");
				else catSearch(vo);
			}
		});
		
		// 창닫기 버튼 클릭 시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CatMain();
			}
		});
		
		// 창닫기 버튼 엔터키 클릭 시 수행
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {}
				dispose();
				new CatMain();
			}
		});
	}

	// 삭제처리하기
	protected void setCatDelete() {
		String name = txtName.getText().trim();
		
		int ans = JOptionPane.showConfirmDialog(null, name + "을(를) 정말 삭제하시겠습니까?","고양이 목록삭제창", JOptionPane.YES_NO_OPTION);
		if(ans == 0) {
			res = dao.setCatDelete(name);
			if(res != 0) {
				JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
				dispose();
				new CatMain();
			}
			else JOptionPane.showMessageDialog(null, "삭제를 실패하였습니다.");
		}
		else JOptionPane.showMessageDialog(null, "삭제를 취소하였습니다.");
	}

	private void catSearch(CatVO vo) {
		lblIdx.setText("("+vo.getIdx()+")");
		txtName.setText(vo.getName());
		lblPhoto.setIcon(new ImageIcon("images/cat/"+vo.getPhoto()));
		txtFeatures.setText(vo.getFeatures());
		txtSingoja.setText(vo.getSingoja());
		String[] tels = vo.getSingotel().split("-");
		tel1.setSelectedItem(tels[0]);
		tel2.setText(tels[1]);
		tel3.setText(tels[2]);
		String ymd = vo.getfDate();
		String[] ymds = vo.getfDate().substring(0, 10).split("-");
		
		comboKind.setSelectedItem(vo.getKind());
		comboYear.setSelectedItem(ymds[0]);
		if(ymds[1].substring(0, 1).equals("0")) ymds[1] = ymds[1].substring(1, 2);
		comboMonth.setSelectedItem(ymds[1]);
		if(ymds[2].substring(0, 1).equals("0")) ymds[2] = ymds[2].substring(1, 2);
		comboDay.setSelectedItem(ymds[2]);
		if(ymd.substring(11,12).equals("0")) comboClock.setSelectedItem(ymd.substring(12,13));
		else comboClock.setSelectedItem(ymd.substring(11,13));
		String gender = vo.getGender();
		if(gender.equals("암컷")) rdFemale.setSelected(true);
		else rdMale.setSelected(true);
		if(vo.getMissing().equals("0")) rdMissing.setSelected(true);
		else rdYougi.setSelected(true);
	}
}
