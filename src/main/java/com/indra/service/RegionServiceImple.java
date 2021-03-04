package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Regions;
import com.indra.repository.RegionRepository;

@Service
public class RegionServiceImple implements RegionService {

	@Autowired
	private RegionRepository repoR;
	
	
	@Override
	public List<Regions> buscar() {
		/*Iterable<Regions> iter = repoR.findAll();
		for(Regions region: iter) {
			System.out.println(region.toString());
		}*/
		return (List<Regions>)repoR.findAll();
	}

	@Override
	public String borrar(int id) {
		try {
			repoR.deleteById(id);
		}catch(Exception e){
			return "Se borraron los registros correctamente";
		}
		return "No se borraron los registros";
	}

	@Override
	public String actualizar(Regions re, int id) {
		Optional<Regions> encontrarId = repoR.findById(id);
		
		if(encontrarId.isPresent()) {
			Regions region = encontrarId.get();
			region.setRegion_name(re.getRegion_name());
			repoR.save(region);
			return "Se realizaron los cambios correctamente";
		}
		return"No se realizaron los camnios";
	}

	@Override
	public String guardar(Regions region) {
		try {
			repoR.save(region);
			return "Se guardaron los datos correctamente";
		}catch(Exception e) {
			return "No se guardaron los cambios";
		}
		
	}

}
