/**
 * 
 * @author jaimejp
 * @version 1.0	
 */
public class Sobremesa extends Ordenador {
	private String velocidad;
	private int tamaño;
	public Sobremesa() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param ref
	 * @param procesador
	 * @param memoria
	 */
	public Sobremesa(String ref, String procesador, String memoria) {
		super(ref, procesador, memoria);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param ref
	 * @param procesador
	 * @param memoria
	 * @param velocidad
	 * @param tamaño
	 */
	public Sobremesa(String ref, String procesador, String memoria, String velocidad, int tamaño) {
		super(ref, procesador, memoria);
		this.velocidad = velocidad;
		this.tamaño = tamaño;
	}
	/**
	 * 
	 * @return
	 */
	public String getVelocidad() {
		return velocidad;
	}
	/**
	 * 
	 * @param velocidad
	 */
	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * 
	 * @return
	 */
	public int getTamaño() {
		return tamaño;
	}
	/**
	 * 
	 * @param tamaño
	 */
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	@Override
	public String toString() {
		return "Sobremesa [velocidad=" + velocidad + ", tamaño=" + tamaño + " Ref=" + getRef()
				+ " Procesador=" + getProcesador() + " Memoria=" + getMemoria() + "]";
	}
	/**
	 * 
	 * @return
	 */
	public double calcular() {
		double precio=0;
		double media=0;
		String velocidades[] = {"2.1Ghz","3.1Ghz","4.1Ghz","4.8Ghz","4.7Ghz"};
		double precios[][] = {
				{345.56,419.89,567.23},
				{367.99,429.71,567.99},
				{389.34,424.44,598.67},
				{401.22,549.90,679.98},
				{405.21,839.25,969.89}
				};
		for(int i=0;i<precios.length;i++) {
			for(int j=0;j<precios[i].length;j++) {
				if(velocidad.equalsIgnoreCase(velocidades[i])){
					precio=precio+precios[i][j];
				}
			}
		}
		media=precio/3;
		return media;
		
	}
	

}
