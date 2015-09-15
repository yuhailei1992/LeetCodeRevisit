public class Solution {
    private static final String[] ones = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private static final String[] tens = {"Zero ", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String[] units = {"Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(num);
        int len = s.length();
        // Fill with zero.
        int i = -1;
        while (len >= 0) {
            String lowest = len >= 3 ? s.substring(len - 3) : s;
            s = s.substring(0, len >= 3 ? len - 3 : len);
            len -= 3;
            String part = convertLessThanAThousand(lowest);
            if (i >= 0 && part.length() != 0) {
                part += units[i];
            }
            sb.insert(0, part);
            i++;
        }
        return sb.toString().trim();
    }
    
    private String convertLessThanAThousand(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        if (len > 1 && s.charAt(len - 2) < '2') { // Twelve instead of Ten Two.
            int index = Integer.parseInt(s.substring(len - 2, len));
            if (index > 0) {
                sb.insert(0, ones[index]);
            }
            if (len == 3) {
                if (s.charAt(0) - '0' > 0) {
                    sb.insert(0, ones[s.charAt(0) - '0'] + "Hundred ");
                }
            }
        } else { // One Hundred Thirty Four.
            for (int i = len - 1; i >= 0; --i) {
                int num = s.charAt(i) - '0';
                if (num > 0) {
                    if (i == len - 1) {
                        sb.insert(0, ones[num]);
                    } else if (i == len - 2) {
                        sb.insert(0, tens[num]);
                    } else {
                        sb.insert(0, ones[num] + "Hundred ");
                    }
                }
            }
        }
        return sb.toString();
    }
}


// Use integer.
public class Solution {
    private static final String[] ones = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private static final String[] tens = {"Zero ", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String[] units = {"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int lowest = num % 1000;
            num /= 1000;
            String part = convertLessThanAThousand(lowest) + (lowest > 0 ? units[i] : "");
            sb.insert(0, part);
            i++;
        }
        return sb.toString().trim();
    }
    
    private String convertLessThanAThousand(int num) {
        StringBuilder sb = new StringBuilder();
        int lowest = num % 100;
        if (lowest < 20) {
            if (lowest > 0) {
                sb.insert(0, ones[lowest]);
            }
            num /= 100;
            if (num > 0) {
                sb.insert(0, ones[num] + "Hundred ");
            }
        } else {
            int i = 0;
            while (num > 0) {
                lowest = num % 10;
                num /= 10;
                if (lowest > 0) {
                    if (i == 0) {
                        sb.insert(0, ones[lowest]);
                    } else if (i == 1) {
                        sb.insert(0, tens[lowest]);
                    } else {
                        sb.insert(0, ones[lowest] + "Hundred ");
                    }
                }
                ++i;
            }
        }
        return sb.toString();
    }
}

