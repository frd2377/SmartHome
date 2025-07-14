package model;

import patron_V_20.generica;

public class Luz {
	
	private generica<Integer,String> dt_l;
	private generica<String, String>dte_l;
	public Luz(int id_luces, int id_ambiente, String estado, String fecha_i, String fecha_f, String hora_i, 
			String hora_f) {
		dt_l=new generica<>(id_luces, id_ambiente, estado, hora_i);
		dte_l=new generica<>(fecha_i, fecha_f,hora_f);
	}
	//Getters
	public int getId_luces() {
		return dt_l.getAtributo1();
	}

	public int getId_ambiente() {
		return dt_l.getAtributo2();
	}
	public String getEstado() {
		return dt_l.getAtributo3();
	}
	public String getHora_1() {
		return dt_l.getAtributo4();
	}
	public String getFecha_i() {
		return dte_l.getAtributo1();
	}
	public String getFecha_f() {
		return dte_l.getAtributo2();
	}
	public String getHora_f() {
		return dte_l.getAtributo3();
	}

}
