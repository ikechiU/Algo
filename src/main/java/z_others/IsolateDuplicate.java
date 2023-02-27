package z_others;

import java.util.Arrays;


public class IsolateDuplicate {

    public static void main(String[] args) {

        String a = "helloookat";
        String b = "aaaabbcdefffffffg";
        String c = "abcdefg";
        String d = "";
        String e = "aabbccddeeffgg";
        String f = "aabccdeefgg";
        String g = "iiijjjjooooppppp";
        String h = "ssssssssssssssssssss";
        String i = "boopdedoop";
        String j = "hellllloooooodeeeecadevvsss";
        String k = "HelllllooooooDeeeecadevvsss";
        String l = "HEEEELLLLLOOOOOOOTHHHHHEEEEERRRREEE";
        String m = "TttTTTTttttTTTTTTIIIIIiiiiiiiSSSSSSSSSTTTTAAAAAAAAAaaaaaaaaaSSSSSSSSSSKKKKKkkkkkk";


        if (method(a) != null)
            System.out.println(Arrays.toString(method(a)));
        else
            System.out.println("Please enter a valid string");

        if (method(b) != null)
            System.out.println(Arrays.toString(method(b)));
        else
            System.out.println("Please enter a valid string");

        if (method(c) != null)
            System.out.println(Arrays.toString(method(c)));
        else
            System.out.println("Please enter a valid string");

        if (method(d) != null)
            System.out.println(Arrays.toString(method(d)));
        else
            System.out.println("Please enter a valid string");

        if (method(e) != null)
            System.out.println(Arrays.toString(method(e)));
        else
            System.out.println("Please enter a valid string");

        if (method(f) != null)
            System.out.println(Arrays.toString(method(f)));
        else
            System.out.println("Please enter a valid string");

        if (method(g) != null)
            System.out.println(Arrays.toString(method(g)));
        else
            System.out.println("Please enter a valid string");

        if (method(h) != null)
            System.out.println(Arrays.toString(method(h)));
        else
            System.out.println("Please enter a valid string");

        if (method(i) != null)
            System.out.println(Arrays.toString(method(i)));
        else
            System.out.println("Please enter a valid string");

        if (method(j) != null)
            System.out.println(Arrays.toString(method(j)));
        else
            System.out.println("Please enter a valid string");

        if (method(k) != null)
            System.out.println(Arrays.toString(method(k)));
        else
            System.out.println("Please enter a valid string");

        if (method(l) != null)
            System.out.println(Arrays.toString(method(l)));
        else
            System.out.println("Please enter a valid string");

        if (method(m) != null)
            System.out.println(Arrays.toString(method(m)));
        else
            System.out.println("Please enter a valid string");
    }

    private static String[] method(String string) {
        StringBuilder  stringBuilder = new StringBuilder();

        int chCount = 0;
        int currentPosition = 0;
        int internalArrCount = 0;
        String[] returnValue =  new String[2];
        int maxCh = 2;

        if (string.length() == 0) {
            return null;
        } else {
            for (int i = 0; i < string.length(); i++) {
                chCount = 0;

                var ch = string.charAt(i);
                chCount++;
                stringBuilder.append(ch);

                if (i < string.length() - 1) {
                    for (int j = i +  1; j < string.length(); j++) {
                        var nextCh = string.charAt(j);
                        currentPosition = j;

                        if (ch == nextCh) {
                            chCount++;

                            if (j == string.length() - 1) {
                                i = string.length() - 1;
                                int count = chCount - maxCh;

                                if (count >= 1) {
                                    internalArrCount = getInternalArrCount(stringBuilder, internalArrCount, ch, count);
                                }
                            }

                        } else {
                            i = currentPosition -1;
                            int count = chCount - maxCh;

                            if (count >= 1) {
                                internalArrCount = getInternalArrCount(stringBuilder, internalArrCount, ch, count);
                            } else if (chCount == 2)
                                stringBuilder.append(ch);

                            break;
                        }
                    }
                }
            }

            returnValue[0] = new String(stringBuilder);
            returnValue[1] = String.valueOf(internalArrCount);

            return returnValue;
        }
    }

    private static int getInternalArrCount(StringBuilder stringBuilder, int internalArrCount, char ch, int count) {
        stringBuilder.append(ch);
        internalArrCount++;
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int k = 0; k < count; k++) {
            s.append(ch);
            if (k == count - 1)
                s.append("]");
        }

        stringBuilder.append(new String(s));
        return internalArrCount;
    }
}
