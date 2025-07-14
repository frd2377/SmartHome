package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.fazecast.jSerialComm.SerialPort;

public class SerialConn{

	private char option = '0'; //dato a enviar al arduino
	private SerialPort port; //puerto de comunicacion
	
	public SerialPort openConn(String name) {
		SerialPort[] ports = SerialPort.getCommPorts(); //array con los puertos encontrados
		for (SerialPort port_ : ports) { //ver todos los puertos encontrados
			System.out.println(port_);
			if (port_.toString().equals(name)) {
				this.port = port_;
			}
		}

		if (port.openPort()) {
			System.out.println("Puerto serial abierto");
		}else {
			System.out.println("Error en el puerto serial");
		}
		
		port.setComPortParameters(9600, 8, 1, 0);
		
		return port;
	}
	
	public List<SerialPort> getPorts() {
		ArrayList<SerialPort> puertosEnc = new ArrayList<SerialPort>();
		SerialPort[] ports = SerialPort.getCommPorts(); //array con los puertos encontrados
		for (SerialPort port_ : ports) { //ver todos los puertos encontrados
			puertosEnc.add(port_);
		}
		return puertosEnc;
	}
	
	public SerialPort getPort() {
		return this.port;
	}
	
	public void sendMsg(char msg) {
		setOption(msg);
		PrintWriter output = new PrintWriter(port.getOutputStream());
		output.write(getOption());
		output.flush();
	}
	
	public boolean closeConn() {
		return port.closePort();
	}

	public char getOption() {
		return option;
	}

	public void setOption(char option) {
		this.option = option;
	}
	
}
