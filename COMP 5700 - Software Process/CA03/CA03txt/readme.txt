aries.txt

This file provides the altitude and declination of Aries on the hour for each day of the year.  Each line of the file consists of a date, an hour, and the Greenwich Hour Angle.  The format is:
	mm/dd/yy		followed by
	whitespace		followed by
	hh				followed by
	whitespace 		followed by
	ddd				followed by
	degree symbol	followed by
	aa.a			followed by
	\n
	
Where
	mm = two-digit month number with leading zero
	dd = two-digit day of the month with leading zero
	yy = two-digit year number
	whitespace = blanks or tabs
	hh = two-digit hour, range 0 - 23.
	ddd = degrees
	aa.a = arc minutes
	
Example:
	09/30/16	10	159°34.9  = shows Aries is 159degrees, 34.9 minutes at 10am on 30 Sep 16
	

--------------------------------
stars.txt

This file provides the altitude and declination of stars used for navigation.  Each line of the file consists of the star name, the date, the star's Sidereal Hour Angle, and the star's declination.  It has the format:

	body			followed by
	whitespace		followed by
	mm/dd/yy		followed by
	whitespace		followed by
	ddd				followed by
	degree symbol	followed by
	aa.a			followed by
	whitespace		followed by
	ddd				followed by
	degree symbol	followed by
	aa.a			followed by
	\n
	
Where
	body =  star name (trimmed, no embedded whitespace)
	mm = two-digit month number with leading zero
	dd = two-digit day of the month with leading zero
	yy = two-digit year number
	whitespace = blanks or tabs
	hh = two-digit hour, range 0 - 23.
	ddd = degrees
	aa.a = arc minutes	
	
Example:
	Hamal	01/04/16	327°58.7	23°32.3 = indicates that Hamal is 327 degrees, 58.7 minutes past the GHA of Aries on 4 Jan 16.  Hamal is located 23 degrees 32.3 above the celestial equator.
	
	
Note:  Because stars shift so slightly, the table only lists star SHAs every three days.  If an observation is made between dates in the table, take the earlier date.  For example, if an observation is made on 6 Jan 16, the entries for 4 Jan 16 should be used.
	
	

