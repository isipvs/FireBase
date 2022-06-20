package com.example.firebase;

import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {

    String Info;

    public boolean Check(String email, String password, String password2, String phone)
    {
        int i=0;
        Info="";
        Pattern emailP = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Pattern passP = Pattern.compile("[A-Za-z0-9*/<|>-]");
        Pattern phoneP = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Pattern rusP = Pattern.compile("[А-Яа-я]");

        Matcher emailM = emailP.matcher(email);
        Matcher passM = passP.matcher(password);
        Matcher phoneM=phoneP.matcher(phone);

        Matcher rusMpass =rusP.matcher(password);
        Matcher rusMemail =rusP.matcher(email);


        if(emailM.find()==true)
        { i++; } else {Info+="-Неверный формат почты;\n";}


        if(passM.find()==true)
        { i++; } else {Info+="-Неверный формат пароля;\n";}

        if(password.equals(password2)==true)
        { i++; } else {Info+="-Пароли не совпадают;\n";}

        if(password.length()>=7)   { i++; } else {Info+="-Минимальная длина пароля - 7 символов;\n";}

        if(phoneM.find()==true)
        { i++; }else {Info+="-Неверный формат телефона;\n";}

        if(rusMemail.find()==false || rusMpass.find()==false)
        { i++; } else {Info+="-В почте и пароле не должно быть кириллицы;\n";}



        if(i==6)
        {return true;}
        else
        return false;

    }

    public String getInfo()
    {
        return Info;
    }

}
