import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {                                    //1
        if (list.size() <= 0) {                                                                 //2
            throw new IllegalArgumentException("List length should be greater than 0");         //3
        }                                                                                       //4
        int n = list.size();                                                                    //5
        int rootOfN = (int) Math.sqrt(n);                                                       //6
        if (rootOfN * rootOfN  != n) {                                                          //7
            throw new IllegalArgumentException("List length should be a perfect square");       //8
        }                                                                                       //9
        List<String> numMines = new ArrayList<>();                                              //10
        for (int i = 0; i < n; i++) {                                                           //11
            if (!list.get(i).equals("#")) {                                                     //12
                int num = 0;                                                                    //13
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) {   //14
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){ //15
                        num += 2;                                                               //16
                    }                                                                           //17
                    else {                                                                      //18
                        num  += 1;                                                              //19
                    }                                                                           //20
                }                                                                               //21
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){                     //22
                    num++;                                                                      //23
                }                                                                               //24
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){                      //25
                    num++;                                                                      //26
                }                                                                               //27
                numMines.add(String.valueOf(num));                                              //28
            }                                                                                   //29
            else {                                                                              //30
                numMines.add(list.get(i));                                                      //31
            }                                                                                   //32
        }                                                                                       //33
        return numMines;                                                                        //34
    }
}