package model;

import patron_V_20.connection;

public class lucesDAO {

	private Luz l;
	private connection conn=new connection("ejemplo2");
	private boolean flag=false;

	public lucesDAO(Luz l) {
		super();
		this.l = l;
	}
	
	public lucesDAO() {
		
	}
	
	public boolean insertLuces() {
		flag=conn.setQuery(String.format("INSERT INTO smarthome.luces VALUES(null, %d, '%s','%s','%s','%s','%s');"
				,l.getId_ambiente()
				,l.getEstado()
				,l.getFecha_i()
				,l.getFecha_f()
				,l.getHora_1()
				,l.getHora_f()));
		conn.closeConn();
		return flag;
	}

	public boolean updateLuces() {
		flag=conn.setQuery(String.format("UPDATE smarthome.luces SET estado='%s', fecha_fin='%s', hora_fin='%s' WHERE id_ambiente=%d AND estado='on';", 
				l.getEstado()
				,l.getFecha_f()
				,l.getHora_f()
				,l.getId_ambiente()
				));
		conn.closeConn();
		return flag;
	}
	
}
