public class CommonFunctionality {

    public static void count(Object source, int counter){
        StringBuilder builder = new StringBuilder();
        if (counter>=0) for(int i=0;i<=counter;i++)  builder.append(i).append(' ');
        System.out.println();
        System.out.printf("%s:%s",source.getClass().getName(),builder);
        System.out.println();
    }

}
