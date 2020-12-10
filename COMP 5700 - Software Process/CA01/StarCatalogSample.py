#  Note: This is file provides samples of the use of the StarCatalog class.
#  IT IS NOT TEST CODE.

import Assignment.prod.StarCatalog as StarCatalog

# construct
stars = StarCatalog.StarCatalog()


# -------------- loadCatalog -----------------------------
# Load the catalog with a valid file
# The return value will be a count of the number of stars loaded
starCount = stars.loadCatalog(starFile="Sao.Txt")

# Attempts to load the catalog using a non-existent file or 
# a file that does not contain legitimate star information
# should result in a ValueError exception bearing a
# diagnostic message.
try:
    stars.loadCatalog(starFile="aValidStarFile.txt")
except ValueError as e:
    diagnosticString1 = e.args[0]


# -------------- getStarCount -----------------------------
# Get a count of stars with magnitudes between 2 and 5, inclusive.
starsBetween2And5 = stars.getStarCount(dimmest=5, brightest=2)

# Get a count of stars with magnitudes .LE. 5.
starsLE5 = stars.getStarCount(brightest=5)

# Get a count of stars with magnitudes .GE. 3
starsGE3 = stars.getStarCount(dimmest=3)

# Get a count of all stars
allStars = stars.getStarCount()

# Attempt to get a count of stars using an invalid magnitude
try:
    stars.getStarCount('a', 5)
except ValueError as e:
    diagnosticString2 = e.args[0]


# -------------- getStarData -----------------------------
# Get information associated with a specific star
star = stars.getStarData("150340")
#  star[0] is "150340"
#  star[1] is "4.3"
#  star[2] is 79.8937753
#  star[3] is -13.176769

# Attempt to get information on a star not present in the catalog
try:
    stars.getStarData("231888")
except ValueError as e:
    diagnosticString2 = e.args[0]


# -------------- emptyCatalog -----------------------------
# empty the catalog
starsDeleted = stars.emptyCatalog()