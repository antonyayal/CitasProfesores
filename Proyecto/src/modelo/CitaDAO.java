/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import beans.Cita;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CitaDAO extends SimpleJdbcDaoSupport{


	private static final String CONSULTATODASASIGNADASPROFESOR = "SELECT * FROM cita WHERE solicitada = false and asignada = true and id_profesor = ";
	private static final String CONSULTATODASDISPONIBLESPROFESOR = "SELECT * FROM cita WHERE solicitada = false and asignada = false and id_profesor = ";
	private static final String CONSULTATODASSOLICITADASPROFESOR = "SELECT * FROM cita WHERE solicitada = true and asignada = false and id_profesor = ";
	
	private static final String CONSULTATODOSALUMNO = "SELECT * FROM cita WHERE id_alumno = ";
	private static final String CONSULTATODOSPROFESOR = "SELECT * FROM cita WHERE id_profesor = ";
	private static final String MODIFICACITA =
			"UPDATE cita SET id_cita = ?,id_profesor =  ?, id_alumno = ?, lugar = ?, fecha = ?, hora = ?, asignada = ?"+
					"WHERE id_cita = ? ";
	private static final String AGREGACITA = "INSERT INTO `cita` (`id_profesor`,`lugar`,`fecha`,`hora`,"+
			"`solicitada`, `asignada`) "+
			"VALUES (?,?,?,?,?,?)";

	class ProyectosRowMapper implements ParameterizedRowMapper<Cita>  {

		public Cita mapRow( ResultSet rs, int numeroRenglon ) throws SQLException {

			Cita cita = new Cita();

			cita.setId_cita( rs.getInt( "id_cita" ) );
			cita.setFecha( rs.getDate( "fecha" ) );
			cita.setHora( rs.getString( "hora" ) );
			cita.setLugar( rs.getString( "lugar" ) );
			cita.setId_alumno( rs.getInt( "id_alumno" ) );
			cita.setId_profesor( rs.getInt( "id_profesor" ) );
			cita.setAsignada( rs.getBoolean( "asignada" ) );

			return cita;
		}
	}

	public void agregaCita( Cita cita ) {

		SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
		sjdbct.update( AGREGACITA, cita.getId_profesor(),cita.getLugar(),cita.getFecha(),
				cita.getHora(),cita.isSolicitada(),cita.isAsignada());

	}
	
	public ArrayList<Cita> consultaTodosProfesorAsignadasArray(int id) {
		SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
		ArrayList<Cita> citas =
				(ArrayList<Cita>) sjdbc.query( CONSULTATODASASIGNADASPROFESOR + id, new ProyectosRowMapper() );	
		
		return  citas ;   	
	}
	public ArrayList<Cita> consultaTodosProfesorDisponiblesArray(int id) {
		SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
		ArrayList<Cita> citas =
				(ArrayList<Cita>) sjdbc.query( CONSULTATODASDISPONIBLESPROFESOR + id, new ProyectosRowMapper() );	
		
		return  citas ;   	
	}
	public ArrayList<Cita> consultaTodosProfesorSolicitadasArray(int id) {
		SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
		ArrayList<Cita> citas =
				(ArrayList<Cita>) sjdbc.query( CONSULTATODASSOLICITADASPROFESOR + id, new ProyectosRowMapper() );	
		
		return  citas ;   	
	}
	
	
	
	
	
	
	public ArrayList<Cita> consultaTodosAlumnoArray(int id) {
		SimpleJdbcTemplate sjdbc = getSimpleJdbcTemplate();
		ArrayList<Cita> citas =
				(ArrayList<Cita>) sjdbc.query( CONSULTATODOSALUMNO + id , new ProyectosRowMapper() );	
		return  citas ;   	
	}
	

	public void modificaCita( Cita cita ) {

		SimpleJdbcTemplate sjdbct = getSimpleJdbcTemplate();
		sjdbct.update( MODIFICACITA, cita.getId_cita(), cita.getFecha(),cita.getHora(),cita.getLugar(),
				cita.getId_alumno(),cita.getId_profesor(),cita.isAsignada());

	}


}