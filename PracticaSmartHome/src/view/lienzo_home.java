package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class lienzo_home extends JPanel{

	private Color sala=Color.green;
	private Color dormitorio=Color.green;
	private Color cocina=Color.green;
	
	private String msg_sala="on";
	private String msg_dormitorio="on";
	private String msg_cocina="on";
	
	public lienzo_home() {
		super();
		setBounds(0,0,400,500);
		repaint();
	}
	public void paint(Graphics g) {
		ImageIcon img_home=new ImageIcon("./src/multimedia/home.png");
		g.drawImage(img_home.getImage(),0,0,400,500,null);
		
		//Sala
		g.setColor(sala);
		g.fillRect(300, 280, 80, 30);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString(msg_sala, 330, 300);
		//Dormitorio
		g.setColor(dormitorio);
		g.fillRect(200, 150, 80, 30);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString(msg_dormitorio, 230, 170);
		//Cocina
		g.setColor(cocina);
		g.fillRect(50, 280, 80, 30);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString(msg_cocina, 90, 300);
		
	}
	public void setColorSala(Color color_,String msg) {
		this.sala=color_;
		msg_sala=msg;
		repaint();
	}
	
	public void setColorDormitorio(Color color_,String msg) {
		this.dormitorio=color_;
		msg_dormitorio=msg;
		repaint();
	}
	
	public void setColorCocina(Color color_,String msg) {
		this.cocina=color_;
		msg_cocina=msg;
		repaint();
	}
	
	

}
