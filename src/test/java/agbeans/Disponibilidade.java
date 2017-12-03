package agbeans;

public enum Disponibilidade {
		SEGUNDA(1), TERCA(2), QUARTA(3), QUINTA(4), SEXTA(5), SABADO(6), DOMINGO(7);
		
		public int codigo;
		
		Disponibilidade(int c) {
			codigo = c;
		}
		public int getCodigo(){
			return codigo;
		}
}
