package leetedCode;

public class CompareStr {

    public static boolean isUnique(String astr) {
        if (astr.length() == 1 || astr.length() == 0) {
            return true;
        }
        boolean flag = true;
        for (int i = 0, len = astr.length(); i < len -1; i++){
            System.out.println(astr.charAt(i));
            System.out.println(astr.indexOf(astr.charAt(i)));
            System.out.println(astr.lastIndexOf(astr.charAt(i)));
            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))){
                flag =false;
            }
            System.out.println("---------");
        }
        return flag;
    }

    public static void main(String[] args) {
        String str = "yangjichao";
        System.out.println(isUnique(str));
    }
}
