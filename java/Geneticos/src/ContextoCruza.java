
public class ContextoCruza {
	
	private IEstrategiaCruza cruza;
	
	ContextoCruza(IEstrategiaCruza cruza) {
		this.cruza = cruza;
	}
	
	public Cromosoma cruzar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		return this.cruza.cruzar(cromosoma1, cromosoma2);
	}
}
