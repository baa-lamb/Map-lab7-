
import java.io.*;
import java.util.Map;

/**
 * Created by Алена on 19.04.2017.
 */
public class Grag {
    private int [][] matrix;
    private int size = 0;

    public Grag(int size1) {
        size = size1;
        matrix = new int[size1][size1];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                matrix[i][j] = 0;
    }

    public boolean get(int r, int c){
        if (r >= size || c >= size)
            return false;
        if(matrix[r][c] == 1 || matrix[c][r] == 1)
            return true;
        return false;
    }

    public void set(int r, int c) {
        matrix[r][c] = 1;
        matrix[c][r] = 1;
    }

    public void saveFromBinaryFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buffer;
        for(int i = 0; i < size; i++) {
            String s = "";
            for(int j = 0; j < size; j++){
                s = s + matrix[i][j];
            }
            s = s + "\n";
            buffer = s.getBytes();
            fos.write(buffer);
            fos.flush();
        }
        fos.close();
    }

    public void saveToTextFile(String filename) throws  IOException{
        FileWriter fos = new FileWriter(filename, false);
        for(int i = 0; i < size; i++) {
            String s = "";
            for (int j = 0; j < size; j++) {
                s = s + matrix[i][j];
            }
            s = s + "\n";
            fos.write(s);
            fos.flush();
        }
        fos.close();
    }

    public void loadFromTextFile(String filename) throws IOException {
        FileReader fin = new FileReader(filename);

        int j = 0;
        int r = 0;
        int val = 0;

        int i;
        while((i = fin.read())!=-1) {
            if (i == '\n') {
                j++;
                r = 0;
                continue;
            }
           else  {
                matrix[r][j] = (int)i - '0';
                matrix[j][r] = (int)i - '0';
                r++;
                continue;
            }

        }
    }

    public void loadFromBinaryFile(String filename) throws  IOException{
        FileInputStream fin = new FileInputStream(filename);

        byte[] buffer = new byte[fin.available()];
        fin.read(buffer, 0, fin.available());

        int j = 0;
        int r = 0;

        for(int i=0; i < buffer.length; i++) {
            if ((char)buffer[i] == '\n') {
                j++;
                r = 0;
                continue;
            }
            else  {
                matrix[r][j] = (int)i - '0';
                matrix[j][r] = (int)i - '0';
                r++;
                continue;
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrix[i][j] == 1)
                str.append(i + " -> " + j + "\n");
            }
        }
        return str.toString();
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(this == null)
            return false;
        if(!(o instanceof Grag))   //this.getClass() != o.getClass()
            return false;

        Grag obj = (Grag) o;
        if(size != obj.size)
            return false;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++)
                if(matrix[i][j] != obj.matrix[i][j])
                    return false;
        }

        return true;
    }
}
