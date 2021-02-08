public class Pruebas {
    private static int[][] vectores = {
            {-1 ,0, 2, 3, 10, 12, -23, -14, -7},
            {-94, -89, -87, -82, -79, -76, -72, -70, -66, -61, -57, -53, -51, -46, -41, -38, -34, -31, -27, -22, -21, -17, -13, -11, -6, -4, -1, 1, 6},
            {1, -16, -15, -11, -6, -2},
            {-4, 1, 4, 9, -17, -16, -15, -12, -8, -7},
            {-15, -13, -12, -11, -7, -3, 1, 5, 6, 8, 9, 10, 12, 15, 17, -20},
            {-2, 1, 4, 6, 11, 16, 21, 24, 26, 27, 29, -70, -67, -64, -60, -56, -54, -51, -50, -45, -42, -37, -34, -31, -28, -23, -18, -13, -12, -7},
            {-4, 1, 4, 7, 10, 15, 20, 22, 23, 27, -40, -36, -31, -30, -27, -24, -23, -22, -19, -14, -13, -9, -8},
            {-23, -22, -18, -17, -16, -12, -11, -8, -5, 1, 5, 9, 10, 13, 18, 23, 28, 30, 31},
            {18, 22, -15, -13, -9, -6, -3, -2, 1, 4, 6, 8, 9, 11, 16},
            {-49, -47, -46, -44, -43, -39, -38, -34, -29, -24, -20, -19, -14, -13, -10, -6, -3, 1, 6, 8, 12, 13, 14, 18, 21, 25, -60, -59, -54},
            {4, 8, -1, 1},
            {1, 6, 7, 12, 13, -2},
            {-4, -3, 1, 3},
            {-32, -31, -29, -27, -23, -22, -19, -15, -10, -7, -5, -4, -2, 1, 3, 4, 6, 8, -69, -66, -61, -56, -51, -50, -45, -42, -37},
            {8, -13, -12, -10, -9, -4, -3, 1, 2, 4, 7},
            {3, -4, 1},
            {1, 6, 11, 12, 15, -12, -10, -5},
            {21, 26, -53, -52, -50, -46, -45, -44, -42, -39, -34, -30, -25, -21, -16, -12, -9, -8, -7, -5, -3, 1, 5, 8, 12, 14, 17},
            {-22, -17, -16, -13, -8, -6, -5, 1, 3, 6, 9, 12, 13, -23},
            {-43, -38, -35, -31, -30, -27, -22, -20, -16, -15, -10, -7, -5, -2, 1, -44},
            {-57, -56, -55, -54, -49, -46, -45, -42, -40, -36, -31, -27, -23, -22, -17, -15, -11, -7, -4, -1, 1, 5, 6, 10, 13, 18, 19, 22, 26},
    };

    private static int[] resul={27, 7, 1, 14, 83, 165, 129, 168, 95, 118, 13, 39, 4, 22, 22, 4, 45, 104, 44, 1, 120};

    private static void imprimirVector(int[] vector) {
        for (int f = 0; f < vector.length-1; f++)
            System.out.print(vector[f]+ ", ");
        System.out.println(vector[vector.length-1]);
    }

    private static void probarTest(int apartado, int[][] vectores, int[]resul){
        boolean exito=true;
        for (int i=0;i<vectores.length;i++) {
            int suma=sumaPositivosDyV(apartado,vectores[i]);
            if (suma!=resul[i]) {
                System.out.println("NO FUNCIONA TU ALGORITMO EN ESTE CASO");
                imprimirVector(vectores[i]);
                System.out.println("La suma de los elementos positivos es " + resul[i] + ". Tu algoritmo devuelve " + suma);
                System.out.println();
                exito=false;
            }
        }
        if (exito)
            System.out.println("HAN TENIDO ÉXITO TODOS LOS TESTS. DISEÑA NUEVOS TESTS Y ASEGÚRATE QUE FUNCIONA TU ALGORITMO CORRECTAMENTE");
    }

    private static int sumaPositivosDyV(int apartado, int[] vector){
        if (apartado==1)
            return Principal.sumaPositivos1(vector);
        else
            return Principal.sumaPositivos2(vector);
    }

    public static void main(String[] args){
        System.out.println("TEST APARTADO 1");
        System.out.println("==========================");
        probarTest(1,vectores, resul);
        System.out.println();
        System.out.println("TEST APARTADO 2");
        System.out.println("==========================");
        probarTest(2,vectores, resul);
    }


}