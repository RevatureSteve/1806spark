package com.cpo.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.cpo.models.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokeAPIDao implements PokemonDao {
	
	private static final String URL = "http://pokeapi.co/api/v2/";

	public PokeAPIDao() {
	}

	@Override
	public List<Pokemon> GetPokemonById(List<Integer> ids) {
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		for (int i = 0; i < ids.size(); i++) {
//			String fullURL = URL + "pokemon/" + ids.get(i);
			String fullURL = "http://pokeapi.co/api/v2/pokemon/15";
			try {
				String json = sendGET(fullURL);
				ObjectMapper mapper = new ObjectMapper();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pokemon;
	}
	
	private String sendGET(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return null;
		}

	}

}
