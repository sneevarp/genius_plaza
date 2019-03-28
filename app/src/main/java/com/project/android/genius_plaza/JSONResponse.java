package com.project.android.genius_plaza;

import java.util.ArrayList;

class JSONResponse {
    private ArrayList<Users> data;

   public ArrayList<Users> getUsers(){
       return data;
   }
   public void setData(ArrayList<Users> users){
       this.data=users;
   }
}
