class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(0, 0, n, sb, res);
        return res;
    }

    private void generateParenthesis(int open, int close, int n, StringBuilder sb, List<String> res) {
        if(open == n && close == n) {
            res.add(new String(sb));
            return;
        }
        if(open < n) {
            sb.append("(");
            generateParenthesis(open + 1, close, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open) {
            sb.append(")");
            generateParenthesis(open, close + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
