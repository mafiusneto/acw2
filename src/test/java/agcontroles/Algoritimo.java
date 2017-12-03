package agcontroles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import agbeans.Horario;
import agbeans.Professor;
import lombok.Data;

public class Algoritimo {

	private static ArrayList<Horario> solucao;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    private static ArrayList<Professor> colecaoGenes; 
    
    public static Populacao novaGeracao(Populacao populacao, boolean elitismo) {
        Random r = new Random();
        
        //nova popula��o do mesmo tamanho da antiga
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

        //se tiver elitismo, mant�m o melhor indiv�duo da gera��o atual
        if (elitismo) {
            novaPopulacao.setIndividuo(populacao.getIndivduo(0));
        }

        //insere novos indiv�duos na nova popula��o, at� atingir o tamanho m�ximo
        while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {
            //seleciona os 2 pais por torneio
            Horario[] pais = selecaoTorneio(populacao);

            Horario[] filhos = new Horario[2];

            //verifica a taxa de crossover, se sim realiza o crossover, se n�o, mant�m os pais selecionados para a pr�xima gera��o
            if (r.nextDouble() <= taxaDeCrossover) {
                filhos = crossover(pais[1], pais[0]);
            } else {
                filhos[0] = new Horario(pais[0].getGenes());
                filhos[1] = new Horario(pais[1].getGenes());
            }

            //adiciona os filhos na nova gera��o
            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);
        }

        //ordena a nova popula��o
        novaPopulacao.ordenaPopulacao();
        return novaPopulacao;
    }
    
    public static Horario[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(3);

        //seleciona 3 indiv�duos aleat�riamente na popula��o
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));

        //ordena a popula��o
        populacaoIntermediaria.ordenaPopulacao();

        Horario[] pais = new Horario[2];

        //seleciona os 2 melhores deste popula��o
        pais[0] = populacaoIntermediaria.getIndivduo(0);
        pais[1] = populacaoIntermediaria.getIndivduo(1);

        return pais;
    }
    
    public static Horario[] crossover(Horario individuo1, Horario individuo2) {
        Random r = new Random();

        //sorteia o ponto de corte
        int pontoCorte1 = r.nextInt((individuo1.getGenes().length /2) -1) + 1;
        int pontoCorte2 = r.nextInt((individuo1.getGenes().length/2) -1) + individuo1.getGenes().length/2;

        Horario[] filhos = new Horario[2];

        //pega os genes dos pais
        Professor[] genePai1 = individuo1.getGenes();
        Professor[] genePai2 = individuo2.getGenes();

        Professor[] geneFilho1;
        Professor[] geneFilho2;
        
        ArrayList<Professor> arrayAdap = new ArrayList<Professor>();

        //realiza o corte, 
        arrayAdap.addAll(Arrays.asList(Arrays.copyOfRange(genePai1,0,pontoCorte1)));				//genePai1.substring(0, pontoCorte1);
        arrayAdap.addAll(Arrays.asList(Arrays.copyOfRange(genePai2,pontoCorte1,pontoCorte2)));		//genePai2.substring(pontoCorte1, pontoCorte2);
        arrayAdap.addAll(Arrays.asList(Arrays.copyOfRange(genePai1,pontoCorte2,genePai1.length)));	//genePai1.substring(pontoCorte2, genePai1.length());
        geneFilho1 = new Professor[arrayAdap.size()];
        geneFilho1 = arrayAdap.toArray(geneFilho1);
        
        arrayAdap = new ArrayList<Professor>();
        
        arrayAdap.addAll(Arrays.asList(Arrays.copyOfRange(genePai2,0,pontoCorte1)));				//geneFilho2 = genePai2.substring(0, pontoCorte1);
        arrayAdap.addAll(Arrays.asList(Arrays.copyOfRange(genePai1,pontoCorte1,pontoCorte2)));		//geneFilho2 += genePai1.substring(pontoCorte1, pontoCorte2);
        arrayAdap.addAll(Arrays.asList(Arrays.copyOfRange(genePai2,pontoCorte2,genePai1.length)));	//geneFilho2 += genePai2.substring(pontoCorte2, genePai2.length());
        geneFilho2 = new Professor[arrayAdap.size()];
        geneFilho2 = arrayAdap.toArray(geneFilho2);
        
        //cria o novo indiv�duo com os genes dos pais
        filhos[0] = new Horario(geneFilho1);
        filhos[1] = new Horario(geneFilho2);

        return filhos;
    }

	public static ArrayList<Horario> getSolucao() {
		return solucao;
	}

	public static void setSolucao(ArrayList<Horario> solucao) {
		Algoritimo.solucao = solucao;
	}

	public static double getTaxaDeCrossover() {
		return taxaDeCrossover;
	}

	public static void setTaxaDeCrossover(double taxaDeCrossover) {
		Algoritimo.taxaDeCrossover = taxaDeCrossover;
	}

	public static double getTaxaDeMutacao() {
		return taxaDeMutacao;
	}

	public static void setTaxaDeMutacao(double taxaDeMutacao) {
		Algoritimo.taxaDeMutacao = taxaDeMutacao;
	}

	public static ArrayList<Professor> getColecaoGenes() {
		return colecaoGenes;
	}

	public static void setColecaoGenes(ArrayList<Professor> colecaoGenes) {
		Algoritimo.colecaoGenes = colecaoGenes;
	}
    
    
}
