class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int length = 1;
    
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String curr = queue.poll();
                if(curr.equals(endWord)) {
                    return length;
                }
                for(String neighbour : getNeighbours(curr, wordSet)) {
                    if(!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private List<String> getNeighbours(String word, Set<String> wordSet) {
        List<String> neighbours = new ArrayList<>();
        char[] ch = word.toCharArray();
        for(int i=0;i<word.length();i++) {
            char old = ch[i];
            for(int j=0;j<26;j++) {
                ch[i] = (char) ('a' + j);
                String neighbour = new String(ch);
                if(!word.equals(neighbour) && wordSet.contains(neighbour)) {
                    neighbours.add(neighbour);
                }
            }
            ch[i] = old;
        }
        return neighbours;
    }
}