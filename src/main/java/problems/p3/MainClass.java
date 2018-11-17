package problems.p3;

public class MainClass {
    public static void main(String[] args) throws Exception {

        int length = lengthOfLongestSubstring("wteubifcbeajzhnzvdrxyismtdgbscxqyclzksdnwgzypmxlsqisaceuglvapurnyepkwuavaztqnsbhjlzjoefurcw");
        System.out.println(length);
    }

    /**
     * @param inputString
     * @return
     */
    private static int lengthOfLongestSubstring(String inputString) {

        int maxLen = 0;
        if (inputString == null || inputString.length() == 0) {
            return maxLen;
        }

        int winStartIndex = 0;
        String maxSubString = "";
        //窗口尾部向后移动
        for (int winEndIndex = 0; winEndIndex < inputString.length(); winEndIndex++) {
            String subString = "";

            System.out.println(String.format("winStartIndex(%s),winEndIndex(%s)", winStartIndex, winEndIndex));
            //开始位数在结束位数之后，异常，说明逻辑有问题
            if (winStartIndex > winEndIndex) {
                return 0;
//                throw new Exception(String.format("exception !!!! winStartIndex(%s) > winEndIndex(%s)", winStartIndex, winEndIndex));
            }

            //若窗口长度不为1，需要判断最后一位字符是否在前面的子串中存在
            if (winStartIndex != winEndIndex) {
                String winLastChar = inputString.substring(winEndIndex, winEndIndex + 1);
                String frontSubString = inputString.substring(winStartIndex, winEndIndex);

                //最后字符在前面子串中的位置
                int indexOfLastString = frontSubString.indexOf(winLastChar);


                if (indexOfLastString < 0) { //若最后字符不在前面子串存在
                } else { //若最后字符已经存在
                    //窗口起始位需要变化
                    winStartIndex = winStartIndex + indexOfLastString + 1;
                }
            }

            if (winStartIndex == winEndIndex) {
                subString = inputString.substring(winStartIndex, winStartIndex + 1);
            } else {
                subString = inputString.substring(winStartIndex, winEndIndex + 1);
            }

            if (subString.length() > maxLen) {
                maxLen = subString.length();
                maxSubString = subString;
            }
            System.out.println(String.format("winStartIndex(%s),winEndIndex(%s),winContent(%s), maxSubString(%s), maxSubString(%s)", winStartIndex, winEndIndex, subString, maxLen, maxSubString));
        }


        return maxLen;
    }
}
