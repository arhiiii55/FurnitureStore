package com.qlnt.form;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qlnt.controllers.ProductDTO;
import com.qlnt.controllers.TypeDTO;
import com.qlnt.model.Product;
import com.qlnt.model.TypeProductModel;

public class ProductList extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable tbListProduct;
	private JTextField txtId;
	private JTextField txtPdName;
	private JTextField txtStock;
	private JTextField txtPrice;
	private JTextField txtBrand, txtQuantity;
	private JButton btnAddSP;
	private JButton btnEdit;
	private JButton btnDel;
	private JLabel lblNewLabel;
	private JLabel lblTnSp;
	private JLabel lblLoiSp;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4, lblQuantity;
	private JComboBox<String> comboBoxBrand, comboBoxStock;

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
		setBounds(100, 100, 1127, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(377, 0, 736, 568);
		contentPane.add(scrollPane);

		showProductData();

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtId.setBounds(85, 95, 253, 28);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtPdName = new JTextField();
		txtPdName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPdName.setColumns(10);
		txtPdName.setBounds(85, 149, 253, 28);
		contentPane.add(txtPdName);

		txtBrand = new JTextField();
		txtBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBrand.setColumns(10);
		txtBrand.setBounds(85, 246, 253, 28);
		contentPane.add(txtBrand);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrice.setColumns(10);
		txtPrice.setBounds(85, 350, 253, 28);
		contentPane.add(txtPrice);

		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(85, 407, 253, 28);
		contentPane.add(txtQuantity);

		btnAddSP = new JButton("Thêm");
		btnAddSP.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\plus (1).png"));
		btnAddSP.setBackground(SystemColor.text);
		btnAddSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddSP.setBounds(82, 458, 117, 41);
		btnAddSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(txtId.getText());
					String name = txtPdName.getText();
					int typeId = splitId(comboBoxBrand.getSelectedItem().toString());
					String brand = txtBrand.getText();
					int storeId = splitId(comboBoxStock.getSelectedItem().toString());
					int price = Integer.parseInt(txtPrice.getText());
					int quantity = Integer.parseInt(txtQuantity.getText());
					if (ProductDTO.insertProduct(id, name, storeId, typeId, brand, quantity, price)) {
						showProductData();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnAddSP);

		btnEdit = new JButton("Sửa");
		btnEdit.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\edit.png"));
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(221, 458, 117, 41);
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(txtId.getText());
					String name = txtPdName.getText();
					int typeId = splitId(comboBoxBrand.getSelectedItem().toString());
					String brand = txtBrand.getText();
					int storeId = splitId(comboBoxStock.getSelectedItem().toString());
					int price = Integer.parseInt(txtPrice.getText());
					int quantity = Integer.parseInt(txtQuantity.getText());
					if (ProductDTO.updateProduct(id, name, storeId, typeId, brand, quantity, price)) {
						showProductData();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnEdit);

		btnDel = new JButton("Xoá Sản Phẩm");
		btnDel.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\button.png"));
		btnDel.setBackground(SystemColor.text);
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDel.setBounds(82, 525, 253, 41);
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int column = 0;
					int row = tbListProduct.getSelectedRow();
					String value = tbListProduct.getModel().getValueAt(row, column).toString();
					int id = Integer.parseInt(value);
					if (ProductDTO.deleteProductById(id)) {
						showProductData();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
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

		JLabel lblLoiSp_1 = new JLabel("Thương hiệu");
		lblLoiSp_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiSp_1.setBounds(10, 249, 117, 23);
		contentPane.add(lblLoiSp_1);

		lblNewLabel_3 = new JLabel("Kho");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 306, 65, 13);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Giá");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 357, 79, 21);
		contentPane.add(lblNewLabel_4);

		lblQuantity = new JLabel("Số lượng");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(10, 410, 79, 21);
		contentPane.add(lblQuantity);

		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 357, 52);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Projects\\Java\\QuanliHH\\src\\img\\categories.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);

		showTypeProductData();

		showStoreData();

		JButton btnback = new JButton("Back");
		btnback.setBackground(SystemColor.text);
		btnback.setBounds(4, 3, 85, 21);
		contentPane.add(btnback);
	}

	private void showTypeProductData() {
		comboBoxBrand = new JComboBox();
		comboBoxBrand.setBackground(SystemColor.text);
		comboBoxBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxBrand.setBounds(85, 198, 166, 28);
		List<TypeProductModel> typeProductModels = TypeDTO.getListTypeProduct();
		String[] typeProductData = new String[typeProductModels.size()];
		for (int i = 0; i < typeProductModels.size(); i++) {
			TypeProductModel productModel = typeProductModels.get(i);
			typeProductData[i] = productModel.getId() + " - " + productModel.getNameType();
		}
		comboBoxBrand.setModel(new DefaultComboBoxModel(typeProductData));
		contentPane.add(comboBoxBrand);
	}

	private void showStoreData() {
		comboBoxStock = new JComboBox();
		comboBoxStock.setBackground(SystemColor.text);
		comboBoxStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxStock.setBounds(85, 299, 166, 28);
		List<TypeProductModel> typeProductModels = TypeDTO.getListTypeProduct();
		String[] typeProductData = new String[typeProductModels.size()];
		for (int i = 0; i < typeProductModels.size(); i++) {
			TypeProductModel productModel = typeProductModels.get(i);
			typeProductData[i] = productModel.getId() + " - " + productModel.getNameType();
		}
		comboBoxStock.setModel(new DefaultComboBoxModel(typeProductData));
		contentPane.add(comboBoxStock);
	}

	private void showProductData() {
		tbListProduct = new JTable();
		tbListProduct.setFillsViewportHeight(true);
		tbListProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		List<Product> products = ProductDTO.getListProduct();
		String[][] productData = new String[products.size()][7];
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			for (int j = 0; j < 7; j++) {
				if (j == 0) {
					productData[i][j] = String.valueOf(product.getId());
				} else if (j == 1) {
					productData[i][j] = product.getName();
				} else if (j == 2) {
					productData[i][j] = product.getTypeProduct().getNameType();
				} else if (j == 3) {
					productData[i][j] = product.getBrand();
				} else if (j == 4) {
					productData[i][j] = product.getStorage().getArea();
				} else if (j == 5) {
					productData[i][j] = String.valueOf(product.getQuantity());
				} else if (j == 6) {
					productData[i][j] = String.valueOf(product.getPrice()) + "k";
				}
			}
		}
		tbListProduct.setModel(new DefaultTableModel(productData,
				new String[] { "ID", "Tên SP", "Danh mục", "Thương hiệu", "Kho", "Số lượng", "Giá" }));
		scrollPane.setViewportView(tbListProduct);
	}

	private int splitId(String data) {
		String spltData = data.split("-")[0].trim();
		return Integer.parseInt(spltData);
	}
}
