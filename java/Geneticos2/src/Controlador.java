
public class Controlador {

	public static void main(String[] args) {
		Cromosoma[] cromosomas = new Cromosoma[10];
		Cromosoma[] ruleta;
		int sumRuleta;
		int indiceRuleta;
		int padre;
		int madre;
		int corte;
		Cromosoma[] hijos;
		
		//generacion inicial
		for(int i=0;i<10;i++) {
			Gen[] genes = new Gen[30];
			
			for(int j=0;j<30;j++) {
				genes[j] = new Gen(j);
			}
			
			cromosomas[i] = new Cromosoma(i, genes);
		}
		
		//analisis
		
		//calcular fitness
		for(int i=0;i<10;i++) {
			cromosomas[i].setFitness(OpGeneticos.calcFitness(cromosomas, i));
		}
		
		sumRuleta = 0;
		
		//calcular ruleta de cada cromosoma
		for(int i=0;i<10;i++) {
			cromosomas[i].setRuleta(OpGeneticos.calcRuleta(cromosomas[i]));
			sumRuleta += cromosomas[i].getRuleta();
		}
		
		ruleta = new Cromosoma[sumRuleta];
		indiceRuleta = 0;
		
		//rellenar ruleta
		for(int i=0;i<sumRuleta;i++) {
			for(int j=0;j<cromosomas[i].getRuleta();j++) {
				ruleta[indiceRuleta] = cromosomas[i];
			}
		}
		
		hijos = new Cromosoma[10];
		
		//parir proxima generacion
		//TODO: implementar chance de cruza
		for(int i=0;i<5;i++) {
			padre = (int)Math.round(Math.random() * sumRuleta);
			madre = (int)Math.round(Math.random() * sumRuleta);
			corte = (int)Math.round((Math.random() * 29) + 1);
			
			hijos[i*2] = OpGeneticos.crossover(ruleta[padre], ruleta[madre], corte);
			hijos[(i*2)+1] = OpGeneticos.crossover(ruleta[madre], ruleta[padre], corte);
			OpGeneticos.mutar(hijos[i*2]);
			OpGeneticos.mutar(hijos[(i*2)+1]);
		}		
	}
}
