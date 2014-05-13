
public class AnalisisFitness implements IEstrategiaAnalisis {

	public void analizar(Cromosoma[] cromosomas) {
		double sumaObjetivo = 0;
		
		for(int i=0;i<10;i++){
			sumaObjetivo += cromosomas[i].getfObjetivo();
		}
		
		for(int i=0;i<10;i++){
			cromosomas[i].setfFitness(cromosomas[i].getfObjetivo() / sumaObjetivo);
		}
	}

}
