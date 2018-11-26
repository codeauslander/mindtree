public class Hello {
    public static void main(String[] args){

//        8 Primitive data types are byte, short, int, long, float, double, char, boolean

        int number = (int) ((5 + 5) / (0.5 * 4));

//        long has a width of 64
        long minLong = -9_223_372_036_854_775_808L;
        long maxLong = 9_223_372_036_854_775_807L;
        long castLong = maxLong / 2;

//        int has a width of 32
        int minInteger = -2_147_483_648;
        int maxInteger = 2_147_483_647;
        int castInteger = maxInteger / 2;

//        byte has a width of 8
        byte minByte = -128;
        byte maxByte = 127;
        byte castByte = (byte) (maxByte / 2);

//        short has a width of 16
        short minShort = -32_768;
        short maxShort = 32_767;
        short castShort = (short) (maxShort / 2);

//        float has 7 decimal values (4 bytes) with a width of 32
        float notationFloat = -5f;
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;

//        double has 16 decimal values (8 bytes) with a width of 64
        double notationDouble = -5d;
        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;


        int value = maxByte * maxShort;

        System.out.println(
                "Hello World!" +
                "\nHello Cesar"+" Hi "+ number +
                "\n minimum Long: "+minLong+" maximum Long: " + maxLong +
                "\n minimum Integer: "+minInteger+" maximum Integer: " + maxInteger +
                "\n minimum Byte: "+minByte+" maximum Byte:" + maxByte +
                "\n minimum Short: "+minShort+" maximum Short: " + maxShort +
                "\n smaller widths can operate inside bigger ones: "+ value +
                "\n minimum Float: "+minFloat+" maximum Float: " + maxFloat +
                "\n minimum Double: "+minDouble+" maximum Double: " + maxDouble
        );

        double pounds = 200;
        double kilograms = pounds * 0.453_592_37;
        System.out.println("200 pounds to kilograms: "+kilograms);

        char unicodeChar = '\u00a9';
        char registeredSymbol = '\u00ae';
        boolean is = true;
        System.out.println("Unicode character: " + unicodeChar + " It works: "+ is + " "+ registeredSymbol);

// almost a primitive type the ninth
        String sentence = "This is a String";
        sentence = sentence + " and there is more \u00a9";
        System.out.println(sentence);

        if(is)
            System.out.print("\nYes");

        boolean no = false;
        if(no = true)
            System.out.print("\nNo");
//        Check operators precedence

    }
}
