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
public class We implements internetserivceprovider {

    @Override
    public String servesite(String url) {
       return String.format("https://%s.com",url);
    }
    
}
