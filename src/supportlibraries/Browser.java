package supportlibraries;

public enum Browser
{
	
	Firefox("firefox");
	
	private String value;
	
	Browser(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
	
}