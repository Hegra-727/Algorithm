package Daily.Oct2023;

public class 老人的数目2678 {
    public int countSeniors(String[] details) {
        char[] ch=new char[15];
        int count=0;
        for (int i = 0; i < details.length; i++) {
            if(details[i].charAt(11)-'0'>6){
                count++;
                continue;
            }
            if(details[i].charAt(11)-'0'>=6&&details[i].charAt(12)-'0'>0){
                count++;
            }
        }
        return count;
    }
}
