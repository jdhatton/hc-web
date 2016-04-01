package com.hc.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.dto.charts.Series;

@RestController
@Component
public class GoogleChartResource {

	public GoogleChartResource() { }
	
    @RequestMapping(value = "/chartDataBubble", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public Series greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("\n Getting Chart Data to populate the bubble chart! \n");
    	
    	Series series = new Series();
    	series.fakeLoad();
   
        return series;
    }
    
    @RequestMapping(value = "/chartData", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN})
    public String timelineChartData(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("\n Getting Chart Data to populate the bubble chart! \n");
    	
//    	Series series = new Series();
//    	series.fakeLoad();
    	
     String json = "{  \"cols\": [{  \"id\": null,  \"label\": \"Title graph\", \"type\": \"string\" }, " +
    	 "{ \"id\": null, \"label\": \"Description\",  \"type\": \"string\" }, "+
    	 "{ \"id\": null, \"label\": \"Start\", \"type\": \"date\" }, "+
    	 "{ \"id\": null,  \"label\": \"End\",  \"type\": \"date\" }],"+
    	 " \"rows\": [{\"c\": [{\"v\": \"Event1\" }, "+
    	 "{ \"v\": \"#06ae00\"},{\"f\": \"August 1st, 2011\"},{\"f\": \"August 1st, 2011\"}]}," +
    	 "{ \"c\": [{\"v\": \"Event2\"},{\"v\": \"#fdff00\"},{\"f\": \"August 1st, 2011\"},"+
    	 "{ \"f\": \"August 1st, 2011\"}]},{\"c\": [{\"v\": \"Event2\"},{\"v\": \"#dd0e0e\"},"+ 
    	 "{ \"f\": \"August 1st, 2011\"},{\"f\": \"August 1st, 2011\"}]}," +
    	 "{ \"c\": [{\"v\": \"Event3\"},{\"v\": \"#dd0e0e\"},{\"f\": \"August 1st, 2011\"}," +
    	 "{ \"f\": \"August 1st, 2011\"}]},{\"c\": [{\"v\": \"Event3\"},{\"v\": \"#fdff00\"}," +
    	 "{ \"f\": \"August 1st, 2011\"},{\"f\": \"August 1st, 2011\"}]}]}";
     
//     String json = "{  \"cols\": [{  \"id\": null,  \"label\": \"Title graph\", \"type\": \"string\" }, " +
//        	 "{ \"id\": null, \"label\": \"Description\",  \"type\": \"string\" }, "+
//        	 "{ \"id\": null, \"label\": \"Start\", \"type\": \"date\" }, "+
//        	 "{ \"id\": null,  \"label\": \"End\",  \"type\": \"date\" }],\"rows\": [{\"c\": [{\"v\": \"Event1\" }, "+
//        	 "{ \"v\": \"#06ae00\"},{\"v\": \"2012-04-21T18:25:43-05:00\"},{\"v\": \"2012-04-21T18:25:43-05:00\"}]}," +
//        	 "{ \"c\": [{\"v\": \"Event2\"},{\"v\": \"#fdff00\"},{\"v\": \"2012-04-21T18:25:43-05:00\"},"+
//        	 "{ \"v\": \"2012-04-21T18:25:43-05:00\"}]},{\"c\": [{\"v\": \"Event2\"},{\"v\": \"#dd0e0e\"},"+ 
//        	 "{ \"v\": \"2012-04-21T18:25:43-05:00\"},{\"v\": \"2012-04-21T18:25:43-05:00\"}]}," +
//        	 "{ \"c\": [{\"v\": \"Event3\"},{\"v\": \"#dd0e0e\"},{\"v\": \"2012-04-21T18:25:43-05:00\"}," +
//        	 "{ \"v\": \"2012-04-21T18:25:43-05:00\"}]},{\"c\": [{\"v\": \"Event3\"},{\"v\": \"#fdff00\"}," +
//        	 "{ \"v\": \"2012-04-21T18:25:43-05:00\"},{\"v\": \"2012-04-21T18:25:43-05:00\"}]}]}";
   
     //  2012-04-23T18:25:43.511Z
     
     
     System.out.println("RETURNING: "+ json);
        return json;
    }
    
    
 
}
