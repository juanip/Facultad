
public class OpGeneticos {

	public static double calcObjetivo(long decimal) {
		return decimal / (Math.pow(2, 30) - 1);
	}
	
	public static double calcFitness(Cromosoma[] cromosomas, int indice) {
		double sumObjetivos = 0;
		
		for(int i=0;i<10;i++){
			sumObjetivos += cromosomas[i].getObjetivo();
		}
		
		return cromosomas[indice].getObjetivo() / sumObjetivos;
	}
	
	public static int calcRuleta(Cromosoma cromosoma) {
		int ruleta = (int)Math.round(cromosoma.getFitness() * 100);
		return ruleta == 0 ? 1 : ruleta;
	}
	
	public static Cromosoma crossover(Cromosoma padre, Cromosoma madre, int corte) {
		Gen[] genes = new Gen[30];
		
		for(int i=0;i<corte;i++) {
			genes[i] = padre.getGen(i);
		}
		
		for(int i=corte;i<30;i++) {
			genes[i] = madre.getGen(i);
		}
		
		return new Cromosoma(padre.getGeneracion()+1, genes);
	}

	public static void mutar(Cromosoma cromosoma) {
		cromosoma.mutar((int)Math.round(Math.random()*30));
	}
}
