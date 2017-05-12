package kr.re.kitri;

import kr.re.kitri.model.Items;
import kr.re.kitri.model.Searchs;
import kr.re.kitri.service.MovieSearchService;

import java.util.List;
import java.util.Scanner;


public class NaverMoviesearchMain {
    public static void main(String[] args){


        int count = 1;

        MovieSearchService service = new MovieSearchService();

        while (true) {
            System.out.print("Input keyword(Exit => Quit) : ");
            Scanner in = new Scanner(System.in);
            String search = in.nextLine().trim();

            if (search.equals("Quit")) {
                System.out.println("Program Exit");
                break;
            }
            else {

                /*List<Searchs> searchsList = service.getSearchlist(search, count);*/


                List<Items> actionlist = service.getMovielist(search, count);


                System.out.println("INSERT Complete");
                count++;
            }


        }
    }
}
