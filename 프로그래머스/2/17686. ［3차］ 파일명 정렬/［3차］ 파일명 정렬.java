import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        // ✅ Arrays.sort()로 files 배열을 정렬
        //   Comparator를 커스터마이징하여 HEAD와 NUMBER 기준으로 정렬 수행
        Arrays.sort(files, Comparator.comparing(
                // 🔹 첫 번째 비교 기준: HEAD (문자 부분)
                //   - 파일명에서 숫자가 나오기 전까지의 문자를 모두 HEAD로 간주
                //   - 정렬 시 대소문자 구분이 없도록 toLowerCase() 처리
                //   - replaceAll("\\d.*", "") → 첫 숫자 이후의 모든 문자를 제거 → HEAD만 남김
                s -> ((String) s).toLowerCase().replaceAll("\\d.*","")
            )
            // 🔹 두 번째 비교 기준: NUMBER (숫자 부분)
            //   - HEAD가 같을 경우, 첫 번째 등장하는 숫자를 찾아서 정렬
            //   - 정규식 ".*?(\\d+).*" : 문자열 중 첫 숫자 그룹(\\d+)을 캡처
            //   - replaceAll()의 "$1"은 첫 번째 그룹(숫자 부분)을 의미
            //   - Integer.parseInt()로 숫자로 변환해 정수 비교
            .thenComparing(
                s -> Integer.parseInt(((String) s).replaceAll(".*?(\\d+).*", "$1"))
            )
        );
        
        return files;
    }
}