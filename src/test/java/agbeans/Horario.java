package agbeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import agservicos.DisponibilidadeServ;
import agcontroles.Algoritimo;

public class Horario {

	private Professor[] genes;
    private int aptidao = 0;
    private int[] genesAptos = new int[10];
    
    //gera um indivíduo aleatório
	public Horario(int numGenes){
		genes = new Professor[numGenes];
		
		Arrays.fill(genesAptos, 0);
        Random r = new Random();
        
        ArrayList<Professor> colecaoGenes = Algoritimo.getColecaoGenes();
        
        for (int i = 0; i < numGenes; i++) {
            genes[i] = colecaoGenes.get(r.nextInt(colecaoGenes.size()));//   += caracteres.charAt(r.nextInt(colecaoGenes.length()));
        }
        
        geraAptidao();
	}
	
    //cria um indivíduo com os genes definidos
    public Horario(Professor[] genes) {    
        this.genes = genes;
        
        Random r = new Random();
        //se for mutar, cria um gene aleatório
        if (r.nextDouble() <= Algoritimo.getTaxaDeMutacao()) {
        	ArrayList<Professor> colecaoGenes = Algoritimo.getColecaoGenes();
            Professor[] geneNovo = new Professor[genes.length];
            int posAleatoria = r.nextInt(genes.length);
            for (int i = 0; i < genes.length; i++) {
                if (i==posAleatoria){
                    geneNovo[i] = colecaoGenes.get(r.nextInt(colecaoGenes.size()));//   caracteres.charAt(r.nextInt(caracteres.length()));
                }else{
                    geneNovo[i] = genes[i];
                }                
            }
            this.genes = geneNovo;   
        }
        geraAptidao();
    }

    //gera o valor de aptidão, será calculada pelo número de bits do gene iguais ao da solução
    private void geraAptidao() {
    	/*
    	 * condições a serem analisadas
    	 * - professor não pode repetir * no caso 1, depois ira poder repetir 2 vezes e com mesma materia
    	 * - a materia nao pode repetir 
    	 * - o individuo deve respeitar o dia disponivel
    	 * 
    	 * Versao 2
    	 * Condicoes a serem analisadas  (10 horarios, com 2 horarios dia)
    	 * - disponibilidade do dia do prof (ok)
    	 * - materia repetida e de  mesmo professor
    	 * - impossibilitar prof repatido em varias materias 
    	 * - impossibilitar prof no mesmo dia
    	 * 
    	 * */

    	
    	DisponibilidadeServ servDisponibilidade = new DisponibilidadeServ();
    	Boolean disponivel;
    	Boolean disciplina;
    	Boolean prof;
    	//int repDisciplina;
    	int repProf;
    	String nomeI, nomeB;
    	Disciplina discplinaI, disciplinaB;
		    	
    	Professor[] genes = this.genes;
    	
    	//limpa aptidoes anteriores
    	//for (int i = 0; i< genes.length;i++){
    	//limpa aptidao
    	Arrays.fill(genesAptos, 0);
    	//}
		this.aptidao = 0;  
		
    	for (int posicao = 0; posicao< this.genes.length;posicao++){
    		//System.out.println("\tPosição: "+posicao);
    		//this.genes[posicao].obs += " Posição:"+posicao;
    		
    		//verifica se esta disponivel no diaa
    		// nota: nesse primeiro exemplo i+1 = dia da semana pois numSoluçao é 5 ou seja de 1 a 5 é segunda a sexta
    		 
    		disponivel = false;
    		
    		//pega os dias disponiveis do professor gene
    		ArrayList<Disponibilidade> diasDisponivel = genes[posicao].getDiasDisponivel();
    		
    		//analisa o dia da semana pela posição do array, ex 0 e 1 é segunda  4 e 5 = quarta, 2 horarios cada dia
    		int hoje = 0;
    		hoje = servDisponibilidade.getDiaAtual(posicao);
    		
    		for(Disponibilidade dia: diasDisponivel){    			
    			if(hoje == dia.getCodigo()){
        			disponivel = true;
        			break;
        		}
    		}

    		//---em analise --------------------------------------------------------------------------------------###########################################  4
    		//!! em analise se compativel
    		//verifica se disciplina não está repetida se disponivel senão nem verifica
    		//traduzindo 0 = ha 1disciplina(erro), 1 ou 2 = disciplina repetida 2 vezes(ok), >2 = disciplina repetida mais de 2 vezes (Erro)
    		//materia repetida e de  mesmo professor
    		
    		disciplina = true;
    		prof = true; 
    		//repDisciplina = 0;
    		repProf = 0;
    		
    		if (disponivel){		//se prof não disponivel nem olha disciplinas
    			for(int b = 0;b<posicao;b++){
    				//analisa professor
    				nomeI = genes[posicao].getNome();
    				nomeB = genes[b].getNome();
    				
    				discplinaI = genes[posicao].getDisciplinaAtual();
    				disciplinaB = genes[b].getDisciplinaAtual();
    				
    				if(nomeI.equals(nomeB)){ //parte mesmo professor
    					//analisa disciplina
    					if(discplinaI == disciplinaB){
    						//repDisciplina ++;
        					repProf ++;
    					}else{
    						if(genesAptos[b]== 1){ 
    							prof = false;
    						}
    						
    					}
    					
    					//invalidar se for no mesmo dia
    					if((posicao%2 == 1) && (posicao-b == 1)){
    						prof = false;
    						break;
    					}
    					
    				}else{		//parte professor diferente
    					//analisa disciplina
    					if(discplinaI == disciplinaB){
    						//verifica se outro professor(gene) esta apto para a disciplina atual, caso esteja o prof verificado(i) não pode ser apto para essa disciplina
    						if(genesAptos[b] == 1){ 
    							disciplina = false;
    							break;
    						}
    						//repDisciplina ++;
    					}
    					
    				}
    			}
    			
    			//verifica se professor+disciplina repetiu mais de 2 vezes (prof verificado não é rechecado)
    			if (repProf > 1){
					prof = false;
				}
    		}    
    		
    		//analise final de resultados separados
    		if (disponivel && disciplina && prof){
    			aptidao++;
    			genesAptos[posicao] = 1;
    		}

    	} // for posicao
    } 
    // fim geraaptidao############################################################################################################################################

    public int getAptidao() {
        return aptidao;
    }
    
    public Professor[] getGenes() {
        return genes;
    }
    public String imprimeGenes(){
    	String texto = "";
    	String textApto = "";
    	int i = 0;
    	DisponibilidadeServ dispServ = new DisponibilidadeServ();
    	
    	for (Professor prof: genes){
			String dias ="";
			for(Disponibilidade dia: prof.getDiasDisponivel()){
				if(dias.equals("")){
    				dias += dia;    					
				}else{
					dias += ", "+dia;
				}
			}
			textApto = genesAptos[i]==1?" - OK ":" - Não";
			
			if (texto.equals("")){
				texto += "\t"+AjustaTamanhoString(dispServ.getDiaAtualStr(i),7)+textApto+" - "+ AjustaTamanhoString(prof.getNome(),10)+" - "+ 
						AjustaTamanhoString(prof.getDisciplinaAtual().toString(),8)+" - Disp.: "+dias;// + prof.obs;
			}else{
				texto += "\n\t"+AjustaTamanhoString(dispServ.getDiaAtualStr(i),7)+textApto+" - "+AjustaTamanhoString(prof.getNome(),10)+" - "+
						AjustaTamanhoString(prof.getDisciplinaAtual().toString(),8)+" - Disp.: "+dias;// + prof.obs;
			}	
			
			i++;
		}
    	return texto;
    }
    
    private String AjustaTamanhoString(String str, int tamanho){
    	String texto = "";
    	if(tamanho <= str.length()){
    		texto = str;
    	}else{
    		texto = str;
    		for(int i = str.length();i<tamanho;i++){
    			texto += " ";
    		}
    	}
    	
    	return texto;
    }
}
