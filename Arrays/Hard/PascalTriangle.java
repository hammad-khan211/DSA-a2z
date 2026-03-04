import java.util.*;
class PascalTriangle
{
    //Type - 1 Question => Find the element present at a particular row,column in pascals triangle
    static long findElement(int row , int column)
    {
        return findnCr(row - 1, column - 1);
    }
    static long findnCr(int n , int r) //time complexity O(r)
    {                                 //nCr = nC(n - r) so we will use this to reduce iterations in case of worst case
        long resultant = 1;
        r = Math.min(r , n - r);
        for(int i = 0 ; i < r ; i++)
        {
            resultant *= ( n - i );
            resultant /= ( i + 1 );
        }
        return resultant; 
    }
    
    //Type - 2 Question => Print any particular entire row of pascal's triangle
    static List < Long > printRow(int rowNumber) //time complexity O(rowNumber) 
    {
        List < Long > nums = new ArrayList<>();
        long result = 1;
        nums.add(result);
        for(int col = 1 ; col < rowNumber ; col++)
        {
            result *= (rowNumber - col);
            result /= col;
            nums.add(result);
        }
        return nums;
    }

    //Type - 3 Question => Print the entire pascal's trinagle
    static List < List < Long > > printPascalTriangle(int rowNumber) //Time COmplexity O(rownumber * col)
    {
        List < List < Long > > triangle = new ArrayList<>();
        for(int row = 1 ; row <= rowNumber ; row++)
        {
            List < Long > temp = new ArrayList<>();
            long result = 1;
            temp.add(result);
            for(int col = 1 ; col < row ; col++)
            {
                result *= (row - col);
                result /= col;
                temp.add(result);
            }
            triangle.add(temp);
        }
        return triangle;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        // // TYPE 1
        // System.out.print("Enter the row and column of the element you need to find in Pascal's Triangle : ");
        // int row = sc.nextInt();
        // int column = sc.nextInt();
        // if(column <= row && column > 0)
        // {
        //     long ans = findpascalElement(row, column);
        //     System.out.println("Element at ( " + row + " , " + column + " ) is : " + ans);
        // }
        // else{
        //     System.out.println("Enter valid rows and columns");
        // }

        //TYPE 2
        // System.out.println("Enter the row number of Pascal's Triangle : ");
        // int row = sc.nextInt();
        // List < Long > result = printRow(row);
        // System.out.println("Row " + row + " of Pascal's Triangle : ");
        // for(Long X : result)
        // {
        //     System.out.print(X + " ");
        // }

        //TYPE 3
        System.out.println("Enter the size of Pascal's Triangle : ");
        int row = sc.nextInt();
        List < List < Long > > answer = printPascalTriangle(row);
        System.out.println("--------------------------------------");
        for(List < Long > X : answer)
        {
            for(long Y : X)
            {
                System.out.print(Y + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}