package cat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class CatList extends JFrame {
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JTextArea txtaFeatures;
	
	CatDAO dao = new CatDAO();
	
	public CatList() {
		super("유기묘 전체목록");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(128, 128, 128));
		pn1.setBounds(0, 0, 784, 67);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고양이 전체목록");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY엽서M", Font.BOLD, 35));
		lblNewLabel.setBounds(12, 0, 760, 67);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 66, 445, 495);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 52, 421, 388);
//		pn2.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JComboBox comboSelect = new JComboBox();
		comboSelect.setBackground(new Color(255, 255, 255));
		comboSelect.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		comboSelect.setModel(new DefaultComboBoxModel(new String[] {"번호", "종류", "이름", "성별", "구분"}));
		comboSelect.setBounds(12, 10, 105, 34);
		pn2.add(comboSelect);
		
		JRadioButton rdAsc = new JRadioButton("오름차순");
		rdAsc.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		rdAsc.setSelected(true);
		buttonGroup.add(rdAsc);
		rdAsc.setBounds(138, 16, 121, 23);
		pn2.add(rdAsc);
		
		JRadioButton rdDesc = new JRadioButton("내림차순");
		rdDesc.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		buttonGroup.add(rdDesc);
		rdDesc.setBounds(270, 16, 121, 23);
		pn2.add(rdDesc);
		
		JButton btnOrder = new JButton("정렬하여 검색");
		btnOrder.setBackground(new Color(255, 255, 255));
		btnOrder.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		btnOrder.setBounds(237, 450, 196, 35);
		pn2.add(btnOrder);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(444, 66, 340, 495);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setBounds(5, 54, 330, 300);
		pn3.add(lblPhoto);
		
		lblPhoto.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1));
		
		JButton btnExit = new JButton("창 닫 기");
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		btnExit.setBounds(198, 442, 130, 43);
		pn3.add(btnExit);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 359, 330, 80);
		pn3.add(scrollPane_1);
		
		txtaFeatures = new JTextArea();
		txtaFeatures.setOpaque(false);
		txtaFeatures.setFont(new Font("HY엽서M", Font.PLAIN, 20));
		scrollPane_1.setViewportView(txtaFeatures);
		
		JLabel lblNewLabel_1 = new JLabel("목록을 누르면 사진이 나와요!");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("HY엽서M", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(5, 10, 323, 36);
		pn3.add(lblNewLabel_1);
		
		// JTable설계
		vData = dao.getCatList();

	// 가져온 데이터의 '번호' 열을 1부터 다시 세팅
	for (int i = 0; i < vData.size(); i++) {
	    Vector row = (Vector) vData.get(i);
	    row.set(0, i + 1); // 0번째 칸(번호)을 현재 줄번호+1로 변경
	}

	dtm = new DefaultTableModel(vData, title);
	table = new JTable(dtm);
		
		title = new Vector<>();
		title.add("번호");
		title.add("종류");
		title.add("이름");
		title.add("성별");
		title.add("발견날짜");
		title.add("신고자");
		title.add("구분");
		title.add("고유번호");
		
		vData = dao.getCatList();
		
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 54, 421, 393);
		pn2.add(scrollPane);
		
		setVisible(true);
		
		// 테이블안의 내용(행/열) 편집하기
		cellEditProcess();
		
		// -----------위로 UI(디자인) / 아래는 메소드 영역--------------------
		
		// 조건별 정렬처리하기
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cbCondition = comboSelect.getSelectedItem().toString();
				String sortOption = "";
				
				if(cbCondition.equals("번호")) cbCondition = "idx";
				else if(cbCondition.equals("종류")) cbCondition = "kind";
				else if(cbCondition.equals("이름")) cbCondition = "name";
				else if(cbCondition.equals("성별")) cbCondition = "gender";
				else if(cbCondition.equals("구분")) cbCondition = "missing";
			
				if(rdDesc.isSelected()) sortOption = "desc";
				else sortOption = "asc";
				
				vData = dao.getCatListsort(cbCondition, sortOption);
				dtm.setDataVector(vData,title);
				
				cellEditProcess();
			}
		});
		
		// table안의 셀을 클릭시 처리..
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				//int col = table.getSelectedColumn();
				int idx = (int) table.getValueAt(row, 7);
				CatVO vo = dao.getSearch(idx);
				
				txtaFeatures.setText(vo.getFeatures());
				lblPhoto.setIcon(new ImageIcon("images/cat/"+vo.getPhoto()));
			}
		});
		
		// 창닫기 클릭 시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CatMain();
			}
		});
	}
	
	private void cellEditProcess() {
		table.getColumnModel().getColumn(7).setMinWidth(0);
		int[] maxWidths ={30,100,40,35,120,70,45,0};
//		table.getColumnModel().getColumn(0).setMaxWidth(30);
//		table.getColumnModel().getColumn(1).setMaxWidth(80);
//		table.getColumnModel().getColumn(2).setMaxWidth(50);
//		table.getColumnModel().getColumn(3).setMaxWidth(35);
//		table.getColumnModel().getColumn(4).setMaxWidth(110);
//		table.getColumnModel().getColumn(5).setMaxWidth(80);
//		table.getColumnModel().getColumn(6).setMaxWidth(45);
//		table.getColumnModel().getColumn(7).setMaxWidth(0);
		for(int i=0; i<maxWidths.length; i++) {
			table.getColumnModel().getColumn(i).setMaxWidth(maxWidths[i]);
		}
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

//	public static void main(String[] args) {
//		new CatList();
//	}
}
