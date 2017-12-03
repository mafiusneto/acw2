package agcontroles;

import java.util.ArrayList;

import agbeans.Disciplina;
import agbeans.Disponibilidade;
import agbeans.Professor;

public class RepositorioProfessor {
	
	private ArrayList<Professor> colecaoFullProf;
	private ArrayList<Professor> colecaoEspecificaProf;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<Disponibilidade> disponibilidade; 
	
	//gera��o de dados para analise
	public void CriaColecaoFullProf(){
		colecaoFullProf  = new ArrayList<Professor>();
		
		//Preenche professores: Ricardo Roberto, Alisson, Bruno, Fujioka, Daniel, Humberto		
		//dados Ricardo Roberto
		disciplinas = new ArrayList<Disciplina>();
		disponibilidade = new ArrayList<Disponibilidade>();
		
		disciplinas.add(Disciplina.APS);
		disciplinas.add(Disciplina.GP);
		disciplinas.add(Disciplina.MLPA);
		
		disponibilidade.add(Disponibilidade.SEGUNDA);
		disponibilidade.add(Disponibilidade.QUARTA);
		
		colecaoFullProf.add(new Professor("Ricardo", disciplinas, disponibilidade));
		
		//dados Alisson
		disciplinas = new ArrayList<Disciplina>();
		disponibilidade = new ArrayList<Disponibilidade>();
		
		disciplinas.add(Disciplina.MLPA);
		disciplinas.add(Disciplina.TADI);
		
		disponibilidade.add(Disponibilidade.SEGUNDA);
		disponibilidade.add(Disponibilidade.TERCA);
		
		colecaoFullProf.add(new Professor("Alisson", disciplinas, disponibilidade));
		
		//dados Bruno
		disciplinas = new ArrayList<Disciplina>();
		disponibilidade = new ArrayList<Disponibilidade>();
		
		disciplinas.add(Disciplina.REDES);
		
		disponibilidade.add(Disponibilidade.QUARTA);
		disponibilidade.add(Disponibilidade.QUINTA);
		disponibilidade.add(Disponibilidade.SEXTA);
		
		colecaoFullProf.add(new Professor("Bruno", disciplinas, disponibilidade));
		
		//dados Fujioka
		disciplinas = new ArrayList<Disciplina>();
		disponibilidade = new ArrayList<Disponibilidade>();
		
		disciplinas.add(Disciplina.MLPA);
		disciplinas.add(Disciplina.TADI);
		
		disponibilidade.add(Disponibilidade.SEGUNDA);
		disponibilidade.add(Disponibilidade.TERCA);
		disponibilidade.add(Disponibilidade.QUARTA);
		
		colecaoFullProf.add(new Professor("Fujioka", disciplinas, disponibilidade));
		
		//dados Daniel
		disciplinas = new ArrayList<Disciplina>();
		disponibilidade = new ArrayList<Disponibilidade>();
		
		disciplinas.add(Disciplina.MLPA);
		disciplinas.add(Disciplina.PDW);
		
		disponibilidade.add(Disponibilidade.SEGUNDA);
		disponibilidade.add(Disponibilidade.TERCA);
		disponibilidade.add(Disponibilidade.QUARTA);
		disponibilidade.add(Disponibilidade.QUINTA);
		disponibilidade.add(Disponibilidade.SEXTA);
		
		colecaoFullProf.add(new Professor("Daniel", disciplinas, disponibilidade));
		
		//dados Humberto
		disciplinas = new ArrayList<Disciplina>();
		disponibilidade = new ArrayList<Disponibilidade>();
		
		disciplinas.add(Disciplina.GP);
		disciplinas.add(Disciplina.APS);
		
		disponibilidade.add(Disponibilidade.QUINTA);
		disponibilidade.add(Disponibilidade.SEXTA);
		
		colecaoFullProf.add(new Professor("Humberto", disciplinas, disponibilidade));
	}

	/*
	 * Cria��o de biblioteca genes, baseado na cole��o full de professores */
	public ArrayList<Professor> CriaColecaoEspecificaProf(){
		colecaoEspecificaProf = new ArrayList<Professor>();
		
		for (Professor p: colecaoFullProf){
			for(Disciplina d: p.getDisciplinas()){
				colecaoEspecificaProf.add(new Professor(p.getNome(), d, p.getDiasDisponivel()));
			}
		}
		return colecaoEspecificaProf;
	}
	
	public void ImprimeColFullProf(){
		for (Professor p : getColecaoFullProf()){
		 	p.Imprime();
		}
	}
	
	public void ImprimeColEspecificaProf(){
		for (Professor p : getColecaoEspecificaProf()){
		 	p.Imprime();
		}
	}
	
	public ArrayList<Professor> getColecaoFullProf() {
		return colecaoFullProf;
	}

	public void setColecaoFullProf(ArrayList<Professor> colecaoFullProf) {
		this.colecaoFullProf = colecaoFullProf;
	}

	public ArrayList<Professor> getColecaoEspecificaProf() {
		return colecaoEspecificaProf;
	}

	public void setColecaoEspecificaProf(ArrayList<Professor> colecaoEspecificaProf) {
		this.colecaoEspecificaProf = colecaoEspecificaProf;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public ArrayList<Disponibilidade> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(ArrayList<Disponibilidade> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}
