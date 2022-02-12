
public class Problem_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int[][] image = {{1,4,5,8,9},{12,3,25,1,9},{3,15,54,32,98},{255,137,21,98,74},{71,230,31,69,45}};
		
		System.out.println("Original pixel matrix");
		display(image);
	
		
		 
		System.out.println("Pixel matrix after rotating 90 degrees");
		rotate90(image);
		
	}
	
	public static void rotate90(int[][] pixel ) {
		for(int i = 0;  i < pixel.length; i++) {
			for (int j = pixel.length-1; j >=0; j--) {
				System.out.print(pixel[j][i] + "\t");
			}
			System.out.println("\n");
		}
		
	}
	
	public static void display (int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr.length; j++) {	      
	        	System.out.print(arr[i][j] + "\t");	        }
        System.out.println("\n");   
	    }
	}



}
