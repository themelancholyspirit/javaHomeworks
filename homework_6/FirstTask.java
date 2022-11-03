

class FirstTask {
    public static void main(String[] args) {
        int first = 121;
        int second = 13431;
        int third = 345;

        System.out.println(is_palindrome(first) == true);
        System.out.println(is_palindrome(second) == true);
        System.out.println(is_palindrome(third) == false);
    }

    public static boolean is_palindrome(int n) {
        String str_n = Integer.toString(n);
        int length = str_n.length();

        for (int i=0; i<length/2; i++) {
            if (str_n.charAt(i) != str_n.charAt(length-1-i)) return false;
        }

        return true;
    }
}