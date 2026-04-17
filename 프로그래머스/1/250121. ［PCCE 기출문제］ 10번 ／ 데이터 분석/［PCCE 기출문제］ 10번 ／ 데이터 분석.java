import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // 조건에 맞는 데이터만 담을 리스트
        List<int[]> list = new ArrayList<>();
        
        // ext(조건 컬럼)의 인덱스 구하기
        int extIndex = getIndex(ext);
        
        // 조건 필터링
        // ext 컬럼 값이 val_ext보다 작은 데이터만 리스트에 추가
        for(int[] d : data){
            if(d[extIndex] < val_ext){
                list.add(d);
            }
        }
        
        // sort_by(정렬 기준 컬럼)의 인덱스 구하기
        int sortIndex = getIndex(sort_by);
        
        // 해당 컬럼 기준으로 오름차순 정렬
        list.sort((o1, o2) -> o1[sortIndex] - o2[sortIndex]);
        
        // List → 2차원 배열로 변환 후 반환
        return list.toArray(new int[0][]);
    }
    
    // 컬럼명을 실제 인덱스로 변환하는 함수
    public int getIndex(String indexString) {
        
        // 컬럼 순서 정의
        // 0: code, 1: date, 2: maximum, 3: remain
        String[] arr = {"code","date","maximum","remain"};
        
        // 전달받은 컬럼명과 일치하는 인덱스 찾기
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(indexString)) return i;
        }
        
        // 기본값 (정상적으로는 여기 안 옴)
        return 0;
    }
}