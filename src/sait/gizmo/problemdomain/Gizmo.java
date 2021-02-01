package sait.gizmo.problemdomain;

public class Gizmo
{
	private int id;
	private String name;
	private int quantity;
	private double price;
	private boolean active; 
	
	/**
	 * 
	 */
	public Gizmo()
	{
		active = true;
	}

	/**
	 * @param id
	 * @param name
	 * @param quantity
	 * @param price
	 */
	public Gizmo(int id, String name, int quantity, double price)
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		active = true;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/**
	 * 
	 * @return active 
	 */
	public boolean isActive()
	{
		return active;
	}
	
	/**
	 * @param active 
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	@Override
	public String toString()
	{
		return id +";" + name + ";" + quantity + ";" + price;
	}
	
	
}
