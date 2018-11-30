package Novo.Cron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainCron {

   
    @Scheduled(cron="${cron.expression}")
    private void exec(){  
    	try {
    		String nomeBkp = "/home/luis/Desktop/nomeome123.sql";
    		Runtime runtime = Runtime.getRuntime();
    		Process child = runtime.exec("mysqldump -v -v -v --host=g.cowreym0hdhn.sa-east-1.rds.amazonaws.com --user=g --port=3306 --password=12345678 --protocol=tcp --force --allow-keywords --compress --add-drop-table --result-file=" + nomeBkp + " --databases NOVO ");
   
    	    System.out.println("Backup realizado" + child);
    	    
    	    
    	}  catch (IOException ex) {
        			   JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
        System.out.println("Backup não realizado");		
    	
    	}
    }
}
