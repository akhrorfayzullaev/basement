/*
package dao;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogTools {
    private static final int aUser = 0;
    private static final int bUser = 1;
    private static final int kUser = 2;
    private static final int base = 3;

    public String getFolderDirection(int name) {
        File mainDirection = new File(System.getProperty("user.home") + "\\Documents");
        File file = new File(mainDirection + "/Basement_logs");
        if (!file.exists()) {
            if (!file.mkdir()) {
                System.out.println("Log file is not created.............................................................");
            }
        }

        File folderDirection = new File(file.getAbsolutePath());
        if (!folderDirection.exists()) {
            if (!folderDirection.mkdir()) {
                System.out.println(" Folder direction is not founded....................................................");
            }
        }

        File aUserLog = new File(folderDirection.getAbsolutePath() + "/Axror_logs");
        if (!aUserLog.exists()) {
            if (!aUserLog.mkdir()) {
                System.out.println("User folder is not created..........................................................");
            }
        }

        File bUserLog = new File(folderDirection.getAbsolutePath() + "/Bobur_logs");
        if (!bUserLog.exists()) {
            if (!bUserLog.mkdir()) {
                System.out.println("User folder is not created..........................................................");
            }
        }

        File kUserLog = new File(folderDirection.getAbsolutePath() + "/Yigami_logs");
        if (!kUserLog.exists()) {
            if (!kUserLog.mkdir()) {
                System.out.println("User folder is not created..........................................................");
            }
        }

        File baseLog = new File(folderDirection.getAbsolutePath() + "/Base_logs");
        if (!baseLog.exists()) {
            if (!baseLog.mkdir()) {
                System.out.println("Base file is not created............................................................");
            }
        }

        switch (name) {
            case 0:
                return aUserLog.toString();
            case 1:
                return bUserLog.toString();
            case 2:
                return kUserLog.toString();
            case 3:
                return baseLog.toString();
            default:
                break;

        }
        return null;

    }


    */
/*public void logMessage(String message ,int fileName){
            String insideFileName = getFolderDirection(fileName)+"/"+
                    new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())+".txt";
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

            try (BufferedWriter in = new BufferedWriter(new FileWriter(insideFileName,true))) {
                in.write("\n"+date+"--------"+message);
            }catch (Exception exception){
                exception.printStackTrace();
            }
    }*//*

}
*/
