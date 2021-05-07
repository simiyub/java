import java.io.File;
import java.io.FileFilter;

public class App {
    public static void main(String[] args) {
        File dir = new File("/Users/simiyub/Development/code/java/learn/whats-new-java8/src/main/java");
        for (File x: dir.listFiles(new JavaFileFilter())){
            System.out.println(x.getName());
        }

        for (File x: dir.listFiles(new FileFilter(){
            public boolean accept(File fileName){
                return fileName.getName().endsWith(".java");
            }
        })){
            System.out.println("anonymous: "+x.getName());
        }
    }

    public static class JavaFileFilter implements FileFilter{

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".java");
        }
    }

}
