package com.qlnt.form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qlnt.constant.Constant;
import com.qlnt.controllers.InspectionDTO;
import com.qlnt.controllers.ProductDTO;
import com.qlnt.controllers.TypeDTO;
import com.qlnt.model.Inspection;
import com.qlnt.model.Product;
import com.qlnt.model.TypeProductModel;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
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
	private JButton btnEdit;
	private JButton btnDel;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JComboBox<String> comboBoxStaff, comboBoxProduct;

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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 10, 483, 470);
		contentPane.add(scrollPane);

		showInspectionData();

		JLabel lblNewLabel = new JLabel("Kiểm tra sản phẩm");
		lblNewLabel.setIcon(new ImageIcon(Constant.URL_IMAGE + "product-research.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 50, 227, 39);
		contentPane.add(lblNewLabel);

		showStaffData();

		showProductData();

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

		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon(Constant.URL_IMAGE + "plus (1).png"));
		btnAdd.setBackground(SystemColor.text);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(42, 281, 109, 39);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int staffId = splitId(comboBoxStaff.getSelectedItem().toString());
					int productId = splitId(comboBoxProduct.getSelectedItem().toString());
					String note = txtNote.getText();
					Date checkDate = new Date(Calendar.getInstance().getTime().getTime());
					if (InspectionDTO.insertInspection(staffId, productId, note, checkDate)) {
						showInspectionData();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnAdd);

		btnEdit = new JButton("Sửa");
		btnEdit.setIcon(new ImageIcon(Constant.URL_IMAGE + "(2).png"));
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(175, 281, 109, 39);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int column = 0;
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, column).toString();
					int id = Integer.parseInt(value);
					String note = txtNote.getText();
					if (InspectionDTO.updateInspection(id, note)) {
						showInspectionData();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnEdit);

		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(0, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}

	private void showStaffData() {
		comboBoxStaff = new JComboBox();
		comboBoxStaff.setBackground(SystemColor.text);
		comboBoxStaff.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxStaff.setBounds(118, 118, 166, 28);
		List<TypeProductModel> typeProductModels = TypeDTO.getListTypeProduct();
		String[] typeProductData = new String[typeProductModels.size()];
		for (int i = 0; i < typeProductModels.size(); i++) {
			TypeProductModel productModel = typeProductModels.get(i);
			typeProductData[i] = productModel.getId() + " - " + productModel.getNameType();
		}
		comboBoxStaff.setModel(new DefaultComboBoxModel(typeProductData));
		contentPane.add(comboBoxStaff);
	}

	private void showProductData() {
		comboBoxProduct = new JComboBox();
		comboBoxProduct.setBackground(SystemColor.text);
		comboBoxProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxProduct.setBounds(118, 171, 166, 28);
		List<Product> products = ProductDTO.getListProduct();
		String[] productData = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			Product productModel = products.get(i);
			productData[i] = productModel.getId() + " - " + productModel.getName();
		}
		comboBoxProduct.setModel(new DefaultComboBoxModel(productData));
		contentPane.add(comboBoxProduct);
	}

	private void showInspectionData() {
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		List<Inspection> inspections = InspectionDTO.getListInspection();
		String[][] inspectionData = new String[inspections.size()][5];
		for (int i = 0; i < inspections.size(); i++) {
			Inspection inspection = inspections.get(i);
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					inspectionData[i][j] = String.valueOf(inspection.getId());
				} else if (j == 1) {
					inspectionData[i][j] = inspection.getStaff().getFullNameString();
				} else if (j == 2) {
					inspectionData[i][j] = inspection.getProduct().getName();
				} else if (j == 3) {
					inspectionData[i][j] = inspection.getCheckStatus();
				} else if (j == 4) {
					inspectionData[i][j] = inspection.getCheckDate().toLocaleString();
				}
			}
		}
		table.setModel(new DefaultTableModel(inspectionData,
				new String[] { "ID", "Nhân viên KT", "Sản phẩm", "Ghi Chú", "Ngày KT" }));
		scrollPane.setViewportView(table);
	}

	private int splitId(String data) {
		String spltData = data.split("-")[0].trim();
		return Integer.parseInt(spltData);
	}
}
