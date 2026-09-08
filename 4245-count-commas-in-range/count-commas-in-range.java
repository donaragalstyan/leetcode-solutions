class Solution {
    public int countCommas(int n) {
        int count=0;
        int num=n;
        int comma=0;
        while(num>0){
            int rem=num%10;
            num=num/10;
            count++;
        }
        if(count>=4){
            for(int i=1000;i<=n;i++){
                comma=i-1000+1;
            }
        }
        if(count<=3){
            return 0;
        }
        return comma;
    }
}