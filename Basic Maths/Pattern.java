import java.util.Scanner;
class Pattern
{
    // public static void main(String args[])
    // {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the number for pattern");
    //     int n = sc.nextInt();
    //     for(int i = 0; i < n; i++)               // ****
    //     {                                        // ****
    //         for(int j = 0; j < n; j++)           // ****
    //         {                                    // ****
    //             System.out.print("* ");
    //         }
    //         System.out.println("");
    //     }
    // }

    // public static void main(String args[])
    // {
    //     Scanner sc = new Scanner(System.in);
    //     for(int i = 0; i < 5; i++)
    //     {                                         //*
    //         for(int j = 0; j <= i; j++)           //* * 
    //         {                                     //* * *
    //             System.out.print("* ");           //* * * *
    //         }                                     //* * * * *
    //         System.out.println(" ");
    //     }
    // }

//     public static void main(String args[])
//     {
//         for(int i = 1; i <= 5; i++)
//         {
//             for(int j = 1; j <= i; j++)            //1
//             {                                      //1 2
//                 System.out.print(j + " ");         //1 2 3
//             }                                      //1 2 3 4
//             System.out.println(" ");               //1 2 3 4 5
//         }
//     }

    //  public static void main(String args[])
    //  {
    //     for(int i = 1; i <= 5; i++)
    //     {
    //         for(int j=1; j <= i; j++)            //1
    //         {                                    //2 2
    //             System.out.print(i + " ");       //3 3 3
    //         }                                    //4 4 4 4
    //         System.out.println(" ");             //5 5 5 5 5
    //     }
    //  }

    // public static void main(String args[])
    // {
    //     for(int i = 1; i <= 5; i++)
    //     {
    //         for(int j = 1; j <= 5-i+1; j++)      //* * * * *
    //         {                                    //* * * *
    //             System.out.print("* ");          //* * *
    //                                              //* *
    //         }                                    //*
    //         System.out.println(" ");
    //     }
    // }

    // public static void main(String args[])
    // {
    //     for(int i = 1; i <= 5; i++)
    //     {
    //         for(int j = 1; j <= 5-i+1; j++)       //1 2 3 4 5
    //         {                                     //1 2 3 4
    //             System.out.print(j + " ");        //1 2 3
    //         }                                     //1 2
    //         System.out.println(" ");              //1
    //     }
    // }


    // void pattern1(int N){
    // {
    //     for(int i = 0; i < N; i++)
    //     {
    //         //space
    //         for(int j = 0; j < N-i-1; j++)
    //         {
    //             System.out.print("  ");
    //         }

    //         //star                                          *
    //         for(int j = 0; j < 2*i+1; j++)           //   * * * 
    //         {                                 //        * * * * *
    //             System.out.print("* ");//             * * * * * * *
    //         }

    //         //space
    //         for(int j = 0; j < N-i-1; j++)
    //         {
    //             System.out.print("  ");
    //         }
    //         System.out.println(" ");
    //     }
    // }
    // }

    // void pattern2(int N){
    // {
    //     for(int i = 0; i < N; i++)
    //     {
    //         //space
    //         for(int j = 0; j < i; j++)
    //         {
    //             System.out.print("  ");
    //         }

    //         //star                                        //               * * * * * * * * *
    //         for(int j = 0; j < (2*N)-(2*i)-1 ; j++)       //                 * * * * * * *
    //         {                                             //                   * * * * *
    //             System.out.print("* ");                   //                     * * *
    //                                                       //                       *
    //         }


    //         //space
    //         for(int j = 0; j < i; j++)
    //         {
    //             System.out.print("  ");

    //         }
    //         System.out.println(" ");
    //     }
  
    // }
    // }

    // public static void main(String args[])    // this code is the combination of both the given patterns
    // {
    //     Scanner sc = new Scanner(System.in);
    //     int num = sc.nextInt();
    //     Pattern result = new Pattern();
    //     result.pattern1(num);
    //     result.pattern2(num);
    // }

    //  public static void main(String args[])  
    //  {
    //     Scanner sc = new Scanner(System.in);
    //     int N = sc.nextInt();
    //     for(int i = 1; i <= 2*N-1; i++)                         *
    //     {                                                       **
    //         int stars = i;                                      ***
    //         if(i >N) stars = 2*N-i;                             ****
    //         for(int j = 1; j <= stars; j++)                     *****
    //         {                                                   ****
    //             System.out.print("*");                          ***
    //         }                                                   **
    //         System.out.println(" ");                            *
    //     }
    //  }

}
   
