package acw2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import acw2.consume.WsConsumer;
import acw2.domain.Cidade;
import acw2.domain.dto.CidadeDto;
import acw2.repository.CidadeRepository;

@Service
public class CidadeService extends AbstractService<Cidade>{
	
	@Autowired
	private CidadeRepository repository;

	public List<Cidade> list() {
		return  (List<Cidade>) repository.findAll();
	}
	
	public Cidade getById(Long id){
		return (Cidade) repository.findOne(id);
	}
	
	public Long save(Cidade curso){
		Cidade obj = null;
		obj = repository.save(curso);
		if (obj != null){ 
			return obj.getId();
		}else{
			return 0L;
		}
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
	public List<Cidade> finds(List<Long> ids) {
		return  (List<Cidade>) repository.findAll(ids);
	}
	
	public ArrayList<Cidade> consumirCidades(){
		WsConsumer ws = new WsConsumer();

		try {
			String response = ws.sendGet("http://www.geonames.org/childrenJSON?geonameId=3393098");//"http://138.197.98.219/cidades.json"); 
			System.out.println("retorno resposta consumo:"+response);
			
			Gson gson = new Gson();
			
			//ArrayList<Cidade> cidades = gson.fromJson(response, new TypeToken<Cidade>(){}.getType());
			//ArrayList<CidadeDto> cidades = gson.fromJson(response, new TypeToken<ArrayList<CidadeDto>>(){}.getType());
			CidadeDto csm = gson.fromJson(response, new TypeToken<CidadeDto>(){}.getType());
			salvarConsumo(csm.getGeonames());
			return csm.getGeonames();
			//System.out.println(cidade.getCidade());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void salvarConsumo(ArrayList<Cidade> cidades){
		
		ArrayList<Cidade> citysTemp = (ArrayList<Cidade>) repository.findAll();
		Boolean vInsert = true;
		
		for (Cidade cidade : cidades) {
			vInsert = true;
			
			for (Cidade city : citysTemp) {
				if (cidade.getGeonameId().longValue() == city.getGeonameId().longValue()){
					cidade.setId(city.getId());
					
					if (cidade.getAdminName1().equals(city.getAdminName1())
						& cidade.getPopulation().longValue() == city.getPopulation().longValue()
						& cidade.getCountryName().equals(city.getCountryName())
						& cidade.getLat().equals(city.getLat())
						& cidade.getLng().equals(city.getLng())
						& cidade.getName().equals(city.getName())
					){
						vInsert = false;
						System.out.println("Cidade já existe:"+cidade.toString());
					}
					
					break;
				}
			}
			
			/*
			if (citysTemp.contains(cidade)){
				vInsert = false;
				System.out.println("Cidade já existe:"+cidade.toString());
			}
			*/
			if (vInsert){
				repository.save(cidade);
				System.out.println("Salvo cidade:"+cidade.toString());
			}
		}
		
	}
	
	/*
	public List<CursoDto> finds2(List<Long> ids) {
		List<CursoDto> listaCursoDto = new ArrayList<CursoDto>();
		
		for (Curso curso : (List<Curso>) repository.findAll(ids)){
			CursoDto cursoDto = new CursoDto();
			BeanUtils.copyProperties(curso, cursoDto);
			
			cursoDto.setPeriodos(null);
			
			//cursoDto.setProfessores(null);
			//cursoDto.setDisciplinas(null);
			listaCursoDto.add(cursoDto);
			
		}
		
		return listaCursoDto;		
		//return  (List<Curso>) repository.findAll(ids);
	}*/
	
}
