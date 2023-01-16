package com.example.btvn.Service;

import com.example.btvn.Model.Staff;

import java.util.ArrayList;
import java.util.List;

public class ServiceStaff {
    public static List<Staff> staffList= new ArrayList<>();
    static {
        staffList.add(new Staff("1","Tien",18,15000,0));
        staffList.add(new Staff("2","Nam",22,16000,1));
        staffList.add(new Staff("3","Hai",40,19000,2));
    }

    public static void Delete(String index){

        staffList.remove(index);

    }
    public static int findbyid(String employeeCode ){
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getEmployeeCode().equals(employeeCode)){
                return i;
            }

        }
        return -1;
    }

}
