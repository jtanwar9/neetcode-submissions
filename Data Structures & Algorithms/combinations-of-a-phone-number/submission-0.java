class Solution {

    Map<Character, String> combinations = new HashMap<>();
        
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }

        combinations.put('2', "abc");
        combinations.put('3', "def");
        combinations.put('4', "ghi");
        combinations.put('5', "jkl");
        combinations.put('6', "mno");
        combinations.put('7', "pqrs");
        combinations.put('8', "tuv");
        combinations.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        letterCombinations(digits, 0, sb, res);
        return res;
    }

    private void letterCombinations(String digits, int index, StringBuilder sb, List<String> res) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = combinations.get(digits.charAt(index));
        for(char ch : letters.toCharArray()) {
            sb.append(ch);
            letterCombinations(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
