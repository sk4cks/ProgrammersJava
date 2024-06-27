class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int startRow = 0;
        int startCol = 0;
        int[] answer = new int[2];
        String[][] realPark = new String[h][w];

        for(int i=0; i< h; i++){
            String[] division = park[i].split("");
            for(int j=0; j< division.length; j++){
                realPark[i][j] = division[j];
                if(division[j].equals("S")){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        for(int i=0; i< routes.length; i++){
            String[] division = routes[i].split(" ");
            int baseRow = startRow;
            int baseCol = startCol;
            int length = Integer.parseInt(division[1]);
            for(int j=0; j<length; j++){
                switch (division[0]){
                    case "E":
                        startCol++;
                        break;
                    case "W":
                        startCol--;
                        break;
                    case "S":
                        startRow++;
                        break;
                    case "N":
                        startRow--;
                        break;
                }
                try{
                    String s = realPark[startRow][startCol];
                    if(s.equals("X")){
                        throw new RuntimeException();
                    }
                }catch (RuntimeException e){
                    startRow = baseRow;
                    startCol = baseCol;
                    break;
                }

            }

        }
        answer[0] = startRow;
        answer[1] = startCol;
        
        return answer;
    }
}