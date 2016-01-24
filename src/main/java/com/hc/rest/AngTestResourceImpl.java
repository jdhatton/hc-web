package com.hc.rest;


public class AngTestResourceImpl implements AngTestResource {

	public AngTestResourceImpl() { }

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
