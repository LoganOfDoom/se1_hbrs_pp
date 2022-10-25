package org.hbrs.se1.ws22.uebung3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location;

    public PersistenceStrategyStream(){
        location = "H:\\Dateien\\IntelliJWorkspace\\java\\src\\org\\hbrs\\se1\\ws22\\members.xml";
    }

    public PersistenceStrategyStream(String loc){
       location = loc;
    }

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException  {
        try{
            XMLEncoder e = new XMLEncoder(
                    new ObjectOutputStream(
                            new FileOutputStream(location)));
            e.writeObject(member);
            e.close();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {

        XMLDecoder d = null;
        try {
            d = new XMLDecoder(
                    new ObjectInputStream(
                            new FileInputStream(location)));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        List<E> result = (List<E>) d.readObject();
        d.close();

        return result;
        // Some Coding hints ;-)

        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)

    }
}