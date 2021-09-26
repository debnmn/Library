package com.bjpowernode.util;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InitDataUtil {
    public static void main(String[] args) {
        initUser(null);
    }

    public static void initUser(List<User> userList){
        ObjectOutputStream oos = null;
        try {
            File directory = new File("user/");
            File file = new File(PathConstant.USER_PATH);
            if(!directory.exists()){
                directory.mkdir();
            }
            if (!file.exists()){
                file.createNewFile();
                List<User> list = new ArrayList<>();
                if (userList == null){
                    list.add(new User(1001,"’≈¥Ûª¢", Constant.USER_OK, BigDecimal.TEN));
                }
                else{
                    list = userList;
                }
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
                oos.writeObject(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
