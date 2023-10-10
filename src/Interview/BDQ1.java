package Interview;

import java.util.Scanner;

public class BDQ1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        if (a == b) {
            System.out.println(a.length() * b.length());
        }

        int length = Math.min(a.length(), b.length());
        int front = 0;
        int back = 0;

        for (int i = 0; i < length; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                front++;
            } else {
                break;
            }
        }

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (a.charAt(i) == b.charAt(j)) {
                back++;
            } else {
                break;
            }
        }

        int res = Math.max(front * back, Math.max(modify1(a, b), modify2(a, b)));
        System.out.println(res);

    }

    private static int modify2(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int front = 0;
        int back = 0;
        char[] aSplit = a.toCharArray();
        char[] bSplit = b.toCharArray();

        for (int i = 0; i < length; i++) {
            if (aSplit[i] == bSplit[i]) {
                front++;
            } else {
                break;
            }
        }

        if (front < length) {
            aSplit[front] = bSplit[front];
        }

        front = 0;
        for (int i = 0; i < length; i++) {
            if (aSplit[i] == bSplit[i]) {
                front++;
            } else {
                break;
            }
        }

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (aSplit[i] == bSplit[j]) {
                back++;
            } else {
                break;
            }
        }

        return front * back;
    }

    private static int modify1(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int front = 0;
        int back = 0;
        char[] aSplit = a.toCharArray();
        char[] bSplit = b.toCharArray();

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (aSplit[i] == bSplit[j]) {
                back++;
            } else {
                break;
            }
        }

        if (back < length) {
            aSplit[a.length() - 1 - back] = bSplit[b.length() - 1 - back];
        }

        back = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (aSplit[i] == bSplit[j]) {
                back++;
            } else {
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            if (aSplit[i] == bSplit[i]) {
                front++;
            } else {
                break;
            }
        }

        return front * back;
    }
}
