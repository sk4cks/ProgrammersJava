class Solution {
    
    int maxjoin = 0;
    int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] discountRateArr = new int[emoticons.length];

        dfs(0,discountRateArr, users, emoticons);
        
        return new int[] {this.maxjoin, this.maxSales};
    }
    
    void dfs(int index, int[] discountRateArr, int[][] users, int[] emoticons) {
        if(index == emoticons.length) {
            calculate(discountRateArr, users, emoticons);
            return;
        }

        for(int i=10; i<=40; i+=10) {
            discountRateArr[index] = i;
            dfs(index+1, discountRateArr, users, emoticons);
        }
    }
    
    void calculate(int[] discountRateArr, int[][] users, int[] emoticons) {
        int join = 0;
        int sales = 0;

        for(int[] user : users) {
            int userDiscountRate = user[0];
            int userLimit = user[1];
            int sum = 0;

            for(int i=0; i<emoticons.length; i++) {
                if(discountRateArr[i] >= userDiscountRate) {
                    sum += (emoticons[i] / 100) * (100 - discountRateArr[i]);
                }
            }

            if(userLimit <= sum) {
                join++;
            } else {
                sales += sum;
            }
        }

        if(this.maxjoin < join || (this.maxjoin == join && this.maxSales < sales)) {
            this.maxjoin = join;
            this.maxSales = sales;
        }
    }
    
}