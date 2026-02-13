import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // 최대 data.length 만큼 결과 배열을 먼저 생성
        // (조건에 맞는 데이터만 나중에 필터링할 예정)
        int[][] answer = new int[data.length][4];
        
        // ext에 해당하는 컬럼의 인덱스를 구함
        // ex) "date" -> 1
        int extIndex = getIndex(ext);
        
        // 조건에 맞는 데이터만 answer 배열에 임시 저장
        for(int i=0; i<data.length; i++){
            // data의 ext 컬럼 값이 val_ext보다 작은 경우만 저장
            if(data[i][extIndex] < val_ext){
                answer[i] = data[i];
            }
        }
        
        // 위에서 조건에 맞지 않는 행은 [0,0,0,0] 상태
        // 첫 번째 값(o[0])이 0이 아닌 데이터만 필터링
        // ※ 단, code 값이 실제로 0일 경우 제거될 수 있음 (주의)
        answer = Arrays.stream(answer)
                       .filter(o -> o[0] != 0)
                       .toArray(int[][]::new);
        
        // sort_by에 해당하는 컬럼 인덱스 구하기
        int sortIndex = getIndex(sort_by);
        
        // 해당 컬럼 기준으로 오름차순 정렬
        Arrays.sort(answer, (o1, o2) -> {
            return o1[sortIndex] - o2[sortIndex];
        });
        
        return answer;
    }
    
    // 문자열 컬럼명을 실제 배열 인덱스로 변환하는 메서드
    public int getIndex(String indexString) {
        
        // data의 컬럼 순서
        // 0: code
        // 1: date
        // 2: maximum
        // 3: remain
        String[] sortArr = {"code","date","maximum","remain"};
        
        int result = 0;
        
        // 전달받은 문자열과 일치하는 인덱스 찾기
        for(int i=0; i<sortArr.length; i++){
            if(sortArr[i].equals(indexString)){
                result = i;
            }
        }
        
        return result;
    }
}