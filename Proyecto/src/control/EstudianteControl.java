package control;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.lang.Iterable;

import beans.Login;

import beans.UsuarioCita;
import beans.Cita;
import modelo.CitaDAO;
import beans.Usuario;
import beans.ListaUsuarios;
import modelo.UsuarioDAO;
import beans.ListaCitas;

import beans.Estudiante;
import beans.ListaEstudiantes;
import modelo.EstudianteDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class EstudianteControl {

	private Usuario usr;

	/*@RequestMapping( value = "/get", method = RequestMethod.GET )
	public ModelAndView get() {


        ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
        UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );

    	ArrayList<Usuario> lista = dao.consultaTodosArray();

		ListaUsuarios listaUsuarios = new ListaUsuarios();
		listaUsuarios.setUsuarios( lista );

		return new ModelAndView( "add_contacto" , "listaestudiantes", listaUsuarios );
	}*/
	@RequestMapping( value = "/get", method = RequestMethod.GET )
	public ModelAndView get() {


		Usuario usuario = new Usuario();

		return new ModelAndView( "add_contacto" , "usuario", usuario );
	}

	@RequestMapping( value = "/agregar_usuario", method = RequestMethod.POST )
	public ModelAndView agregar_usuario(@ModelAttribute("usuario") Usuario usuario) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );

		dao.agregaUsuario(usuario);

		return new ModelAndView( "add_contacto" , "usuario", usuario );
	}

	@RequestMapping( value = "/ingresar", method = RequestMethod.POST )
	public ModelAndView ingresar(@ModelAttribute("login") Login login) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );

		ArrayList<Usuario> lista = dao.consultaTodosArray();

		ListaUsuarios listaUsuarios = new ListaUsuarios();
		listaUsuarios.setListaUsuarios( lista );

		for (Usuario usuario : lista){ 
			if(usuario.getEmail().contentEquals(login.getEmail()) &&
					usuario.getPassword().contentEquals(login.getPassword())) {
				usr = usuario;
				if(usuario.getEsProfesor())
					return new ModelAndView( "administrar_datos_prof" , "usuario", usuario );
				else
					return new ModelAndView( "administrar_datos_alumno" , "usuario", usuario );

			}
		}

		return new ModelAndView( "add_contacto" , "login", login );		
	}
	//////////////////////////////PROFESOR////////////////////////////////
	@RequestMapping( value = "/administrar_datos_prof", method = RequestMethod.POST )
	public ModelAndView administrar_datos_prof(@ModelAttribute("usuario") Usuario usuario) {
		usuario = usr;

		return new ModelAndView( "administrar_datos_prof" , "usuario", usuario );
	}

	@RequestMapping( value = "/actualizar_datos_prof", method = RequestMethod.POST )
	public ModelAndView actualizar_datos_prof(@ModelAttribute("usuario") Usuario usuario) {

		usr.setNombre(usuario.getNombre());
		usr.setApellido1(usuario.getApellido1());
		usr.setApellido2(usuario.getApellido2());
		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );
		UsuarioDAO dao = (UsuarioDAO)context.getBean( "usuarioDAO" );
		dao.modificaUsuario(usr);

		return new ModelAndView( "administrar_datos_prof" , "usuario", usr );
	}

	@RequestMapping( value = "/publicar_cita", method = RequestMethod.POST )
	public ModelAndView publicar_cita(@ModelAttribute("usuario") Usuario usuario) {
		usuario = usr;

		return new ModelAndView( "publicar_cita" , "usuario", usuario );
	}

	@RequestMapping( value = "/publica", method = RequestMethod.POST )
	public ModelAndView publica(@ModelAttribute("cita") Cita cita ) {

		if(cita.getLugar() != null) {

			ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
			CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

			cita.setId_profesor((int)usr.getId_usuario());

			dao.agregaCita(cita);
		}
		return new ModelAndView( "ver_citas" , "usuario", usr );


	}



	@RequestMapping( value = "/ver_citas", method = RequestMethod.POST )
	public ModelAndView ver_citas(@ModelAttribute("listaCitas") ListaCitas listaCitas, @ModelAttribute("listaCitas2") ListaCitas listaCitas2) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

		ArrayList<Cita> lista = dao.consultaTodosProfesorAsignadasArray( usr.getId_usuario());

		listaCitas.setListaCitas( lista );
		
		ArrayList<Cita> lista2 = dao.consultaTodosProfesorDisponiblesArray( usr.getId_usuario());

		listaCitas2.setListaCitas( lista2 );


		return new ModelAndView( "ver_citas" , "usuario", usr );
	}
	@RequestMapping( value = "/ver_citas_solicitadas", method = RequestMethod.POST )
	public ModelAndView ver_citas_solicitadas(@ModelAttribute("listaCitas") ListaCitas listaCitas) {

		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		CitaDAO dao = (CitaDAO)context.getBean( "citaDAO" );

		ArrayList<Cita> lista = dao.consultaTodosProfesorSolicitadasArray( usr.getId_usuario());
		listaCitas.setListaCitas( lista );
		
		return new ModelAndView( "ver_citas_solicitadas" , "usuario", usr );
	}



	//////////////////////////////ALUMNO////////////////////////////////

	@RequestMapping( value = "/administrar_datos_alumno", method = RequestMethod.POST )
	public ModelAndView administrar_datos_alumno(@ModelAttribute("usuario") Usuario usuario) {


		return new ModelAndView( "administrar_datos_alumno" , "usuario", usuario );
	}

	@RequestMapping( value = "/ver_citas_agendadas", method = RequestMethod.POST )
	public ModelAndView ver_citas_agendadas(@ModelAttribute("usuario") Usuario usuario) {


		return new ModelAndView( "ver_citas_agendadas" , "usuario", usuario );
	}
	@RequestMapping( value = "/solicitar_cita", method = RequestMethod.POST )
	public ModelAndView solicitar_cita(@ModelAttribute("usuario") Usuario usuario) {


		return new ModelAndView( "solicitar_cita" , "usuario", usuario );
	}


	//////////////////////////////////////////////////////////////

	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public ModelAndView save( @ModelAttribute("listaestudiantes") ListaEstudiantes listaestudiantes ) {

		System.out.println( listaestudiantes );
		System.out.println( listaestudiantes.getEstudiantes() );
		List<Estudiante> lista = listaestudiantes.getEstudiantes();
		ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );	            
		EstudianteDAO dao = (EstudianteDAO)context.getBean( "estudianteDAO" );

		if( null != lista && lista.size() > 0 ) {
			for( Estudiante estu : lista ) {
				dao.modificaEstudiante( estu );
			}
		}		
		return new ModelAndView( "show_contacto", "listaestudiantes", listaestudiantes );
	}		
}
