package Thalia;

import java.util.List;

public interface InterfaceShows {
	
    List<shows> getAllShows();
    shows createShow(String name, String web, String date, String time, int sid, double price);
    shows getShowDetail(int lid);
    void updateShow(int id, shows s);
    
}