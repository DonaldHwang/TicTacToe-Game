
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;
import spark.ModelAndView;
import ttt_source_code.*;

public class Main {
	public static void main(String[] args) {
    	staticFileLocation("/public"); //set static files
    	port(1120);
    	FreeMarkerEngine fmg = new FreeMarkerEngine();
    	Map<String, Object> attributes = new HashMap<>();
    	
    	//Create a list stores data of nine points
    	grid_list grid_list = new grid_list();
    	List<grid_list> list = new ArrayList<grid_list>();
    	list.add(grid_list);
        attributes.put("grid_list", list.toArray());
        
        
        //initialize result and IQ
        attributes.put("result", "Playing Game");
        attributes.put("iq", "0");
        
        get("/playttt", (request, response) -> {
    	    attributes.put("turn", "?");
    	    return fmg.render(new ModelAndView(attributes,"Template/ttt_html.ftl"));
    	});
        
        //initialize page
    	get("/playttt/iq", (request, response) -> {
    		int iq = Integer.parseInt(request.queryParams("range"));
    		TicTacToe game = new TicTacToe(iq);
            //get my role, and put it to attributes
    	    attributes.put("turn", game.getPerson());
    	    attributes.put("iq", Integer.toString(iq));
    		
    	    //use session to store game
    	    request.session().attribute("ttt",game);
    	    return fmg.render(new ModelAndView(attributes,"Template/ttt_html.ftl"));
    	});
    	
    	get("/playttt/begin", (request, response) -> {
    		//if I am O, the first move should be computer
    		TicTacToe game =request.session().attribute("ttt");
    		if("O".equals(game.getPerson().toString())) {
            	Move first = game.getAMove();
            	game.board.handleMove(first, game.player);
            	String place = Integer.toString(first.getRow())+Integer.toString(first.getColumn());
            	grid_list.setGrid(place, "X");
            	game.player = game.oppositePlayer();  	
            }
    	    return fmg.render(new ModelAndView(attributes,"Template/ttt_html.ftl"));
    	});
    	
    	post("/playttt/:id", (request, response) ->{
    		TicTacToe game =request.session().attribute("ttt");

    		attributes.remove("grid_list"); //remove old list
    		attributes.remove("result");
    		String id = request.params("id");
    		String value = request.queryParams(id); //get the value of my move
    		grid_list.setGrid(id, value); //update the value of my move
    		int row = (int)id.charAt(0)-'0';
    		int column = (int)id.charAt(1)-'0';
    		
    		Move mymove = game.getAMove2(row, column);
    		game.board.handleMove(mymove, game.player); //use board to handle my move
    		
    		if (game.board.isGameWon() || game.board.isFull()) {
    			game.showGameResult();
    			if (game.board.isGameWon()) {
    				String result = game.player==game.person ? "You won!" : "Robot won!";
    				attributes.put("result", result);
    			}
    			else if(game.board.isFull()) {
    				String result = "We tied!";
    				attributes.put("result", result);
    			}
    			attributes.put("grid_list", list.toArray());
				return fmg.render(new ModelAndView(attributes,"Template/ttt_html.ftl"));
    		}    
    	    else { 
    	    	game.player = game.oppositePlayer(); //change player to computer
    			attributes.put("result", "Playing Game");
    	    }
    		
    		Move next = game.getAMove(); //get the value of computer's move
    		game.board.handleMove(next, game.player); //use board to handle the move by computer
    		
    		//update the move of computer
    		String place = Integer.toString(next.getRow())+Integer.toString(next.getColumn());
    		if("O".equals(game.getPerson().toString())) {
    			grid_list.setGrid(place, "X"); 
    		}
    		else {
    			grid_list.setGrid(place, "O"); 
    		}
    		
    		if (game.board.isGameWon() || game.board.isFull()) {
    			game.showGameResult();
    			if (game.board.isGameWon()) {
    				String result = game.player==game.person ? "You won!" : "Robort won!";
    				attributes.put("result", result);
    			}
    			else if(game.board.isFull()) {
    				String result = "We tied!";
    				attributes.put("result", result);
    			}
    			attributes.put("grid_list", list.toArray());
    			return fmg.render(new ModelAndView(attributes,"Template/ttt_html.ftl"));
    		}    
    		else { 
    	    	game.player = game.oppositePlayer(); //change the player to myself
    			attributes.put("result", "Playing Game");
    	    }
    		
            attributes.put("grid_list", list.toArray()); //put new list to attributes
    	    return fmg.render(new ModelAndView(attributes,"Template/ttt_html.ftl"));
    	});
    	
    }
    	   
}
