package com.example.firebase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void IsValid()
    {
        String phone = "88005553535";
        String email = "mail123@mail.com";
        String password ="jo-jo3BA";
        String password2 = "jo-jo3BA";
        boolean exp = true;
        CheckData cd = new CheckData();
        boolean isVal = cd.Check(email,password,password2,phone);
        assertEquals(exp,isVal);

    }
}