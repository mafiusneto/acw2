package agservicos;

import agbeans.Disponibilidade;

public class DisponibilidadeServ {
	
	public int getDiaAtual(int posicao){
		int codDia;
		
		switch (posicao) {
			case 0:
				codDia = Disponibilidade.SEGUNDA.getCodigo();
				break;
			case 1:
				codDia =  Disponibilidade.SEGUNDA.getCodigo();
				break;
			case 2:
				codDia =  Disponibilidade.TERCA.getCodigo();
				break;
			case 3:
				codDia = Disponibilidade.TERCA.getCodigo();
				break;
			case 4:
				codDia = Disponibilidade.QUARTA.getCodigo();
				break;
			case 5:
				codDia = Disponibilidade.QUARTA.getCodigo();
				break;
			case 6:
				codDia = Disponibilidade.QUINTA.getCodigo();
				break;
			case 7:
				codDia = Disponibilidade.QUINTA.getCodigo();
				break;
			case 8:
				codDia = Disponibilidade.SEXTA.getCodigo();
				break;
			case 9:
				codDia = Disponibilidade.SEXTA.getCodigo();
				break;
			case 10:
				codDia = Disponibilidade.SABADO.getCodigo();
				break;
			case 11:
				codDia = Disponibilidade.SABADO.getCodigo();
				break;
			case 12:
				codDia = Disponibilidade.DOMINGO.getCodigo();
				break;
			case 13:
				codDia = Disponibilidade.DOMINGO.getCodigo();
				break;
			default:
				//deve gerar erro
				codDia = 0;
				break;
		}
		
		return codDia;		
	}

	public String getDiaAtualStr(int posicao){
		String codDia;
		
		switch (posicao) {
			case 0:
				codDia = Disponibilidade.SEGUNDA.toString();
				break;
			case 1:
				codDia =  Disponibilidade.SEGUNDA.toString();
				break;
			case 2:
				codDia =  Disponibilidade.TERCA.toString();
				break;
			case 3:
				codDia = Disponibilidade.TERCA.toString();
				break;
			case 4:
				codDia = Disponibilidade.QUARTA.toString();
				break;
			case 5:
				codDia = Disponibilidade.QUARTA.toString();
				break;
			case 6:
				codDia = Disponibilidade.QUINTA.toString();
				break;
			case 7:
				codDia = Disponibilidade.QUINTA.toString();
				break;
			case 8:
				codDia = Disponibilidade.SEXTA.toString();
				break;
			case 9:
				codDia = Disponibilidade.SEXTA.toString();
				break;
			case 10:
				codDia = Disponibilidade.SABADO.toString();
				break;
			case 11:
				codDia = Disponibilidade.SABADO.toString();
				break;
			case 12:
				codDia = Disponibilidade.DOMINGO.toString();
				break;
			case 13:
				codDia = Disponibilidade.DOMINGO.toString();
				break;
			default:
				//deve gerar erro
				codDia = "ERRO_DIA_STR";
				break;
		}
		
		return codDia;		
	}
}
