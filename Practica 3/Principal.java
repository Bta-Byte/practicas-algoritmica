import java.util.*;

public class Principal {

	private static byte huecosRestantes;
	private static byte posI;
	private static byte posJ;
	
	public static ArrayList<Objeto> llenarInventario(ArrayList<Objeto> candidatos, Inventario inventario) {
		huecosRestantes=25;
		Objeto obj;//Para guardar el candidato
		ArrayList<Objeto> sol= new ArrayList<Objeto>();//Arraylist solucion
		candidatos.sort((p1, p2) -> Integer.compare(p2.getValor(), p1.getValor()));//ordenaremos el arraylist objeto de mayor a menor valor mediante mergesort
		while(huecosRestantes >0 && !candidatos.isEmpty())
		{
			obj=seleccionarCandidato(candidatos);
			candidatos.remove(obj);
			if(esCandidatoFactible(obj,inventario))
			{
				sol.add(obj);//Añadimos el objeto al arraylist solucion
				for(byte k=posI; k<obj.getAlto()+posI;k++)
				{
					for (byte l = posJ; l <obj.getAncho() + posJ; l++)
					{
						inventario.setCelda(l, k, obj.getId());//Añadimos el objeto al inventario
					}
				}
			}

		}
		return sol;
	}
	
	private static Objeto seleccionarCandidato(ArrayList<Objeto> candidatos)
	{
		/*Tendremos una variable que diga cuantos huecos quedan libres si el objeto tiene un
		tamaño mayor entonces pasaremos al siguiente candidato.
		Puesto que esta ordenado de mayor a menor valor los que no sean candidatos hay que borrarlos.
		 */
		while(candidatos.get(0).getAncho()*candidatos.get(0).getAlto()>huecosRestantes)
		{
			candidatos.remove(0);
			if(candidatos.isEmpty()) return null;//Si el ultimo objeto no es candidato al borrarlo ya no quedaran objetos por lo que devolvemos null
		}
		return candidatos.get(0);
	}
	
	private static boolean esCandidatoFactible(Objeto candidato, Inventario inventario)
	{
	/*Comprobamos si el objeto que ya sabemos que hay huecos >= que el tamaño del objeto cabe pues:
	  Puede haber 4 huecos libres pero que estos huecos no esten juntos por lo que un objeto de 4 si es candidato pero no factible
	 */
	if(candidato==null) return  false;
	boolean seSuperpone;
	for(byte i=0; i<5;i++)
	 {
		for(byte j=0;j<5;j++)
		{
			if(inventario.getCelda(j,i)==-1)
			{
				if(candidato.getAncho()+j<=5 && candidato.getAlto()+i<=5)//Comprobamos si el objeto a insertar respeta los limites.
				{
					seSuperpone=false;
					posI = i;
					posJ = j;
					for (byte k = i; k < candidato.getAlto() + i && !seSuperpone; k++)
					{
						for (byte l = j; l < candidato.getAncho() + j && !seSuperpone; l++)
						{
							if (inventario.getCelda(l, k) != -1) seSuperpone=true;//Comprobamos que el candidato no se superpone con otro objeto.
						}
					}
					if(!seSuperpone) //Candidato factible
					{
						//Restamos el tamaño del objeto a los huecos restantes
						huecosRestantes -= candidato.getAncho() * candidato.getAlto();
						return true;
					}
				}
			}
		}
	 }
    return false;//Candidato no factible
	}
}
