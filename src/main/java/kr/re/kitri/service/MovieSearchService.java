package kr.re.kitri.service;

import kr.re.kitri.model.Items;
import kr.re.kitri.model.Searchs;
import kr.re.kitri.util.NaverAPIConstants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MovieSearchService {
    public MovieSearchService() {

        try {
            Class.forName(NaverAPIConstants.DRIVER_POSTGRES);
            System.out.println("driver check");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Items> getMovielist(String search, int count) {


        List<Items> resultlist = new ArrayList<>();

        try {
            String text = URLEncoder.encode(search,"UTF-8");
            String apiUrl = "https://openapi.naver.com/v1/search/movie.json?query="+ text;

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", NaverAPIConstants.clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", NaverAPIConstants.clientSecret);
            int responseCode = conn.getResponseCode();
            BufferedReader br;


            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            JSONObject obj = new JSONObject(response.toString());

            JSONArray jsonarr = obj.getJSONArray("items");



            String query =
                    "INSERT INTO public.searchmovie(" +
                            " lastbuilddate, totalsearch, keyword) " +
                            "VALUES ( ?, ?, ?); " +
                    + '\n' +
                    "INSERT INTO public.items(" +
                            " title, link, image, subtitle, pubdata, director, actor, userrating) " +
                            "VALUES (  ?, ?, ?, ?, ?, ?, ?, ?);";

            Connection conn2 =
                    DriverManager.getConnection(
                            NaverAPIConstants.DB_URL,
                            NaverAPIConstants.USERNAME,
                            NaverAPIConstants.PASSWORD);

            PreparedStatement pst = conn2.prepareStatement(query);

            LocalDate day = LocalDate.of(2017,05,12);
            int total = obj.getInt("total");
            /*String dateStr = obj.getString("lastBuildDate");*/


            pst.setDate(1,Date.valueOf(day));
            pst.setInt(2, total);
            pst.setString(3,search);

            pst.setString(4, jsonarr.getJSONObject(1).getString("title"));
            pst.setString(5, jsonarr.getJSONObject(2).getString("link"));
            pst.setString(6, jsonarr.getJSONObject(3).getString("image"));
            pst.setString(7, jsonarr.getJSONObject(4).getString("subtitle"));
            pst.setString(8, jsonarr.getJSONObject(5).getString("pubDate"));
            pst.setString(9, jsonarr.getJSONObject(6).getString("director"));
            pst.setString(10, jsonarr.getJSONObject(7).getString("actor"));
            pst.setDouble(11, jsonarr.getJSONObject(8).getDouble("userRating"));


            pst.executeUpdate();


            conn2.close();

            return resultlist;

        } catch (Exception e){
            System.out.println(e);
            return null;
        }

    }


}
