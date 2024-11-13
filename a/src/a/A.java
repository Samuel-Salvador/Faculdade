package a;

public class A {

	public static void main(String[] args) {
		
		int aux=0, indice=0;
		int[] vec = {45,5,72,19,28,61,37,49,47,89,66,33,55,57,1};
		
		for(int i=1;i<vec.length;i++) {
			indice=i;
			aux=vec[i];
			while(indice>0 && vec[indice-1]>aux) {
				vec[indice]=vec[indice-1];
				indice--;
			}
			vec[indice]=aux;
		}
		for(int i=0;i<vec.length;i++) {
			System.out.print(vec[i]+ " ");
		}
	}

}
