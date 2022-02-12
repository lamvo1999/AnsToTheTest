import java.util.Scanner;

public class Problem_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int M = 3;
       int N = 4;
       Scanner scnr = new Scanner(System.in);
       int startFloor;
       int endFloor;
       int elevator;
       
       int [][] area = {{0,1,0},
    		            {0,0,0},
    		            {0,0,1},
    		            {1,0,0}
    		            };
       display(area, N, M);
       
     
       
       System.out.println("Enter the elevator you'd like to go to ==> ");
       elevator = scnr.nextInt();
       System.out.println("Enter the start floor ==> ");
       startFloor = scnr.nextInt();
       System.out.println("Enter the floor you'd like to go to ==> ");
       endFloor = scnr.nextInt();
       
       
       System.out.println(elevator +"\t" + startFloor +"\t"+ endFloor);
       ElevatorSystem(area, elevator, startFloor, endFloor, M, N);
       
	}

	public static void ElevatorSystem(int[][] area, int eleva, int startF, int endF, int M, int N) {
		int currentFloorOfElevator;
		if(isElevatorOnFloor(area, startF, eleva)) {
			System.out.println("Open Elevator ");
			currentFloorOfElevator = startF;
			
		}else {
			System.out.println("Wait ");
			currentFloorOfElevator = getCurrentFloorOfElevator(area, eleva, N);
		}
		System.out.println("The elevator is on the floor : " +currentFloorOfElevator);
		
		if(currentFloorOfElevator < startF) {
			if(startF < endF){
				moveUpFloor(area, eleva, currentFloorOfElevator, startF);
				System.out.println("Open Elevator ");
				moveUpFloor(area, eleva, startF, endF);
				System.out.println("End ");
			}else {
				moveUpFloor(area, eleva, currentFloorOfElevator, startF);
				System.out.println("Open Elevator ");
				moveDownFloor(area, eleva, startF, endF);
				System.out.println("End ");
			}
			
		}else if( currentFloorOfElevator > startF){
			if(startF < endF) {
				moveDownFloor(area, eleva, currentFloorOfElevator, startF);
				System.out.println("Open Elevator ");
				moveUpFloor(area, eleva, startF, endF);
				System.out.println("End ");
			}else {
				moveDownFloor(area, eleva, currentFloorOfElevator, startF);
				System.out.println("Open Elevator ");
				moveDownFloor(area, eleva, startF, endF);
				System.out.println("End ");
			}
		}else if(currentFloorOfElevator == startF) {
			if(currentFloorOfElevator > endF) {
				moveDownFloor(area, eleva, currentFloorOfElevator, endF);
				System.out.println("End ");
			}else {
				moveUpFloor(area, eleva, startF, endF);
				System.out.println("End ");
			}
		}
	}
	
	public static void moveUpFloor(int[][] are,int eleva ,int startF, int endF) {
			for(int i = startF ; i < endF; i++) {
				are[i][eleva] = 0;
				are[i+1][eleva] = 1;
				display(are, 4, 3);
				System.out.println("\n");
			}
		}
	
	public static void moveDownFloor(int[][] are,int eleva ,int startF, int endF) {
		for(int i = startF ; i > endF; i--) {
			are[i][eleva] = 0;
			are[i-1][eleva] = 1;
			display(are, 4, 3);
			System.out.println("\n");
		}
	}
	
	public static int getCurrentFloorOfElevator(int[][] area, int eleva, int N){
		int current = 0 ;
		for(int i = 0; i < N; i++) {
			if(area[i][eleva] == 1) {
				current = i;
			}
		}
		return current;
	}
	
	
	public static boolean isElevatorOnFloor(int[][] are, int startF , int elev) {
		return are[startF][elev] == 1;
	}

	public static void display(int[][] area, int N, int M) {
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {	      
	        	System.out.print(area[i][j] + "\t");	        }
        System.out.println("\n");   
	    }
	}
	
}
