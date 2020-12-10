import unittest
import Assignment.prod.TCurve as TCurve
import math


class TCurveTest(unittest.TestCase):

    def setUp(self):
        pass

    def tearDown(self):
        pass
     
# Acceptance Tests
# Analysis - Constructor
#    inputs
#        n ->    int .GE. 2 and .LE. 50 mandatory unvalidated
#    output -> instance of TCurve
# Happy path
#    nominal case:  TCurve(7)
#    edge case: TCurve(2)
#    edge case: TCurve(50)
# Sad path
#    n
#            non-int n:  TCurve(1.2)
#            out-of-bounds n:  TCurve(100)
#            missing n:  TCurvde()
#
# Analysis - p
#    inputs
#        t ->  numeric, unvalidated, mandatory, .GT 0
#        tails ->  {1,2} unvalidated  optional, defaults to 1
#  Happy path
#    nominal case:  assume n=5  p(1.1558, 1) -> 0.85 
#    nominal case:  assume n=5 p(1.1558, 2) -> 0.70 
#    edge case:   assume n = 3   p(0.2767,1) -> 0.60
#    edge case:   assume n = 3   p(0.2767,2) -> 0.20
#    edge case:   assume n = 15   p(0.2579,1) -> 0.60
#    edge case:   assume n = 15   p(0.2579,2) -> 0.20
#    edge case:   assume n = 3   p(2.3534,1) -> 0.95
#    edge case:   assume n = 3   p(2.3534,2) -> 0.9
#    edge case:   assume n = 15   p(1.7531,1) -> 0.95
#    edge case:   assume n = 15   p(1.7531,2) -> 0.9
#  Sad path
#        t
#            t is .LE. 0    p(-1,1)  -> ValueError
#            



# 100 constructor
# Happy path tests
    def test100_010_ShouldConstruct(self):
        self.assertIsInstance(TCurve.TCurve(7), TCurve.TCurve)
        
# 200 p
# Design:    if tails == 1, then integrate from 0 to t and add .5
#           if tails == 2, integrate from 0 to t and double
# Happy path
    def test200_010ShouldCalculateNominalCaseOneTail(self):
        myT = TCurve.TCurve(7)
        self.assertAlmostEquals(myT.p(1.8946, 1), .95, 3)
        
    def test200_020ShouldCalculateNominalCaseTwoTail(self):
        myT = TCurve.TCurve(7)
        self.assertAlmostEquals(myT.p(1.8946, 2), .90, 3)

    def test200_030ShouldEdgeLowTLowNOneTail(self):
        myT = TCurve.TCurve(3)
        self.assertAlmostEquals(myT.p(0.2767, 1), 0.6, 3)        

    def test200_040ShouldEdgeLowTHighNOneTail(self):
        myT = TCurve.TCurve(20)
        self.assertAlmostEquals(myT.p(0.2567, 1), 0.6, 3)    

    def test200_050ShouldEdgeHighTLowNOneTail(self):
        myT = TCurve.TCurve(3)
        self.assertAlmostEquals(myT.p(5.8409, 1), .995, 3)
        
    def test200_060ShouldEdgeHighTHighNOneTail(self):
        myT = TCurve.TCurve(20)
        self.assertAlmostEquals(myT.p(2.8453, 1), .995, 3)

# Sad path
    def test200_910ShouldRaiseExceptionOnMissingT(self):
        myT = TCurve.TCurve(7)
        with self.assertRaises(ValueError) as context:
            myT.p(tails=1)
    
    def test200_920ShouldRaiseExceptionOnBadT(self):
        myT = TCurve.TCurve(7)
        with self.assertRaises(ValueError) as context:
            myT.p(t=1, tails=1)
            
    def test200_930ShouldRaiseExceptionOnOutOfRangeT(self):
        myT = TCurve.TCurve(7)
        with self.assertRaises(ValueError) as context:
            myT.p(t=-1, tails=1)
            
    def test200_930ShouldRaiseExceptionInvalidTails(self):
        myT = TCurve.TCurve(7)
        with self.assertRaises(ValueError) as context:
            myT.p(t=-1, tails=0)
        
# 300 gamma
# Analysis
#    inputs:
#        x: numeric mandatory validated
# Acceptance tests
# Happy path:
#    gamma(1)  -> 1
#    gamma(1/2)  -> sqrt(pi)
#    gamma(5)  ->  4*3*2*1*1 = 24
#    gamma(5/2) -> 3/2 * 1/2 * sqrt(pi) ~ 1.329
# Sad path:
#    none ... will prevalidate
# Design:  gamma algorithm
    def test300_010_ShouldReturnUpperTerminationCondition(self):
        myT = TCurve.TCurve(5)
        self.assertEquals(myT.gamma(1), 1)
        
    def test300_020_ShouldReturnLowerTerminationCondition(self):
        myT = TCurve.TCurve(5)
        self.assertEquals(myT.gamma(1.0 / 2.0), math.sqrt(math.pi))
        
    def test300_030_ShouldWorkOnIntegerX(self):
        myT = TCurve.TCurve(5)
        self.assertEquals(myT.gamma(5), 24)
        
    def test300_030_ShouldWorkOnHalfX(self):
        myT = TCurve.TCurve(5)
        self.assertAlmostEquals(myT.gamma(5.0 / 2.0), 1.329, 3)
        
# 400 LHP
# Analysis
#    inputs
#        n -> numeric  mandatory validated
#    outputs
#        float .GE. 0 
#
# Happy path
#    nominal case:  LHP(5) -> 
# Sad path
#    none ... will prevalidate

    def test400_010_ShouldCalculateLHP(self):
        n = 5
        myT = TCurve.TCurve(n)
        self.assertEquals((2.0) / (1.5 * 0.5 * math.sqrt(math.pi) * math.sqrt(n * math.pi)), myT.LHP(n))  
        
# 500 f
# Analysis
#    inputs
#        n -> numeric mandatory validated
#        u -> float mandatory validated
#    outputs
#        float .GE. 0
# Happy path
#    nominal case:  f(1) -> 0.5787
# Sad path
#    none ... will prevalidate
# Design:  equation
    def test500_010_ShouldCalculateFStarterCase(self):
        myT = TCurve.TCurve(5)
        self.assertAlmostEquals(myT.f(0, 5), 1, 4)
        
    def test500_020_ShouldCalculateF(self):
        myT = TCurve.TCurve(5)
        self.assertAlmostEquals(myT.f(1, 5), 0.578703704)
        
# 600 integrate
# Analysis - integrate
#   inputs:  f    function, validated
#            n    validated
#            l    validated
#            h    validated
# Happy path:
#    integrate(f(x)=5, n= 5,l=0, h=5)  -> 25
#    
# Design:  Requirement is to use Simpson's algorithm:
# {
#     let epsilon = 0.001
#     let simpsonOld = 0
#     let simpsonNew = epsilon
#     set S to a value of your choice (a good starting value is 4)
#     while abs((simpsonNew - simpsonOld ) / simpsonNew) > epsilon
#     {
#         simpsonOld = simpsonNew
#         W = (highBound - lowBound) / S
#         simpsonNew = (W/3) * (f(0) + 4f(0+W) + 2f(0+2W) + ... + 4f(highBound-W) + f(highBound))
#         S = S * 2
#     }
#     return simpsonNew  as the answer
# }


################################################    
# TO DO
    def test600_610_ShouldWorkWithHardCodedSimpsons(self):
        def f(x):
            return 5
        n = 5
        l = 0
        h = 5
        myT = TCurve.TCurve(n)
        self.assertEquals(25.0, myT.integrate(f, n, l, h))



