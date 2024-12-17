/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoftt.quiz;

/**
 *
 * @author M.osman
 */
public class eelubulider {
    private String name;
    private String establishedDate;
    
    public eelubulider name (String Name){
    this.name=Name;
    return this;
    }
    
    public eelubulider data (String data){
    this.establishedDate=data;
    return this;
    }
    
  
    public eelu bulid(){
     return new eelu(name,establishedDate);
        
    }
}
