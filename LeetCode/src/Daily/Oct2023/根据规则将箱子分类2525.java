package Daily.Oct2023;

public class 根据规则将箱子分类2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy=mass>=100;
        boolean isBulky=length>=10000||width>=10000||height>=10000||(long)length*width*height>=1000000000;
        if (isBulky&&isHeavy)
            return "Both";
        else if (isBulky)
            return "Bulky";
        else if (isHeavy)
            return "Heavy";
        else
            return "Neither";
    }
}
