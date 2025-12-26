import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        
        // 발견된 후보키들을 비트마스크 형태로 저장
        ArrayList<Integer> candidateKey = new ArrayList<>();
		
		int rowLen = relation.length;   // 튜플(행) 개수
		int colLen = relation[0].length;    // 속성(열) 개수
		
        // 1부터 (2^colLen - 1)까지 모든 속성 조합 탐색
        // 각 숫자는 선택된 컬럼 집합을 비트마스크로 표현
		for(int set = 1 ; set < (1 << colLen) ; set++) {
            
            // 최소성 검사
            // 이미 찾은 후보키가 현재 집합의 부분집합이면 스킵
			if(!isMinimal(set, candidateKey)) continue;
			
            // 유일성 검사
			if(isUnique(set, rowLen, colLen, candidateKey, relation)) {
				candidateKey.add(set);  // 유일성과 최소성을 만족하면 후보키로 등록
			}
		}
		
        // 후보키 개수 반환
		return candidateKey.size();
    }
    
    // 🔹 유일성 검사
    // 선택된 컬럼 집합(set)으로 모든 행을 구분할 수 있는지 확인
    boolean isUnique(int set, int rowLen, int colLen, ArrayList<Integer> candidateKey,
                     String[][] relation) {
        
        // 각 행에서 선택된 컬럼 값 조합을 저장
		HashMap<String, String> map = new HashMap<>();
		
        // 모든 행에 대해 검사
		for(int row = 0 ; row < rowLen ; ++row) {
            
            // 현재 행에서 set에 해당하는 컬럼 값 조합
			String dataByKeySet = "";
			
            // 각 컬럼에 대해
			for(int th = 0 ; th < colLen ; ++th) {
                
                // set에 포함된 컬럼인지 비트마스크로 확인
				if((set & (1 << th)) != 0) {
					dataByKeySet += relation[row][th];  // 해당 컬럼 값 추가
				}
			}
			
            // 이미 같은 조합이 존재하면 유일성 실패
			if(map.containsKey(dataByKeySet)) return false;
			else map.put(dataByKeySet, dataByKeySet);
		}
		
        // 모든 행이 유일하면 true
		return true;
	}
    
    // 🔹 최소성 검사
    // 이미 존재하는 후보키가 현재 set의 부분집합인지 확인
    boolean isMinimal(int set, ArrayList<Integer> candidateKey) {
        
        // 기존 후보키들과 비교
		for(int key : candidateKey) {
            
            // key가 set의 부분집합이면 최소성 위반
            // (key & set) == key → key의 모든 비트가 set에 포함됨
			if((key & set) == key) return false;
		}
		
        // 최소성 만족
		return true;
	}

}