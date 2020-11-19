package com.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Page
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/11/5
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Page {

    private int current=1;
    private int limit=10;
    private int rows;
    private String path;

    public int getOffset(){
        return (current-1)*limit;
    }

    public int  getTotal(){

        if (rows % limit==0){
            return rows/limit;
        }else {
            return rows/limit+1;
        }
    }

    public int getFrom(){
        int from=current-2;
        return from < 1 ? 1:from;
    }

    public int getTo(){
            int to=current+2;
            int total=getTotal();
            return to > total ? total:to;
    }


}
