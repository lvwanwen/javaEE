package package2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    // 1. 第一行是固定的, 就只有一个 1
    // 2. 第二行也是固定的, 就只有两个 1
    // 3. 任意一行, 开头和结尾也都是 1
    // 4. 第 i 行, 有 i 列
    // 5. 第 i 行的第 j 列, 这个数字是根据 i - 1行的j - 1列和 j 列相加
    public List<List<Integer>> generate(int numRows){
        //所有的为list,这个list中的每一行也是list
        if(numRows<=0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //插入第一行
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows==1){
            return result;
        }
        //插入第二行
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows==2){
            return result;
        }
        //插入第i行
        for (int row = 3; row <= numRows; row++){
            // row 本来是 从 1 开始计数的.
            // row - 1 是把从 1 开始计数的数字转成下标.
            // row - 1 - 1 取到上一行的下标
            List<Integer> prevLine = result.get(row - 1 - 1);//?
            // 创建一个表示当前行的 List
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 1; col < row - 1; col++){
                curLine.add(prevLine.get(col - 1) + prevLine.get(col));
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
