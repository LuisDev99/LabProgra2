package work;

import java.util.Scanner;

public class Hotel {
	static boolean[][] habitaciones = new boolean[6][6];
	static int c = 0, guardarTotal = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = 0, j = 0;

		do {
			System.out.print("****MENU****\n" + "1. Reservar habitacion\n" + "2. Habilitar \"Checkout\"\n"
					+ "3. Informacion del Hotel\n4. Salir del menu\n5. Ver arreglo (Extra)\n" + "Ingrese lo que quiere hacer: ");
			i = scn.nextInt();

			switch (i) {
			case 1:
				System.out.print("\nIngrese que habitacion desea\n" + "1. Habitacion Suite\n" + "2. Habitacion Doble\n"
						+ "3. Habitacion Sencillas\n" + "Ingrese lo que quiere hacer: ");
				j = scn.nextInt();
				boolean hayHabitacion = reservarHabitacion(j);

				if (j > 0 && j < 4) {
					if (hayHabitacion) {
						System.out.println("\nHabitacion reservada!");
						if (j == 3)
							guardarTotal += 1200;
						else if (j == 2)
							guardarTotal += 3400;
						else if (j == 1)
							guardarTotal += 5000;
					} else {
						System.out.println("\nYa no hay habitaciones disponibles :(");
					}
				} else {
					System.out.println("\nPorfavor solo ingrese una de estas opciones");
				}

				break;
			case 2:
				System.out.print("Orden de las habitaciones\n"
						+ "\tFila 0   --> Habitacion Suit\n"
						+ "\tFila 1-2 --> Habitacion Doble\n"
						+ "\tFila 3-4 --> Habitacion Sencilla\n"
						+ "Ingrese la fila: ");
				int fila = scn.nextInt();
				System.out.print("Ingrese la columna: ");
				int columna = scn.nextInt();
				if (fila >= 0 && fila <=5) {
					boolean seRetiro = retirarHabitacion(fila, columna);
					String msg = (seRetiro)?"La habitacion se retiro!":"La habitacion ya estaba vacia";
					System.out.println(msg);
				}else{
					System.out.println("\nPorfavor solo coordenadas correctas!");
				}
				break;
			case 3:
				System.out.println("Cantidad de habitaciones reservadas: "+c);
				System.out.println("Total de dinero en habitaciones ocupadas: "+guardarTotal);
				break;
			case 4:
				System.out.println("Has terminado el menu!");
				break;
			case 5:
				System.out.println();
				for(int l = 0; l<habitaciones.length; l++){
					for (int k = 0; k < habitaciones.length; k++) {
						System.out.print(habitaciones[l][k] + "\t");
					}
					System.out.println();
				}
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				break;
			}

		} while (i != 4);

		scn.close();
	}

	private static boolean retirarHabitacion(int fila, int columna) {
		if(habitaciones[fila][columna] == true){
			habitaciones[fila][columna] = false;
			if(fila == 0){ guardarTotal -= 5000; c--;}
			if(fila >0 && fila <= 2){ guardarTotal -= 3400; c--;}
			if(fila > 2 && fila <= 4){ guardarTotal -= 1200;c--;}
			return true;
		}
	return false;
	}
	
	
	public static boolean reservarHabitacion(int room){
		if(room == 1){
			for (int h = 0; h < habitaciones.length; h++) {
				if(habitaciones[room-1][h] == false){
					habitaciones[room-1][h] = true;
					c++;
					return true;
				}
			}
		}
			if(room == 2){//Doble
				for (int h = 0; h < habitaciones.length; h++) {
					if(habitaciones[room-1][h] == false){
						habitaciones[room-1][h] = true;
						c++;
						return true;
					}
				}
				for (int h = 0; h < habitaciones.length; h++) {
					if(habitaciones[room][h] == false){
						habitaciones[room][h] = true;
						c++;
						return true;
					}
				}

			}

			if(room==3){//Sencilla
				for (int h = 0; h < habitaciones.length; h++) {
					if(habitaciones[room][h] == false){
						habitaciones[room][h] = true;
						c++;
						return true;
					}
				}
				for (int h = 0; h < habitaciones.length; h++) {
					if(habitaciones[room+1][h] == false){
						habitaciones[room+1][h] = true;
						c++;
						return true;
					}
				}
			}

			return false;
		}
		
	}



	

