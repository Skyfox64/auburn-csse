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
% ***** OUTPUT *****
% Print the velocities and distances in a two columns with a title and
% column headings

function plotHubbleData(velocity, distance, slope, intercept)
scatter(velocity, distance);
hold on
orderedV = sort(velocity);
distance = slope.*orderedV + intercept;
grid on
plot(orderedV, distance);
end