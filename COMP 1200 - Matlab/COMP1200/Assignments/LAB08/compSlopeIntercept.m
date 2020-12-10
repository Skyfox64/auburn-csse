% John Carroll
% Lab08.m
% Due November 3rd 2011
%{
    Edwin Hubble used the Mount Wilson Observatory telescopes to measure 
features of nebulae outside the Milky Way. He found that there is a 
relationship between a nebula’s distance from earth and the velocity with 
which it was traveling from the earth. Hubble’s initial data on 24 nebula 
is presented in Table 1 in the problem scenario.

    The relationship between distance and velocity led scientists to propose 
that the universe came into being with a Big Bang, a long time ago. If 
material scattered from the point of the Big Bang traveling at a constant 
velocity, the distance traveled can be determined.

    Using Hubble’s data, the program finds the linear equation that estimates the 
relationship between the velocity and distance readings. It also, displays 
the data on a graph using two defined functions to compute the slope and 
y-intercept.
%}
 
 % =======================================================================
% ***** COMPUTATION *****
% compute the slope and y-intercept for the given velocity and distance
% initialize counters
function [slope, intercept] = compSlopeIntercept(velocity, distance)
r= length(distance);
distance_sum=0; 
velocity_sum=0;  
velocity_sum_sq=0; 
velocity_and_distance_sum=0; 

for    k=1:r
    distance_sum = distance_sum + distance(k);
    velocity_sum = velocity_sum + velocity(k);
    velocity_sum_sq = (velocity_sum_sq + velocity(k).^2);
    velocity_and_distance_sum = velocity_and_distance_sum + (velocity(k).*distance(k));
end

slope_1 = (r.*velocity_and_distance_sum - velocity_sum.*distance_sum);
slope_2 = (r.*velocity_sum_sq - (velocity_sum.^2));
slope = slope_1/slope_2;
intercept_1 = ((distance_sum.*velocity_sum_sq)-(velocity_sum.*velocity_and_distance_sum));
intercept_2 = (r.*velocity_sum_sq - (velocity_sum.^2));
intercept = intercept_1/intercept_2;