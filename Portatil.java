/**
 * 
 * @author jaimejp
 * @version 1.0	
 *
 */
public class Portatil extends Ordenador {
	private double peso;
	private int autonomia;
	public Portatil() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param ref
	 * @param procesador
	 * @param memoria
	 */
	public Portatil(String ref, String procesador, String memoria) {
		super(ref, procesador, memoria);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param ref
	 * @param procesador
	 * @param memoria
	 * @param peso
	 * @param autonomia
	 */
	/**
	 * 
	 * @param ref
	 * @param procesador
	 * @param memoria
	 * @param peso
	 * @param autonomia
	 */
	public Portatil(String ref, String procesador, String memoria, double peso, int autonomia) {
		super(ref, procesador, memoria);
		this.peso = peso;
		this.autonomia = autonomia;
	}
	/**
	 * 
	 * @return
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * 
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * 
	 * @return
	 */
	public int getAutonomia() {
		return autonomia;
	}
	/**
	 * 
	 * @param autonomia
	 */
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	@Override
	public String toString() {
		return "Portatil [peso=" + peso + ", autonomia=" + autonomia + " Ref=" + getRef() + " Procesador="
				+ getProcesador() + " Memoria=" + getMemoria()+"]";
	}
	/**
	 * 
	 * @return
	 */
	public double calcular() {
		double precio;
		if(peso<2.00) {
			precio=1500-(peso*0.2);
		}
		else {
			precio=1500-(peso*0.1);
		}
		return precio;
	}
	
	
	
}
