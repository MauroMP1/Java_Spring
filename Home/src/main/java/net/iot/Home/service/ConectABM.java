package net.iot.Home.service;


import java.io.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ConectABM {
	
	private static String mensajeConectABM;
	
	
	
	public String getMensajeConectABM() {
		return mensajeConectABM;
	}


	public void setMensajeConectABM(String mensajeConectABM) {
		ConectABM.mensajeConectABM = mensajeConectABM;
	}
	
	public static String conectPost(String dato, String ur) throws IOException {
		URL url = null;
		try {
			url = new URL(ur);
		} catch (MalformedURLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/plain");
			String input = dato;
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.write(input.getBytes());
			os.flush();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader bufferedReader;
				bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
					mensajeConectABM = line;
				}
			} else {
				// ... do something with unsuccessful response
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensajeConectABM;

	}
		
	public static String conectPut(String dato, String ur) throws IOException {
		URL url = null;
		try {
			url = new URL(ur);
		} catch (MalformedURLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "text/plain");
			String input = dato;
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.write(input.getBytes());
			os.flush();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader bufferedReader;
				bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
					mensajeConectABM = line;
				}
			} else {
				// ... do something with unsuccessful response
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensajeConectABM;

	}

	public static String conectBorrar(String dato, String ur) throws IOException {
		URL url = null;
		try {
			url = new URL(ur);
		} catch (MalformedURLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "text/plain");
			String input = dato;
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.write(input.getBytes());
			os.flush();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader bufferedReader;
				bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
					mensajeConectABM = line;
				}
			} else {
				// ... do something with unsuccessful response
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensajeConectABM;

	}

}
