class Solution {
    
    int maxjoin = 0;    // 최대 이모티콘 플러스 가입자 수
    int maxSales = 0;   // 최대 매출액
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        // 각 이모티콘에 적용할 할인율을 저장하는 배열
        int[] discountRateArr = new int[emoticons.length];

        // 이모티콘별 할인율 조합을 DFS로 생성
        dfs(0,discountRateArr, users, emoticons);
        
        // 최대 가입자 수와 그때의 매출 반환
        return new int[] {this.maxjoin, this.maxSales};
    }
    
    // 모든 이모티콘에 대해 가능한 할인율(10,20,30,40%) 조합을 생성하는 DFS
    void dfs(int index, int[] discountRateArr, int[][] users, int[] emoticons) {
        
        // 모든 이모티콘에 할인율을 다 적용한 경우
        if(index == emoticons.length) {
            
            // 해당 할인율 조합으로 결과 계산
            calculate(discountRateArr, users, emoticons);

            return;
        }

        // 할인율은 10%, 20%, 30%, 40% 중 하나
        for(int i=10; i<=40; i+=10) {
            discountRateArr[index] = i; // 현재 이모티콘 할인율 설정
            dfs(index+1, discountRateArr, users, emoticons);    // 다음 이모티콘 처리
        }
    }
    
    /**
     * 특정 할인율 조합에 대해
     *  - 이모티콘 플러스 가입자 수
     *  - 총 매출액
     * 을 계산
     */
    void calculate(int[] discountRateArr, int[][] users, int[] emoticons) {
        int join = 0;   // 이번 조합의 가입자 수
        int sales = 0;  // 이번 조합의 매출액

        // 각 사용자별로 구매 여부 계산
        for(int[] user : users) {
            int userDiscountRate = user[0]; // 사용자가 원하는 최소 할인율
            int userLimit = user[1];        // 사용자의 구매 한도 금액
            int sum = 0;                    // 사용자의 총 구매 금액

            // 모든 이모티콘 확인
            for(int i=0; i<emoticons.length; i++) {
                
                // 할인율이 사용자 기준 이상인 경우만 구매
                if(discountRateArr[i] >= userDiscountRate) {
                    // 할인 적용된 가격 계산
                    sum += (emoticons[i] / 100) * (100 - discountRateArr[i]);
                }
            }

            // 구매 금액이 한도를 넘으면 플러스 가입
            if (userLimit <= sum) {
                join++;
                
            // 아니면 매출로 반영
            } else {
                sales += sum;
            }
        }

        // 기존 최대값과 비교하여 갱신
        // 1순위: 가입자 수
        // 2순위: 매출액
        if(this.maxjoin < join || (this.maxjoin == join && this.maxSales < sales)) {
            this.maxjoin = join;
            this.maxSales = sales;
        }
    }
    
}