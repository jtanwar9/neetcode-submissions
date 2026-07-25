class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        partition(s, 0, curr, res);
        return res;
    }

    private void partition(String s, int index, List<String> curr, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList(curr));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                partition(s, i + 1, curr, res);
                curr.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
