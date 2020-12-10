import math


class TCurve(object):

    def __init__(self, n=None):
        functionName = "TCurve.__init__: "
        if(n == None):
            raise ValueError(functionName + "invalid n")
        if(not(isinstance(n, int))):
            raise ValueError(functionName + "invalid n")
        if((n < 2) or (n > 50)):
            raise ValueError(functionName + "invalid n")
        self.n = n

    def p(self, t=None, tails=None):
        if(t == None):
            raise ValueError
        if(not(isinstance(t, float))):
            raise ValueError
        if(t < 0.0):
            raise ValueError

        if(tails == None):
            raise ValueError
        if(not(isinstance(tails, int))):
            raise ValueError
        if((tails != 1) & (tails != 2)):
            raise ValueError

        constant = self.LHP(self.n)
        integration = self.integrate(self.f, self.n, 0, t)
        if(tails == 1):
            result = constant * integration + 0.5
        else:
            result = constant * integration * 2

        if(result > 1.0):
            raise ValueError

        return result

    def gamma(self, x):
        if(x == 1):
            return 1
        if(x == 0.5):
            return math.sqrt(math.pi)
        return (x - 1) * self.gamma(x - 1)

    def LHP(self, n):
        num = self.gamma(float(n + 1) / 2.0)
        denom = self.gamma(float(n) / 2.0) * math.sqrt(math.pi * n)
        result = num / denom
        return result

    def f(self, u, n):
        n = float(n)
        base = (1 + (u ** 2) / n)
        exponent = -(n + 1.0) / 2
        result = base ** exponent
        return result

################################################
# TO DO
    def integrate(self, f, n, lowBound, highBound):
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
        

        epsilon = 0.001
        simpsonOld = 0
        simpsonNew = epsilon
        s = 4
        while (abs((simpsonNew - simpsonOld) / simpsonNew) > epsilon):
            simpsonOld = simpsonNew
            w = float((highBound - lowBound)) / s
            equation = f(lowBound, n)
            for i in range(1, s):
                if (i % 2 == 1):
                    equation = equation + 4 * f(lowBound + (i * w), n)
                else:
                    equation = equation + 2 * f(lowBound + (i * w), n)
        equation = equation + f(highBound, n)
        simpsonNew = (w / 3) * equation
        s = s * 2
        return simpsonNew
