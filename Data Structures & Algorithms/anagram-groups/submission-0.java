class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
            String key = Arrays.toString(freq);
            map.putIfAbsent(key,new ArrayList<String>());
            map.get(key).add(s);
        }
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
