package com.qlnt.form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qlnt.constant.Constant;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InspectionForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNV;
	private JTextField txtSP;
	private JTextField txtDate;
	private JTextField txtNote;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnAdd;
	private JButton BtnEdit;
	private JButton BtnDel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InspectionForm frame = new InspectionForm();
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
	public InspectionForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 10, 483, 470);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nh\u00E2n vi\u00EAn KT", "S\u1EA3n ph\u1EA9m", "Ghi Ch\u00FA", "Ng\u00E0y KT" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Kiểm tra sản phẩm");
		lblNewLabel.setIcon(new ImageIcon(Constant.URL_IMAGE + "product-research.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 50, 227, 39);
		contentPane.add(lblNewLabel);

		txtNV = new JTextField();
		txtNV.setBounds(118, 118, 166, 32);
		contentPane.add(txtNV);
		txtNV.setColumns(10);

		txtSP = new JTextField();
		txtSP.setColumns(10);
		txtSP.setBounds(118, 171, 166, 32);
		contentPane.add(txtSP);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(118, 280, 166, 32);
		contentPane.add(txtDate);

		txtNote = new JTextField();
		txtNote.setColumns(10);
		txtNote.setBounds(118, 224, 166, 32);
		contentPane.add(txtNote);

		lblNewLabel_1 = new JLabel("Nhân viên");
		lblNewLabel_1.setLabelFor(txtNV);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 119, 76, 25);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Sản phẩm");
		lblNewLabel_2.setLabelFor(txtSP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 172, 76, 25);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Ghi chú");
		lblNewLabel_3.setLabelFor(txtNote);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 225, 76, 25);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Ngày KT");
		lblNewLabel_4.setLabelFor(txtDate);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 281, 76, 25);
		contentPane.add(lblNewLabel_4);

		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon(Constant.URL_IMAGE + "plus (1).png"));
		btnAdd.setBackground(SystemColor.text);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(42, 342, 109, 39);
		contentPane.add(btnAdd);

		BtnEdit = new JButton("Sửa");
		BtnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnEdit.setIcon(new ImageIcon(Constant.URL_IMAGE + "(2).png"));
		BtnEdit.setBackground(SystemColor.text);
		BtnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnEdit.setBounds(175, 342, 109, 39);
		contentPane.add(BtnEdit);

		BtnDel = new JButton("Xoá");
		BtnDel.setIcon(new ImageIcon(Constant.URL_IMAGE + "trash.png"));
		BtnDel.setBackground(SystemColor.text);
		BtnDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnDel.setBounds(42, 408, 238, 39);
		contentPane.add(BtnDel);

		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(0, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
