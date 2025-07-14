package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_home;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class view_home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public lienzo_home pn_lienzo;
	public JButton btn_connect;
	public JButton btn_estadoAll;
	public JComboBox cbm_ports;
	public JLabel lbl_conect;

	public view_home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 587);
		setResizable(false);
		setTitle("SmartHome");
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_control = new JPanel();
		pn_control.setBackground(Color.WHITE);
		pn_control.setBounds(10, 10, 156, 530);
		contentPane.add(pn_control);
		pn_control.setLayout(null);
		
		cbm_ports = new JComboBox();
		cbm_ports.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbm_ports.setBounds(0, 5, 156, 34);
		pn_control.add(cbm_ports);
		
		btn_connect = new JButton("CONNECT");
		btn_connect.setForeground(Color.BLACK);
		btn_connect.setBackground(Color.WHITE);
		btn_connect.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_connect.setBounds(0, 46, 156, 34);
		pn_control.add(btn_connect);
		
		btn_estadoAll = new JButton("ALL ON");
		btn_estadoAll.setForeground(Color.BLACK);
		btn_estadoAll.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_estadoAll.setBackground(Color.GREEN);
		btn_estadoAll.setBounds(0, 107, 156, 72);
		pn_control.add(btn_estadoAll);
		
		lbl_conect = new JLabel("DISCCONECT");
		lbl_conect.setBounds(20, 209, 106, 23);
		pn_control.add(lbl_conect);
		
		pn_lienzo = new lienzo_home();
		pn_lienzo.setBounds(176, 30, 400, 530);
		contentPane.add(pn_lienzo);
		
		logic_view_home lvh=new logic_view_home(this,pn_lienzo);
	}
}
