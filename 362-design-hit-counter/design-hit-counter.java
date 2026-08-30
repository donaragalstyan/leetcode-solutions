class HitCounter {

    private Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hits.offer(timestamp);
    }
    
    public int getHits(int timestamp) {

        while (!hits.isEmpty()) {

            int oldestHit = hits.peek();

            if (timestamp - oldestHit >= 300) {
                hits.poll();
            } else {
                break;
            }
        }

        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */