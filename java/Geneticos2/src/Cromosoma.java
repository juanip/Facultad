public class Cromosoma {

	private double objetivo;
	private double fitness;
	private int ruleta;
	private long decimal = 0;
	private int generacion;
	private Gen[] genes;
	
	Cromosoma(int generacion, Gen[] genes) {
		this.setGenes(genes);
		this.setGeneracion(generacion);
		this.setDecimal();
		this.setObjetivo();		
	}
	
	private void setDecimal() {
		for(int i=0;i<30;i++){
			this.decimal += genes[i].getDecimal();
		}
	}
	
	private void setObjetivo() {
		this.objetivo = OpGeneticos.calcObjetivo(this.getDecimal());
	}
	
	public Gen getGen(int indice) {
		return this.getGenes()[indice];
	}
	
	public void mutar(int indice) {
		this.getGen(indice).mutar();
		this.setDecimal();
		this.setObjetivo();
	}
	
	//getters & setters 
	
	public void setGenes(Gen[] genes) {
		this.genes = genes;
	}
	
	public Gen[] getGenes() {
		return this.genes;
	}
	
	public double getObjetivo() {
		return objetivo;
	}	
	
	public double getFitness() {
		return fitness;
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public int getRuleta() {
		return ruleta;
	}
	
	public void setRuleta(int ruleta) {
		this.ruleta = ruleta;
	}
	
	public long getDecimal() {
		return decimal;
	}
	
	public int getGeneracion() {
		return generacion;
	}
	
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}	
}
