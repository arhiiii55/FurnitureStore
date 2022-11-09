package com.qlnt.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qlnt.controllers.TypeDTO;
import com.qlnt.db.ConnectDB;
import com.qlnt.model.TypeProductModel;

public class TypeProduct extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtID;
	private JTextField txtType;
	private DefaultTableModel tbDefaultTableModel;
	private ConnectDB connectDB;
	private PreparedStatement preparedStatement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeProduct frame = new TypeProduct();
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
	public TypeProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 10, 369, 250);
		contentPane.add(scrollPane);

		table = new JTable();
		List<TypeProductModel> typeProductModels = TypeDTO.getListTypeProduct();
		String[][] typeProductData = new String[typeProductModels.size()][2];
		for (int i = 0; i < typeProductModels.size(); i++) {
			for (int j = 0; j < 2; j++) {
				TypeProductModel productModel = typeProductModels.get(i);
				if (j == 0) {
					typeProductData[i][j] = String.valueOf(productModel.getId());
				} else if (j == 1) {
					typeProductData[i][j] = productModel.getNameType();
				}
			}
		}
		table.setModel(new DefaultTableModel(typeProductData, new String[] { "ID", "Loại" }));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Danh mục sản phẩm");
		lblNewLabel.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\app.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(38, 29, 201, 29);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(72, 66, 167, 29);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtType = new JTextField();
		txtType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtType.setColumns(10);
		txtType.setBounds(72, 119, 167, 29);
		contentPane.add(txtType);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<TypeProductModel> typeProductModels = TypeDTO.getListTypeProduct();
				JFrame typeProductFrame = new JFrame();

				List<String> listString = new ArrayList<>();
				for (TypeProductModel typeProductModel : typeProductModels) {
					listString.add(typeProductModel.getNameType());
				}
				typeProductFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				typeProductFrame.setLocationRelativeTo(null);
				typeProductFrame.setVisible(true);
//				TypeController.TypeAction();
//				System.exit(0);
			}
		});
		btnAdd.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\plus (1).png"));
		btnAdd.setBackground(SystemColor.text);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(10, 180, 112, 37);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\edit (2).png"));
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(132, 180, 106, 37);
		contentPane.add(btnEdit);

		JButton BtnDel = new JButton("Xoá danh mục");
		BtnDel.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\trash.png"));
		BtnDel.setBackground(SystemColor.text);
		BtnDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnDel.setBounds(38, 223, 179, 37);
		contentPane.add(BtnDel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 77, 33, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Loại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 127, 33, 18);
		contentPane.add(lblNewLabel_1_1);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setForeground(Color.BLACK);
		btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(0, 0, 79, 19);
		contentPane.add(btnBack_1);
	}

}
