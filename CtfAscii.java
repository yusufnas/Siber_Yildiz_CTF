/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calisma;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author YUSUFNAS
 */
public class CtfAscii {

    static final int MAX = 1000000000;

    public static void main(String[] args) {
        char harf;
        int ascii, toplam = 0;
        int enbuyuk = 10;
        try {
            FileReader fr = new FileReader("C:\\Users\\ysfna\\Downloads\\SiberyildizIndirilenler\\strings.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null) {
                //System.out.println(str);
                for (int i = 0; i < str.length(); i++) {
                    harf = str.charAt(i);
                    ascii = harf;
                    toplam += ascii;
                }
                if (toplam > enbuyuk) {
                    enbuyuk = toplam;
                }
                toplam = 0;

            }
            System.out.println("En buyuk sayı: " + enbuyuk);
            br.close();

        } catch (Exception e) {
            System.out.println("Dosya Okunmadı!! (" + e + ")");
        }
        power(enbuyuk, 987654);

    }

    static void power(int x, int n) {

        //printing value "1" for power = 0
        if (n == 0) {
            System.out.print("1");
            return;
        }
        int res[] = new int[100000000];
        int res_size = 0;
        int temp = x;

        // Initialize result
        while (temp != 0) {
            res[res_size++] = temp % 10;
            temp = temp / 10;
        }

        // Multiply x n times
        // (x^n = x*x*x....n times)
        for (int i = 2; i <= n; i++) {
            res_size = multiply(x, res, res_size);
        }

        System.out.print(x + "^" + n + " = ");
        for (int i = res_size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
    }

    static int multiply(int x, int res[], int res_size) {

        // Initialize carry
        int carry = 0;

        // One by one multiply n with
        // individual digits of res[]
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;

            // Store last digit of
            // 'prod' in res[]
            res[i] = prod % 10;

            // Put rest in carry
            carry = prod / 10;
        }

        // Put carry in res and
        // increase result size
        while (carry > 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }
}
