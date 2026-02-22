class Hello
{
    public static void main(String args[])
    {
        System.out.println("Hello World");
        float num1 = 5.6f; //f is required when using float to declare decimal value
        double num2 = 4.56;
        int num3 = 3;
        byte by = 127;
        short sh = 234;
        long l = 234503l;

        char c = 'a';
        boolean b = true;

        int bin = 0b1001;  //binary literals
        int hex = 0xEFA; //hexadecimal literals
        int z = 1_00_00_000; //trick to keep a count of multiple zeros
        double p = 23e10; //10 raise to the power
        char ch = 'b';
        ch++;//character inccrement

        int num10 = 257;
        byte numb = 11;
        byte numb2 = 23;
        numb = (byte)num10; //type casting int(4bytes) into -> byte(1 byte)  EXPLICIT TYPE CASTING
        int num11 = numb2; //type conversion byte(1 byte) into -> int(4 bytes) IMPLICIT TYPE CONVERSION
        float marks = 23.78f;
        int intmarks = (int)marks;
        long longnumb = (long)num10;

        byte b1 = 10;
        byte b2 = 30;
        int resultb = b1*b2;


        int arth = 4;

        // arth++   post - increment
        // ++arth   pre increment

        System.out.println(arth++); // first fetch the value of arth and then perform the increment
        System.out.println(++arth); //first increments the value and then performs the increment


        // System.out.println(num1);
        // System.out.println(num2);
        // System.out.println(num3);
        // System.out.println(by);
        // System.out.println(sh);
        // System.out.println(l);
        // System.out.println(c);
        // System.out.println(b);
        // System.out.println(bin);
        // System.out.println(hex);
        // System.out.println(z);
        // System.out.println(p);
        // System.out.println(ch);
        // System.out.println(numb);
        // System.out.println(num11);
        //  System.out.println(resultb);
    }
}