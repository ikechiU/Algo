package z_others;

public class ReverseWords {
    public static void main(String[] args) {
        String s1 = reverseWord("This is an example!");
        String s2 = reverseWord("double  spaces");
        String s3 = reverseWord("The quick brown fox jumps over the lazy dog.");



//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);

//        reverseWord2("The quick brown fox jumps over the lazy dog.");
        reverseWord2("     ");
        System.out.println(reverseWord2("     "));
    }

    private static String reverseWord2(String original) {
        String[] array = original.split(" ");

        if(array.length == 0)
            return original;

        int i = 0;
        for(String string : array){
            array[i] = new StringBuilder(string).reverse().toString();
            i++;
        }

        return String.join(" ", array);
    }

    private static String reverseWord(String word) {

        if (word.trim().isEmpty()) {
            return word;
        } else {
            String[] strArr = word.split(" ", 0);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].isEmpty()) {
                    stringBuilder.append(" ");
                }
                for (int j = strArr[i].length() - 1; j >= 0; j--) {
                    stringBuilder.append(strArr[i].charAt(j));
                    if (i != strArr.length - 1) {
                        if (j == 0) {
                            stringBuilder.append(" ");
                        }
                    }
                }
            }

            return stringBuilder.toString();
        }
    }


}
