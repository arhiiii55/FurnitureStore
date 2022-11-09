package com.qlnt.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ProductList extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable tbListProduct;
	private JTextField txtId;
	private JTextField txtPdName;
	private JTextField txtStock;
	private JTextField txtDate;
	private JButton btnAddSP;
	private JButton btnEdit;
	private JButton btnDel;
	private JLabel lblNewLabel;
	private JLabel lblTnSp;
	private JLabel lblLoiSp;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Projects\\Java\\QuanliHH\\src\\img\\list.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1127, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(377, 0, 736, 499);
		contentPane.add(scrollPane);
		
		tbListProduct = new JTable();
		tbListProduct.setFillsViewportHeight(true);
		tbListProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbListProduct.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EAn SP", "Danh m\u1EE5c", "Th\u01B0\u01A1ng hi\u1EC7u", "Kho", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		scrollPane.setViewportView(tbListProduct);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtId.setBounds(85, 95, 117, 28);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPdName = new JTextField();
		txtPdName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPdName.setColumns(10);
		txtPdName.setBounds(85, 149, 253, 28);
		contentPane.add(txtPdName);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStock.setColumns(10);
		txtStock.setBounds(85, 299, 253, 28);
		contentPane.add(txtStock);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDate.setColumns(10);
		txtDate.setBounds(85, 350, 253, 28);
		contentPane.add(txtDate);
		
		btnAddSP = new JButton("Thêm");
		btnAddSP.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\plus (1).png"));
		btnAddSP.setBackground(SystemColor.text);
		btnAddSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddSP.setBounds(82, 407, 117, 41);
		contentPane.add(btnAddSP);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\edit.png"));
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(221, 407, 117, 41);
		contentPane.add(btnEdit);
		
		btnDel = new JButton("Xoá Sản Phẩm");
		btnDel.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\button.png"));
		btnDel.setBackground(SystemColor.text);
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDel.setBounds(82, 458, 253, 41);
		contentPane.add(btnDel);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 102, 65, 13);
		contentPane.add(lblNewLabel);
		
		lblTnSp = new JLabel("Tên SP");
		lblTnSp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSp.setBounds(10, 156, 65, 13);
		contentPane.add(lblTnSp);
		
		lblLoiSp = new JLabel("Danh mục");
		lblLoiSp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoiSp.setBounds(10, 203, 65, 21);
		contentPane.add(lblLoiSp);
		
		lblNewLabel_3 = new JLabel("Kho");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 306, 65, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Giá");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 357, 79, 21);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 357, 52);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\categories.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(114, 232, 1, 1);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.text);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox.setBounds(85, 198, 166, 28);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(SystemColor.text);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Đang bán", "Ngừng kinh doanh"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(212, 94, 126, 28);
		contentPane.add(comboBox_1);
		
		JLabel lblLoiSp_1 = new JLabel("Thương hiệu");
		lblLoiSp_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiSp_1.setBounds(10, 249, 117, 23);
		contentPane.add(lblLoiSp_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(85, 246, 166, 28);
		contentPane.add(comboBox_2);
		
		JButton btnback = new JButton("Back");
		btnback.setBackground(SystemColor.text);
		btnback.setBounds(4, 3, 85, 21);
		contentPane.add(btnback);
	}
}
