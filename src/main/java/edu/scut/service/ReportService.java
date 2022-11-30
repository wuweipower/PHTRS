package edu.scut.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ReportService {
    public HashMap<String,String> street_district;

    public int calPriority(Integer size,String location,String street,String district)
    {
        if(verifyReport(size,location,street,district))
        {
            if(size<3)
                return 3;
            else if(size<6)
                return 2;
            else return 1;

        }
        return -1;
    }
    public boolean verifyReport(Integer size,String location,String street,String district)
    {
        if(size<0 || size>10)
        {
            return false;
        }
        if(!location.equals("middle") && !location.equals("curb"))
        {
            return false;
        }
        HashMap<String, String> street_district1 = getStreet_district();

        if(!street_district1.get(street).equals(district))
        {
            return false;
        }
        return true;
    }

    public HashMap<String, String> getStreet_district() {
        street_district = new HashMap<>();
        street_district.put("A","B");
        street_district.put("C","D");
        return street_district;
    }
}
