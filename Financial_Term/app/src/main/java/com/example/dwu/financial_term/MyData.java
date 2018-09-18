package com.example.dwu.financial_term;

import android.media.Image;
import android.widget.ImageButton;

/**
 * Created by 전승원 on 2018-07-23.
 */

public class MyData {
    private String _id;
    private String content;

    public MyData(String _id, String content){
        this._id = _id;
        this.content = content;

    }
    public String get_id(){return _id;}
    public void set_id(String _id){this._id=_id;}
    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}

}
