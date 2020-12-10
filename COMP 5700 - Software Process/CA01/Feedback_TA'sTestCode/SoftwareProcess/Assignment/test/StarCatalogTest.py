import Assignment.prod.StarCatalog as SC
import math
import unittest
import random


class StarCatalogTest(unittest.TestCase):

# 100 constructor
# Happy path tests
    def test100_010_ShouldConstruct(self):
        self.assertIsInstance(SC.StarCatalog(), SC.StarCatalog)
        
# 200 loadCatalog
# Happy path tests
    def test200_010_ShouldLoadCatalog(self):
        theCat = SC.StarCatalog()
        self.assertEquals(20, theCat.loadCatalog("saoLocal.txt", 1))
        
    def test200_020_ShouldLoadCatalogIfMagIsMissing(self):
        theCat = SC.StarCatalog()
        self.assertEquals(51, theCat.loadCatalog("saoLocal.txt"))
        
    def test200_020_ShouldAddStarsFromMultipleCatalogs(self):
        theCat = SC.StarCatalog()
        self.assertEquals(51, theCat.loadCatalog("saoLocal.txt"))
        self.assertEquals(2, theCat.loadCatalog("saoLocal2.txt"))
        self.assertEquals(53, theCat.getStarCount())
        
# Sad path tests
    def test200_905_ShouldRaiseErrorOnBadFileName(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("", 6.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid file name")

    def test200_907_ShouldRaiseErrorOnMissingFileName(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog(magnitude=6.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Minor:  failure to check for missing file name")
        
    def test200_910_ShouldRaiseErrorOnNonStringFileName(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog(42, 6.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for nonString file name")
        
    def test200_915_ShouldRaiseErrorOnMissingFile(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        randomFileName = ''.join(random.choice('abcd01234') for x in range(8)) + "txt"
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog(randomFileName, 6.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for missing file")
        
    def test200_920_ShouldRaiseErrorOnBadFileContents(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("saoBad.txt", 6.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for file that doesn't fit star format")
         
    def test200_925_ShouldRaiseErrorOnBadNonNumericMagnitude(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("saoLocal.txt", "abc")
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for nonNumeric magnitude")  
        
    def test200_930_ShouldRaiseErrorOnBelowRangeMagnitude(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("saoLocal.txt", -30.1)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Minor:  failure to check for out-of-range magnitude")    
        
    def test200_935_ShouldRaiseErrorOnAboveRangeMagnitude(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("saoLocal.txt", 30.1)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Minor:  failure to check for out-of-range magnitude")  
        
    def test200_950_ShouldRaiseErrorOnDuplicateStarInDifferentFiles(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 2.0)
        originalStarCount = theCat.getStarCount()        
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("saoLocal.txt", 2.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value")
        self.assertEquals(originalStarCount, theCat.getStarCount())
        
    def test200_955_ShouldRaiseErrorOnDuplicateStarInSameFile(self):
        expectedString = "StarCatalog.loadCatalog:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.loadCatalog("saoLocalWithDuplicates.txt", 2.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value")   
        self.assertEquals(0, theCat.getStarCount())        

# 300 emptyCatalog
# Happy path tests
    def test300_010_ShouldEmptyTheCatalog(self):
        theCat = SC.StarCatalog()
        starCount = theCat.loadCatalog("saoLocal.txt", 3.0)
        self.assertEquals(starCount, theCat.emptyCatalog())
        
    def test300_020_ShouldEmptyAnCatalog(self):
        theCat = SC.StarCatalog()
        self.assertEquals(0, theCat.emptyCatalog())
        
# 400 getStarCount
    def test400_010_ShouldGetCountOfAllStars(self):
        theCat = SC.StarCatalog()
        starCount = theCat.loadCatalog("saoLocal.txt", 3.0)
        self.assertEquals(starCount, theCat.getStarCount())
        
    def test400_020_ShouldGetCountOfStarsBetweenBounds(self):
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        self.assertEquals(8, theCat.getStarCount(dimmest=2.0, brightest=2.0)) 
        
    def test400_030_ShouldGetCountOfStarsDimmerThanMag(self):
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        self.assertEquals(20, theCat.getStarCount(dimmest=1.0))
        
    def test400_040_ShouldGetCountOfStarsBrighterThanMag(self):
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        self.assertEquals(41, theCat.getStarCount(brightest=0.0)) 
        
    def test400_050_ShouldReturnZeroIfDimmerIsBrigherThanBrightest(self):
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        self.assertEquals(0, theCat.getStarCount(dimmest=1.0, brightest=2.0)) 

    def test400_060_ShouldGetCountOfEmptyCatalog(self):
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        theCat.emptyCatalog()
        self.assertEquals(0.0, theCat.getStarCount(dimmest=20.0, brightest=-20.0)) 
        
    def test400_070_ShouldGetCountOfFreshCatalog(self):
        theCat = SC.StarCatalog()
        self.assertEquals(0.0, theCat.getStarCount(dimmest=20.0, brightest=-20.0)) 
        
#  Sad path tests
        
    def test400_910_ShouldRaiseErrorOnNonNumericDimmestParm(self):
        expectedString = "StarCatalog.getStarCount:"
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 2.0)
        with self.assertRaises(ValueError) as context:
            theCat.getStarCount(dimmest="abd", brightest=0.0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value")   
        
    def test400_920_ShouldRaiseErrorOnNonNumericBrightestParm(self):
        expectedString = "StarCatalog.getStarCount:"
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 2.0)
        with self.assertRaises(ValueError) as context:
            theCat.getStarCount(dimmest=0.0, brightest="abc")
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value")  

# 500 getStarData
#  Happy Path
    def test500_010_ShouldGetStarData(self):
        id = '15384'
        mag = 2.0
        ra = 165.932
        dec = 61.75089
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        retrievedStar = theCat.getStarData(id)
        self.assertEquals(id, retrievedStar[0])
        self.assertEquals(mag, retrievedStar[1])  
        self.assertAlmostEquals(ra, retrievedStar[2], 3)
        self.assertAlmostEquals(dec, retrievedStar[3], 3)     
        
    def test500_010_ShouldGetStarDataIgnoreLeadingTrailingBlanks(self):
        id = ' 15384 '
        mag = 2.0
        ra = 165.932
        dec = 61.75089
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 3.0)
        retrievedStar = theCat.getStarData(id)
        self.assertEquals(id.strip(), retrievedStar[0])
        self.assertEquals(mag, retrievedStar[1])  
        self.assertAlmostEquals(ra, retrievedStar[2], 3)
        self.assertAlmostEquals(dec, retrievedStar[3], 3)   

# Sad Path
    def test500_910_ShouldRaiseExceptionOnNoStarFound(self):
        expectedString = "StarCatalog.getStarData:"
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 2.0)
        with self.assertRaises(ValueError) as context:
            theCat.getStarData(starId=0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value")  

    def test500_915_ShouldRaiseExceptionOnEmptyCatalog(self):
        expectedString = "StarCatalog.getStarData:"
        theCat = SC.StarCatalog()
        with self.assertRaises(ValueError) as context:
            theCat.getStarData(starId=0)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value")  
        
    def test500_920_ShouldRaiseErrorOnBadStarId(self):
        expectedString = "StarCatalog.getStarData:"
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 2.0)
        with self.assertRaises(ValueError) as context:
            theCat.getStarData(starId=42)
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value") 

    def test500_930_ShouldRaiseErrorOnMissingStarId(self):
        expectedString = "StarCatalog.getStarData:"
        theCat = SC.StarCatalog()
        theCat.loadCatalog("saoLocal.txt", 2.0)
        with self.assertRaises(ValueError) as context:
            theCat.getStarData()
        self.assertEquals(expectedString, context.exception.args[0][0:len(expectedString)],
                          "Major:  failure to check for invalid degradation value") 
