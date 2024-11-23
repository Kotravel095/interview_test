public class Water_Bill {
    public static void main(String[] arg){

        calculateWaterBill(-1);
        calculateWaterBill(0);
        calculateWaterBill(5);
        calculateWaterBill(19);
        calculateWaterBill(23);
        calculateWaterBill(39);
        calculateWaterBill(20000);
        calculateWaterBill(5000000);

    }

    private static void calculateWaterBill(int used_unit)
    {
        if(used_unit < 0){
            System.out.println("จำนวนหน่วยผิดพลาด กรุณาตรวจสอบใหม่อีกครั้ง!!!");
        } else {
            int result = calculate(used_unit);
            System.out.println("ใช้ไป " + used_unit + " หน่วย จ่ายเป็นจำนวนเงิน " + result + " บาท");
        }
    }

    private static int calculate(int unit)
    {  
        int fee = 50;
        int result = 0;

        if(unit == 0){
            return fee + result;
        }

        // ผมมองช่วงของ ราคาอัตราต่อหน่วย เป็น 4 ช่วง ให้แต่ละช่วงแทน array ของ 4 ตำแหน่ง 
        // {ตำแหน่งที่ 0 = อัตราราคา 5 บาท , ตำแหน่งที่ 1 = อัตราราคา 10 บาท,ตำแหน่งที่ 2 = อัตราราคา 30 บาท,ตำแหน่งที่ 3 = อัตราราคา 50 บาท} 
        // แล้วค่า value ของ array แต่ละตำแหน่งคือจำนวนหน่วย
        int[] arrRangePrice = getArrayRangePrice(unit);

        int count = 0;
        for(int unitInRange : arrRangePrice){
            count ++;
            int resPrice = calculatePricePerUnit(count);
            result += (unitInRange * resPrice);
        }
        result += fee;

        return result;
    }

    private static int[] getArrayRangePrice(int unit)
    {
        int[] arr = {0,0,0,0};
        int total = 0;

        if(unit > 30){
            total = unit - 30;
            arr = new int[]{10,10,10,total};
        } else if(unit > 20){
            total = unit - 20;
            arr = new int[]{10,10,total,0};
        } else if(unit > 10){
            total = unit - 10;
            arr = new int[]{10,total,0,0};
        } else {
            total = unit;
            arr = new int[]{total,0,0,0};
        }
        return arr;
    }

    private static int calculatePricePerUnit(int input)
    {
        int result = 0;
        switch(input){
            case 1 :
                result = 5;
                break;
            case 2 :
                result = 10;
                break;
            case 3 :
                result = 30;
                break;
            case 4 :
                result = 50;
                break;
            default:
                result = 0;
        }
        return result;
    }
}