package com.unary.plugin.Utils;

public class TimeUtil 
{
	private static Tuple<Long, String> GetYear(Tuple<Long, String> Time)
	{
		Tuple<Long, String> Result;
		
		if(Time.x >= 31556926)
		{
			Long Years = Time.x / 31556926;
			Long Remained = Time.x % 31556926;
			
			if(Years == 1)
			{
				Result = new Tuple<Long, String>(Remained, "1 год ");
			}
			else if(Years > 1 && Years < 5)
			{
				Result = new Tuple<Long, String>(Remained, Years + " года ");
			}
			else
			{
				Result = new Tuple<Long, String>(Remained, Years + " лет ");
			}
			
			return Result;
		}
		else
		{
			return Time;
		}
	}
	
	private static Tuple<Long, String> GetMonth(Tuple<Long, String> Time)
	{
		Tuple<Long, String> Result;
		
		if(Time.x >= 2629743)
		{
			Long Months = Time.x / 2629743;
			Long Remained = Time.x % 2629743;
			
			if(Months == 1)
			{
				Result = new Tuple<Long, String>(Remained, "1 месяц ");
			}
			else if(Months > 1 && Months < 5)
			{
				Result = new Tuple<Long, String>(Remained, Months + " месяца ");
			}
			else
			{
				Result = new Tuple<Long, String>(Remained, Months + " месяцев ");
			}
			
			return Result;
		}
		else
		{
			return Time;
		}
	}
	
	private static Tuple<Long, String> GetWeek(Tuple<Long, String> Time)
	{
		Tuple<Long, String> Result;
		
		if(Time.x >= 604800)
		{
			Long Weeks = Time.x / 604800;
			Long Remained = Time.x % 604800;
			
			if(Weeks == 1)
			{
				Result = new Tuple<Long, String>(Remained, "1 неделя ");
			}
			else if(Weeks > 1 && Weeks < 5)
			{
				Result = new Tuple<Long, String>(Remained, Weeks + " недели ");
			}
			else
			{
				Result = new Tuple<Long, String>(Remained, Weeks + " недель ");
			}
			
			return Result;
		}
		else
		{
			return Time;
		}
	}
	
	private static Tuple<Long, String> GetDay(Tuple<Long, String> Time)
	{
		Tuple<Long, String> Result;
		
		if(Time.x >= 86400)
		{
			Long Days = Time.x / 86400;
			Long Remained = Time.x % 86400;
			
			if(Days == 1)
			{
				Result = new Tuple<Long, String>(Remained, "1 день ");
			}
			else if(Days > 1 && Days < 5)
			{
				Result = new Tuple<Long, String>(Remained, Days + " дня ");
			}
			else
			{
				Result = new Tuple<Long, String>(Remained, Days + " дней ");
			}
			
			return Result;
		}
		else
		{
			return Time;
		}
	}
	
	private static Tuple<Long, String> GetHour(Tuple<Long, String> Time)
	{
		Tuple<Long, String> Result;
		
		if(Time.x >= 3600)
		{
			Long Hours = Time.x / 3600;
			Long Remained = Time.x % 3600;
			
			if(Hours == 1)
			{
				Result = new Tuple<Long, String>(Remained, "1 час ");
			}
			else if(Hours > 1 && Hours < 5)
			{
				Result = new Tuple<Long, String>(Remained, Hours + " часа ");
			}
			else if(Hours > 4 && Hours < 21)
			{
				Result = new Tuple<Long, String>(Remained, Hours + " часов ");
			}
			else if(Hours == 21)
			{
				Result = new Tuple<Long, String>(Remained, "21 час ");
			}
			else
			{
				Result = new Tuple<Long, String>(Remained, Hours + " часа ");
			}
			
			return Result;
		}
		else
		{
			return Time;
		}
	}
	
	private static Tuple<Long, String> GetSeconds(Tuple<Long, String> Time)
	{
		Tuple<Long, String> Result;
		
		if(Time.x >= 1)
		{
			Result = new Tuple<Long, String>(new Long(0), Time.x + " секунд ");
			return Result;
		}
		else
		{
			return Time;
		}
	}
	
	public static String GetStringRepresentation(Long UnixTime)
	{
		Tuple<Long, String> Result = new Tuple<Long, String>(UnixTime, "");
		
		Result = GetSeconds(GetHour(GetDay(GetWeek(GetMonth(GetYear(Result))))));
		
		return Result.y.substring(0, Result.y.length() - 1);
	}
}