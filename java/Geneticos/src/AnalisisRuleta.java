
public class AnalisisRuleta implements IEstrategiaAnalisis {

	public void analizar(Cromosoma[] cromosomas) {
		int ruleta;
		for(int i=0;i<10;i++){
			ruleta = (int) Math.round(cromosomas[i].getfFitness()*100);
			cromosomas[i].setRuleta(ruleta);
		}
	}

}
