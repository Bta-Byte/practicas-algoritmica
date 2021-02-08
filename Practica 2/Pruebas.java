public class Pruebas {


    private static String[] str1 = {
            "AGCT",
            "AGTC",
            "AGTCTAAGCC",
            "ATTGC",
            "GGGCTTAGTAAAGGTT",
            "AGCTAGCTTTGGAATTTGCTAATTGCCATA",
            "GCTAGCTTTGGAATTTGCTAATTGCCATA",
            "AGCT",
            "AAAGGGTTTAAACCC",
            "AAAGGGGTTTTCGCTAGTCGATCGATCGATCGATAGCTAGATCGGGGGCCCCTTTTTTTAAAA",
            "ATCGATCGGGGGCCCCTTTTTTTAAAA",
            "GG",
            "AGTCT"
    };
    private static String[] str2 = {
            "AAGCT",
            "AACTA",
            "AAA",
            "GGCTTAGGCT",
            "GGGCTTAGT",
            "GCTAGCTTTGGAATTTGCTAATTGCCATA",
            "AGCTAGCTTTGGAATTTGCTAATTGCCATA",
            "TCGA",
            "AAAGGGTTTAAACCC",
            "AGGTGGTTTTCGCTGGAGTCGACGATCGATAGCTAAGATCGGGGGCCCCCTATTTTTTAA",
            "ATCGATCGATCGATAGCTAGATCGGGGGCCCCTTTTTTTAAAA",
            "AAAACCCTTTT",
            "AACTAAG"
    };

    private static int[] resultados = { 1, 3, 7, 6, 7, 1, 1, 4, 0, 13, 16, 11, 5};


    private static void test() {
        boolean exito = true;
        System.out.println("TESTS");
        System.out.println("-----");
        System.out.println();
        int fallos=0;
        for (int i = 0; i < str1.length; i++) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.print("PRUEBA " + (i+1) + ". Ejecutando.....");


            long t1 = System.nanoTime();
            int dist = Principal.numMinMutaciones(str1[i], str2[i]);
            long t2 = System.nanoTime();

            if ((t2-t1)/1E6 < 1E3)
                System.out.println("   La ejecución ha tardado: "  + (t2-t1)/1E6 + " [ms] ");
            else System.out.println("   La ejecución ha tardado: "  +  (t2-t1)/1E6 + " [ms]  ->>> " + (t2-t1)/1E9 + " [s] ");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            if (dist != resultados[i]) {
                fallos++;

                System.out.println("    -> NO FUNCIONA TU ALGORITMO EN ESTE CASO");
                System.out.println("          cadena1: " + str1[i]);
                System.out.println("          cadena2: " + str2[i]);
                System.out.println();
                System.out.println("    -> El numero minimo de mutaciones deberia ser " + resultados[i] + ". Tu algoritmo devuelve " + dist);
                exito = false;
            }
            else{

                System.out.println("    -> SUPERADA. El numero minimo de mutaciones es de " + dist);
                System.out.println("          cadena1: " + str1[i]);
                System.out.println("          cadena2: " + str2[i]);

            }
            System.out.println();
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        if (exito)
            System.out.println("HAN TENIDO ÉXITO TODOS LOS TESTS. DISEÑA NUEVOS TESTS Y ASEGURATE DE QUE FUNCIONA TU ALGORITMO CORRECTAMENTE");
        else if (fallos != str1.length){
            if (fallos>1)
                System.out.println("****  HAN FALLADO " + fallos + " PRUEBAS DE LAS "  + str1.length + " PLANTEADAS");
            else
                System.out.println("****  HA FALLADO 1 PRUEBA DE LAS "  + str1.length + " PLANTEADAS");
        }
        else
            System.out.println("****  HAN FALLADO TODAS LAS PRUEBAS");
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }


    public static void main(String[] args) {
        test();
        System.out.println();
    }

}
