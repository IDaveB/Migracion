package com.ipartek.formacion.backoffice.modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.backoffice.pojo.Persona;

public class PersonaDAO implements Persistable<Persona> {

	

	@Override
	public int insert(Persona p ) throws SQLException {
		
		int resul = -1;
		DbConnection conn = new DbConnection();
		String sql ="INSERT INTO `persona` (`id`,`pass`,`nombre`, `dni`, `fecha_nacimiento`, `observaciones`, `email`) VALUES (?,?,?,?,?,?,? );";
		PreparedStatement pst = conn.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS );
		pst.setInt(1,0);
		pst.setString(2, "123456");
		pst.setString(3, p.getNombre() );
		pst.setString(4, p.getDni() );
		pst.setString(5, null);
		pst.setString(6, p.getRol() );
		pst.setString(7, p.getEmail() );
		if ( pst.executeUpdate() == 1 ){
			
			ResultSet generatedKeys = pst.getGeneratedKeys();
			 if (generatedKeys.next()) {				 
				 p.setId( generatedKeys.getInt(1) );
				 resul = p.getId();
			 }else{
				 throw new SQLException("Creating user failed, no ID obtained.");
			 }
			
		}
		pst.close();
    	conn.desconectar();
		return resul;
	}
	
	
	private Persona mapeo ( ResultSet rs ) throws SQLException{
		return null;
		
	}


	@Override
	public List<Persona> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Persona getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Persona persistable) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
