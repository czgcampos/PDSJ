package Main;

import Controller.*;
import Model.*;
import View.*;
import static java.lang.System.out;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DateTimeMVCApp {

	private static InterfaceDateTimeModel createData(String file) {
		DateTimeModel model = DateTimeModel.of();
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			model = DateTimeModel.of((DateTimeModel) ois.readObject());
			ois.close();
		} catch(Exception e){
			System.out.println("Não foi possível ler os dados: "+e);
		}
		return model;
	}

	private static void saveData(String file, InterfaceDateTimeModel model) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(model);    
			oos.flush();
			oos.close();
		}catch(Exception e) {
			out.println("Ocorreu um erro ao guadar os dados: "+e);
		}
	}

	public static void main(String[] args) {
		InterfaceDateTimeModel model = createData("Schedule.dat");
		InterfaceDateTimeView view = new DateTimeViewTxt();
		DateTimeController control = new DateTimeController();
		control.setModel(model);  
		control.setView(view);
		control.startFlow();
		saveData("Schedule.dat",model);
		out.println("Fim da Aplicação >> " + java.time.LocalDateTime.now());
		System.exit(0);
	}
}