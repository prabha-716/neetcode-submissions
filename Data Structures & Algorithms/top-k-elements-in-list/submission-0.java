class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(int x : nums) {map.put(x,map.getOrDefault(x,0)+1);}
        for(int x : map.keySet()){
            q.offer(x);
            if(q.size() > k){
                q.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = q.poll();
        }
        return res;
    }
}
