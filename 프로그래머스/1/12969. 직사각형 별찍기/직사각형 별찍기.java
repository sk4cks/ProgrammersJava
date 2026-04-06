import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        
        // 가로 길이 (별의 개수)
        int a = sc.nextInt();
        
        // 세로 길이 (줄의 개수)
        int b = sc.nextInt();
        
        // 세로(b)만큼 반복 → 줄 개수
        for(int i=0; i<b; i++) {
            
            // 가로(a)만큼 반복 → 한 줄에 별 출력
            for(int j=0; j<a; j++) 
                System.out.print("*");
            
            // 한 줄 출력 후 줄바꿈
            System.out.println();
        }

    }
}