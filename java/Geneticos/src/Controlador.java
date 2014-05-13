
public class Controlador {

	public static void main(String[] args) {

		Cromosoma[] cromosomas = new Cromosoma[10];
		int generacion = 0;
		
		for(int i=0; i<10;i++){
			Gen[] genes = new Gen[30];
			
			for(int j=0;j<30;j++){
				genes[j] = new Gen(j); 
			}
			
			cromosomas[i] = new Cromosoma(generacion,genes);
		}
		
		ContextoAnalisis analisisFitness = new ContextoAnalisis(new AnalisisFitness());
		analisisFitness.analizar(cromosomas);
		
		ContextoAnalisis analisisRuleta = new ContextoAnalisis(new AnalisisRuleta());
		analisisRuleta.analizar(cromosomas);
		
		
	}

}
