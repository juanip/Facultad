
public class ContextoAnalisis {
	
	private IEstrategiaAnalisis analisis;
	
	public ContextoAnalisis(IEstrategiaAnalisis analisis) {
		this.analisis = analisis;
	}

	public void analizar(Cromosoma[] cromosomas) {
		analisis.analizar(cromosomas);
	}
	
}
