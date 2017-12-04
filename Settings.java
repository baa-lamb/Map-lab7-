

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Алена on 18.04.2017.
 */
public class Settings {
    private Map <String, Integer> MyMap;

    public Settings() {
        MyMap = new HashMap<String, Integer>();
    }

    public void put(String s, int Int) {
        MyMap.put(s, Int);
    }

    public int get(String s){
        return MyMap.get(s);
    }

    public void delete(String s) {
        MyMap.remove(s);
    }

    public void saveFromBinaryFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buffer;
        for(Map.Entry i : MyMap.entrySet()) {
            String s = i.getKey()+ " " + i.getValue() + '\n';
            buffer = s.getBytes();
            fos.write(buffer);
        }
        fos.close();
    }

    public void loadFromBinaryFile(String filename) throws  IOException{
        FileInputStream fin = new FileInputStream(filename);

        byte[] buffer = new byte[fin.available()];
        fin.read(buffer, 0, fin.available());

        int count  = 0;
        String skey = "";
        String sValue = "";
        int val = 0;
        for(int i=0; i < buffer.length; i++) {
            if ((char) buffer[i] == '\n') {
                count = 0;
                val = Integer.parseInt(sValue);
                MyMap.put(skey, val);
                skey = "";
                sValue = "";
                val = 0;
                continue;
            }
            if ((char) buffer[i] == ' ') {
                count = 1;
                continue;
            }
            if (count == 0) {
                skey = skey + (char) buffer[i];
                continue;
            }
            if (count == 1) {
                sValue = sValue + (char) buffer[i];
            }
        }
    }

    public void loadFromTextFile(String filename) throws IOException {
        FileReader fin = new FileReader(filename);

        int count  = 0;
        String skey = "";
        String sValue = "";
        int val = 0;

        int i;
        while((i=fin.read())!=-1) {
            if (i == '\n') {
                count = 0;
                val = Integer.parseInt(sValue);
                MyMap.put(skey, val);
                skey = "";
                sValue = "";
                val = 0;
                continue;
            }
            if (i == ' ') {
                count = 1;
                continue;
            }
            if (count == 0) {
                skey = skey + (char)i;
                continue;
            }
            if (count == 1) {
                sValue = sValue + (char)i;
            }
        }
    }

    public void saveToTextFile(String filename) throws  IOException{
        FileWriter fos = new FileWriter(filename, false);
        for(Map.Entry i : MyMap.entrySet()) {
            String s = i.getKey()+ " " + i.getValue() + '\n';
            fos.write(s);
        }
        fos.close();
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry i : MyMap.entrySet()){
            str.append(i.getKey() + ":   " + i.getValue() + "\n");
        }
        return str.toString();
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(this == null)
            return false;
        if(!(o instanceof Settings))   //this.getClass() != o.getClass()
            return false;

        Settings obj = (Settings) o;
        if(MyMap.size() != obj.MyMap.size())
            return false;

        for(Map.Entry i : MyMap.entrySet()) {
            int count  = 0;
            for(Map.Entry j : obj.MyMap.entrySet()) {
                if(i.getKey() == j.getKey() && i.getValue() == j.getValue()){
                   count = 1;
                   break;
                }
            }
            if(count == 0)
                return false;
        }
        return true;
    }
}
