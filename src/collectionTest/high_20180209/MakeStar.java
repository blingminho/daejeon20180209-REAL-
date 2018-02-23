package collectionTest.high_20180209;


public class MakeStar {
	public static void main(String[] args) {
		int row = 10;// 행의 수
		for (int i = 0; i < row; i++) {// 행의 수만큼 반복
			for (int j = 1; j < row*2; j++) {// 열의 수만큼 반복
				if(row-i == j || j == row+i){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
				
	}
}
