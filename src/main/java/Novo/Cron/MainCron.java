package Novo.Cron;


import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainCron {
    
	
		String novo1;
	
	
	@Scheduled(cron="${cron.expression}")
    private void exec(){  
    	try {
    		
    		java.util.Date date = Calendar.getInstance().getTime();
    		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    		
    		Date data = new Date(System.currentTimeMillis());
    		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
    				
    		String today = formatter.format(date);
    		String Day = formatarDate.format(data);
    		
    		
    		
    		String nomeBkp = "/home/luis/Desktop/" + today +"--"+ Day + ".sql" ;
    		Runtime runtime = Runtime.getRuntime();
    		Process novo1 = runtime.exec("mysqldump -v -v -v --host=g.cowreym0hdhn.sa-east-1.rds.amazonaws.com --user=g --port=3306 --password=12345678 --protocol=tcp --force --allow-keywords --compress --add-drop-table --result-file=" + nomeBkp + " --databases NOVO ");
   
    	    System.out.println("Backup realizado" + novo1);
    	    
    		
    	}  catch (IOException ex) {
        			   JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
        System.out.println("Backup não realizado");		
    	
    	}
    }
    
	/*private void exec2 () {
    	try {
    			
    		Runtime runtime = Runtime.getRuntime();
    		Process novo2 = runtime.exec("aws cp *.sql s3://crons3/backup/*.sql");
    		
    		
    	}catch(IOException ex){
    		
    		
    		
    		}
	
		}*/
    
    }

