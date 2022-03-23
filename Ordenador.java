import java.io.Serializable;
/**
 * 
 * @author jaimejp
 * @version 1.0	
 */
public class Ordenador implements Serializable{
	private String ref;
	private String procesador;
	private String memoria;
	public Ordenador() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param ref
	 * @param procesador
	 * @param memoria
	 */
	public Ordenador(String ref, String procesador, String memoria) {
		super();
		this.ref = ref;
		this.procesador = procesador;
		this.memoria = memoria;
	}
	/**
	 * 
	 * @return
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * 
	 * @param ref
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}
	/**
	 * 
	 * @return
	 */
	public String getProcesador() {
		return procesador;
	}
	/**
	 * 
	 * @param procesador
	 */
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	/**
	 * 
	 * @return
	 */
	public String getMemoria() {
		return memoria;
	}
	/**
	 * 
	 * @param memoria
	 */
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	

}
