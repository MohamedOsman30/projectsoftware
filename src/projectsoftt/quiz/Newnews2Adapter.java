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
public class Newnews2Adapter implements news {
   private Newnews2 news;
   public Newnews2Adapter(Newnews2 n){
   this.news=n;
   }
    @Override
    public void shownews() {
        this.news.showthenewnews();
    }
    
}
