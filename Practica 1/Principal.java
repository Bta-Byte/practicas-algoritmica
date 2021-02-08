public class Principal {
    public static int sumaPositivos1(int[] vector){
        return sumaPositivos1Aux(vector, 0, vector.length - 1);
    }

    private static int sumaPositivos1Aux(int[] vector, int i0, int in) {
        if(i0==in){
            if(vector[i0]>0) return vector[i0];
            else{return 0;}
        }
        else{
            int ik =(i0+in)/2; int suma1 = 0; int suma2 =0;
            suma1 += sumaPositivos1Aux(vector, i0, ik);
            suma2 += sumaPositivos1Aux(vector, ik + 1, in);
            return suma1+suma2;
        }
    }

    public static int sumaPositivos2(int[] vector){
        return sumaPositivos2Aux(vector, 0, vector.length - 1);
    }

    private static int  sumaPositivos2Aux(int[] vector, int i0, int in) {
        if(i0==in){
            if(vector[i0]>0) return vector[i0];
            else{return 0;}
        }
        else{
            int ik =(i0+in)/2; int suma1 = 0; int suma2 =0;
            if(!(vector[i0]<=0&&vector[ik]<=0&&vector[i0]<=vector[ik]))
                suma1 += sumaPositivos2Aux(vector, i0, ik);
            if(!(vector[ik+1]<=0&&vector[in]<=0&&vector[ik+1]<=vector[in]))
                suma2 += sumaPositivos2Aux(vector, ik + 1, in);
            return suma1+suma2;
        }
    }

}
