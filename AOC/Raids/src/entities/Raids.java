
package entities;

public class Raids {
   public Raids() {
   }

   public static void raid0(String entrada) {
      for(int i = 0; i < entrada.length(); ++i) {
         if (i % 2 == 0) {
            Disco.disco1 += entrada.charAt(i);
         } else if (i % 2 != 0) {
    
            Disco.disco2 += entrada.charAt(i);
         }
      }

   }

   public static void raid4(String entrada) {
      int[] asciiParidade = new int[20];
      int[] asciiDisco1 = new int[20];
      int[] asciiDisco2 = new int[20];
      int[] asciiDisco3 = new int[20];
      int[] asciiDiscoReconstruido = new int[20];
      Disco.zerarDiscos();

      for(int i = 0; i < entrada.length(); ++i) {
         Disco.disco1 += entrada.charAt(i);
         ++i;    
         Disco.disco2 +=  entrada.charAt(i);
         ++i;
         Disco.disco3 += entrada.charAt(i);
      }

      for(int i = 0; i < entrada.length() && i < 19; ++i) {
         asciiDisco1[i] = Disco.disco1.charAt(i);
         asciiDisco2[i] = Disco.disco2.charAt(i);
         asciiDisco3[i] = Disco.disco3.charAt(i);
      }

      for(int i = 0; i < entrada.length() && i < 19; ++i) {
         asciiParidade[i] = asciiDisco1[i] ^ asciiDisco2[i] ^ asciiDisco3[i];
         Disco.paridade += (char)asciiParidade[i];
      }

      for(int i = 0; i < entrada.length() && i < 19; ++i) {
         asciiDiscoReconstruido[i] = asciiDisco1[i] ^ asciiParidade[i] ^ asciiDisco3[i];
         Disco.discoReconstruido += (char)asciiDiscoReconstruido[i];
      }

   }

   public static void printarRaid0(String entrada) {
      raid0(entrada);
      System.out.println("\tRaid 0");
      System.out.println("Disco 1: " + Disco.disco1);
      System.out.println("Disco 2: " + Disco.disco2 + "\n");
   }

   public static void printarRaid1(String entrada) {
      System.out.println("\tRaid 1");
      System.out.println("Disco 1: " + entrada);
      System.out.println("Disco 2: " + entrada + "\n");
   }

   public static void printarRaid4(String entrada) {
      try {
         raid4(entrada);
         System.out.println("\tRaid 4");
         System.out.print("Separando dados e criando disco de paridade");
         Thread.sleep(1000L);
         System.out.print(".");
         Thread.sleep(1000L);
         System.out.print(".");
         Thread.sleep(1000L);
         System.out.println(".\n");
         System.out.println("Disco 1: " + Disco.disco1);
         System.out.println("Disco 2: " + Disco.disco2);
         System.out.println("Disco 3: " + Disco.disco3);
         System.out.println("Paridade: " + Disco.paridade);
         System.out.println("==============================");
         System.out.print("Disco 2 danificado, buscando backup");
         Thread.sleep(1000L);
         System.out.print(".");
         Thread.sleep(1000L);
         System.out.print(".");
         Thread.sleep(1000L);
         System.out.println(".\n");
         System.out.println("Disco 1: " + Disco.disco1);
         System.out.println("Disco 2 reconstru\u00eddo: " + Disco.discoReconstruido);
         System.out.println("Disco 3: " + Disco.disco3);
         System.out.println("Paridade: " + Disco.paridade);
      } catch (InterruptedException var2) {
         System.out.println("\n\ncoisa linda");
      }

   }
}
