public class Principal {
    private static boolean exito;
    private static int mS;//MEJOR SOLUCION
    private static int Ts1;//tamaño de cadena1
    private static int Ts2;//tamaño de cadena2


    public static int numMinMutaciones(String cadena1, String cadena2)
    {
        Ts1=cadena1.length();
        Ts2=cadena2.length();
        exito=false;
        mS=Integer.MAX_VALUE;//MEJOR SOLUCION
        seleccionOptima (0,cadena1,cadena2,0,0);
        return mS;
    }

    private static void seleccionOptima (int S,String s1,String s2,int it1,int it2)//S=solucion actual, s1=cadena1, s2=cadena2, it1= iterador de s1, it2= iterador de s2.
    {
        byte t=0;//0=sustituir, 1=añadir, 2=eliminar (utilizo 'byte' ya que reserva menos memoria que 'int')
        int cA,d=0;//cA= numero de cambios adivinados. d=cambios a desanotar.
        byte ch=1;//cambio hecho, esta variable sirve para que no anote un cambio si el candidato no es aceptable
        byte b1=1,b2=1;//guardan los avances hechos en esta iteraccion.
        while(t<3)
        {
            cA=esSolucion(it1,it2,Ts1,Ts2);
            if(cA<0)//Es aceptable?
            {
                if ((s1.charAt(it1) == s2.charAt(it2)))//SI coinciden pasamos a la siguiente posicion y no hacemos cambios.
                {
                    t = 3;
                    //b1=1.Avanzamos a la siguiente posicion de s1
                    //b2=1.Avanzamos a la siguiente posicion de s2
                    //d=0; no cambiamos desanotar pues ya esta inicializado a cero
                }
                else//NO coinciden entonces se necesitan cambios
                {
                    switch (t)
                    {
                        case 0://SUSTITUIR
                            b1=1;//Avanzamos a la siguiente posicion de s1
                            b2=1;//Avanzamos a la siguiente posicion de s2
                            break;
                        case 1://AÑADIR
                            b1=0;
                            b2=1;//Avanzamos a la siguiente posicion de s2
                            break;
                        case 2://ELIMINAR
                            b2=0;
                            b1=1;//Avanzamos a la siguiente posicion de s1
                            break;
                    }
                    t = (byte) (t + 1);//Avanzamos en tipo de operacion
                    S += ch;//hemos hecho un cambio ANOTAMOS.
                    d=ch;//para luego desanotar.
                }
            }
            else ch=0;//No es aceptable pues hemos encontrado solucion y hemos hecho 0 cambios.
            if(cA>=0)//ES SOLUCION?
            {
                if(!exito)//Primera solucion
                {
                    exito=true;//Para no volver a entrar
                    mS=S+cA;//Guardamos la 1º solucion como mejor solucion
                }
                else if(cA+S<mS) mS=cA+S; //Hemos encontrado una solucion mejor que la mejor guardada
                d=cA+ch;//para desanotar todos los cambios despues.
                t=3;//Si es solucion no nos interesa seguir en esta rama PODAMOS.
            }
            else if (S<mS) seleccionOptima (S,s1,s2,it1+b1,it2+b2);//NO ES SOLUCION seguimos buscando al menos que la solucion que llevemos sea igual que la mejor, en ese caso PODAMOS
            S=S-d; //quitamos a solucion el numero de cambios hechos
            /*Descontamos el numero de cambios pues aunque hayamos hecho 1, al volver de la llamada recursiva, probaremos otra
             operacion distinta que tambien sumara 1 a cambiosACT. Puesto que no editamos cadena1 no hace falta deshacer el cambio*/
        }
    }

    private static int esSolucion (int i,int j,int s1,int s2)
    {
        if(i==s1 && j==s2) return 0;//Si hemos llegado al final de cada cadena hemos llegado a una solucion sin mas cambios por hacer.
        if(i == s1) return s2-j;//Si hemos llegado primero al final de cadena1 entonces no calcularemos mas cambios directamente
                                //sumaremos a los cambios actaules los elementos que no se han recorrido en cadena2
        if(j == s2) return s1-i;//Si hemos llegado primero al final de cadena2 entonces no calcularemos mas cambios directamente
                                //sumaremos a los cambios actaules los elementos que sobran en cadena1
        return -1;//No se ha llegado al final en ninguna cadena
    }
}