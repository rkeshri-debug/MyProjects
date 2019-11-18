import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;



public class ConvertPropToJson {

	public static void main(String[] args) throws IOException {
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("C://Users//Rahul Keshri//eclipse-workspace//JavaTask//src//config.properties");
		prop.load(ip);
		//System.out.println(prop.getProperty("db.password"));
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(String key : prop.stringPropertyNames()){
			sb.append("\"" +key + "\":");
			sb.append("\"" + prop.getProperty(key) + "\",");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("}");
		System.out.println(sb.toString());
		
		File file =new File("C://Users//Rahul Keshri//eclipse-workspace//JavaTask//src//output.json");
		FileWriter fr = null;
		try{
			fr = new FileWriter(file);
			fr.write(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fr.close();
		}
		
		System.out.println("content writed successfully");
		

	}

}
