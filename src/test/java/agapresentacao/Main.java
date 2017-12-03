package agapresentacao;

import agcontroles.Algoritimo;
import agcontroles.Populacao;
import agcontroles.RepositorioProfessor;

public class Main {

	public static void main(String[] args) {
		
		RepositorioProfessor professores = new RepositorioProfessor();
		professores.CriaColecaoFullProf();
		//professores.ImprimeColFullProf();
		//professores.CriaColecaoEspecificaProf();
		//professores.ImprimeColEspecificaProf();
		
		//Define os posiveis genes
        Algoritimo.setColecaoGenes(professores.CriaColecaoEspecificaProf());
        
        //taxa de crossover de 60% = 0.6
        Algoritimo.setTaxaDeCrossover(0.6);
        //taxa de muta��o de 3% 0.3
        Algoritimo.setTaxaDeMutacao(0.3);
        //elitismo
        boolean elitismo = true;
        //tamanho da popula��o
        int tamPop = 1000;
        //numero m�ximo de gera��es
        int numMaxGeracoes = 1000000;
        //define o n�mero de genes do indiv�duo baseado na solu��o
        int numGenes = 10;

        //cria a primeira popula��o aleat�ria
        Populacao populacao = new Populacao(numGenes, tamPop);
        
        //System.out.println(populacao.getIndivduo(0).imprimeGenes());
        
        boolean temSolucao = false;
        int geracao = 0;
        
        //teste
        //populacao.imprimePopulacao();
        
        //verifica se teve solu��o na gera��o inicial
        temSolucao = populacao.temSolucao(numGenes);        
				
		while (!temSolucao && geracao < numMaxGeracoes) {
			geracao++;
            
			//cria nova populacao
            populacao = Algoritimo.novaGeracao(populacao, elitismo);
            
            System.out.println("Gera��o " + geracao + " | \n" + populacao.getIndivduo(0).imprimeGenes() + "\n\t (Aptid�o: " + populacao.getIndivduo(0).getAptidao() + ")");
            
            //verifica se teve solu��o na gera��o inicial
            temSolucao = populacao.temSolucao(numGenes); 
            
		}
		
		if (geracao == numMaxGeracoes) {
            System.out.println("\nN�mero Maximo de Gera��es  \n" + populacao.getIndivduo(0).imprimeGenes() + "\n\t(Aptid�o: " + populacao.getIndivduo(0).getAptidao() + ")");
        }

        if (temSolucao) {
            System.out.println("\nEncontrado resultado na gera��o " + geracao + " | \n" + populacao.getIndivduo(0).imprimeGenes() + "\n\t (Aptid�o: " + populacao.getIndivduo(0).getAptidao() + ")");
        }
        
        /*System.out.println("---- Mostrando toda a popula��o final ------------###########=======");
        for(int i = 0; i < tamPop; i++){
        	System.out.println("\nNum popula��o " + i + " | \n" + populacao.getIndivduo(i).imprimeGenes() + "\n\t (Aptid�o: " + populacao.getIndivduo(i).getAptidao() + ")");
    	}*/
	}
	
	
	

}
