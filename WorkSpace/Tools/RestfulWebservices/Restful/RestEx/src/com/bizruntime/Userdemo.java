package com.bizruntime;

import java.io.*;
import java.util.*;

public class Userdemo {
	public static List<User> list=new ArrayList<User>();
	
	public List<User> getList(){
		return list;
	}
	
	public void setList(List<User> list){
		Userdemo.list=list;
	}
	public List<User> userList(){
		return list;
	}
	
	/*public List<User> getallusers(){
		List<User> list=null;
		try{
			File file=new File("/home/santanu/rest/Users.dat");
			if(!file.exists()){
				User user=new User(101,"Santanu");
				list=new ArrayList<User>();
				list.add(user);
				saveUserList(list);
			}
			else{
				FileInputStream fis=new FileInputStream(file);
				ObjectInputStream ois=new ObjectInputStream(fis);
				list=(List<User>)ois.readObject();
				ois.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
    public int addUser(User user){
	   List<User> list=getallusers();
	   boolean userexist=false;
	   for(User fuser:list){
		   if(fuser.getUid()==user.getUid()){
			   userexist=false;
			   break;
		   }
	   }
	   if(!userexist){
		   list.add(user);
		   saveUserList(list);
		   return 1;
	   }
	   return 0;
    }
    
    public int updateUser(User user){
    	List<User> list=getallusers();
    	for(User u:list){
    		if(u.getUid()==user.getUid()){
    			int i=list.indexOf(u);
    			list.set(i, user);
    			saveUserList(list);
    			return 1;
    		}
    	}
    	return 0;
    }
    
    public void saveUserList(List<User> list){
    	try{
    		File file=new File("/home/santanu/rest/Users.dat");
        	FileOutputStream fos=new FileOutputStream(file);
        	ObjectOutputStream oos=new ObjectOutputStream(fos);
        	oos.writeObject(list);
        	oos.close();
        	
    	}catch(Exception e){
    		e.printStackTrace();
    	}	
    }*/
}
