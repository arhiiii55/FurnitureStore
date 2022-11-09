package com.qlnt.form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Staff extends JFrame {

	private JPanel contentPane;
	private JTable tbStaff;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 502);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 10, 749, 431);
		contentPane.add(scrollPane);
		
		tbStaff = new JTable();
		tbStaff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tbStaff.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "H\u1ECD v\u00E0 T\u00EAn", "S\u0110T"
			}
		));
		scrollPane.setViewportView(tbStaff);
		
		JLabel lblNewLabel = new JLabel("Thông tin nhân viên");
		lblNewLabel.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\teamwork.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 47, 268, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\plus (1).png"));
		btnAdd.setBackground(SystemColor.text);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(59, 339, 129, 41);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\edit (2).png"));
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(208, 339, 129, 41);
		contentPane.add(btnEdit);
		
		JButton btnDel = new JButton("Xoá nhân viên");
		btnDel.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\trash.png"));
		btnDel.setBackground(SystemColor.text);
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDel.setBounds(59, 400, 268, 41);
		contentPane.add(btnDel);
		
		JButton btnBack = new JButton("←Back");
		btnBack.setForeground(SystemColor.textText);
		btnBack.setBackground(SystemColor.text);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(0, 8, 87, 27);
		contentPane.add(btnBack);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(67, 114, 260, 41);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(67, 187, 260, 41);
		contentPane.add(txtName);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(67, 268, 260, 41);
		contentPane.add(txtPhoneNumber);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 121, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên NV");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 194, 60, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SĐT");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 275, 45, 13);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
