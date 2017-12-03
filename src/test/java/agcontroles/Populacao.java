package agcontroles;

import agbeans.Disponibilidade;
import agbeans.Horario;
import agbeans.Professor;

public class Populacao {
	private Horario[] individuos;
    private int tamPopulacao;
        
    //cria uma popula��o com indiv�duos aleat�ria
    public Populacao(int numGenes, int tamPop) {
        tamPopulacao = tamPop;
        individuos = new Horario[tamPop];
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = new Horario(numGenes);
        }
        ordenaPopulacao();
    }

    //cria uma popula��o com indiv�duos sem valor, ser� composto posteriormente
    public Populacao(int tamPop) {
        tamPopulacao = tamPop;
        individuos = new Horario[tamPop];
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = null;
        }
    }    

    //!!! teste 
    public void imprimePopulacao(){
    	int i = 1;
    	for(Horario individuo :individuos){
			System.out.println("Individuo "+i+ "  - Aptid�o:"+individuo.getAptidao());
    		for (Professor prof: individuo.getGenes()){
    			String dias ="";
    			for(Disponibilidade dia: prof.getDiasDisponivel()){
    				if(dias.equals("")){
        				dias += dia;    					
    				}else{
    					dias += ", "+dia;
    				}
    			}
    			System.out.println("\t"+prof.getNome()+" - "+prof.getDisciplinaAtual()+" - Disp.: "+dias);
    		}
    		i++;
    	}
    }

    //coloca um indiv�duo em uma certa posi��o da popula��o
    public void setIndividuo(Horario individuo, int posicao) {
        individuos[posicao] = individuo;
    }

    //coloca um indiv�duo na pr�xima posi��o dispon�vel da popula��o
    public void setIndividuo(Horario individuo) {
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }

    //verifoca se algum indiv�duo da popula��o possui a solu��o
    public boolean temSolucao(int solucao) {
    	//solu��o � o numero max de aptidao
    	for (int j = 0; j < individuos.length; j++) {
            if (individuos[j].getAptidao() == solucao) {
            	return true;
                //break;
            }
        }
    	/*Individuo i = null;
        for (int j = 0; j < individuos.length; j++) {
            if (individuos[j].getGenes().equals(solucao)) {
                i = individuos[j];
                break;
            }
        }
        if (i == null) {
            return false;
        }
        return true;
        */
        return false;
    }

    //ordena a popula��o pelo valor de aptid�o de cada indiv�duo, do maior valor para o menor, assim se eu quiser obter o melhor indiv�duo desta popula��o, acesso a posi��o 0 do array de indiv�duos
    public void ordenaPopulacao() {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < individuos.length - 1; i++) {
                if (individuos[i].getAptidao() < individuos[i + 1].getAptidao()) {
                    Horario temp = individuos[i];
                    individuos[i] = individuos[i + 1];
                    individuos[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }

    //n�mero de indiv�duos existentes na popula��o
    public int getNumIndividuos() {
        int num = 0;
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] != null) {
                num++;
            }
        }
        return num;
    }

    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public Horario getIndivduo(int pos) {
        return individuos[pos];
    }
}
