package com.indra;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indra.identity.JobHistoryId;
import com.indra.model.Countries;
import com.indra.model.Departaments;
import com.indra.model.Employees;
import com.indra.model.JobHistory;
import com.indra.model.Jobs;
import com.indra.model.Locations;
import com.indra.model.Phone;
import com.indra.model.Regions;
import com.indra.repository.CountriesRepository;
import com.indra.repository.DepartamentsRepostitory;
import com.indra.repository.EmployeesRepository;
import com.indra.repository.JobsHistoryRepository;
import com.indra.repository.JobsRepository;
import com.indra.repository.LocationsRepository;
import com.indra.repository.PhoneRepository;
import com.indra.repository.RegionRepository;
import com.indra.repository.UsuarioRepository;
import com.indra.service.CountryService;
import com.indra.service.DepartmentsService;
import com.indra.service.EmployeesService;
import com.indra.service.EmployeesServiceImple;
import com.indra.service.JobHistoryService;
import com.indra.service.JobService;
import com.indra.service.LocationsService;
import com.indra.service.PhoneService;
import com.indra.service.RegionService;


@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	private EmployeesService serviceE;
	
	@Autowired
	private DepartmentsService serviceD;
	
	@Autowired
	private LocationsService serviceL;
	
	@Autowired
	private RegionService serviceR;
	
	@Autowired
	private PhoneService serviceP;
	
	@Autowired
	private JobService serviceJ;
	
	@Autowired
	private CountryService serviceC;
	
	@Autowired
	private JobHistoryService serviceJH;

	@Autowired 
	private UsuarioRepository repo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	/*
		if(serviceE.buscar() !=null )
			System.out.println("El repositorio se inyecto");
		
		    Employees  emple = new Employees();
			//emple.setFirst_name("zszz");
			//emple.setLast_name("Barcenasw");
			emple.setEmail("JBARCENASs");
			Date date= new Date();
			//emple.setHire_date(date);
			//emple.setJob_id("IT_PROG");
			//emple.setManager_id(205);
			//emple.setDepartment_id(110);
			
		    Departaments dep= new Departaments();
		    dep.setDepartment_name("depa");
		    dep.setManager_id(103);
		    dep.setLocation_id(1700);
		    
		    
		    Locations location = new Locations();
		    location.setStreet_address("200 Ignacio");
		    location.setCity("Mexico");
		    location.setCountry_id("IT");
		    location.setState_province("mexico");
		    location.setPostal_code("50170");
		    
		    Regions region = new Regions();
		    region.setRegion_name("Regions");
		    
		    Phone phone = new Phone();
		    phone.setExtension("19d11");
		    phone.setIsd_code("32w2d");
		    phone.setPhone_number("23225");
		    phone.setType("Tel2");
		    phone.setEmployee_id(144);
		    
		    Jobs job = new Jobs();
		    //job.setJob_id("PR");
		    job.setJob_title("xxx");
		    job.setMax_salary(123400);
		    job.setMin_salary(12341);
		    
		    Countries country = new Countries();
		   // country.setCountry_id("NO");
		    country.setCountry_name("Xuy");
		    country.setRegion_id(3);
		    
		    JobHistory jobH = new JobHistory();
		    String fechaInicio = "27/02/2021";
		    String fechaTermino = "27/04/2021";
		    
		    SimpleDateFormat formatoFecha =new SimpleDateFormat("dd/MM/yy");
		    Date dateIni = formatoFecha.parse(fechaInicio);
		    Date dateT =formatoFecha.parse(fechaTermino);
		  
			//jobH.setId(new JobHistoryId(211,dateIni));
			
			jobH.setDepartment_id(80);
			jobH.setEnd_date(dateT);
			jobH.setJob_id("IT_PROG");
			
			JobHistoryId id = new JobHistoryId(211,dateIni);
			
			
			
			//repo.findByLastName("King");
			//repo.findByLastNameOrFirstName("King", "Lex");
			//repo.findByEmail("Sking");
			//repo.findByFirstnameEndsWith("Lex");
			
		
		/*	
			for(Employees e :repo.findByLastNameOrFirstName("King", "Lex") ) {
				System.out.println("Nombre o apellido "+e.toString());
		    }
			
			for(Employees e :repo.findByLastName("King") ) {
				System.out.println("por apellido "+e.toString());
		    }
			
			for(Employees e :repo.findByEmail("Sking")) {
				System.out.println("email "+e.toString());
		    }
			
			for(Employees e :repo.findByFirstnameEndsWith("ex")) {
				System.out.println("que contengan "+e.toString());
		    }*/
		    	
		    //System.out.println(serviceD.actualizar(300,dep));
		    // System.out.println(serviceD.borrar(310));
		    // System.out.println(serviceD.guardar(dep));
		    //System.out.println(serviceD.buscar());
			
		    //System.out.println(serviceE.buscar());
			//System.out.println(serviceE.guardar(emple));
			//System.out.println(serviceE.actualizar(211,emple));
		    //System.out.println(serviceE.borrar(236));
			
		    //System.out.println(serviceL.buscar());
		    //System.out.println(serviceL.guardar(location));
		   // System.out.println(serviceL.borrar(3300));
		   //System.out.println(serviceL.actualizar(3400,location));
		    
		   //System.out.println(serviceR.guardar(region));
		    //System.out.println(serviceR.actualizar(region,9));
		    //System.out.println(serviceR.borrar(9));
		    //System.out.println(serviceR.buscar());
		    
		    //System.out.println(serviceP.buscar());
		    //System.out.println(serviceP.guardar(phone));
		    //System.out.println(serviceP.actualizar(phone, 1));
		   // System.out.println(serviceP.borrar(1));
		    
		   // System.out.println(serviceJ.guardar(job));
		   // System.out.println(serviceJ.actualizar("PR", job));
		   // System.out.println(serviceJ.buscar());
		   // System.out.println(serviceJ.borrar("PR"));
		    
		    //System.out.println(serviceC.buscar());
		   // System.out.println(serviceC.guardar(country));
		    //System.out.println(serviceC.actualizar(country, "NO"));
		   // System.out.println(serviceC.borrar("NO"));
		    
		   // System.out.println(serviceJH.buscar());
		   //System.out.println(serviceJH.guardar(jobH));
			//System.out.println(serviceJH.borrar(jobH));
			//System.out.println(serviceJH.actualizar(id,jobH));
		    
	}
	
}	
	
	
	
	
	

