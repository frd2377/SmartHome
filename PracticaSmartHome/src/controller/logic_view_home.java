package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.fazecast.jSerialComm.SerialPort;

import model.Luz;
import model.lucesDAO;
import view.lienzo_home;
import view.view_home;

public class logic_view_home implements MouseListener, ActionListener{

	private view_home vh;
	private lienzo_home lh;
	private boolean est_sala=false;
	private boolean est_dormitorio=false;
	private boolean est_cocina=false;
	private boolean est_all=false;
	private SerialConn serialConn = new SerialConn();
	private lucesDAO lucesDAO = new lucesDAO();
	private Integer ambiente;
	private Luz luz;
	
	
	public logic_view_home(view_home vh,lienzo_home lh) {
		super();
		this.vh = vh;
		this.lh=lh;
		this.vh.pn_lienzo.addMouseListener(this);
		this.vh.btn_connect.addActionListener(this);
		this.vh.btn_estadoAll.addActionListener(this);
		getports();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			Point p=new Point();
			p.x=e.getX();
			p.y=e.getY();
			//System.out.println(p.x+";"+p.y);
			if(p.x>=300 && p.x<380) {
				if(p.y>=280&&p.y<310) {
					ambiente = 1;
					if(!est_sala) {
						lh.setColorSala(Color.red,"off");
						serialConn.sendMsg('1');
						est_sala=true;
						luz = new Luz(0, ambiente, "on", formatFecha(), "", formatHora(), "");
						lucesDAO = new lucesDAO(luz);
						lucesDAO.insertLuces();
						
					}else {
						lh.setColorSala(Color.green,"on");
						serialConn.sendMsg('2');
						est_sala=false;
						luz = new Luz(0, ambiente, "off", "", formatFecha(), "", formatHora());
						lucesDAO = new lucesDAO(luz);
						lucesDAO.updateLuces();
					}
				}
			}
			
			else if(p.x>=200 && p.x<277) {
				if(p.y>=150&&p.y<175) {
					ambiente = 3;
					if(!est_dormitorio) {
						lh.setColorDormitorio(Color.red,"off");
						serialConn.sendMsg('3');
						est_dormitorio=true;
						luz = new Luz(0, ambiente, "on", formatFecha(), "", formatHora(), "");
						lucesDAO = new lucesDAO(luz);
						lucesDAO.insertLuces();
					}else {
						lh.setColorDormitorio(Color.green,"on");
						serialConn.sendMsg('4');
						est_dormitorio=false;
						luz = new Luz(0, ambiente, "off", "", formatFecha(), "", formatHora());
						lucesDAO = new lucesDAO(luz);
						lucesDAO.updateLuces();
					}
				}
			}
			
			else if(p.x>=51 && p.x<128) {
				if(p.y>=280&&p.y<308) {
					ambiente=2;
					if(!est_cocina) {
						lh.setColorCocina(Color.red,"off");
						serialConn.sendMsg('5');
						est_cocina=true;
						luz = new Luz(0, ambiente, "on", formatFecha(), "", formatHora(), "");
						lucesDAO = new lucesDAO(luz);
						lucesDAO.insertLuces();
					}else {
						lh.setColorCocina(Color.green,"on");
						serialConn.sendMsg('6');
						est_cocina=false;
						luz = new Luz(0, ambiente, "off", "", formatFecha(), "", formatHora());
						lucesDAO = new lucesDAO(luz);
						lucesDAO.updateLuces();
					}
				}
			}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vh.btn_connect)) {
			SerialPort port = serialConn.openConn(vh.cbm_ports.getSelectedItem().toString());
			if (port.openPort()) {
				vh.cbm_ports.setEnabled(false);
				vh.btn_connect.setEnabled(false);
				JOptionPane.showMessageDialog(lh, "CONNECTED");
				vh.lbl_conect.setText("CONNECTED");
			}
		}
		
		else if (e.getSource().equals(vh.btn_estadoAll) && serialConn.getPort()!=null) {
			
			if(!est_all) {
				vh.btn_estadoAll.setText("ALL OFF");
				vh.btn_estadoAll.setBackground(Color.red);
				serialConn.sendMsg('7');
				lh.setColorCocina(Color.red,"off");
				lh.setColorDormitorio(Color.red,"off");
				lh.setColorSala(Color.red,"off");
				est_sala = true;
				est_dormitorio = true;
				est_cocina = true;
				est_all=true;
			}else {
				vh.btn_estadoAll.setText("ALL ON");
				vh.btn_estadoAll.setBackground(Color.green);
				serialConn.sendMsg('8');
				lh.setColorCocina(Color.green,"on");
				lh.setColorDormitorio(Color.green,"on");
				lh.setColorSala(Color.green,"on");
				est_sala = false;
				est_dormitorio = false;
				est_cocina = false;
				est_all=false;
			}
			
			
		}
		
	}
	
	public void getports() {
		List<SerialPort> serialPorts = serialConn.getPorts();
		for (SerialPort serialPort : serialPorts) {
			vh.cbm_ports.addItem(serialPort.toString());
		}
		
	}
	
	public String formatFecha() {
		Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yy/MM/dd");
        return formatoFecha.format(fechaActual);
    }

    public String formatHora() {
    	Date fechaActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        return formatoHora.format(fechaActual);
    }
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
