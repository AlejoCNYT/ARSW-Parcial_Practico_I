/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

// import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;dafasd
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {


    public static void main(String a[]){
        HostBlackListsValidator hblv=new HostBlackListsValidator();
        List<Integer> blackListOcurrences=hblv.checkHost("200.24.34.55", 1000);
        System.out.println("The host was found in the following blacklists:"+blackListOcurrences);

        HostBlackListsServerResearcher hblsr = new HostBlackListsServerResearcher();
        List<Integer> serverResearch=hblsr.findServer("200.24.34.55", 2, 4);
        System.out.println("The disponible server segment was found in the following blacklists:"+serverResearch);
        
    }
    
}
