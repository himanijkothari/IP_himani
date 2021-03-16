/**
 * Class that is used in writing tasklist to the text file
 * and vice versa
 * @author : Himani Paronigar
 */
package ip.todolist;

import java.util.ArrayList;

public class TaskToFile {

   /* Task_List taskList;

    public boolean saveToFile(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean readFromFile(String fileName)
    {
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(fileName)))
            {
                System.out.println("The data file, i.e., " + fileName + " does not exists");
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (Task_List) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }



    }*/

}
