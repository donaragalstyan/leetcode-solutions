class Solution {
    public int distributeCandies(int[] candyType) {
       Set<Integer> type = new HashSet<>();
        for(int i : candyType) {
            type.add(i);
        }
        
        int allowed = candyType.length / 2;
        if (type.size() > allowed) {
            return allowed;
        } else {
            return type.size();
        }
    }
}