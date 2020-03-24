package br.com.exemplo.weather.api.modelApi;

import java.util.ArrayList;

public class WeatherData {

	Coord CoordObject;
	ArrayList<Object> weather = new ArrayList<Object>();
	private String base;
	Main MainObject;
	private float visibility;
	Wind WindObject;
	Clouds CloudsObject;
	private float dt;
	Sys SysObject;
	private float id;
	private String name;
	private float cod;

	// Getter Methods

	public Coord getCoord() {
		return CoordObject;
	}

	public String getBase() {
		return base;
	}

	public Main getMain() {
		return MainObject;
	}

	public float getVisibility() {
		return visibility;
	}

	public Wind getWind() {
		return WindObject;
	}

	public Clouds getClouds() {
		return CloudsObject;
	}

	public float getDt() {
		return dt;
	}

	public Sys getSys() {
		return SysObject;
	}

	public float getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getCod() {
		return cod;
	}

	// Setter Methods

	public void setCoord(Coord coordObject) {
		this.CoordObject = coordObject;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setMain(Main mainObject) {
		this.MainObject = mainObject;
	}

	public void setVisibility(float visibility) {
		this.visibility = visibility;
	}

	public void setWind(Wind windObject) {
		this.WindObject = windObject;
	}

	public void setClouds(Clouds cloudsObject) {
		this.CloudsObject = cloudsObject;
	}

	public void setDt(float dt) {
		this.dt = dt;
	}

	public void setSys(Sys sysObject) {
		this.SysObject = sysObject;
	}

	public void setId(float id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCod(float cod) {
		this.cod = cod;
	}
}

class Sys {
	private float type;
	private float id;
	private float message;
	private String country;
	private float sunrise;
	private float sunset;

	// Getter Methods

	public float getType() {
		return type;
	}

	public float getId() {
		return id;
	}

	public float getMessage() {
		return message;
	}

	public String getCountry() {
		return country;
	}

	public float getSunrise() {
		return sunrise;
	}

	public float getSunset() {
		return sunset;
	}

	// Setter Methods

	public void setType(float type) {
		this.type = type;
	}

	public void setId(float id) {
		this.id = id;
	}

	public void setMessage(float message) {
		this.message = message;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setSunrise(float sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(float sunset) {
		this.sunset = sunset;
	}
}

class Clouds {
	private float all;

	// Getter Methods

	public float getAll() {
		return all;
	}

	// Setter Methods

	public void setAll(float all) {
		this.all = all;
	}
}

class Wind {
	private float speed;
	private float deg;

	// Getter Methods

	public float getSpeed() {
		return speed;
	}

	public float getDeg() {
		return deg;
	}

	// Setter Methods

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setDeg(float deg) {
		this.deg = deg;
	}
}
