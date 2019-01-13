package Controller;

import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {

	public static String readString() {
		Scanner input = new Scanner(in);
		boolean ok = false; 
		String txt = "";
		while(!ok) {
			try {
				txt = input.nextLine();
				ok = true;
			} catch(InputMismatchException e) {
				out.println("Texto Invalido");
				out.print("Novo valor: ");
				input.nextLine(); 
			}
		}
		return txt;
	}

	public int readSequence(String[] v,String palavra) {
		int res=0;
		String aux;
		for(;true;res++) {
			aux=readString();
			if(aux.equals(palavra))
				break;
			else {
				v[res]=new String(aux);
			}
		}
		return res;
	}

	public static int readInt() {
		Scanner input = new Scanner(in);
		boolean ok = false;
		int i = 0;
		while(!ok) {
			try {
				i = input.nextInt();
				ok = true;
			} catch(InputMismatchException e) {
				out.println("Inteiro Invalido");
				out.print("Novo valor: ");
				input.nextLine();
			}
		}
		return i;
	}
	
	public static int readPositiveInt() {
		Scanner input = new Scanner(in);
		boolean ok = false;
		int i = 0;
		while(!ok) {
			try {
				i = input.nextInt();
				if(i>=0)
					ok = true;
				else {
					out.println("Inteiro negativo");
					out.print("Novo valor: ");
					input.nextLine();
				}
			} catch(InputMismatchException e) {
				out.println("Inteiro Invalido");
				out.print("Novo valor: ");
				input.nextLine();
			}
		}
		return i;
	}

	public static double readDouble() {
		Scanner input = new Scanner(in);
		boolean ok = false;
		double d = 0.0;
		while(!ok) {
			try {
				d = input.nextDouble();
				ok = true;
			} catch(InputMismatchException e) { 
				out.println("Valor real Invalido");
				out.print("Novo valor: ");
				input.nextLine(); 
			}
		}
		return d;
	}

	public static float readFloat() {
		Scanner input = new Scanner(in);
		boolean ok = false;
		float f = 0.0f;
		while(!ok) {
			try {
				f = input.nextFloat();
				ok = true;
			} catch(InputMismatchException e) { 
				out.println("Valor real Invalido");
				out.print("Novo valor: ");
				input.nextLine(); 
			}
		}
		return f;
	}

	public static boolean readBoolean() {
		Scanner input = new Scanner(in);
		boolean ok = false; 
		boolean b = false; 
		while(!ok) {
			try {
				b = input.nextBoolean();
				ok = true;
			} catch(InputMismatchException e) { 
				out.println("Booleano Invalido");
				out.print("Novo valor: ");
				input.nextLine();
			}
		}
		return b;
	}

	public static short readShort() {
		Scanner input = new Scanner(in);
		boolean ok = false;
		short s = 0; 
		while(!ok) {
			try {
				s = input.nextShort();
				ok = true;
			} catch(InputMismatchException e) {
				out.println("Short Invalido");
				out.print("Novo valor: ");
				input.nextLine(); 
			}
		}
		return s;
	}
}