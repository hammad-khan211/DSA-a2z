import java.util.Scanner;
class Switch
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any Day of the week : ");
        String day = sc.nextLine();
        //  switch(day)
        //  {
        //     case "Saturday","Sunday" -> System.out.println("Wake up at 9:00am");
        //     case "Monday" -> System.out.println("Wake up at 7:00am");
        //     default -> System.out.println("Wake up at 8:00am");

        //  }

         //using switch as expression
        String result = "";
        result = switch(day)
        {
            case "Saturday","Sunday" -> "9";
            case "Monday" -> "8";
            default -> "7";

        };
        System.out.println(result);


    }
}