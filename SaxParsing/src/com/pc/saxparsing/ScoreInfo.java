package com.pc.saxparsing;


public class ScoreInfo {
String start_date;
String start_time;
String end_time;
String current_status;
String match_type;

public String getStart_date () {
	return start_date;
}

public void setStart_date (String start_date) {
	this.start_date = start_date;
}

public String getStart_time () {
	return start_time;
}

public void setStart_time (String start_time) {
	this.start_time = start_time;
}

public String getEnd_time () {
	return end_time;
}

public void setEnd_time (String end_time) {
	this.end_time = end_time;
}

public String getCurrent_status () {
	return current_status;
}

public void setCurrent_status (String current_status) {
	this.current_status = current_status;
}

public String getMatch_type () {
	return match_type;
}

public void setMatch_type (String match_type) {
	this.match_type = match_type;
}
@Override
public String toString() {
    return start_date + ": " + match_type + ":"+current_status +":"+start_time;
}
}
