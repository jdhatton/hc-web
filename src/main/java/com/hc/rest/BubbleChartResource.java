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
public class BubbleChartResource {

	public BubbleChartResource() { }
	
    @RequestMapping(value = "/chartData", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public Series greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("\n Getting Chart Data to populate the bubble chart! \n");
    	
    	Series series = new Series();
    	series.fakeLoad();
   
        return series;
    }

}
