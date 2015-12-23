package com.ipartek.formacion.backoffice.pruebas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.ipartek.formacion.backoffice.modelo.PersonaDAO;
import com.ipartek.formacion.backoffice.pojo.Persona;

public class Prueba {

	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		String[] datos;
		int contador =0;

		PersonaDAO pd = new PersonaDAO();

		try {
			Persona p = new Persona();
			fr = new FileReader("personas.txt");

			br = new BufferedReader(fr);

			for (int i = 0; i < 10003; i++) {

				linea = br.readLine();
				datos = linea.split(",");

				// comprobar 7

				if (datos.length >= 7) {

					p.setDni(datos[5]);
					p.setNombre(datos[0] + " " + datos[1] + " " + datos[2]);
					p.setEmail(datos[4]);
					p.setRol(datos[6]);

					pd.insert(p);
					contador++;
					System.out.println(contador);

				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {

			try {
				if (br != null) {
					br.close();
				}

				if (fr != null) {
					fr.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
