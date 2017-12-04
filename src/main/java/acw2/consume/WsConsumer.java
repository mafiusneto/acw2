package acw2.consume;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

public class WsConsumer {

	public String sendGet(String url) throws Exception{

		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		StringBuffer response = new StringBuffer();

		while((inputLine = in.readLine()) != null) {
			response.append(new String(inputLine.getBytes(), "UTF-8"));
		}
		
		in.close();

		return response.toString();
	}


	public String sendPost(String url, String paramentros, 
			Map<String, String> headersMap) throws Exception{

		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		
		/*
		 * caso queira passar um XML como @PARAM para o Servi�o
		 */
		for(Map.Entry<String, String> entry : headersMap.entrySet()) {
			con.setRequestProperty(entry.getKey(), entry.getValue());
		}
		
		con.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		
		wr.writeBytes(paramentros);
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		StringBuffer response = new StringBuffer();

		while((inputLine = in.readLine()) != null) {
			response.append(new String(inputLine.getBytes(), "UTF-8"));
		}
		
		in.close();
		
		return response.toString();

	}
	
	public String sendPostJson(String url, String json) throws Exception{

		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-type", "application/json");
		
		con.setDoInput(true);
		con.setDoOutput(true);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		StringBuffer response = new StringBuffer();

		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			response.append("\r");
		}
		in.close();
		return response.toString();
	}
	
	
	public String getBasicToken(String user, String senha) {
		
		String token = user + ":" + senha;
		try {
			return "Token: " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
		
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Acesso Invalido");
		}
		
	}
	



















}
