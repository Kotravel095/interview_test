import java.util.ArrayList;

public class Prime_Number {
    public static void main(String[] arg)
    {
        primeAndNember("Hello");
        primeAndNember("10");
        // primeAndNember("100");
        // primeAndNember("1000");
        // primeAndNember("10000");
    }

    private static void primeAndNember(String input)
    {
        try {
            int number_input = Integer.parseInt(input);
            System.out.println("input is : " + number_input);
            Action(number_input);
            System.out.println("---------------");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void Action(int input)
    {
        ArrayList<Integer> primeNumber = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        for(int i = 1; i < input; i ++)
        {  
            if(i == 1){
                number.add(i);
            } else {
                int count = 0;

                // ไล่หารตั้งแต่ i ลงไปจนถึง 1 แล้วดูว่ามีกี่คู่ที่หารลงตัว
                // ซึ่งจำนวนเฉพาะจะมีแค่ 2 คู่ที่หารลงตัวคือ 1 และตัวมันเอง
                for(int j = i; j > 0; j--){
                    if(i % j == 0){
                        count ++;
                    }
                    if(count > 2){
                        break;
                    }
                }

                // ดังนั้นถ้าหารลงตัวมากกว่า 2 คู่จึงเป็น "จำนวนไม่เฉพาะ"
                // แต่ถ้าหารลงตัว แค่ 2 คู่ คือ 1 กับตัวมันเอง จึงเป็น "จำนวนเฉพาะ"
                if(count > 2){
                    number.add(i);
                } else {
                    primeNumber.add(i);
                }
            }
        }
        System.out.println("number is : " + number);
        System.out.println("primeNumber is : " + primeNumber);
    }

}