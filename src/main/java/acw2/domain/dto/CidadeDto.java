package acw2.domain.dto;

import java.util.ArrayList;

import acw2.domain.Cidade;
import lombok.Data;

@Data
public class CidadeDto {

	public Long totalResultsCount;
	public ArrayList<Cidade> geonames;
}
