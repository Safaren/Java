/**
 * 
 */
package basico;

/**
 * @author 
 *
 */
public class rickyRubio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Datos personales
		
		String nombre = "Ricky";
		String apellido = "Rubio";
		int altura = 188;
		int edad = 31;
		
		// Datos  del equipo
		
		short dorsal = 13;
		String equipo = "Cavaliers";
		
		// Temporada 21-22
		
		float puntosPartido = 13.1f;
		float rebPartido = 4.1f;
		float asistPartido = 6.6f;
		boolean lesionado = true;
		
		// Imprimiendo los datos por pantalla
		
		System.out.println("--------Datos Personales--------");
		System.out.println("Nombre: " +  nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Altura(cm):" + altura);
		System.out.println();
		System.out.println("--------Datos Equipo--------");
		System.out.println("Dorsal: " + dorsal);
		System.out.println("Equipo: " + equipo);
		System.out.println();
		System.out.println("--------Estadísticas--------");
		System.out.println("PP: " + puntosPartido);
		System.out.println("RP: " + rebPartido);
		System.out.println("AP: " + asistPartido);
		System.out.println("Lesionado: " + lesionado);
		
		
		

	}

}
