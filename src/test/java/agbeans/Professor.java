package agbeans;

import java.util.ArrayList;

public class Professor {
	
	private String nome;
	private Disciplina disciplinaAtual;
	private ArrayList<Disciplina> disciplinas= new ArrayList<Disciplina>();
	private ArrayList<Disponibilidade> diasDisponivel = new ArrayList<Disponibilidade>();
	
	public Professor (String nome, Disciplina disciplinaAtual, ArrayList<Disponibilidade> diasDisponivel){
		setNome(nome);
		setDisciplinaAtual(disciplinaAtual);
		setDiasDisponivel(diasDisponivel);
	}
	
	public Professor (String nome, ArrayList<Disciplina> disciplinas, ArrayList<Disponibilidade> diasDisponivel){
		setNome(nome);
		setDisciplinas(disciplinas);
		setDiasDisponivel(diasDisponivel);
	}
	
	public void Imprime(){
		System.out.println("#----------------------------------------------#");
		System.out.println("Professor: "+getNome());
		System.out.println("Disciplinas: ");
		for(Disciplina d: disciplinas){
			System.out.println("\t"+d);
		}
		System.out.println("Dias Disponivel: ");
		for(Disponibilidade d: diasDisponivel){
			System.out.println("\t"+d);
		}
		System.out.println("Disciplina atual: "+getDisciplinaAtual());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina getDisciplinaAtual() {
		return disciplinaAtual;
	}

	public void setDisciplinaAtual(Disciplina disciplinaAtual) {
		this.disciplinaAtual = disciplinaAtual;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public ArrayList<Disponibilidade> getDiasDisponivel() {
		return diasDisponivel;
	}

	public void setDiasDisponivel(ArrayList<Disponibilidade> diasDisponivel) {
		this.diasDisponivel = diasDisponivel;
	}
	
	
}
