package com.cf.helloworld.response;

import java.util.Date;

public class CustomerDetailResponse
{
    public final String id;
    public final String name;
    public final String emailAddress;
    public final Date birthday;
    
    public CustomerDetailResponse(String id, String name, String emailAddress, Date birthday)
    {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.birthday = birthday;
    }
}
