package com.qlnt.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.qlnt.constant.Constant;

public class FeatureList extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeatureList frame = new FeatureList();
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
	public FeatureList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 587);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 438, 206);
		lblNewLabel.setIcon(new ImageIcon("home.png"));
		contentPane.add(lblNewLabel);
		
		JButton btnProduct = new JButton("Sản phẩm");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hioiii");
				System.exit(0);
			}
		});
		btnProduct.setIcon(new ImageIcon(Constant.URL_IMAGE + "package.png"));
		btnProduct.setForeground(SystemColor.textText);
		btnProduct.setBackground(SystemColor.window);
		btnProduct.setFont(new Font("Arial", Font.PLAIN, 18));
		btnProduct.setBounds(103, 226, 267, 41);
		contentPane.add(btnProduct);
		
		JButton btnInspect = new JButton("Kiểm tra tình trạng");
		btnInspect.setIcon(new ImageIcon(Constant.URL_IMAGE + "product-research (1).png"));
		btnInspect.setForeground(SystemColor.textText);
		btnInspect.setBackground(SystemColor.text);
		btnInspect.setFont(new Font("Arial", Font.PLAIN, 18));
		btnInspect.setBounds(103, 277, 267, 41);
		contentPane.add(btnInspect);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(btnExit, "yes i do");
//			}
//		});
		btnExit.setIcon(new ImageIcon(Constant.URL_IMAGE + "button.png"));
		btnExit.setForeground(SystemColor.windowText);
		btnExit.setBackground(SystemColor.text);
		btnExit.setFont(new Font("Arial", Font.PLAIN, 18));
		btnExit.setBounds(103, 443, 267, 41);
		contentPane.add(btnExit);
		
		JButton btnStaff = new JButton("Danh sách nhân viên");
		btnStaff.setIcon(new ImageIcon(Constant.URL_IMAGE + "teamcolor.png"));
		btnStaff.setForeground(Color.BLACK);
		btnStaff.setFont(new Font("Arial", Font.PLAIN, 18));
		btnStaff.setBackground(Color.WHITE);
		btnStaff.setBounds(103, 392, 267, 41);
		contentPane.add(btnStaff);
		
		JButton btnType = new JButton("Danh mục sản phẩm");
		btnType.setIcon(new ImageIcon(Constant.URL_IMAGE + "box.png"));
		btnType.setForeground(Color.BLACK);
		btnType.setFont(new Font("Arial", Font.PLAIN, 18));
		btnType.setBackground(Color.WHITE);
		btnType.setBounds(103, 338, 267, 41);
		contentPane.add(btnType);
	}
}
