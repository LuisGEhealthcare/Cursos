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
    		String nomeBkp = "C:/Users/212719040/Desktop/nomeome123.sql";
    		Runtime runtime = Runtime.getRuntime();
    		Process child = runtime.exec("cmd.exe /c mysqldump -h g.cowreym0hdhn.sa-east-1.rds.amazonaws.com -u g -p12345678 NOVO > " + nomeBkp);
    		File backupFile = new File(nomeBkp);
    		FileWriter fw = new FileWriter(backupFile);
    		InputStreamReader irs = new InputStreamReader(child.getInputStream());
    	    BufferedReader br = new BufferedReader(irs);

    	    String line;
            while( (line=br.readLine()) != null )
            {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();
    	    System.out.println("Backup realizado");
    	    
    	    
    	}  catch (IOException ex) {
        			   JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
        System.out.println("Backup não realizado");		
    	
    	}
    }
}
