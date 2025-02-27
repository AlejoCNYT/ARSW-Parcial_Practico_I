/*Cree una clase de tipo Thread que represente el ciclo de vida de un hilo
 que haga la búsqueda de un segmento del conjunto de servidores disponibles.*/
package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;
import java.util.List;


public class HostBlackListsServerResearcher extends Thread
{

    List<Integer> findServer(String Ip, int BLACK_LIST_ALARM_BEGIN, int BLACK_LIST_ALARM_FINAL)
    {
        LinkedList<Integer> blackListOcurrences=new LinkedList<>();

        int ocurrencesCount=0;

        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();

        int checkedListsCount=0;

        for (int i=BLACK_LIST_ALARM_BEGIN;i<skds.getRegisteredServersCount() && ocurrencesCount<BLACK_LIST_ALARM_FINAL;i++)
        {
            checkedListsCount++;

            if (skds.isInBlackListServer(i, Ip))
            {

                blackListOcurrences.add(i);

                ocurrencesCount++;
            }
        }

        return blackListOcurrences;
    }

/*    public String getServer()
    {
        return server;
    }*/
}
