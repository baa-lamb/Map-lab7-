
import java.io.IOException;

/**
 * Created by Алена on 18.04.2017.
 */
public class Main {
    public static void main(String[] args){
        Settings s1 = new Settings();
        Settings s2 = new Settings();

        s1.put("AAA", 1);   s2.put("AAA", 1);
        s1.put("BBB", 1);   s2.put("BBB", 1);
        s1.put("CCC", 2);   s2.put("CCC", 2);
        s1.put("AAA", 0);   s2.put("AAA", 0);


        System.out.println(s1);
        System.out.println(s2);

        if(s1.equals(s2))
            System.out.println(1);
        else
            System.out.println(0);

	String path = "C:\\Users\\Алена\\IdeaProjects\\laba7\\l\\f.txt";
       /* try {
            s2.saveToTextFile(path); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s1.loadFromTextFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s1);

        Grag g = new Grag(5);
        Grag g2 = new Grag(5);
        g.set(0,1);
        g.set(1,3);
        g.set(2,2);
        //System.out.println(g);
        try {
            g.saveFromBinaryFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            g2.loadFromTextFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(g2);

        if(g2.equals(g))
            System.out.println(1);
        else
            System.out.println(0);*/

    }
}
