package com.hackerranck;

public class JavaExam{

    /*
     * Complete the isPossible function below.
     */
    public String isPossible(int a, int b, int c, int d) {
        /* 1,4 -> 5,4 - 5,9
        /* 1,2 -> 5,4 - 3,6
         * Write your code here.
         */
        String result= "No";

        int bb = Integer.valueOf(b);
        
        outer:while ( a <= c ){

            a+=b;

            inner:for (; b <= d; b+=a){

                if (a == c && b == d ){
                    result = "Yes";
                    break outer;
                }
                continue inner;
            }
            b = bb;
        }

        return result;
    }

    /*
     * Complete the isPossible function below.
     */
    public String isPossibleV2(int a, int b, int c, int d) {
        /* 1,4 -> 5,4 - 5,9
        /* 1,2 -> 5,4 - 3,6
         * Write your code here.
         */
        String result= "No";

        int bb = Integer.valueOf(b);
        
        outer:while ( a <= c ){

            a+=b;
            
            inner:while ( b <= d){

                b+=a;

                if (a == c && b == d ){
                    result = "Yes";
                    break outer;
                }
                continue inner;
            }

            b = bb;
        }

        return result;
    }
}